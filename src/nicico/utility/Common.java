/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicico.utility;

import java.sql.SQLException;
import javax.swing.UIManager;
import nicico.model.User;
import nicico.service.UserService;

/**
 *
 * @author Hamed
 */
public class Common {
    private static final UserService userService = new UserService();
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
    public static User getLoginedUser() throws SQLException {
        return userService.getUser(getLoginedUserName());
    }
    
    public static void setUIFont (javax.swing.plaf.FontUIResource f){
    java.util.Enumeration keys = UIManager.getDefaults().keys();
    while (keys.hasMoreElements()) {
      Object key = keys.nextElement();
      Object value = UIManager.get (key);
      if (value instanceof javax.swing.plaf.FontUIResource)
        UIManager.put (key, f);
      }
    } 
}
