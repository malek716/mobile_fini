/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.charts.util.ColorUtil;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.Log;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import java.util.ArrayList;

/**
 *
 * @author Achraf
 */
public class addliv extends Form{
    Form me ;
    public addliv (Form previous){
    
 
       me=this;
        setTitle("Add  a new commande");
        setLayout(BoxLayout.y());
          me.getStyle().setBgColor(ColorUtil.WHITE);
        me.getStyle().setBgTransparency(255);
       TextField name= new TextField("", "namev",0, TextArea.ANY);
       TextField street= new TextField("", "street",0, TextArea.ANY);
       
       TextField cite= new TextField("", "cite",0, TextArea.ANY);
       TextField ville= new TextField("", "ville",0, TextArea.ANY);
       TextField codep = new TextField("", "code postal",0, TextArea.ANY);
       TextField email= new TextField("", "email",0, TextArea.ANY);
       
       TextField tel= new TextField("", "tel",0,TextField.NUMERIC);
       TextField modelivraison= new TextField("", "modelivraison",0, TextArea.ANY);
       Button btnValider = new Button("Ajouter livraison");
        btnValider.getStyle().setBgColor(ColorUtil.rgb(51, 153, 0));
        btnValider.getStyle().setBgTransparency(255);
        addAll(name,street,cite,ville,codep,email,tel,modelivraison,btnValider);
        
        
         btnValider.addActionListener((ActionListener) new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
               
                if ((name.getText().length()==0) || (cite.getText().length()==0)|| (ville.getText().length()==0) || (email.getText().length()==0) || (tel.getText().length()==0)|| (modelivraison.getText().length()==0)) {
                    Dialog.show("Alert", "Veuillez remplir vos champs svp", new Command("OK"));
                }
                else
                {
                   
                    ConnectionRequest con = new ConnectionRequest();
                    con.setPost(false);
                    String nam1 = name.getText();
                    String nam2 = street.getText();
                    String nam3 = cite.getText();
                    String nam4 = ville.getText();
                    String nam = codep.getText();
                    String nam5 = email.getText();
                    String nam6 = tel.getText();
                    String nam7 = modelivraison.getText();
                    int userId = 1;
                    con.setUrl("http://localhost/FINAL%20symfony/final/web/app_dev.php/addl/"+nam1+"/"+nam2+"/"+nam3+"/"+nam4+"/"+nam+"/"+nam5+"/"+nam6+"/"+nam7);
                    con.addResponseListener(new ActionListener<NetworkEvent>() {
                    @Override
                    public void actionPerformed(NetworkEvent evt) {
                    System.out.println("done comment!");
                    byte[] data = (byte[]) evt.getMetaData();
                    String s = new String(data);
                    Log.p("hhhh "+s);
                    System.out.println("response : " + s);
                    System.out.println("response : " + evt.getMetaData().equals("true"));
                    if ( s.equals("\"success\"")) {
                    Dialog.show("Confirmation", "livraison ajoutée avec succés", "Ok", null);
                  
                    
                    // previous.showBack();
                     livraff l = new livraff (me);
                    l.show();
                   
                    // to do c.refreshTheme();
                    }
                    else {
                    Dialog.show("Error", "ajout not ok", "Not Ok", null);
             
                    }
                    }
                    });
                    NetworkManager.getInstance().addToQueue(con);
                   
                }
            }
        });
   
      
         
    
       
            getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> {
                previous.showBack();
               
                //stringsArray2.clear();
                        });
            
           
           }
     
    
    
}
