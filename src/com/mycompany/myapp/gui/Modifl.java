/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.io.ConnectionRequest;
import com.codename1.io.Log;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.entities.Livr;
import com.mycompany.entities.produit;
import com.mycompany.entities.societe;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Achraf
 */
public class Modifl extends Form{
      Form me ;
     
      Form previous = Display.getInstance().getCurrent();
       public Modifl(Livr l){
       
        me=this;
        setTitle("Modifier reclamation");
        setLayout(BoxLayout.y());
        
       Button btnValider = new Button("Modifier Reclamation");
       TextField nam1= new TextField("", "name",0,TextField.NUMERIC);
       nam1.setText(l.getNamev());
       TextField nam2= new TextField("", "Street",0,TextField.NUMERIC);
       nam2.setText(l.getStreet());
       TextField nam3= new TextField("", "cite",0,TextField.NUMERIC);
       nam3.setText(l.getCite());
       TextField nam4= new TextField("", "ville",0,TextField.NUMERIC);
       nam4.setText(l.getVille());
        TextField nam5= new TextField("", "codepostal",0,TextField.NUMERIC);
       nam5.setText(l.getCodep());
        TextField nam6= new TextField("", "email",0,TextField.NUMERIC);
       nam6.setText(l.getEmail());
        TextField nam7= new TextField("", "tel",0,TextField.NUMERIC);
       nam7.setText(l.getTel());
        TextField nam8= new TextField("", "modelivraison",0,TextField.NUMERIC);
       nam8.setText(l.getModelivraison());
       Label designationLabel = new Label("name");
       Label descriptionLabel2 = new Label("Street");
        Label descriptionLabel3 = new Label("cite");
         Label descriptionLabel4 = new Label("ville");
          Label descriptionLabel5 = new Label("code postal");
           Label descriptionLabel6 = new Label("email");
            Label descriptionLabel7 = new Label("tel");
             Label descriptionLabel8 = new Label("modelivraison");
             me.addAll(designationLabel,nam1,descriptionLabel2,nam2,descriptionLabel3,nam3,descriptionLabel4,nam4,descriptionLabel5,nam5,descriptionLabel6,nam6,descriptionLabel7,nam7,descriptionLabel8,nam8);
        
        me.add(btnValider);
       //******************
       btnValider.addActionListener((ActionListener) (ActionEvent evt) -> {
           
           
           if ((nam1.getText().length()==0) || (nam2.getText().length()==0))
           Dialog.show("Alert", "Veuillez remplir vos champs svp", new Command("OK"));
           else
           {
               int identifiant = l.getIdv();
               ConnectionRequest con = new ConnectionRequest();
               con.setPost(false);
               String namev = nam1.getText();
               String street = nam2.getText();
               String cite = nam3.getText();
               String ville = nam4.getText();
               String codep = nam5.getText();
               String email = nam6.getText();
               String tel = nam7.getText();
               String modelivraison = nam8.getText();
               con.setUrl("http://localhost/FINAL%20symfony/final/web/app_dev.php/up/"+identifiant+"/"+namev+"/"+street+"/"+cite+"/"+ville+"/"+codep+"/"+email+"/"+tel+"/"+modelivraison);
              
               con.addResponseListener(new ActionListener<NetworkEvent>() {
                    @Override
                    public void actionPerformed(NetworkEvent evt) {
                        System.out.println("done comment!");
                        byte[] data = (byte[]) evt.getMetaData();
                        String s = new String(data);
                        Log.p("response : " + s);
                        if ( s.equals("\"success\"")) {
                            Dialog.show("Confirmation", "cette reclamation est modifiée avec succés", "Ok", null);
                            livraff l = new livraff(me);
                             l.show();
                        }
                        else {
                            Dialog.show("Error", "not modified", "Not Ok", null);
                        }
                    }
                });
               NetworkManager.getInstance().addToQueue(con);
            }
        });
      }

      // getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e->previous.showBack());
       
       }

    

