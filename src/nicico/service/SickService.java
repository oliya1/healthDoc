/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicico.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import nicico.model.BaseResponse;
import nicico.model.Sick;
import nicico.utility.Common;

/**
 *
 * @author Hamed
 */
public class SickService {
//    private DataBase db;
    ObjectMapper mapper = new ObjectMapper();
    public SickService(){
//        db = DataBase.getInstance();
    }
    public BaseResponse<Integer> create(Sick sick) throws Exception{
//        PreparedStatement ps = db.getConnection().prepareStatement("INSERT INTO sick(fname, lname, personnel_no, national_code, create_by)" + 
//                "VALUES (?,?,?,?,?)");
//        ps.setString(1, sick.getFname());
//        ps.setString(2, sick.getLname());
//        ps.setInt(3, sick.getPersonnelNo());
//        ps.setString(4, sick.getNationalCode());
//        ps.setString(5, sick.getCreateBy());
//        int count = ps.executeUpdate();
//        
//        System.out.println("عملیات با موفقیت انجام شد");
////        db.closeConnection();
//        return count;
        String jsonString = mapper.writeValueAsString(sick);
        String excutePost = Common.excutePost("personnel/", jsonString, "POST");
        BaseResponse<Integer> response = mapper.readValue(excutePost, new TypeReference<BaseResponse<Integer>>(){});
        return response;
    }
    
    public BaseResponse<Sick> getByPersonnelNo(int personnelNo) throws Exception{
//        PreparedStatement ps = db.getConnection().prepareStatement("select * from sick where personnel_no = ?");
//        ps.setInt(1, personnelNo);
//        ResultSet rs = ps.executeQuery();
//        Sick sick = null;
//        if(rs.next()){
//            sick = new Sick();
//            sick.setFname(rs.getString("fname"));
//            sick.setLname(rs.getString("lname"));
//            sick.setNationalCode(rs.getString("national_code"));
//            sick.setPersonnelNo(rs.getInt("personnel_no"));
//        }
        String data = Common.getJSON("personnel/" + personnelNo, 3000);        
        BaseResponse<Sick> fromJson = mapper.readValue(data, new TypeReference<BaseResponse<Sick>>(){});
//        List<Sick> reasons = fromJson.getData();
        return fromJson;
    }
    
//    public Sick getByNationalCode(String nationalCode) throws SQLException{
//        PreparedStatement ps = db.getConnection().prepareStatement("select * from sick where national_code = ?");
//        ps.setString(1, nationalCode);
//        ResultSet rs = ps.executeQuery();
//        Sick sick = null;
//        if(rs.next()){
//            sick = new Sick();
//            sick.setFname(rs.getString("fname"));
//            sick.setLname(rs.getString("lname"));
//            sick.setNationalCode(rs.getString("national_code"));
//            sick.setPersonnelNo(rs.getInt("personnel_no"));
//        }
//        return sick;
//    }
}
