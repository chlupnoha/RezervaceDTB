package dao;

import model.Reservation;
import org.hibernate.Session;

import java.util.GregorianCalendar;
import java.util.logging.Logger;

/**
 * @author chlupnoha
 */
public class ReservationDAOImp extends CommonDAOImpl<Reservation> {

    private static final Logger LOG = Logger.getLogger(ReservationDAOImp.class.getName());

    public ReservationDAOImp() {
        this(null);
    }

    public ReservationDAOImp(Session session) {
        super(Reservation.class, session);
    }

    @Override
    public Reservation add(Reservation reservation) {
        reservation.setCreated(new GregorianCalendar());
        return super.add(reservation);
    }

}
