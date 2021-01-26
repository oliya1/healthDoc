/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicico.model;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import nicico.service.DocTraceService;
import nicico.service.UserService;
import nicico.utility.Common;
import oracle.jdbc.OracleDatabaseException;

/**
 *
 * @author Hamed
 */
public class DocTrace {
    private Long id;
    private String barcode;
    private Date dateTime;
    private Date lastUpdate; 
    private Integer level;
    private Integer cycle;
    private User sender;
    private User receiver;
    private Location location;

    public DocTrace() {
    }

    public String getBarcode() {
        return barcode;
    }

    public Integer getLevel() {
        return level;
    }

    public Integer getCycle() {
        return cycle;
    }

    public User getSender() {
        return this.sender;
    }

    public User getReceiver() {
        return this.receiver;
    }
    
    public Date getDateTime() {
        return this.dateTime;
    }

    public Location getLocation() {
        return location;
    }   

    public Long getId() {
        return id;
    }
    
    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public void setCycle(Integer cycle) {
        this.cycle = cycle;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public void setBarcode(String barcode){
        this.barcode = barcode;
    }

    public DocTrace(String barcode, String receiver) throws Exception {
        final DocTraceService docTraceService = new DocTraceService();
        final UserService userService = new UserService();
        this.barcode = barcode;
        this.receiver = userService.getUser(receiver);
        User sender = userService.getUser(Common.getLoginedUserName());
        this.sender = sender;
//        this.senderId = new UserService().getUser(Common.getLoginedUserName()).getId();
        this.cycle = 1;
        this.location = sender.getLocation();
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
//        String input = "2020-05-07T10:05:05.301011" ;
//        LocalDateTime ldt = LocalDateTime.parse( input ) ;
//        this.dateTime = LocalDateTime.now();
        BaseResponse<Integer> maxLevel = docTraceService.getMaxLevel(barcode);
        if(maxLevel.getStatus() == 200){
            this.level = maxLevel.getData().intValue()+1;
        }else if(maxLevel.getStatus() == 201){
            this.level = 1;
        }else{
            throw new ArithmeticException(maxLevel.getMessage());
        }
    }

    public DocTrace(String barcode) throws Exception {
        final DocTraceService docTraceService = new DocTraceService();
        final UserService userService = new UserService();
        this.barcode = barcode;
        this.receiver = null;
        User sender = userService.getUser(Common.getLoginedUserName());
        this.sender = null;
//        this.senderId = new UserService().getUser(Common.getLoginedUserName()).getId();
        this.cycle = 1;
        this.location = sender.getLocation();
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
//        String input = "2020-05-07T10:05:05.301011" ;
//        LocalDateTime ldt = LocalDateTime.parse( input ) ;
//        this.dateTime = LocalDateTime.now();
        BaseResponse<Integer> maxLevel = docTraceService.getMaxLevel(barcode);
        if(maxLevel.getStatus() == 200){
            this.level = maxLevel.getData().intValue()+1;
        }else if(maxLevel.getStatus() == 201){
            this.level = 1;
        }else{
            throw new ArithmeticException(maxLevel.getMessage());
        }
    }    
}
