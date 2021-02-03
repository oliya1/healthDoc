/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicico.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import nicico.model.Location;
import nicico.utility.Common;
import nicico.utility.MySinglton;

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
        Location location = MySinglton.getGson().fromJson(data, Location.class);
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
        Location[] locations = MySinglton.getGson().fromJson(data, Location[].class);
        return Arrays.asList(locations);
    }
}
