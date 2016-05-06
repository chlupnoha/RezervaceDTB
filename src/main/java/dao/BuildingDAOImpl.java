/*
 * Copyright (C) 2015 Ondřej Skoumal <skoumal.ondra@gmail.com>
 *
 */
package dao;

import model.Building;
import org.hibernate.Session;

import java.util.logging.Logger;

/**
 * @author chlupnoha
 */
public class BuildingDAOImpl extends CommonDAOImpl<Building> {

    private static final Logger LOG = Logger.getLogger(BuildingDAOImpl.class.getName());

    protected BuildingDAOImpl() {
        super(Building.class);
    }

    protected BuildingDAOImpl(Session session) {
        super(Building.class, session);
    }
}



