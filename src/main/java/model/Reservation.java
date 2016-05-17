package model;

import dao.DataClass;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;

/**
 * FighterAircraft data class.
 * <p>
 * Represents data model
 */
@Entity(name = "Rezervations")
public class Reservation implements Serializable, DataClass {

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;

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

    @ManyToOne
    private Room room;

    public Reservation() {

    }

    public Reservation(Calendar fromDate, Calendar toDate, Confirmed confirmed, User user, Room room) {
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.confirmed = confirmed;
        this.user = user;
        this.room = room;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Reservation: {id: " + id + ", created: " + (created != null ? created.getTime() : "null") + ", fromDate: " + fromDate.getTime() + ", toDate: " + toDate.getTime() + ", confirmed: " + confirmed + "\n, user: " + user.toString() + "}";
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

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
