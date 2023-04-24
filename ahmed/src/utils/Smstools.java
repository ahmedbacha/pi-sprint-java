/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import entities.Utilisateur;

/**
 *
 * @author chaker
 */
public class Smstools {
     public static void sendSms( Utilisateur user, String code ) {
        String ACCOUNT_SID = "AC19c2f59a62debd10447477c5c976cf21";
        String AUTH_TOKEN = "762ed32480e3b4e67de48455e0d5dac0";
        
         
          Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                // to phone number
                new com.twilio.type.PhoneNumber("+216"+user.getCin()),
                new com.twilio.type.PhoneNumber("+12706771255"),
                " Votre code de reinitialisation du not de passe est : "+code)
            .create();

        System.out.println(message.getSid());
        }
    
    
}
