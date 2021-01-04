/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicico.UI;

import java.awt.ComponentOrientation;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import nicico.model.DocTrace;
import nicico.model.User;
import nicico.service.DocTraceService;
import nicico.service.UserService;
import nicico.utility.Common;

/**
 *
 * @author Hamed
 */
public class AutoSend extends javax.swing.JFrame {

    /**
     * Creates new form autoReceive
     */
    public AutoSend() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        optionPane = new javax.swing.JOptionPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRecevie = new javax.swing.JTable();
        txtRecevie = new javax.swing.JTextField();
        btnConfirm = new javax.swing.JButton();
        lblCount = new javax.swing.JLabel();
        btnRemove = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cmbSend = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("ارسال خودکار");
        setAlwaysOnTop(true);
        setIconImages(null);
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        tblRecevie.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "کد ملی"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblRecevie.setFocusable(false);
        jScrollPane1.setViewportView(tblRecevie);
        tblRecevie.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        txtRecevie.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtRecevie.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtRecevieKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRecevieKeyTyped(evt);
            }
        });

        btnConfirm.setText("تایید");
        btnConfirm.setFocusable(false);
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });

        lblCount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCount.setFocusable(false);

        btnRemove.setText("حذف");
        btnRemove.setFocusable(false);
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        jLabel2.setText("ارسال به:");

        cmbSend.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cmbSend.setFocusable(false);
        cmbSend.setName("cmbSend"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblCount, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtRecevie)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(cmbSend, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel2))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtRecevie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbSend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblCount, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfirm)
                    .addComponent(btnRemove))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtRecevieKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRecevieKeyReleased
        if(txtRecevie.getText().length()==10){
            for(int i=0; i<tblRecevie.getModel().getRowCount(); i++){
                if(tblRecevie.getValueAt(i, 0).equals(txtRecevie.getText())){
                    txtRecevie.setText("");
                    return;
                }
            }
            DefaultTableModel model = (DefaultTableModel)tblRecevie.getModel();            
            model.addRow(new Object[]{txtRecevie.getText()});
            lblCount.setText("تعداد: "+String.valueOf(tblRecevie.getModel().getRowCount()));
            txtRecevie.setText("");
        }
    }//GEN-LAST:event_txtRecevieKeyReleased

    private void txtRecevieKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRecevieKeyTyped
        char enter = evt.getKeyChar();
        if(!(Character.isDigit(enter))){
            evt.consume();
        }
    }//GEN-LAST:event_txtRecevieKeyTyped

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed
        DocTraceService docTraceService = new DocTraceService();
        int count = 0;
        for(int i=0; i<tblRecevie.getModel().getRowCount(); i++){
            String nationalCode = tblRecevie.getValueAt(i, 0).toString();
            try {
                ComboItem selectItem = (ComboItem) cmbSend.getSelectedItem();
                DocTrace docTrace = new DocTrace(nationalCode, selectItem.getValue());
                int insert = docTraceService.insert(docTrace);
                if(insert == 1){
                    count++;
                }
            } catch (SQLException ex) {
                Logger.getLogger(AutoSend.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        String[] options = {"تایید"};
        this.setAlwaysOnTop(false);
        
        JOptionPane optionPane = new JOptionPane();
        int res = optionPane.showOptionDialog(null, "تعداد " + count + " پرونده ارسال شد.", null, JOptionPane.OK_OPTION,
        JOptionPane.INFORMATION_MESSAGE, null, options, null);
        if(res == 0){
            DefaultTableModel model = (DefaultTableModel) tblRecevie.getModel();
            model.setRowCount(0);
            lblCount.setText("تعداد: "+String.valueOf(tblRecevie.getModel().getRowCount()));
        }
    }//GEN-LAST:event_btnConfirmActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        int[] rows = tblRecevie.getSelectedRows();
        DefaultTableModel model = (DefaultTableModel)tblRecevie.getModel();
        for(int i=rows.length-1; i>=0; i--){
            model.removeRow(rows[i]);
        }
        lblCount.setText("تعداد: "+String.valueOf(tblRecevie.getModel().getRowCount()));
        txtRecevie.setText("");
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if(tblRecevie.getModel().getRowCount() > 0){
            JLabel messageLabel = new JLabel("پرونده ها ارسال نشده است!",JLabel.RIGHT);
            JOptionPane.showMessageDialog(this, messageLabel, "خطا", JOptionPane.ERROR_MESSAGE);
            return;
        }
        this.dispose();
        try {
            new MainFrame().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(AutoSend.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowClosing

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            users = userService.getUsers();
            List<User> collect = users.stream().filter(u->!u.getUserName().equalsIgnoreCase(Common.getLoginedUserName())).collect(Collectors.toList());
            collect.forEach(u->cmbSend.addItem(new ComboItem(u.getName(),u.getUserName())));
        } catch (SQLException ex) {
            Logger.getLogger(AutoSend.class.getName()).log(Level.SEVERE, null, ex);
            JLabel messageLabel = new JLabel("ارتباط با سرور برقرار نشد.",JLabel.RIGHT);
            JOptionPane.showMessageDialog(this, messageLabel, "خطا", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_formWindowOpened

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AutoReceive.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AutoReceive.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AutoReceive.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AutoReceive.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AutoSend().setVisible(true);
            }
        });
    }
    List<User> users = new ArrayList<>();
    final UserService userService = new UserService();

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirm;
    private javax.swing.JButton btnRemove;
    private javax.swing.JComboBox<ComboItem> cmbSend;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCount;
    private javax.swing.JOptionPane optionPane;
    private javax.swing.JTable tblRecevie;
    private javax.swing.JTextField txtRecevie;
    // End of variables declaration//GEN-END:variables
}
