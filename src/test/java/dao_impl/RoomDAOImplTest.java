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

import dao.RoomDAO;
import dao.TagDAO;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import model.Building;
import model.Equipment;
import model.Room;
import model.Tag;
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
        
        BuildingDAOImpl buildingDao = new BuildingDAOImpl();
        Building building = buildingDao.addBuilding(
                new Building("testBuilding", "999666333", "test@test.test", "adressTest")
        );
        
        room.setBuilding( building );
        RoomDAOImpl roomDao = new RoomDAOImpl();
        Room result = roomDao.addRoom(room);
        
        assertNotNull(result.getId());;
        assertNotNull(result.getBuilding().getId());
    }

    /**
     * Test of addRoom method, of class RoomDAOImpl.
     */
    @Test
    public void testAddRoomTag() {
        System.out.println("addRoom");
        
        Room room = new Room();
        RoomDAOImpl roomDao = new RoomDAOImpl();
        
        room.setTags(new HashSet(Arrays.asList(new Tag[]{new Tag("testTag")})));
        Room r = roomDao.addEntity(room);
        
        assertEquals(r.getTags().size(), 1);
    }

    /**
     * Test of addRoom method, of class RoomDAOImpl.
     */
    @Test
    public void testAddRoomEquipment() {
        System.out.println("add room equipment");
        
        Room room = new Room();
        RoomDAOImpl roomDao = new RoomDAOImpl();
        
        room.setEquipment(new HashSet(Arrays.asList(new Equipment[]{new Equipment("testEquipment")})));
        Room r = roomDao.addEntity(room);
        
        assertEquals(r.getEquipment().size(), 1);
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
