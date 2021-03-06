/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicico.model;

import java.util.Date;
import nicico.service.DocTraceService;
import nicico.service.UserService;
import nicico.utility.Common;

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
    private ReasonSend reasonSend;

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

    public ReasonSend getReasonSend() {
        return reasonSend;
    }

    public void setReasonSend(ReasonSend reasonSend) {
        this.reasonSend = reasonSend;
    }

    public DocTrace(String barcode, User receiver, ReasonSend reasonSend) throws Exception {
        
        final DocTraceService docTraceService = new DocTraceService();
        final UserService userService = new UserService();
        this.barcode = barcode;
        this.receiver = receiver;
        User sender = userService.getUser(Common.getLoginedUserName());
        this.sender = sender;
//        this.senderId = new UserService().getUser(Common.getLoginedUserName()).getId();
        this.cycle = 1;
        this.location = sender.getLocation();
        this.reasonSend = reasonSend;
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
