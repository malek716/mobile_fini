/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.charts.util.ColorUtil;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.table.TableLayout;
import com.mycompany.entities.Livr;

/**
 *
 * @author Achraf
 */
public class Detailslivr extends Form{
    Form current;
  public Detailslivr (Livr s){
     current=this;
          Form previous = Display.getInstance().getCurrent();
          SpanLabel mail = new SpanLabel(""+s.getEmail());
          //mail.getTextAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_LARGE));
          Container cDetail = BorderLayout.center(
                TableLayout.encloseIn(
                        2,
                        true,
                        new Label("Numéro:", ""),
                        new Label(""+s.getIdv()),
                        new Label("Nom:", ""),
                        new Label(s.getNamev()),
                        new Label("Street:", ""),
                        //createTxtName(c),
                        new Label(s.getStreet()),
                        //createTxtName(c),
                        new Label("Cite", ""),
                        new Label(""+s.getCite()),
                         new Label("Ville", ""),
                        new Label(""+s.getVille()),
                        new Label("Code postal:", ""),
                        //createTxtName(c),
                        new Label(""+s.getCodep()),
                        //createTxtAge(c)
                        new Label("email", ""),
                        new Label(""+s.getEmail()),
                        new Label("Tel", ""),
                        new Label(""+s.getTel()),
                        new Label("modelivraison", ""),
                        new Label(""+s.getModelivraison()),
                        new Label("status", ""),
                        new Label(""+s.isStatus()),
                        new Label("date", ""),
                        new Label(""+s.getDate())
                )      
                  
            );
          Button btnValider = new Button("Envoyer un SMS");
          current.add(btnValider);
          btnValider.addActionListener(e-> sms.SMS_DON());
        current.getStyle().setBgColor(ColorUtil.WHITE);
        current.getStyle().setBgTransparency(255);
        current.add(cDetail);
        current.show();
      
 
     
     
                 getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e->previous.showBack());

    
                 
    }
    
}
