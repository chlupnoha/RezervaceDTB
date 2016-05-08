package model;

import dao.DataClass;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 *
 */
@Entity(name = "Images")
public class Image implements Serializable, DataClass {

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;

    private String name;


    @ManyToOne(fetch = FetchType.LAZY)
    private Room room;

    public Image() {

    }

    public Image(String name) {
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
        return "Image: { \"id\": " + id + ", \"name\": " + name + "}";
    }

}
