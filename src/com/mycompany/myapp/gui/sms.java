/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;
import com.codename1.ui.TextField;
import com.twilio.type.PhoneNumber;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
/**
 *
 * @author Achraf
 */
public class sms {
  
    public static final String ACCOUNT_SID = "ACa8d531caf730e43fb91841d30a00dfcc";
    public static final String AUTH_TOKEN = "Show";
    
    public static void SMS_DON() {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message.creator(new PhoneNumber("+21628546619"),//to
                new PhoneNumber("+12029524289"),//from 
                "a participer a").create();
       System.out.println("gfd");
    }
}

