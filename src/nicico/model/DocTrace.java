/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicico.model;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import nicico.service.DocTraceService;
import nicico.service.UserService;
import nicico.utility.Common;

/**
 *
 * @author Hamed
 */
public class DocTrace {
    private Long id;
    private Long barcode;
    private LocalDateTime dateTime;    
    private Integer level;
    private Integer cycle;
    private Integer senderId;
    private Integer receiverId;
    private Long locationId;

    public DocTrace() {
    }

    public Long getBarcode() {
        return barcode;
    }

    public Integer getLevel() {
        return level;
    }

    public Integer getCycle() {
        return cycle;
    }

    public Integer getSenderId() {
        return senderId;
    }

    public Integer getReceiverId() {
        return receiverId;
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

    public void setSenderId(Integer senderId) {
        this.senderId = senderId;
    }

    public void setReceiverId(Integer receiverId) {
        this.receiverId = receiverId;
    }  

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }   

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DocTrace(Long barcode, String receiver) throws SQLException {
        final DocTraceService docTraceService = new DocTraceService();
        final UserService userService = new UserService();
        this.barcode = barcode;
        this.receiverId = userService.getUser(receiver).getId();
        User sender = userService.getUser(Common.getLoginedUserName());
        this.senderId = sender.getId();
//        this.senderId = new UserService().getUser(Common.getLoginedUserName()).getId();
        this.cycle = 1;
        this.locationId = sender.getLocationId();
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
//        String input = "2020-05-07T10:05:05.301011" ;
//        LocalDateTime ldt = LocalDateTime.parse( input ) ;
        this.dateTime = LocalDateTime.now();
        this.level = docTraceService.getMaxLevel(barcode)+1;
    }

    public DocTrace(Long barcode) throws SQLException {
        final DocTraceService docTraceService = new DocTraceService();
        final UserService userService = new UserService();
        this.barcode = barcode;
        this.receiverId = 0;
        User sender = userService.getUser(Common.getLoginedUserName());
        this.senderId = 0;
//        this.senderId = new UserService().getUser(Common.getLoginedUserName()).getId();
        this.cycle = 1;
        this.locationId = sender.getLocationId();
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
//        String input = "2020-05-07T10:05:05.301011" ;
//        LocalDateTime ldt = LocalDateTime.parse( input ) ;
        this.dateTime = LocalDateTime.now();
        this.level = docTraceService.getMaxLevel(barcode)+1;
    }
    
}
