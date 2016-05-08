package model;

import dao.DataClass;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

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


    @ManyToOne(fetch = FetchType.LAZY)
    private Room room;

    public Equipment() {

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

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "Equipment: { id: " + id + ", name: " + name + "}";
    }

}
