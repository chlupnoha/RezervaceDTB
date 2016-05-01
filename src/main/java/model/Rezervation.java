package model;

import dao_impl.DataClass;
import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;

/**
 * FighterAircraft data class.
 *
 * Represents data model
 */
@Entity(name = "Rezervations")
public class Rezervation implements Serializable, DataClass {

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Integer id;

    @Column(name = "created", nullable = false)
    @Temporal(TemporalType.DATE)//dunno why I cant timestamp :(
    private Calendar created;

    @Column(name = "from_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar fromDate;

    @Column(name = "to_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar toDate;

    @Enumerated(EnumType.STRING)
    private Confirmed confirmed;

    @ManyToOne(cascade = {CascadeType.REMOVE})
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(cascade = {CascadeType.REMOVE})
    @JoinColumn(name = "room_id")
    private Room room;

    public Rezervation() {

    }

    public Rezervation(Calendar fromDate, Calendar toDate, Confirmed confirmed, User user, Room room) {
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.confirmed = confirmed;
        this.user = user;
        this.room = room;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Rezervation: {id: " + id + ", created: " + (created != null ? created.getTime() : "null") + ", fromDate: " + fromDate.getTime() + ", toDate: " + toDate.getTime() + ", confirmed: " + confirmed + "\n, user: " + user.toString() + "\n, room: " + room.toString() + "}";
    }

    public Confirmed getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Confirmed confirmed) {
        this.confirmed = confirmed;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Calendar getToDate() {
        return toDate;
    }

    public void setToDate(Calendar toDate) {
        this.toDate = toDate;
    }

    public Calendar getFromDate() {
        return fromDate;
    }

    public void setFromDate(Calendar fromDate) {
        this.fromDate = fromDate;
    }

    public Calendar getCreated() {
        return created;
    }

    public void setCreated(Calendar created) {
        this.created = created;
    }

}
