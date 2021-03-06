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
package dao;

import model.*;
import org.junit.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertNotNull;

/**
 * @author chlupnoha
 */
public class ReservationDAOImpTest {

    public ReservationDAOImpTest() {
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

    /**
     * Test of getRezervationByID method, of class ReservationDAOImp.
     */
//    @Test
//    public void testGetRezervationByID() {
//        System.out.println("getRezervationByID");
//        
//        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
//        System.out.println(timeStamp);
//        
//        User user = new User("rezervation@rezervation.cz", "password", "salt_salt", UserRole.GUEST);
//        UserDAO userDAO = new UserDAOImpl();
//        User addUser = userDAO.addUser(user);
//        System.out.println(addUser.toString());
//        
//        Room room = new Room();
//        RoomDAO roomDAO = new RoomDAOImpl();
//        Room addRoom = roomDAO.addRoom(room);
//        System.out.println(addRoom.toString());
//        
//        
//	Calendar from = new GregorianCalendar(2013,0,31);
//	Calendar to = new GregorianCalendar(2013,3,31);
//        
//        Reservation rezervation = new Reservation(from, to, Confirmed.CONFIRMED, user, room);
//        
//        ReservationDAOImp instance = new ReservationDAOImp();
//        Reservation result = instance.addRezervation(rezervation);
//        
//        System.out.println(result.toString());
//        
//        assertNotNull(result.getId());
//    }
    /**
     * Test of addRezervation method, of class ReservationDAOImp.
     */
    @Test
    public void testAddRezervation() {
        System.out.println("addRezervation");

        User user = new User("reservati3on@reservation.cz", "pass3word", "salt_salt", UserRole.GUEST);
        UserDAOImpl userDAO = new UserDAOImpl();
        User addUser = userDAO.add(user);
        assertNotNull(addUser.getId());

        BuildingDAOImpl buildingDao = new BuildingDAOImpl();
        Building building = buildingDao.add(new Building("na3me", "888777666", "tes3t@test.cz", "adress"));
        assertNotNull(building.getId());

        Room room = new Room(building);
        RoomDAOImpl roomDAO = new RoomDAOImpl();
        Room addRoom = roomDAO.add(room);
        assertNotNull(addRoom.getId());

        Calendar from = new GregorianCalendar(2013, 0, 31);
        Calendar to = new GregorianCalendar(2013, 3, 31);

        Reservation reservation = new Reservation(from, to, Confirmed.CONFIRMED, addUser, addRoom);

        ReservationDAOImp instance = new ReservationDAOImp();
        Reservation result = instance.add(reservation);

        assertNotNull(result.getId());
    }

//    /**
//     * Test of updateRezervation method, of class ReservationDAOImp.
//     */
//    @Test
//    public void testUpdateRezervation() {
//        System.out.println("updateRezervation");
//        Reservation rezervation = null;
//        ReservationDAOImp instance = new ReservationDAOImp();
//        Reservation expResult = null;
//        Reservation result = instance.updateRezervation(rezervation);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of deleteRezervation method, of class ReservationDAOImp.
//     */
//    @Test
//    public void testDeleteRezervation() {
//        System.out.println("deleteRezervation");
//        int rezervationId = 0;
//        ReservationDAOImp instance = new ReservationDAOImp();
//        boolean expResult = false;
//        boolean result = instance.deleteRezervation(rezervationId);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getAllRezervations method, of class ReservationDAOImp.
//     */
//    @Test
//    public void testGetAllRezervations() {
//        System.out.println("getAllRezervations");
//        ReservationDAOImp instance = new ReservationDAOImp();
//        List<Reservation> expResult = null;
//        List<Reservation> result = instance.getAllRezervations();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
}
