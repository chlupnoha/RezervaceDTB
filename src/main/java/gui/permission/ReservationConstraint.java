package gui.permission;

import dao.ReservationDAOImp;
import dao.RoomDAOImpl;
import dao.UserDAOImpl;
import gui.customcomponents.DatePicker;
import gui.customcomponents.ErrorLabel;
import model.Confirmed;
import model.Reservation;
import model.Room;
import model.User;
import utility.Authorization;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by marek on 11.5.16.
 */
public class ReservationConstraint extends PermissionConstraint {

    private Room room;
    private DatePicker datePickerFrom;
    private DatePicker datePickerTo;

    public ReservationConstraint(ErrorLabel errorLabel, Room room, DatePicker datePickerFrom, DatePicker datePickerTo) {
        super(errorLabel);
        this.room = room;
        this.datePickerFrom = datePickerFrom;
        this.datePickerTo = datePickerTo;
    }

    public ReservationConstraint(Room room, DatePicker datePickerFrom, DatePicker datePickerTo) {
        this.room = room;
        this.datePickerFrom = datePickerFrom;
        this.datePickerTo = datePickerTo;
    }


    @Override
    public boolean isOk() {


        UserDAOImpl userDAO = new UserDAOImpl();
        RoomDAOImpl roomDAO = new RoomDAOImpl();
        ReservationDAOImp reservationDAOImp = new ReservationDAOImp();

        User user = Authorization.getUser();

        int day = datePickerFrom.getDay();
        int month = datePickerFrom.getMonth();
        int year = datePickerFrom.getYear();
        Calendar c = new GregorianCalendar(year, month, day);

        day = datePickerTo.getDay();
        month = datePickerTo.getMonth();
        year = datePickerTo.getYear();
        Calendar c1 = new GregorianCalendar(year, month, day);

        Reservation r = new Reservation(c, c1, Confirmed.NOT_CONFIRMED, user, room);
        user.getReservations().add(r);
        user.getWereThere().add(room);
        room.getWereHere().add(user);

        reservationDAOImp.add(r);
        user = userDAO.update(user);
        Authorization.updateUser(user);
        room = roomDAO.update(room);

        return true;
    }


}
