/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.charts.util.ColorUtil;
import com.codename1.components.MultiButton;
import com.codename1.components.SpanLabel;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.Log;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Component;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.mycompany.entities.CommandeF;
import com.mycompany.entities.Livr;
import com.mycompany.myapp.services.ServiceLivr;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Achraf
 */
public class livraff extends Form{
     Form accueilf;
      accueil a = new accueil();
     String[] commandes = {"Modifier", "Details", "Supprimer"};
       ServiceLivr myServices = new ServiceLivr();
       ArrayList <Livr> listInitial = myServices.getAllTasks();
        ArrayList<Livr> list = listInitial;
         public livraff (Form previous){
             
           //  ServiceLivr myService = new ServiceLivr();
              accueilf=this;
        setTitle("les livraisons ");
        setLayout(BoxLayout.y());
        
        Toolbar.setGlobalToolbar(true);
        Style s = UIManager.getInstance().getComponentStyle("TitleCommand");
                FontImage icon = FontImage.createMaterial(FontImage.MATERIAL_MENU, s);
                TextField searchField = new TextField("", "Search..."); 
                searchField.getHintLabel().setUIID("Title");
                searchField.setUIID("Title");
                searchField.getAllStyles().setAlignment(Component.LEFT);
                accueilf.getToolbar().setTitleComponent(searchField);
                FontImage searchIcon = FontImage.createMaterial(FontImage.MATERIAL_SEARCH, s);
              int m =  list.size();
        Label lnom = new Label("Societe");
     lnom.setText("Nombre des livraison : "+m);
     accueilf.add(lnom);
         if (list.isEmpty()) {
            SpanLabel lb = new SpanLabel(" acune livraison!");
           accueilf.add(lb);
        } else {

            for (Livr r : list) {

                MultiButton b = new MultiButton("");
                b.getStyle().setBgColor(ColorUtil.WHITE);
                b.getStyle().setBgTransparency(255);
                b.getUnselectedStyle().setBorder(Border.createGrooveBorder(2, ColorUtil.rgb(51, 153, 0)));
               // b.getUnselectedStyle().setBorder(Border.createGrooveBorder(4, 0xff));
                b.setTextLine2("Num° \n:" + r.getIdv());
                b.setTextLine4("Name \n:" + r.getNamev());
                 b.setTextLine3("Ville \n:" + r.getVille());
                  accueilf.add(b);
                   b.addActionListener(e -> {
                    Dialog d = new Dialog();
                    d.setLayout(BoxLayout.y());
                    d.getContentPane().setScrollableY(true);
                    for (String cmd : commandes) {
                        MultiButton mb = new MultiButton(cmd);
                        d.add(mb);
                        mb.addActionListener(ee -> {

                            switch (cmd) {

                                case "Modifier":
                                    Modifl  c = null;
                                    c = new Modifl(r);
                                    //   c = new ModifC(r.getIdm(), r.getDate(), r.getQuantite(), r.getSociete(), r.getProduit(), products, societies);
                                   c.show();
                                    
                                    break;
                                case "Supprimer":   
                                    delete(r.getIdv(), d);  
                                    break;
                                default:

                            
                                   
                                 Detailslivr k = new Detailslivr(r);
                                   k.show();
                            
                                   
                                    
                                    break;
                            }

                            
                        });
                    }
                    d.showPopupDialog(b);

                });
                  
            }}
          searchField.addDataChangeListener((i1, i2) -> { 
                    String t = searchField.getText();
                    if(t.length() < 1) {
                        accueilf.removeAll();
                        list = listInitial;
                        Display();
                    } else {
                        t = t.toLowerCase();
                        int i = 0;
                        accueilf.removeAll();
                        for (Livr r : list) {
                            if ( r.getNamev().indexOf(t) > -1 ){

                MultiButton b = new MultiButton("");
                b.getStyle().setBgColor(ColorUtil.WHITE);
                b.getStyle().setBgTransparency(255);
                b.getUnselectedStyle().setBorder(Border.createGrooveBorder(2, ColorUtil.rgb(51, 153, 0)));
               // b.getUnselectedStyle().setBorder(Border.createGrooveBorder(4, 0xff));
                b.setTextLine2("Num° \n:" + r.getIdv());
                b.setTextLine4("Name \n:" + r.getNamev());
                b.setTextLine3("ville \n:" + r.getVille());
                
                  accueilf.add(b);
                   b.addActionListener(e -> {
                    Dialog d = new Dialog();
                    d.setLayout(BoxLayout.y());
                    d.getContentPane().setScrollableY(true);
                    for (String cmd : commandes) {
                        MultiButton mb = new MultiButton(cmd);
                        d.add(mb);
                        mb.addActionListener(ee -> {

                            switch (cmd) {

                                case "Modifier":
                                    Modifl  c = null;
                                    c = new Modifl(r);
                                    //   c = new ModifC(r.getIdm(), r.getDate(), r.getQuantite(), r.getSociete(), r.getProduit(), products, societies);
                                   c.show();
                                    
                                    break;
                                case "Supprimer":   
                                    delete(r.getIdv(), d);  
                                    break;
                                default:

                            
                                   
                                 Detailslivr k = new Detailslivr(r);
                                   k.show();
                            
                                   
                                    
                                    break;
                            }

                            
                        });
                    }
                    d.showPopupDialog(b);

                });
                  
            }}
                    }    
                    
          });
        
         getToolbar().addMaterialCommandToRightBar(
                   "", FontImage.MATERIAL_ADD, 6f,( ActionEvent e) -> {
                 new addliv(accueilf).show();

        });
             getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e->previous.showBack());
          }
         public void Display() {
                 for (Livr r : list) {

                MultiButton b = new MultiButton("");
                b.getStyle().setBgColor(ColorUtil.WHITE);
                b.getStyle().setBgTransparency(255);
                b.getUnselectedStyle().setBorder(Border.createGrooveBorder(2, ColorUtil.rgb(51, 153, 0)));
               // b.getUnselectedStyle().setBorder(Border.createGrooveBorder(4, 0xff));
                b.setTextLine2("Num° \n:" + r.getIdv());
                b.setTextLine4("Name \n:" + r.getNamev());
                 b.setTextLine3("Ville \n:" + r.getVille());
                  accueilf.add(b);
                   b.addActionListener(e -> {
                    Dialog d = new Dialog();
                    d.setLayout(BoxLayout.y());
                    d.getContentPane().setScrollableY(true);
                    for (String cmd : commandes) {
                        MultiButton mb = new MultiButton(cmd);
                        d.add(mb);
                        mb.addActionListener(ee -> {

                            switch (cmd) {

                                case "Modifier":
                                    Modifl  c = null;
                                    c = new Modifl(r);
                                    //   c = new ModifC(r.getIdm(), r.getDate(), r.getQuantite(), r.getSociete(), r.getProduit(), products, societies);
                                   c.show();
                                    
                                    break;
                                case "Supprimer":   
                                    delete(r.getIdv(), d);  
                                    break;
                                default:

                            
                                   
                                 Detailslivr k = new Detailslivr(r);
                                   k.show();
                            
                                   
                                    
                                    break;
                            }

                            
                        });
                    }
                    d.showPopupDialog(b);

                });
                  
            }}
         
         public void delete(int id, Dialog d) {
            Log.p("clicked too");
                    ConnectionRequest con = new ConnectionRequest();
                    con.setPost(false);
                    con.setUrl("http://localhost/FINAL%20symfony/final/web/app_dev.php/delll/"+id);
                    con.addResponseListener(new ActionListener<NetworkEvent>() {
                    @Override
                    public void actionPerformed(NetworkEvent evt) {
                    System.out.println("done comment!");
                    byte[] data = (byte[]) evt.getMetaData();
                    String s = new String(data);
                    System.out.println("response : " + s);
                    System.out.println("response : " + evt.getMetaData().equals("true"));
                    if ( s.equals("\"success\"")) {
                        reloadForm();
                        Dialog.show("Confirmation", "deleted successfulyy", "Ok", null);
                        d.dispose();
                    }
                    else {
                    Dialog.show("Error", "not deleted", "Not Ok", null);
                    }
                    }
                    });
                    NetworkManager.getInstance().addToQueue(con);
        }
         public void reloadForm() {
         listInitial.clear();
         listInitial = myServices.getAllTasks();
         accueilf.removeAll();
         list.clear();
         list = listInitial;
         if (list.isEmpty()) {
            SpanLabel lb = new SpanLabel(" acune livraison!");
           accueilf.add(lb);
        } else {

            for (Livr r : list) {

                MultiButton b = new MultiButton("");
                b.getStyle().setBgColor(ColorUtil.WHITE);
                b.getStyle().setBgTransparency(255);
                b.getUnselectedStyle().setBorder(Border.createGrooveBorder(2, ColorUtil.rgb(51, 153, 0)));
               // b.getUnselectedStyle().setBorder(Border.createGrooveBorder(4, 0xff));
                b.setTextLine2("Num° \n:" + r.getIdv());
                b.setTextLine4("Name \n:" + r.getNamev());
                 b.setTextLine3("Ville \n:" + r.getVille());
                  accueilf.add(b);
                   b.addActionListener(e -> {
                    Dialog d = new Dialog();
                    d.setLayout(BoxLayout.y());
                    d.getContentPane().setScrollableY(true);
                    for (String cmd : commandes) {
                        MultiButton mb = new MultiButton(cmd);
                        d.add(mb);
                        mb.addActionListener(ee -> {

                            switch (cmd) {

                                case "Modifier":
                                    Modifl  c = null;
                                    c = new Modifl(r);
                                   // c = new Modifl(r.getIdv(),r.getNamev(), r.getStreet(),r.getCite(), r.getVille(),r.getCodep(),r.getEmail(),r.getTel(),r.getModelivraison());
                                   c.show();
                                    
                                    break;
                                case "Supprimer":   
                                    delete(r.getIdv(), d);  
                                    break;
                                default:

                            
                                   
                                 Detailslivr k = new Detailslivr(r);
                                   k.show();
                            
                                   
                                    
                                    break;
                            }

                            
                        });
                    }
                    d.showPopupDialog(b);

                });
                  
            }}
        
         }
    
}
         