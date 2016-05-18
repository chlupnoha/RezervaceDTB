package gui.permission;

import dao.RezervationDAOImp;
import dao.RoomDAOImpl;
import dao.UserDAOImpl;
import gui.customcomponents.DatePicker;
import gui.customcomponents.ErrorLabel;
import model.Confirmed;
import model.Reservation;
import model.Room;
import model.User;
import utility.Authorization;

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
        RezervationDAOImp rezervationDAOImp = new RezervationDAOImp();

        User user = Authorization.getUser();
        System.out.println(user);

        Reservation r = new Reservation(new GregorianCalendar(), new GregorianCalendar(), Confirmed.NOT_CONFIRMED, user, room);
        user.getReservations().add(r);
        user.getWereThere().add(room);
        room.getWereHere().add(user);

        rezervationDAOImp.add(r);
        user = userDAO.update(user);
        Authorization.updateUser(user);
        room = roomDAO.update(room);

        return true;
    }


}
