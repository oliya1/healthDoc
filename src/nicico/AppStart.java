/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicico;

import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
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
    public static void main(String[] args) {
        // TODO code application logic here
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Common.setUIFont(new javax.swing.plaf.FontUIResource("b nazanin",Font.BOLD,12));
                
                UIManager.put("OptionPane.okButtonText", "تایید");
                new MainFrame().setVisible(true);
            }
        });
    }
    
}
