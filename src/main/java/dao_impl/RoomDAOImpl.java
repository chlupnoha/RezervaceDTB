/*
 * Copyright (C) 2015 Ondřej Skoumal <skoumal.ondra@gmail.com>
 *
 */
package dao_impl;

import dao.RoomDAO;
import java.util.List;
import java.util.logging.Logger;
import model.Room;
import org.hibernate.Session;

/**
 *
 * @author chlupnoha
 */
public class RoomDAOImpl extends CommonDAOImpl<Room> implements RoomDAO {

    private static final Logger LOG = Logger.getLogger(RoomDAOImpl.class.getName());

    public RoomDAOImpl() {
        this(null);
    }

    public RoomDAOImpl(Session session) {
        super(Room.class, session);
    }

    @Override
    public Room getRoomByID(Integer roomId) {
        return super.getEntityById(roomId);
    }

    @Override
    public Room addRoom(Room room) {
        return super.addEntity(room);
    }

    @Override
    public Room updateRoom(Room room) {
        return super.updateEntity(room);
    }

    @Override
    public boolean deleteRoom(int roomId) {
        return super.deleteEntity(roomId);
    }

    @Override
    public List<Room> getAllRooms() {
        return super.getAllEntities();
    }

    
}
