package nicico.service;

import nicico.data.DataBase;
import nicico.model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserService {
    private DataBase db = DataBase.getInstance();
    public List<User> getUsers() throws SQLException {
        PreparedStatement ps = db.getConnection().prepareStatement("SELECT * FROM user");
        ResultSet rs = ps.executeQuery();
        ArrayList<User> users = new ArrayList<>();
        while (rs.next()){
            User user = new User();
            user.setName(rs.getString("name"));
            user.setId(rs.getInt("id"));
            user.setUserName(rs.getString("user_name"));
            user.setLocationId(rs.getLong("usr_loc_id"));
            user.setRule(rs.getString("rule"));
            users.add(user);
        }
//        db.closeConnection();
        return users;
    }
    public User getUser(String userName) throws SQLException{
        PreparedStatement ps = db.getConnection().prepareStatement("select * from user where user_name = ?");
        ps.setString(1, userName);
        ResultSet rs = ps.executeQuery();
        User user = new User();
        if(rs.next()){        
            user.setName(rs.getString("name"));
            user.setId(rs.getInt("id"));
            user.setUserName(rs.getString("user_name"));
            user.setLocationId(rs.getLong("usr_loc_id"));
            user.setRule(rs.getString("rule"));
        }
        return user;
    }
    public int createUser(User user) throws SQLException{
        PreparedStatement ps = db.getConnection().prepareStatement("insert into user(user_name, name, usr_loc_id, rule) values(?,?,?,?)");
        ps.setString(1, user.getUserName());
        ps.setString(2, user.getName());
        ps.setLong(3, user.getLocationId());
        ps.setString(4, user.getRule());
        return ps.executeUpdate();
    }
//    public static void main(String[] args){
//        try {
//            
//            User user = new UserService().getUser("hamed");
//                    } catch (SQLException ex) {
//            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
}
