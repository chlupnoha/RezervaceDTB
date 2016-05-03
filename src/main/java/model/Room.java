package model;

import dao_impl.DataClass;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 */
@Entity(name = "Rooms")
public class Room implements Serializable, DataClass {

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Integer id;

    @ManyToOne(cascade = {CascadeType.REMOVE})
    @JoinColumn(name = "building_id")
    private Building building;
    
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "room_tag", joinColumns = {
        @JoinColumn(name = "room_id", nullable = false, updatable = false)},
            inverseJoinColumns = {
                @JoinColumn(name = "tag_id",
                        nullable = false, updatable = false)})
    private Set<Tag> tags = new HashSet<>(0);

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "room_equipment", joinColumns = {
        @JoinColumn(name = "room_id", nullable = false, updatable = false)},
            inverseJoinColumns = {
                @JoinColumn(name = "equipment_id",
                        nullable = false, updatable = false)})
    private Set<Equipment> equipment = new HashSet<>(0);

    public Room() {

    }

    public Room(Building building) {
        this.building = building;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public Set<Equipment> getEquipment() {
        return equipment;
    }

    public void setEquipment(Set<Equipment> equipment) {
        this.equipment = equipment;
    }
    
    @Override
    public String toString() {
        return "Room: {\"id\": " + id + ", \"building\" : {" + building.toString() + "}";
    }

}
