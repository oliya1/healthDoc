/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicico.UI;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import nicico.model.DocTrace;
import nicico.model.Sick;
import nicico.model.User;
import nicico.service.DocTraceService;
import nicico.service.LocationService;
import nicico.service.SickService;
import nicico.service.UserService;
import nicico.utility.Common;
import nicico.utility.DateConverter;

/**
 *
 * @author Hamed
 */
public class TraceFrame extends javax.swing.JFrame {

    /**
     * Creates new form TraceFrame
     */
    public TraceFrame() {
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

        jLabel1 = new javax.swing.JLabel();
        txtBarcode = new javax.swing.JTextField();
        btnNew = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cmbSend = new javax.swing.JComboBox<>();
        btnSave = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        grid = new javax.swing.JTable();
        btnSabt = new javax.swing.JButton();
        lblUser = new javax.swing.JLabel();
        btnRefresh = new javax.swing.JButton();
        lblSick = new javax.swing.JLabel();
        btnEnd = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setName("traceFrame"); // NOI18N
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

        jLabel1.setText("بارکد:");
        jLabel1.setName("lblBarcode"); // NOI18N

        txtBarcode.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtBarcode.setName("txtBarcode"); // NOI18N
        txtBarcode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBarcodeKeyReleased(evt);
            }
        });

        btnNew.setText("جدید");
        btnNew.setFocusPainted(false);
        btnNew.setFocusable(false);
        btnNew.setName("btnNew"); // NOI18N
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        jLabel2.setText("ارسال به:");

        cmbSend.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cmbSend.setFocusable(false);
        cmbSend.setName("cmbSend"); // NOI18N

        btnSave.setText("ارسال");
        btnSave.setFocusable(false);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        grid.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ارجاع به", "ارجاع از", "محل پرونده", "ساعت", "تاریخ", "مرحله"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        grid.setFocusable(false);
        jScrollPane1.setViewportView(grid);

        btnSabt.setText("دریافت");
        btnSabt.setFocusable(false);
        btnSabt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSabtActionPerformed(evt);
            }
        });

        lblUser.setText("کاربر:");

        btnRefresh.setText("بروزرسانی");
        btnRefresh.setFocusable(false);
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        lblSick.setFocusable(false);

        btnEnd.setText("اختتام");
        btnEnd.setFocusable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(lblSick)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblUser)
                .addGap(45, 45, 45))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnRefresh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNew, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSabt, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                    .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmbSend, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtBarcode, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)))
                .addGap(46, 46, 46))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtBarcode)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnSabt, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbSend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUser)
                    .addComponent(lblSick))
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(575, 377));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try {                                        
            DocTrace docTrace = null;
            maxLevel = docTraceService.getMaxLevel(txtBarcode.getText());
            Optional<DocTrace> findFirst = docTraces.stream().filter(d->d.getLevel()== maxLevel).findFirst();
            DocTrace maxDocTrace = findFirst.orElse(docTrace);
            if((maxDocTrace != null) && (Common.getLoginedUser().getLocationId() == maxDocTrace.getLocationId())){                
                    try {
                        ComboItem selectItem = (ComboItem) cmbSend.getSelectedItem();
                        docTrace = new DocTrace(txtBarcode.getText(), selectItem.getValue());
                    }
                    catch (SQLException ex) {
                        Logger.getLogger(TraceFrame.class.getName()).log(Level.SEVERE, null, ex);
                        JLabel messageLabel = new JLabel("ارتباط با سرور برقرار نشد.",JLabel.RIGHT);
                        JOptionPane.showMessageDialog(this, messageLabel, "خطا", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    System.out.println(maxDocTrace.getReceiverId());
                    if(maxDocTrace.getReceiverId() != 0){
                        docTrace.setId(maxDocTrace.getId());
                        docTraceService.update(docTrace);
                        JLabel messageLabel = new JLabel("اطلاعات با موفقیت ویرایش شد.",JLabel.RIGHT);
                        JOptionPane.showMessageDialog(this, messageLabel, "پیغام", JOptionPane.INFORMATION_MESSAGE);
                        txtBarcodeKeyReleased(null);
                        return;
                    }
                    try {
                        docTraceService.insert(docTrace);
                        JLabel messageLabel = new JLabel("اطلاعات با موفقیت ثبت شد.",JLabel.RIGHT);
                        JOptionPane.showMessageDialog(this, messageLabel, "پیغام", JOptionPane.INFORMATION_MESSAGE);
                        txtBarcodeKeyReleased(null);
                    }
                    catch (SQLException ex) {
                        Logger.getLogger(TraceFrame.class.getName()).log(Level.SEVERE, null, ex);
                        JLabel messageLabel = new JLabel("ارتباط با سرور برقرار نشد.",JLabel.RIGHT);
                        JOptionPane.showMessageDialog(this, messageLabel, "خطا", JOptionPane.ERROR_MESSAGE);
                    }                 
                
            }
            else{
                JLabel messageLabel = new JLabel("ابتدا پرونده را دریافت کنید.",JLabel.RIGHT);
                JOptionPane.showMessageDialog(this, messageLabel, "خطا", JOptionPane.ERROR_MESSAGE);
            }
        } 
        catch (SQLException ex) {
            Logger.getLogger(TraceFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {                                  
        // TODO add your handling code here:

        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        grid.setDefaultRenderer(Integer.class, centerRenderer);        
        grid.setDefaultRenderer(String.class, centerRenderer);
        grid.getColumnModel().getColumn(5).setPreferredWidth(30);

        lblUser.setText("کاربر: " + Common.getLoginedUser().getName() + " (" + new LocationService().getById(Common.getLoginedUser().getLocationId()).getName() + ")");
        btnSabt.setEnabled(false);
        btnSave.setEnabled(false);
        users = userService.getUsers();
        List<User> collect = users.stream().filter(u->!u.getUserName().equalsIgnoreCase(Common.getLoginedUserName())).collect(Collectors.toList());
        collect.forEach(u->cmbSend.addItem(new ComboItem(u.getName(),u.getUserName())));
        } catch (Exception ex) {
            Logger.getLogger(TraceFrame.class.getName()).log(Level.SEVERE, null, ex);
            JLabel messageLabel = new JLabel("ارتباط با سرور برقرار نشد.",JLabel.RIGHT);
            JOptionPane.showMessageDialog(this, messageLabel, "خطا", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_formWindowOpened

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        // TODO add your handling code here:
        lblSick.setText("");
        txtBarcode.setEnabled(true);
        txtBarcode.setText("");
        btnSabt.setEnabled(false);
        btnSave.setEnabled(false);
        DefaultTableModel model = (DefaultTableModel) grid.getModel();
        model.setRowCount(0);
        txtBarcode.requestFocus();
    }//GEN-LAST:event_btnNewActionPerformed

    private void txtBarcodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBarcodeKeyReleased
        // TODO add your handling code here:  
        DefaultTableModel model = (DefaultTableModel) grid.getModel();        
        if(evt.getKeyChar() == '\n'){
            try {
                model.setRowCount(0);
                Sick sick = sickService.getByNationalCode(txtBarcode.getText());
                if(sick == null){
                    JLabel messageLabel = new JLabel("بارکد وارد شده در سیستم وجود ندارد.",JLabel.RIGHT);
                    JOptionPane.showMessageDialog(this, messageLabel, "خطا", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    lblSick.setText("پرونده: "+sick.getFname()+ " "+ sick.getLname());
                }
                txtBarcode.setEnabled(false);
                btnSabt.setEnabled(true);
                btnSave.setEnabled(true);                
                docTraces = docTraceService.getByBarcode(Long.valueOf(txtBarcode.getText()));
                for(DocTrace d : docTraces){
                    int[] date = DateConverter.gregorian_to_jalali(d.getDateTime().getYear(), d.getDateTime().getMonthValue(), d.getDateTime().getDayOfMonth());
                    Optional<User> sender = users.stream().filter(u->u.getId()==d.getSenderId()).findFirst();
                    Optional<User> receiver = users.stream().filter(u->u.getId()==d.getReceiverId()).findFirst();
                    model.addRow(new Object[]{
                        receiver.orElse(new User().setName("-")).getName(),
                        sender.orElse(new User().setName("-")).getName(),
                        locationService.getById(d.getLocationId()).getName(),
                        d.getDateTime().getHour()+":"+d.getDateTime().getMinute(),
                        date[0]+"/"+date[1]+"/"+date[2],
                        d.getLevel()
                    });
                }               
                
            } catch (Exception ex) {
                Logger.getLogger(TraceFrame.class.getName()).log(Level.SEVERE, null, ex);
                JLabel messageLabel = new JLabel("ارتباط با سرور برقرار نشد.",JLabel.RIGHT);
                JOptionPane.showMessageDialog(this, messageLabel, "خطا", JOptionPane.ERROR_MESSAGE);
            }   
        }
        else{
            model.setRowCount(0);
        }
    }//GEN-LAST:event_txtBarcodeKeyReleased

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            // TODO add your handling code here:
            new MainFrame().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(TraceFrame.class.getName()).log(Level.SEVERE, null, ex);
            JLabel messageLabel = new JLabel("ارتباط با سرور برقرار نشد.",JLabel.RIGHT);
            JOptionPane.showMessageDialog(this, messageLabel, "خطا", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_formWindowClosing

    private void btnSabtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSabtActionPerformed
        try {
            // TODO add your handling code here:
            maxLevel = docTraceService.getMaxLevel(txtBarcode.getText());
            if(maxLevel>0){
                DocTrace maxDocTrace = docTraces.stream().filter(d->d.getLevel()==maxLevel).findFirst().get();
                loginedUser = userService.getUser(Common.getLoginedUserName());
                if(maxDocTrace.getLocationId()!= loginedUser.getLocationId()){
                    if(maxDocTrace.getReceiverId() != loginedUser.getId()){
                        JLabel messageLabel = new JLabel("پرونده به شما ارجاع داده نشده است.",JLabel.RIGHT);
                        JOptionPane.showMessageDialog(this, messageLabel, "خطا", JOptionPane.ERROR_MESSAGE);
                    }
                    else {
                        docTraceService.insert(new DocTrace(txtBarcode.getText()));
                        txtBarcodeKeyReleased(null);
                    }
                }
                else{
                    JLabel messageLabel = new JLabel("پرونده را قبلا شما دریافت کرده اید.",JLabel.RIGHT);
                    JOptionPane.showMessageDialog(this, messageLabel, "خطا", JOptionPane.ERROR_MESSAGE);
                }
            }
            else{
                docTraceService.insert(new DocTrace(txtBarcode.getText()));
                txtBarcodeKeyReleased(null);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TraceFrame.class.getName()).log(Level.SEVERE, null, ex);
            JLabel messageLabel = new JLabel("ارتباط با سرور برقرار نشد.",JLabel.RIGHT);
            JOptionPane.showMessageDialog(this, messageLabel, "خطا", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSabtActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        txtBarcodeKeyReleased(null);
    }//GEN-LAST:event_btnRefreshActionPerformed

    List<User> users = new ArrayList<>();
    List<DocTrace> docTraces;
    final UserService userService = new UserService();
    final DocTraceService docTraceService = new DocTraceService();
    final LocationService locationService = new LocationService();
    final SickService sickService = new SickService();
    User loginedUser = new User();
    int maxLevel = 0;
    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnd;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSabt;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<ComboItem> cmbSend;
    private javax.swing.JTable grid;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblSick;
    private javax.swing.JLabel lblUser;
    private javax.swing.JTextField txtBarcode;
    // End of variables declaration//GEN-END:variables
}
