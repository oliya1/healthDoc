/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicico.UI;

import java.io.File;
import java.io.FileInputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import nicico.utility.Common;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Hamed
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFram
     */
    public MainFrame() throws SQLException {
        initComponents();
        if(Common.getLoginedUser().getRule().equalsIgnoreCase("admin")){
            btnAdmin.setEnabled(true);
        }
        msg = new JLabel("",JLabel.RIGHT);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileChooser = new javax.swing.JFileChooser();
        btnTrace = new javax.swing.JButton();
        btnPrint = new javax.swing.JButton();
        btnAdmin = new javax.swing.JButton();
        btnGPrint = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setName("mainFrame"); // NOI18N
        setResizable(false);

        btnTrace.setText("رهگیری بارکد");
        btnTrace.setFocusable(false);
        btnTrace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTraceActionPerformed(evt);
            }
        });

        btnPrint.setText("چاپ بارکد");
        btnPrint.setFocusable(false);
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });

        btnAdmin.setText("مدیریت");
        btnAdmin.setEnabled(false);
        btnAdmin.setFocusable(false);
        btnAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminActionPerformed(evt);
            }
        });

        btnGPrint.setText("چاپ گروهی");
        btnGPrint.setFocusable(false);
        btnGPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGPrintActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nicico/UI/cooper_arm.png"))); // NOI18N
        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(btnTrace, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(btnGPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(btnAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(btnPrint))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(btnTrace))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(btnGPrint))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(btnAdmin)))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnTraceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTraceActionPerformed
        // TODO add your handling code here:
        new TraceFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnTraceActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        try {
            // TODO add your handling code here:
            if(Common.getLoginedUser().getRule().equalsIgnoreCase("admin")){
                new PrintFrame().setVisible(true);
                this.dispose();
            }
            else{
                msg.setText("کاربر محترم شما به این فرم دسترسی ندارید.");
                JOptionPane.showMessageDialog(this, msg, "خطا", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            msg.setText("ارتباط با سرور برقرار نشد.");
            JOptionPane.showMessageDialog(this, msg, "خطا", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnPrintActionPerformed

    private void btnAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminActionPerformed
        // TODO add your handling code here:
        new AdminFrame().setVisible(true);
    }//GEN-LAST:event_btnAdminActionPerformed

    private void btnGPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGPrintActionPerformed
        // TODO add your handling code here:
        int returnVal = fileChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try {
                FileInputStream file = new FileInputStream(selectedFile.getAbsolutePath());
                //Create Workbook instance holding reference to .xlsx file
                XSSFWorkbook workbook = new XSSFWorkbook(file);
                //Get first/desired sheet from the workbook
                XSSFSheet sheet = workbook.getSheetAt(0);
                Iterator<Row> itr = sheet.iterator();
                ArrayList<Integer> personnelNoList = new ArrayList<>();
                while(itr.hasNext()){
                    Row row = itr.next();
                    Iterator<Cell> cellIterator = row.cellIterator();
                    while(cellIterator.hasNext()){
                        Cell cell = cellIterator.next();
                        if(cell.getCellTypeEnum()!= CellType.NUMERIC){  
                            msg.setText("فرمت فایل اکسل وارد شده صحیح نمیباشد.");
                            JOptionPane.showMessageDialog(this, msg, "خطا", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        if(String.valueOf((int)cell.getNumericCellValue()).length()!= 6){
                            msg.setText("طول اطلاعات سلول بیشتر از 6 کارکتر است.");
                            JOptionPane.showMessageDialog(this, msg, "خطا", JOptionPane.ERROR_MESSAGE);
                            return;    
                        }
                        personnelNoList.add((int)cell.getNumericCellValue());
                    }
                }             
                file.close();
            } 
            catch (Exception e) {
                    e.printStackTrace();
                    msg.setText("فرمت فایل انتخاب شده باید xlsx باشد.");
                    JOptionPane.showMessageDialog(this, msg, "خطا", JOptionPane.ERROR_MESSAGE);
                }
        } else {
            System.out.println("File access cancelled by user.");
        }
    }//GEN-LAST:event_btnGPrintActionPerformed
    private JLabel msg;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdmin;
    private javax.swing.JButton btnGPrint;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnTrace;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
