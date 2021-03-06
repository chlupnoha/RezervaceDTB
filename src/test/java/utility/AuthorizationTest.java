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
package utility;

import dao.UserDAOImpl;
import model.User;
import model.UserRole;
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
public class AuthorizationTest {
    
    public AuthorizationTest() {
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
     * Test of login method, of class Authorization.
     */
    @Test
    public void testAuthorization() throws Exception {
        //create user
        User user = new User("email@dfasdlkjf.cz", "password1234", UserRole.GUEST);
        UserDAOImpl userDao = new UserDAOImpl();
        User addUser = userDao.add(user);
        
        System.out.println("login");

        User resultUser = Authorization.login(user.getEmail(), user.getPassword());
        
        System.out.println(addUser.getPassword());
        System.out.println(resultUser.getPassword());
        
        assertEquals(addUser.getId(), resultUser.getId());
    }
    
}
