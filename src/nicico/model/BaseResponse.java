/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicico.model;

/**
 *
 * @author Hamed
 */
public class BaseResponse {
    private int status;
    private String message;
    
    public int getStatus(){
        return this.status;
    }
    public void setStatuse(int status){
        this.status = status;
    }
    public String getMessag(){
        return this.message;
    }
    public void setMessage(String message){
        this.message = message;
    }
}
