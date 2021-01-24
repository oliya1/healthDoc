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
public class BaseResponse<T> {
    private int status;
    private String message;
    private T data;
    
    public int getStatus(){
        return this.status;
    }
    public void setStatuse(int status){
        this.status = status;
    }
    public String getMessage(){
        return this.message;
    }
    public void setMessage(String message){
        this.message = message;
    }
    public void setData(T data){
        this.data = data;
    }
    public T getData(){
        return this.data;
    }
}
