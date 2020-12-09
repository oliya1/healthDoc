/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicico.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import nicico.data.DataBase;
import nicico.model.DocTrace;

/**
 *
 * @author Hamed
 */
public class DocTraceService {
    private DataBase db;
    public DocTraceService(){
        db = DataBase.getInstance();
    }
    public int getMaxLevel(Long barcode) throws SQLException{
        PreparedStatement ps = db.getConnection().prepareStatement("select ifnull(max(level),0) from workflow where barcode = ?");
        ps.setLong(1, barcode);
        ResultSet rs = ps.executeQuery();
        int max = 0;
        if (rs.next()) {
           max = rs.getInt(1);
        }
        return max;
    }  
    
    
    public int insert(DocTrace dt) throws SQLException{
        PreparedStatement ps = db.getConnection().prepareStatement("INSERT INTO workflow(barcode, date_time, level, cycle, sender_id, receiver_id, location_id)" + 
                "VALUES (?,?,?,?,?,?,?)");
        ps.setLong(1, dt.getBarcode());
        ps.setObject(2, dt.getDateTime());
        ps.setInt(3, dt.getLevel());
        ps.setInt(4, dt.getCycle());
        ps.setInt(5, dt.getSenderId());
        ps.setInt(6, dt.getReceiverId());
        ps.setLong(7, dt.getLocationId());
        return ps.executeUpdate();
    }
    
    public int update(DocTrace dt) throws SQLException{
        PreparedStatement ps = db.getConnection().prepareStatement("update workflow set date_time = ?, location_id = ?, receiver_id = ? where id = ?");
        ps.setObject(1, dt.getDateTime());
        ps.setLong(2, dt.getLocationId());
        ps.setInt(3, dt.getReceiverId());
        ps.setLong(4, dt.getId());
        return ps.executeUpdate();        
    }
    
    public List<DocTrace> getByBarcode(Long barcode) throws SQLException{
        PreparedStatement ps = db.getConnection().prepareStatement("select * from workflow where barcode = ? order by level desc");
        ps.setLong(1, barcode);
        ResultSet rs = ps.executeQuery();
        ArrayList<DocTrace> docTraces = new ArrayList<DocTrace>();
        while(rs.next()){
            DocTrace docTrace = new DocTrace();
            docTrace.setLevel(rs.getInt("level"));
            docTrace.setDateTime(rs.getObject("date_time", LocalDateTime.class));
            docTrace.setReceiverId(rs.getInt("receiver_id"));
            docTrace.setSenderId(rs.getInt("sender_id"));
            docTrace.setLocationId(rs.getLong("location_id"));
            docTrace.setId(rs.getLong("id"));
            docTraces.add(docTrace);
        }
        return docTraces;
    }
//    public static void main(String[] args){
//            
//        try {
//            new DocTraceService().getMaxLevel(9806602991743247l);
//        } catch (SQLException ex) {
//            Logger.getLogger(DocTraceService.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//    }
}
