/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicico.UI;

import java.awt.ComponentOrientation;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import nicico.model.DocTrace;
import nicico.service.DocTraceService;

/**
 *
 * @author Hamed
 */
public class AutoReceive extends javax.swing.JFrame {

    /**
     * Creates new form autoReceive
     */
    public AutoReceive() {
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("دریافت خودکار");
        setAlwaysOnTop(true);
        setIconImages(null);
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtRecevie, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCount, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 2, Short.MAX_VALUE)))
                .addGap(0, 18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(txtRecevie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(lblCount, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfirm)
                    .addComponent(btnRemove))
                .addGap(24, 24, 24))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtRecevieKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRecevieKeyReleased
//        if(txtRecevie.getText().equals("\n")){
//            for(int i=0; i<tblRecevie.getModel().getRowCount(); i++){
//                if(tblRecevie.getValueAt(i, 0).equals(txtRecevie.getText())){
//                    txtRecevie.setText("");
//                    return;
//                }
//            }
//            DefaultTableModel model = (DefaultTableModel)tblRecevie.getModel();            
//            model.addRow(new Object[]{txtRecevie.getText()});
//            lblCount.setText("تعداد: "+String.valueOf(tblRecevie.getModel().getRowCount()));
//            txtRecevie.setText("");
//        }
    }//GEN-LAST:event_txtRecevieKeyReleased

    private void txtRecevieKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRecevieKeyTyped
        char enter = evt.getKeyChar();
        if(enter == '\n'){
            System.out.println("enter");
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
                DocTrace docTrace = new DocTrace(nationalCode);
                int insert = docTraceService.insert(docTrace).getData().intValue();
                if(insert == 1){
                    count++;
                }
            } catch (Exception ex) {
                Logger.getLogger(AutoReceive.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        String[] options = {"تایید"};
        this.setAlwaysOnTop(false);
        
        JOptionPane optionPane = new JOptionPane();
        int res = optionPane.showOptionDialog(null, "تعداد " + count + " پرونده دریافت شد.", null, JOptionPane.OK_OPTION,
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
            JLabel messageLabel = new JLabel("پرونده ها دریافت نشده است!",JLabel.RIGHT);
            JOptionPane.showMessageDialog(this, messageLabel, "خطا", JOptionPane.ERROR_MESSAGE);
            return;
        }
        this.dispose();
        try {
            new MainFrame().setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(AutoReceive.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(AutoReceive.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(AutoReceive.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(AutoReceive.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(AutoReceive.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new AutoReceive().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirm;
    private javax.swing.JButton btnRemove;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCount;
    private javax.swing.JOptionPane optionPane;
    private javax.swing.JTable tblRecevie;
    private javax.swing.JTextField txtRecevie;
    // End of variables declaration//GEN-END:variables
}
