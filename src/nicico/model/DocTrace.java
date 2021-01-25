/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicico.model;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
    private LocalDateTime dateTime;    
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
    
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public void setCycle(Integer cycle) {
        this.cycle = cycle;
    }

    public void setSenderId(User sender) {
        this.sender = sender;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }  

    public Location getLocation() {
        return location;
    }

    public void setLocationId(Location location) {
        this.location = location;
    }   

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        BaseResponse<Double> maxLevel = docTraceService.getMaxLevel(barcode);
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
        BaseResponse<Double> maxLevel = docTraceService.getMaxLevel(barcode);
        if(maxLevel.getStatus() == 200){
            this.level = maxLevel.getData().intValue()+1;
        }else if(maxLevel.getStatus() == 201){
            this.level = 1;
        }else{
            throw new ArithmeticException(maxLevel.getMessage());
        }
    }    
}
