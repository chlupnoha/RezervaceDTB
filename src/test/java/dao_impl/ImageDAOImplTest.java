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

import model.Image;
import org.junit.*;

import static org.junit.Assert.assertNotNull;

/**
 *
 * @author chlupnoha
 */
public class ImageDAOImplTest {
    
    public ImageDAOImplTest() {
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
//     * Test of getImageByID method, of class ImageDAOImpl.
//     */
//    @Test
//    public void testGetImageByID() {
//        System.out.println("getImageByID");
//        Integer imageId = null;
//        ImageDAOImpl instance = new ImageDAOImpl();
//        Image expResult = null;
//        Image result = instance.getImageByID(imageId);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of addImage method, of class ImageDAOImpl.
     */
    @Test
    public void testAddImage() {
        System.out.println("addImage");
        Image image = new Image("testImage");
        ImageDAOImpl instance = new ImageDAOImpl();
        
        Image result = instance.add(image);
        assertNotNull(result.getId());
    }

//    /**
//     * Test of updateImage method, of class ImageDAOImpl.
//     */
//    @Test
//    public void testUpdateImage() {
//        System.out.println("updateImage");
//        Image image = null;
//        ImageDAOImpl instance = new ImageDAOImpl();
//        Image expResult = null;
//        Image result = instance.updateImage(image);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of deleteImage method, of class ImageDAOImpl.
//     */
//    @Test
//    public void testDeleteImage() {
//        System.out.println("deleteImage");
//        int imageId = 0;
//        ImageDAOImpl instance = new ImageDAOImpl();
//        boolean expResult = false;
//        boolean result = instance.deleteImage(imageId);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getAllImages method, of class ImageDAOImpl.
//     */
//    @Test
//    public void testGetAllImages() {
//        System.out.println("getAllImages");
//        ImageDAOImpl instance = new ImageDAOImpl();
//        List<Image> expResult = null;
//        List<Image> result = instance.getAllImages();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
