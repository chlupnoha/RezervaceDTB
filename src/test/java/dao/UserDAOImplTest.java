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

import model.User;
import model.UserRole;
import org.junit.*;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author chlupnoha
 */
public class UserDAOImplTest {

    public UserDAOImplTest() {
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
     * Test of addUser method, of class UserDAOImpl.
     */
    @Test
    public void testAddUser() {
        System.out.println("addUser");
        User user = new User("test_mail@test.cz", "test_password", "test_salt", UserRole.GUEST);
        UserDAOImpl instance = new UserDAOImpl();

        User result = instance.add(user);
        System.out.println(result.toString());
        assertNotNull(result);
    }

    /**
     * Test of getUserByID method, of class UserDAOImpl.
     */
    @Test
    public void testGetUserByID() {
        System.out.println("get user by id");
        User user = new User("test_mail2@test.cz", "test_password", "test_salt", UserRole.GUEST);
        UserDAOImpl instance = new UserDAOImpl();

        User result = instance.add(user);

        if (result != null) {
            User findedUser = instance.getById(user.getId());
            assertEquals(result.getId(), findedUser.getId());
        } else {
            fail("Problem with add user");
        }
    }

    /**
     * Test of updateUser method, of class UserDAOImpl.
     */
    @Test
    public void testUpdateUser() {
        System.out.println("updateUser");

        User user = new User("test_mail3@test.cz", "test_password", "test_salt", UserRole.GUEST);
        UserDAOImpl instance = new UserDAOImpl();

        User result = instance.add(user);

        if (result != null) {
            result.setEmail("test_updated_mail3@test.cz");
            User result2 = instance.update(result);
            assertEquals(result2.getEmail(), "test_updated_mail3@test.cz");
        } else {
            fail("Problem with add user");
        }
    }

    /**
     * Test of deleteUser method, of class UserDAOImpl.
     */
    @Test
    public void testDeleteUser() {
        System.out.println("deleteUser");

        User user = new User("test_mail4@test.cz", "test_password", "test_salt", UserRole.GUEST);
        UserDAOImpl instance = new UserDAOImpl();

        User result = instance.add(user);

        if (result != null) {
            result.setEmail("test_updated_mail3@test.cz");
            instance.delete(result.getId());
            assertNull(instance.getById(result.getId()));
        } else {
            fail("Problem with add user");
        }
    }

    /**
     * Test of getAllUsers method, of class UserDAOImpl.
     */
    @Test
    public void testGetAllUsers() {
        System.out.println("getAllUsers");

        User user = new User("test_mail5@test.cz", "test_password", "test_salt", UserRole.GUEST);
        UserDAOImpl instance = new UserDAOImpl();
        instance.add(user);

        List<User> result = instance.getAll();
        assertTrue(result.size() > 0);
    }


}