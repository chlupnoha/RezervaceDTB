/*
 * Copyright (C) 2016 chlupnoha
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package dao_impl;

import java.util.List;
import model.Room;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author chlupnoha
 */
public class RoomDAOImplTest {
    
    public RoomDAOImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

//    /**
//     * Test of getRoomByID method, of class RoomDAOImpl.
//     */
//    @Test
//    public void testGetRoomByID() {
//        System.out.println("getRoomByID");
//        Integer roomId = null;
//        RoomDAOImpl instance = new RoomDAOImpl();
//        Room expResult = null;
//        Room result = instance.getRoomByID(roomId);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of addRoom method, of class RoomDAOImpl.
     */
    @Test
    public void testAddRoom() {
        System.out.println("addRoom");
        Room room = new Room();
        RoomDAOImpl instance = new RoomDAOImpl();
        Room result = instance.addRoom(room);
        assertNotNull(result.getId());
    }

//    /**
//     * Test of updateRoom method, of class RoomDAOImpl.
//     */
//    @Test
//    public void testUpdateRoom() {
//        System.out.println("updateRoom");
//        Room room = null;
//        RoomDAOImpl instance = new RoomDAOImpl();
//        Room expResult = null;
//        Room result = instance.updateRoom(room);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of deleteRoom method, of class RoomDAOImpl.
//     */
//    @Test
//    public void testDeleteRoom() {
//        System.out.println("deleteRoom");
//        int roomId = 0;
//        RoomDAOImpl instance = new RoomDAOImpl();
//        boolean expResult = false;
//        boolean result = instance.deleteRoom(roomId);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getAllRooms method, of class RoomDAOImpl.
//     */
//    @Test
//    public void testGetAllRooms() {
//        System.out.println("getAllRooms");
//        RoomDAOImpl instance = new RoomDAOImpl();
//        List<Room> expResult = null;
//        List<Room> result = instance.getAllRooms();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
