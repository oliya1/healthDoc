/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicico.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import nicico.model.BaseResponse;
import nicico.model.DocTrace;
import nicico.utility.Common;

/**
 *
 * @author Hamed
 */
public class DocTraceService {
//    private DataBase db;
    ObjectMapper mapper = new ObjectMapper();
    public DocTraceService(){
//        db = DataBase.getInstance();
    }
    
    public BaseResponse<Integer> getMaxLevel(String barcode) throws Exception{
//        PreparedStatement ps = db.getConnection().prepareStatement("select max(wf_level) from workflow where barcode = ?");
//        ps.setString(1, barcode);
//        ResultSet rs = ps.executeQuery();
//        int max = 0;
//        if (rs.next()) {
//           max = rs.getInt(1);
//        }
//        return max;
        String data = Common.getJSON("doc-history/max-level/" + barcode, 3000);
        BaseResponse<Integer> response = mapper.readValue(data, new TypeReference<BaseResponse<Integer>>(){});
        return response;
    }    
    
    public BaseResponse<Integer> insert(DocTrace dt) throws Exception{
//        PreparedStatement ps = db.getConnection().prepareStatement("INSERT INTO workflow(barcode, date_time, wf_level, cycle, sender_id, receiver_id, location_id)" + 
//                "VALUES (?,?,?,?,?,?,?)");
//        ps.setString(1, dt.getBarcode());
//        ps.setObject(2, dt.getDateTime());
//        ps.setInt(3, dt.getLevel());
//        ps.setInt(4, dt.getCycle());
//        ps.setInt(5, dt.getSenderId());
//        ps.setInt(6, dt.getReceiverId());
//        ps.setLong(7, dt.getLocationId());
//        return ps.executeUpdate();
//        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(dt);
        String excutePost = Common.excutePost("doc-history/", jsonString, "POST");
        System.out.println(excutePost);
        BaseResponse<Integer> response = mapper.readValue(excutePost, new TypeReference<BaseResponse<Integer>>(){});
        System.out.println(response.getMessage());
        return response;
    }
    
    public BaseResponse<Integer> update(DocTrace dt) throws Exception{
//        PreparedStatement ps = db.getConnection().prepareStatement("update workflow set date_time = ?, location_id = ?, receiver_id = ? where id = ?");
//        ps.setObject(1, dt.getDateTime());
//        ps.setLong(2, dt.getLocationId());
//        ps.setInt(3, dt.getReceiverId());
//        ps.setLong(4, dt.getId());
//        return ps.executeUpdate();
//        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(dt);
        String excutePost = Common.excutePost("doc-history/"+dt.getId(), jsonString, "PUT");
        System.out.println(excutePost);
        BaseResponse<Integer> response = mapper.readValue(excutePost, new TypeReference<BaseResponse<Integer>>(){});
//        BaseResponse<Double> response = SingltonGson.getGson().fromJson(excutePost, BaseResponse.class);
        System.out.println(response.getMessage());
        return response;
    }
    
    public List<DocTrace> getByBarcode(String barcode) throws Exception{
//        PreparedStatement ps = db.getConnection().prepareStatement("select * from workflow where barcode = ? order by wf_level desc");
//        ps.setLong(1, barcode);
//        ResultSet rs = ps.executeQuery();
//        ArrayList<DocTrace> docTraces = new ArrayList<DocTrace>();
//        while(rs.next()){
//            DocTrace docTrace = new DocTrace();
//            docTrace.setLevel(rs.getInt("wf_level"));
//            docTrace.setDateTime(rs.getObject("date_time", LocalDateTime.class));
//            docTrace.setReceiverId(rs.getInt("receiver_id"));
//            docTrace.setSenderId(rs.getInt("sender_id"));
//            docTrace.setLocationId(rs.getLong("location_id"));
//            docTrace.setId(rs.getLong("id"));
//            docTraces.add(docTrace);
//        }
//        return docTraces;
        String data = Common.getJSON("doc-history/" + barcode, 3000);        
        BaseResponse<List<DocTrace>> fromJson = mapper.readValue(data, new TypeReference<BaseResponse<List<DocTrace>>>(){});
//        Gson gson = new Gson();
//        BaseResponse<List<DocTrace>> fromJson = gson.fromJson(data, new TypeReference<BaseResponse<ArrayList<DocTrace>>>(){});
//        BaseResponse<List<DocTrace>> fromJson = SingltonGson.getGson().fromJson(data, BaseResponse.class);
//        System.out.println(fromJson.getMessage());
        List<DocTrace> docs = fromJson.getData();
        return docs;
    }
    
//    public static void main(String[] args) throws Exception{            
////        try {
////            new DocTraceService().getMaxLevel(9806602991743247l);
////        } catch (SQLException ex) {
////            Logger.getLogger(DocTraceService.class.getName()).log(Level.SEVERE, null, ex);
////        }
//        DocTrace docTrace = new DocTrace("299172345");
//        ObjectMapper mapper = new ObjectMapper();
//        String jsonString = mapper.writeValueAsString(docTrace);
//        String excutePost = Common.excutePost("doc-history/", jsonString);
//        System.out.println(excutePost);
//        BaseResponse<Double> response = SingltonGson.getGson().fromJson(excutePost, BaseResponse.class);
//        System.out.println(response.getMessage());
//    }
}
