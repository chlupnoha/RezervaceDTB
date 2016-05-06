/*
 * Copyright (C) 2015 Ondřej Skoumal <skoumal.ondra@gmail.com>
 *
 */
package dao;

import model.Room;
import org.hibernate.Session;

import java.util.logging.Logger;

/**
 * @author chlupnoha
 */
public class RoomDAOImpl extends CommonDAOImpl<Room> {

    private static final Logger LOG = Logger.getLogger(RoomDAOImpl.class.getName());

    public RoomDAOImpl() {
        this(null);
    }

    public RoomDAOImpl(Session session) {
        super(Room.class, session);
    }

}
