/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicico;

import java.awt.Font;
import java.io.IOException;
import java.net.BindException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import nicico.UI.MainFrame;
import nicico.utility.Common;

/**
 *
 * @author Hamed
 */
public class AppStart {

    /**
     * @param args the command line arguments
     */
    private static final int PORT = 9999;
    private static ServerSocket socket;
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            //Bind to localhost adapter with a zero connection queue 
            socket = new ServerSocket(PORT,0,InetAddress.getByAddress(new byte[] {127,0,0,1}));
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    Common.setUIFont(new javax.swing.plaf.FontUIResource("tahoma",Font.LAYOUT_RIGHT_TO_LEFT,12));                
                    UIManager.put("OptionPane.okButtonText", "تایید");
                    try {
                        new MainFrame().setVisible(true);
                    } catch (Exception ex) {
                        Logger.getLogger(AppStart.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
         }
         catch (BindException e) {
            System.err.println("Already running.");
            System.exit(1);
         }
         catch (IOException e) {
            System.err.println("Unexpected error.");
            e.printStackTrace();
            System.exit(2);
         }
        
    }

    private static JLabel JLabel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
