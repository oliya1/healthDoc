/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicico.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import nicico.model.Location;
import nicico.utility.Common;
import org.eclipse.jdt.internal.compiler.ast.ThisReference;

/**
 *
 * @author Hamed
 */
public class UserRestService {   
    
    public static void main(String[] args) throws Exception {
//        URL oracle = new URL("http://localhost:8080/api/location/");
//        URLConnection yc = oracle.openConnection();
//        BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
//        String inputLine;
//        while ((inputLine = in.readLine()) != null) 
//            System.out.println(inputLine);
//        in.close();
        String data = Common.getJSON("http://localhost:8080/api/location/", 3000);
        Location[] locations = new Gson().fromJson(data, Location[].class);
        for(Location l : locations){
            System.out.println(l.getId() + l.getName());
        }
    }    
}
