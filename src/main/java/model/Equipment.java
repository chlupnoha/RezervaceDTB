package model;

import dao.DataClass;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 *
 */
@Entity(name = "Equipments")
public class Equipment implements Serializable, DataClass {

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;
    
    
    @Column(unique = true)
    private String name;
    
    
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "tags")
    private Set<Room> rooms = new HashSet<>();
        
    public Equipment(){
        
    }

    public Equipment(String name) {
        this.name = name;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Room> getRooms() {
        return rooms;
    }

    public void setRooms(Set<Room> rooms) {
        this.rooms = rooms;
    }
    
    @Override
    public String toString() {
        return "Equipment: { id: " +  id + ", name: " + name +  "}";
    }
   
}
