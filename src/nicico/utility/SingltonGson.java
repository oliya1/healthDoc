/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicico.utility;

import com.google.gson.Gson;

/**
 *
 * @author Hamed
 */
public class SingltonGson {
    private static Gson gson;
    static{
        gson = new Gson();
    }
    public static Gson getGson(){
        return gson;
    }    
}
