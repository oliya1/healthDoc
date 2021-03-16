package nicico.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import nicico.model.User;

import java.util.Arrays;
import java.util.List;
import nicico.model.BaseResponse;
import nicico.utility.Common;
import nicico.utility.MySinglton;

public class UserService {
//    private DataBase db = DataBase.getInstance();
    public List<User> getUsers() throws Exception {
//        PreparedStatement ps = db.getConnection().prepareStatement("SELECT * FROM tbl_user");
//        ResultSet rs = ps.executeQuery();
//        ArrayList<User> users = new ArrayList<>();
//        while (rs.next()){
//            User user = new User();
//            user.setName(rs.getString("name"));
//            user.setId(rs.getInt("id"));
//            user.setUserName(rs.getString("user_name"));
//            user.setLocationId(rs.getLong("usr_loc_id"));
//            user.setRule(rs.getString("rule"));
//            users.add(user);
//        }
//        db.closeConnection();
//        return users;
        String data = Common.getJSON("user/", 3000);
        System.out.println("data:" + data);
        User[] users = MySinglton.getGson().fromJson(data, User[].class);
        return Arrays.asList(users);
    }
    public User getUser(String userName) throws Exception{
//        PreparedStatement ps = db.getConnection().prepareStatement("select * from tbl_user where user_name = ?");
//        ps.setString(1, userName);
//        ResultSet rs = ps.executeQuery();
//        User user = new User();
//        if(rs.next()){        
//            user.setName(rs.getString("name"));
//            user.setId(rs.getInt("id"));
//            user.setUserName(rs.getString("user_name"));
//            user.setLocationId(rs.getLong("usr_loc_id"));
//            user.setRule(rs.getString("rule"));
//        }
        String data = Common.getJSON("user/" + userName, 3000);
        User user = MySinglton.getGson().fromJson(data, User.class);
        return user;
    }
    public BaseResponse createUser(User user) throws Exception{
//        PreparedStatement ps = db.getConnection().prepareStatement("insert into tbl_user(user_name, name, usr_loc_id, rule) values(?,?,?,?)");
//        ps.setString(1, user.getUserName());
//        ps.setString(2, user.getName());
//        ps.setLong(3, user.getLocationId());
//        ps.setString(4, user.getRule());
//        return ps.executeUpdate();
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(user);
        String excutePost = Common.excutePost("user/hamed", jsonString, "POST");
        System.out.println(excutePost);
        BaseResponse response = MySinglton.getGson().fromJson(excutePost, BaseResponse.class);
        return response;
    }
    
    public BaseResponse deleteUser(String userName) throws Exception{
//        PreparedStatement ps = db.getConnection().prepareStatement("insert into tbl_user(user_name, name, usr_loc_id, rule) values(?,?,?,?)");
//        ps.setString(1, user.getUserName());
//        ps.setString(2, user.getName());
//        ps.setLong(3, user.getLocationId());
//        ps.setString(4, user.getRule());
//        return ps.executeUpdate();
        ObjectMapper mapper = new ObjectMapper();
        String excutePost = Common.excutePost("user/del/" + userName, "", "DELETE");
        System.out.println(excutePost);
        BaseResponse response = MySinglton.getGson().fromJson(excutePost, BaseResponse.class);
        return response;
    }
//    public static void main(String[] args) throws JsonProcessingException{
//        User user = new User();
//        user.setName("hamed").setUserName("jafari-o");
//        user.setRule("admin");
//        Location location = new Location();
//        location.setId(1L);
//        user.setLocation(location);
//        ObjectMapper mapper = new ObjectMapper();
//        String jsonString = mapper.writeValueAsString(user);
//        String excutePost = Common.excutePost("user/hamed", jsonString);
//        System.out.println(excutePost);
//        BaseResponse response = MySinglton.getGson().fromJson(excutePost, BaseResponse.class);
//        System.out.println(response.getMessag());
//    }
}
