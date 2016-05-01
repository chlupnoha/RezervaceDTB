/*
 * Copyright (C) 2015 Ondřej Skoumal <skoumal.ondra@gmail.com>
 *
 */
package dao_impl;

import dao.RezervationDAO;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Logger;
import model.Rezervation;
import org.hibernate.Session;

/**
 *
 * @author chlupnoha
 */
public class RezervationDAOImp extends CommonDAOImpl<Rezervation> implements RezervationDAO {

    private static final Logger LOG = Logger.getLogger(RezervationDAOImp.class.getName());

    public RezervationDAOImp() {
        this(null);
    }

    public RezervationDAOImp(Session session) {
        super(Rezervation.class, session);
    }

    @Override
    public Rezervation getRezervationByID(Integer rezervationId) {
        return super.getEntityById(rezervationId);
    }

    @Override
    public Rezervation addRezervation(Rezervation rezervation) {
        rezervation.setCreated(new GregorianCalendar());
        return super.addEntity(rezervation);
    }

    @Override
    public Rezervation updateRezervation(Rezervation rezervation) {
        return super.updateEntity(rezervation);
    }

    @Override
    public boolean deleteRezervation(int rezervationId) {
        return super.deleteEntity(rezervationId);
    }

    @Override
    public List<Rezervation> getAllRezervations() {
        return super.getAllEntities();
    }

    
}
