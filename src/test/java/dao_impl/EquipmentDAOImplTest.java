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
import model.Equipment;
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
public class EquipmentDAOImplTest {
    
    public EquipmentDAOImplTest() {
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
//     * Test of getEquipmentByID method, of class EquipmentDAOImpl.
//     */
//    @Test
//    public void testGetEquipmentByID() {
//        System.out.println("getEquipmentByID");
//        Integer equipmentId = null;
//        EquipmentDAOImpl instance = new EquipmentDAOImpl();
//        Equipment expResult = null;
//        Equipment result = instance.getEquipmentByID(equipmentId);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of addEquipment method, of class EquipmentDAOImpl.
     */
    @Test
    public void testAddEquipment() {
        System.out.println("addEquipment");
        Equipment equipment = new Equipment("testEquipment");
        EquipmentDAOImpl equipmentDao = new EquipmentDAOImpl();
        Equipment result = equipmentDao.addEquipment(equipment);
        assertNotNull(result.getId());
    }

//    /**
//     * Test of updateEquipment method, of class EquipmentDAOImpl.
//     */
//    @Test
//    public void testUpdateEquipment() {
//        System.out.println("updateEquipment");
//        Equipment equipment = null;
//        EquipmentDAOImpl instance = new EquipmentDAOImpl();
//        Equipment expResult = null;
//        Equipment result = instance.updateEquipment(equipment);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of deleteEquipment method, of class EquipmentDAOImpl.
//     */
//    @Test
//    public void testDeleteEquipment() {
//        System.out.println("deleteEquipment");
//        int equipmentId = 0;
//        EquipmentDAOImpl instance = new EquipmentDAOImpl();
//        boolean expResult = false;
//        boolean result = instance.deleteEquipment(equipmentId);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getAllEquipments method, of class EquipmentDAOImpl.
//     */
//    @Test
//    public void testGetAllEquipments() {
//        System.out.println("getAllEquipments");
//        EquipmentDAOImpl instance = new EquipmentDAOImpl();
//        List<Equipment> expResult = null;
//        List<Equipment> result = instance.getAllEquipments();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
