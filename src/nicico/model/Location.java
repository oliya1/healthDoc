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
public class Location {
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public Location setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Location setName(String name) {
        this.name = name;
        return this;
    }

    public Location() {
    }

    public Location(String name) {
        this.name = name;
    }    
    
    @Override
    public String toString(){
        return this.name;
    }
}
