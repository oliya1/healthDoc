/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicico.model;

import nicico.utility.Common;
import nicico.utility.MySinglton;

/**
 *
 * @author jafari-h
 */
public class ReasonSend {
    private Long id;
    private String name;
    private User creator;   
    
    public ReasonSend() {
    }

    public ReasonSend(String name) throws Exception {
        this.name = name;
        this.creator = MySinglton.getLoginedUser();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }
    @Override
    public String toString() {
      return name;
    }
}
