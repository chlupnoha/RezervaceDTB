/*
 * Copyright (C) 2015 Ondřej Skoumal <skoumal.ondra@gmail.com>
 *
 */
package dao;

import model.Room;
import java.util.List;

/**
 * Data Acces Object 
 */
public interface RoomDAO {
    
    Room getRoomByID(Integer roomId);

    Room addRoom(Room room);

    Room updateRoom(Room room);

    boolean deleteRoom(int roomId);
    
    List<Room> getAllRooms();

}
