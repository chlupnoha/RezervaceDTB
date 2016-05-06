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
@Entity(name = "Rooms")
public class Room implements Serializable, DataClass {

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;

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

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "room_image", joinColumns = {
        @JoinColumn(name = "room_id", nullable = false, updatable = false)},
            inverseJoinColumns = {
                @JoinColumn(name = "image_id",
                        nullable = false, updatable = false)})
    private Set<Image> images = new HashSet<>(0);

    public Room() {

    }

    public Room(Building building) {
        this.building = building;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
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

    public Set<Image> getImages() {
        return images;
    }

    public void setImages(Set<Image> images) {
        this.images = images;
    }
    
    @Override
    public String toString() {
        return "Room: {\"id\": " + id + ", \"building\" : {" + building.toString() + "}";
    }

}
