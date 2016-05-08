/*
 * Copyright (C) 2015 Ondřej Skoumal <skoumal.ondra@gmail.com>
 *
 */
package dao;

import model.Reservation;
import org.hibernate.Session;

import java.util.GregorianCalendar;
import java.util.logging.Logger;

/**
 * @author chlupnoha
 */
public class RezervationDAOImp extends CommonDAOImpl<Reservation> {

    private static final Logger LOG = Logger.getLogger(RezervationDAOImp.class.getName());

    public RezervationDAOImp() {
        this(null);
    }

    public RezervationDAOImp(Session session) {
        super(Reservation.class, session);
    }

    @Override
    public Reservation add(Reservation reservation) {
        reservation.setCreated(new GregorianCalendar());
        return reservation;
    }

}
