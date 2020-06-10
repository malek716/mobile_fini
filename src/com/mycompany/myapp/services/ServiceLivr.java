/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.entities.CategorieF;
import com.mycompany.entities.CommandeF;
import com.mycompany.entities.Livr;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Achraf
 */
public class ServiceLivr {
    
    
     public ArrayList<Livr> tasks;
    
    public static ServiceLivr instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

   public ServiceLivr() {
         req = new ConnectionRequest();
    }

    public static ServiceLivr getInstance() {
        if (instance == null) {
            instance = new ServiceLivr();
        }
        return instance;
    }
    

  public ArrayList<Livr>parseTasks(String jsonText) throws ParseException{
        try {
            tasks=new ArrayList<>();
            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json

            /*
                On doit convertir notre réponse texte en CharArray à fin de
            permettre au JSONParser de la lire et la manipuler d'ou vient 
            l'utilité de new CharArrayReader(json.toCharArray())
            
            La méthode parse json retourne une MAP<String,Object> ou String est 
            la clé principale de notre résultat.
            Dans notre cas la clé principale n'est pas définie cela ne veux pas
            dire qu'elle est manquante mais plutôt gardée à la valeur par defaut
            qui est root.
            En fait c'est la clé de l'objet qui englobe la totalité des objets 
                    c'est la clé définissant le tableau de tâches.
            */
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
              /* Ici on récupère l'objet contenant notre liste dans une liste 
            d'objets json List<MAP<String,Object>> ou chaque Map est une tâche.               
            
            Le format Json impose que l'objet soit définit sous forme
            de clé valeur avec la valeur elle même peut être un objet Json.
            Pour cela on utilise la structure Map comme elle est la structure la
            plus adéquate en Java pour stocker des couples Key/Value.
            
            Pour le cas d'un tableau (Json Array) contenant plusieurs objets
            sa valeur est une liste d'objets Json, donc une liste de Map
            */
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            
            //Parcourir la liste des tâches Json
            for(Map<String,Object> obj : list){
                //Création des tâches et récupération de leurs données
             Livr t= new Livr();
                
              
               float id = Float.parseFloat(obj.get("idv").toString());
                t.setIdv((int)id);
               t.setNamev(obj.get("namev").toString());
               t.setCite(obj.get("cite").toString());
                t.setStreet(obj.get("street").toString());
                 t.setVille(obj.get("ville").toString());
                  t.setCodep(obj.get("codep").toString());
                   t.setEmail(obj.get("email").toString());
                    t.setTel(obj.get("tel").toString());
                     t.setModelivraison(obj.get("modelivraison").toString());
                     t.setStatus(Boolean.valueOf(obj.get("status").toString()));
               SimpleDateFormat sdf= new SimpleDateFormat("yy-MM-dd");
                 Map<String, Object> prch = (Map<String, Object>) obj.get("date");
                  Date dateStr;
                dateStr = ((Date)sdf.parse(prch.get("date").toString()));
               
                
              
                t.setDate(dateStr);
                //Ajouter la tâche extraite de la réponse Json à la liste
                tasks.add(t);
            }
            
            
        } catch (IOException ex) {
            
        }
         /*
            A ce niveau on a pu récupérer une liste des tâches à partir
        de la base de données à travers un service web
        
        */
        return tasks;
    }
    
        public ArrayList<Livr> getAllTasks(){
        String url = "http://localhost/FINAL%20symfony/final/web/app_dev.php/alll";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                try {
                    tasks = parseTasks(new String(req.getResponseData()));
                } catch (ParseException ex) {
                    System.out.println("error");
                }
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return tasks;
    }
    
}
