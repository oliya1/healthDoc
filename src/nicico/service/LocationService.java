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
import nicico.model.Location;

/**
 *
 * @author Hamed
 */
public class LocationService {
    private DataBase db = DataBase.getInstance();
    public Location getById(Long id) throws SQLException {
        PreparedStatement ps = db.getConnection().prepareStatement("select * from location where loc_id = ?");
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();
        Location location = new Location();
        if (rs.next()) {
            location.setId(rs.getLong("loc_id"));
            location.setName(rs.getString("loc_name"));
        }
        return location;
    }    
}
