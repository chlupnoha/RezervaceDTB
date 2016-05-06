/*
 * Copyright (C) 2015 Ondřej Skoumal <skoumal.ondra@gmail.com>
 *
 */
package dao;

import model.Rezervation;
import org.hibernate.Session;

import java.util.GregorianCalendar;
import java.util.logging.Logger;

/**
 * @author chlupnoha
 */
public class RezervationDAOImp extends CommonDAOImpl<Rezervation> {

    private static final Logger LOG = Logger.getLogger(RezervationDAOImp.class.getName());

    public RezervationDAOImp() {
        this(null);
    }

    public RezervationDAOImp(Session session) {
        super(Rezervation.class, session);
    }

    @Override
    public Rezervation add(Rezervation rezervation) {
        rezervation.setCreated(new GregorianCalendar());
        return rezervation;
    }

}
