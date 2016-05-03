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
import model.Building;
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
public class BuildingDAOImplTest {
    
    public BuildingDAOImplTest() {
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
//     * Test of getBuildingByID method, of class BuildingDAOImpl.
//     */
//    @Test
//    public void testGetBuildingByID() {
//        System.out.println("getBuildingByID");
//        Integer buildingId = null;
//        BuildingDAOImpl instance = new BuildingDAOImpl();
//        Building expResult = null;
//        Building result = instance.getBuildingByID(buildingId);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of addBuilding method, of class BuildingDAOImpl.
     */
    @Test
    public void testAddBuilding() {
        System.out.println("addBuilding");
        Building building = new Building("testBuilding", "999666333", "test@test.test", "adressTest");
        BuildingDAOImpl buldingDaon = new BuildingDAOImpl();
        Building result = buldingDaon.addBuilding(building);
        assertNotNull(result.getId());
    }

//    /**
//     * Test of updateBuilding method, of class BuildingDAOImpl.
//     */
//    @Test
//    public void testUpdateBuilding() {
//        System.out.println("updateBuilding");
//        Building building = null;
//        BuildingDAOImpl instance = new BuildingDAOImpl();
//        Building expResult = null;
//        Building result = instance.updateBuilding(building);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of deleteBuilding method, of class BuildingDAOImpl.
//     */
//    @Test
//    public void testDeleteBuilding() {
//        System.out.println("deleteBuilding");
//        int buildingId = 0;
//        BuildingDAOImpl instance = new BuildingDAOImpl();
//        boolean expResult = false;
//        boolean result = instance.deleteBuilding(buildingId);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getAllBuildings method, of class BuildingDAOImpl.
//     */
//    @Test
//    public void testGetAllBuildings() {
//        System.out.println("getAllBuildings");
//        BuildingDAOImpl instance = new BuildingDAOImpl();
//        List<Building> expResult = null;
//        List<Building> result = instance.getAllBuildings();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}