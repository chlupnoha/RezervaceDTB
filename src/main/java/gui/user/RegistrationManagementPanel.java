package gui.user;

import dao.RezervationDAOImp;
import dao.RoomDAOImpl;
import gui.ManagedCard;
import model.Reservation;
import utility.Authorization;

/**
 * Created by marek on 18.5.16.
 */
public class RegistrationManagementPanel extends ManagedCard {
    {
        setupComponents();
    }

    public RegistrationManagementPanel() {
        super();
    }

    @Override
    public void setupComponents() {
        RoomDAOImpl roomDAO = new RoomDAOImpl();
        RezervationDAOImp rezervationDAOImp = new RezervationDAOImp();
        for (Reservation r : Authorization.getUser().getReservations()) {
            System.out.println(r.getId());
        }
    }
}
