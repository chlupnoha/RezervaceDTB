package model;

import dao_impl.DataClass;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 */
@Entity(name = "Equipments")
public class Equipment implements Serializable, DataClass {

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Integer id;
    
    
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
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
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
