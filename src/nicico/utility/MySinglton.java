/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicico.utility;

import com.google.gson.Gson;
import java.util.logging.Level;
import java.util.logging.Logger;
import nicico.model.User;
import nicico.service.UserService;

/**
 *
 * @author Hamed
 */
public class MySinglton {
    private static Gson gson;
    private static User loginedUser;
    static{
        if(gson == null){
            gson = new Gson();
        }
        if(loginedUser == null){
            try {
                loginedUser = new UserService().getUser(System.getProperty("user.name").toLowerCase());
                System.out.println(System.getProperty("user.name"));
            } catch (Exception ex) {
                Logger.getLogger(MySinglton.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public static Gson getGson(){
        return gson;
    }  
    public static User getLoginedUser(){
        return loginedUser;
    }
}
