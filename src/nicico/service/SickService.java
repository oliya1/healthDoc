/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicico.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import nicico.data.DataBase;
import nicico.model.Sick;

/**
 *
 * @author Hamed
 */
public class SickService {
    private DataBase db;
    public SickService(){
        db = DataBase.getInstance();
    }
    public int create(Sick sick) throws SQLException{
        PreparedStatement ps = db.getConnection().prepareStatement("INSERT INTO sick(fname, lname, personnel_no, national_code, create_by)" + 
                "VALUES (?,?,?,?,?)");
        ps.setString(1, sick.getFname());
        ps.setString(2, sick.getLname());
        ps.setInt(3, sick.getPersonnelNo());
        ps.setString(4, sick.getNationalCode());
        ps.setString(5, sick.getCreateBy());
        int count = ps.executeUpdate();
        
        System.out.println("عملیات با موفقیت انجام شد");
//        db.closeConnection();
        return count;
    }
    
    public Sick getByPersonnelNo(int personnelNo) throws SQLException{
        PreparedStatement ps = db.getConnection().prepareStatement("select * from sick where personnel_no = ?");
        ps.setInt(1, personnelNo);
        ResultSet rs = ps.executeQuery();
        Sick sick = null;
        if(rs.next()){
            sick = new Sick();
            sick.setFname(rs.getString("fname"));
            sick.setLname(rs.getString("lname"));
            sick.setNationalCode(rs.getString("national_code"));
            sick.setPersonnelNo(rs.getInt("personnel_no"));
        }
        return sick;
    }
    
    public Sick getByNationalCode(String nationalCode) throws SQLException{
        PreparedStatement ps = db.getConnection().prepareStatement("select * from sick where national_code = ?");
        ps.setString(1, nationalCode);
        ResultSet rs = ps.executeQuery();
        Sick sick = null;
        if(rs.next()){
            sick = new Sick();
            sick.setFname(rs.getString("fname"));
            sick.setLname(rs.getString("lname"));
            sick.setNationalCode(rs.getString("national_code"));
            sick.setPersonnelNo(rs.getInt("personnel_no"));
        }
        return sick;
    }
}
