/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicico.UI;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.data.JRCsvDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
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
        btnAutoReceive = new javax.swing.JButton();
        btnAutoSend = new javax.swing.JButton();

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

        btnAutoReceive.setText("دریافت خودکار");
        btnAutoReceive.setFocusable(false);
        btnAutoReceive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAutoReceiveActionPerformed(evt);
            }
        });

        btnAutoSend.setText("ارسال خودکار");
        btnAutoSend.setFocusable(false);
        btnAutoSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAutoSendActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnGPrint, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnPrint, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAutoReceive, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnTrace, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAutoSend, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnTrace)
                        .addGap(18, 18, 18)
                        .addComponent(btnAutoReceive)
                        .addGap(17, 17, 17)
                        .addComponent(btnAutoSend)
                        .addGap(18, 18, 18)
                        .addComponent(btnPrint)
                        .addGap(18, 18, 18)
                        .addComponent(btnGPrint)
                        .addGap(18, 18, 18)
                        .addComponent(btnAdmin))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(47, Short.MAX_VALUE))
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
        FileFilter filter = new FileNameExtensionFilter("Excel file", "xls", "xlsx");
        fileChooser.addChoosableFileFilter(filter);
        fileChooser.setFileFilter(filter);
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
                ArrayList<String> personnelNoList = new ArrayList<>();
                while(itr.hasNext()){
                    Row row = itr.next();
                    Iterator<Cell> cellIterator = row.cellIterator();
                    while(cellIterator.hasNext()){
                        Cell cell = cellIterator.next();
//                        if(cell.getCellTypeEnum()!= CellType.NUMERIC){  
//                            msg.setText("فرمت فایل اکسل وارد شده صحیح نمیباشد.");
//                            JOptionPane.showMessageDialog(this, msg, "خطا", JOptionPane.ERROR_MESSAGE);
//                            return;
//                        }
                        if(cell.getStringCellValue().length()!= 10){
                            msg.setText("طول اطلاعات سلول 10 کارکتر نیست.");
                            JOptionPane.showMessageDialog(this, msg, "خطا", JOptionPane.ERROR_MESSAGE);
                            return;    
                        }
                        personnelNoList.add(cell.getStringCellValue());
                    }
                }             
                file.close();
                createJasperViewer(personnelNoList);
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

    private void btnAutoReceiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAutoReceiveActionPerformed
        new AutoReceive().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAutoReceiveActionPerformed

    private void btnAutoSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAutoSendActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAutoSendActionPerformed
    private void createJasperViewer(List<String> list) throws JRException{
        List<Map<String,?>> maps = new ArrayList<>();
        int i = 0;
        Map<String, Object> map = new HashMap<>();
        for(String s : list){            
            i++;
            map.put("p"+i, s);
            if(i==5){
                maps.add(map);
                map = new HashMap<>();
                i=0;
            }
        }
        maps.add(map);
        JRDataSource dataSource = new JRBeanCollectionDataSource(maps);
        String sourceName = "barcode1.jrxml";
        JasperReport report = JasperCompileManager.compileReport(sourceName);
        JasperPrint fillReport = JasperFillManager.fillReport(report, null, dataSource);
        JasperViewer.viewReport(fillReport, false);
    }
    private void createVcs(List<String> list) throws JRException, FileNotFoundException {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new File("NewData.csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        StringBuilder builder = new StringBuilder();
        String columnNamesList = "p1 p2 p3 p4 p5";
        builder.append(columnNamesList +"\n");
        int i = 0;
        String row = "";
        for(String s : list){
            row += s;
            i++;
            if(i%5 != 0){
                row += " ";
                continue;
            }
            builder.append(row + "\n");
            row = "";
        }
        builder.append(row);
        pw.write(builder.toString());
        pw.close();
        System.out.println("done!");
        FileInputStream file = new FileInputStream("src/nicico/report/barcode.jasper");
        JasperReport name = (JasperReport) JRLoader.loadObject(file);
        JRCsvDataSource jrCsvDataSource = new JRCsvDataSource(JRLoader.getLocationInputStream("NewData.csv"));
        JasperPrint fillReport = JasperFillManager.fillReport(name, null, jrCsvDataSource);        
        JasperViewer.viewReport(fillReport);       
    }
    private JLabel msg;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdmin;
    private javax.swing.JButton btnAutoReceive;
    private javax.swing.JButton btnAutoSend;
    private javax.swing.JButton btnGPrint;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnTrace;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
