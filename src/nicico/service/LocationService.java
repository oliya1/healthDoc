/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicico.service;

import com.google.gson.Gson;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import nicico.data.DataBase;
import nicico.model.Location;
import nicico.utility.Common;
import nicico.utility.SingltonGson;

/**
 *
 * @author Hamed
 */
public class LocationService {
//    private DataBase db = DataBase.getInstance();
    public Location getById(Long id) throws SQLException, IOException {
//        PreparedStatement ps = db.getConnection().prepareStatement("select * from location where loc_id = ?");
//        ps.setLong(1, id);
//        ResultSet rs = ps.executeQuery();
//        Location location = new Location();
//        if (rs.next()) {
//            location.setId(rs.getLong("loc_id"));
//            location.setName(rs.getString("loc_name"));
//        }
        String data = Common.getJSON("location/" + id, 3000);
        Location location = SingltonGson.getGson().fromJson(data, Location.class);
        return location;
    } 
    public List<Location> getAll() throws SQLException, IOException{
//        PreparedStatement ps = db.getConnection().prepareStatement("select * from location");
//        ResultSet rs = ps.executeQuery();
//        List<Location> locations = new ArrayList<>();
//        while(rs.next()){
//            Location location = new Location();
//            location.setId(rs.getLong("loc_id"));
//            location.setName(rs.getString("loc_name"));
//            locations.add(location);
//        }
        String data = Common.getJSON("location/", 3000);
        Location[] locations = SingltonGson.getGson().fromJson(data, Location[].class);
        return Arrays.asList(locations);
    }
}
