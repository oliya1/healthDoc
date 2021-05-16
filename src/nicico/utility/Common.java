/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicico.utility;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
//import org.json.JSONObject;

/**
 *
 * @author Hamed
 */
public class Common {
//    private static final UserService userService = new UserService();
    public static boolean validationNationalCode(String code){
        //check length
        if (code.length() != 10)
            return false;
 
        long nationalCode = Long.parseLong(code);
        byte[] arrayNationalCode = new byte[10];
 
        //extract digits from number
        for (int i = 0; i < 10 ; i++) {
            arrayNationalCode[i] = (byte) (nationalCode % 10);
            nationalCode = nationalCode / 10;
        }
 
        //Checking the control digit
        int sum = 0;
        for (int i = 9; i > 0 ; i--)
            sum += arrayNationalCode[i] * (i+1);
        int temp = sum % 11;
        if (temp < 2)
            return arrayNationalCode[0] == temp;
        else
            return arrayNationalCode[0] == 11 - temp;
    }
    public static String getLoginedUserName(){
        return System.getProperty("user.name");
//                return "ham";
    }
//    public static User getLoginedUser() throws Exception {
//        return userService.getUser(getLoginedUserName());
//    }
    
    public static void setUIFont (javax.swing.plaf.FontUIResource f){
    java.util.Enumeration keys = UIManager.getDefaults().keys();
    while (keys.hasMoreElements()) {
      Object key = keys.nextElement();
      Object value = UIManager.get (key);
      if (value instanceof javax.swing.plaf.FontUIResource)
        UIManager.put (key, f);
      }
    }
    
    public static String getJSON(String url, int timeout) throws IOException {
        url = "http://10.1.254.89:8080/api/" + url;
        HttpURLConnection c = null;
        try {
            URL u = new URL(url);
            c = (HttpURLConnection)u.openConnection();
            c.setRequestMethod("GET");
            c.setRequestProperty("Content-length", "0");
            c.setUseCaches(false);
            c.setAllowUserInteraction(false);
            c.setConnectTimeout(30000);
            c.setReadTimeout(30000);
            c.connect();
            int status = c.getResponseCode();
            switch (status) {
                case 200:
                case 201:
                    BufferedReader br = new BufferedReader(new InputStreamReader(c.getInputStream(), "UTF-8"));
                    StringBuilder sb = new StringBuilder();
                    String line;
                    while ((line = br.readLine()) != null) {
                        sb.append(line+"\n");
                    }
                    br.close();
                    return sb.toString();
            }

        } catch (MalformedURLException ex) {
            Logger.getLogger("Common").log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger("Common").log(Level.SEVERE, null, ex);
        } finally {
           if (c != null) {
              try {
                  c.disconnect();
              } catch (Exception ex) {
                 Logger.getLogger("Common").log(Level.SEVERE, null, ex);
              }
           }
        }
        return null;
    }
    
    public static String excutePost(String targetURL, String urlParameters, String method){
      targetURL = "http://10.1.254.89:8080/api/" + targetURL;
      HttpURLConnection connection = null;  
      try {
        //Create connection
        URL url = new URL(targetURL);
        connection = (HttpURLConnection)url.openConnection();
        connection.setRequestMethod(method);
        connection.setRequestProperty("Content-Type", 
             "application/json");
        connection.setRequestProperty("custom-Header", "XYZ");
        connection.setRequestProperty("Content-Length", "" + 
                 Integer.toString(urlParameters.getBytes().length));
        connection.setRequestProperty("Content-Language", "en-US");        

        connection.setUseCaches (false);
        connection.setDoInput(true);
        connection.setDoOutput(true);
        
        //Send request
        DataOutputStream wr = new DataOutputStream (
                    connection.getOutputStream ());
        wr.write(urlParameters.getBytes("UTF-8"));
        wr.flush ();
        wr.close ();
        //Get Response    
        InputStream is = connection.getInputStream();
        BufferedReader rd = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        String line;
        StringBuffer response = new StringBuffer(); 
        while((line = rd.readLine()) != null) {
          response.append(line);
          response.append('\r');
        }
        rd.close();
        return response.toString();
      } catch (Exception e) {
        e.printStackTrace();
        return null;
      } finally {
        if(connection != null) {
          connection.disconnect(); 
        }
      }
    }
}
