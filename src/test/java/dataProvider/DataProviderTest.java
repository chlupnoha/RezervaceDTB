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
package dataProvider;

import dao.UserDAOImpl;
import java.util.List;
import model.User;
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
public class DataProviderTest {
    
    public DataProviderTest() {
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
//     * Test of fillDatabase method, of class DataProvider.
//     */
//    @Test
//    public void testFillDatabase() {
//        System.out.println("fillDatabase");
//        DataProvider instance = new DataProvider();
//        instance.fillDatabase();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of fillUser method, of class DataProvider.
     */
    @Test
    public void testFillUser() {
        System.out.println("fillUser");
        int count = 10;
        DataProvider instance = new DataProvider();
        instance.fillUser(count);
        UserDAOImpl userDAO = new UserDAOImpl();
        List<User> list = userDAO.getAll();
        assertTrue(list.size() >= 10);
    }
    
}
