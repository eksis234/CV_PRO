/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.Os;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author chochong
 */
public class OsControllerTest {

    public OsControllerTest() {
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
     * Test of saveOrUpdate method, of class OsController.
     */
    @Test
    public void testSaveOrUpdate() {
        System.out.println("===================================================");
        System.out.println("saveOrUpdate");
        String idos = "";
        String osname = "Linux";
        OsController instance = new OsController(tools.HibernateUtil.getSessionFactory());

        for (int i = 0; i < 3; i++) {
            try {
                switch (i) {
                    case 1:
                        idos = "2";
                        break;
                    case 2:
                        idos = "b";
                        break;
                    default:
                        idos = "1b";
                        break;
                }
                boolean result = instance.saveOrUpdate(idos, osname);
                assertTrue(result);
                System.out.println("berhasil simpan karna id = " + idos);
            } catch (Exception e) {
                System.out.println("gagal karna id = " + idos);
            }
        }
    }

    /**
     * Test of delete method, of class OsController.
     */
    @Test
    public void testDelete() {
        System.out.println("===================================================");
        System.out.println("delete");
        String idos = "";
        OsController instance = new OsController(tools.HibernateUtil.getSessionFactory());
        
        for (int i = 0; i < 3; i++) {
            try {
                switch (i) {
                    case 1:
                        idos = "2";
                        break;
                    case 2:
                        idos = "b";
                        break;
                    default:
                        idos = "1b";
                        break;
                }
                boolean result = instance.delete(idos);
        assertTrue(result);
                System.out.println("berhasil hapus karna id = " + idos);
            } catch (Exception e) {
                System.out.println("gagal hapus karna id = " + idos);
            }
        }
    }
//
//    /**
//     * Test of getById method, of class OsController.
//     */
//    @Test
//    public void testGetById() {
//        System.out.println("getById");
//        String idos = "";
//        OsController instance = null;
//        Os expResult = null;
//        Os result = instance.getById(idos);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getByName method, of class OsController.
//     */
//    @Test
//    public void testGetByName() {
//        System.out.println("getByName");
//        String osname = "";
//        OsController instance = null;
//        Os expResult = null;
//        Os result = instance.getByName(osname);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
    /**
     * Test of getAll method, of class OsController.
     */
    @Test
    public void testGetAll() {
        System.out.println("===================================================");
        OsController instance = new OsController(tools.HibernateUtil.getSessionFactory());
        List<Object> result = instance.getAll();
        assertNotNull(result);
        System.out.println("getAll berhasil");
    }

    /**
     * Test of search method, of class OsController.
     */
//    @Test
//    public void testSearch() {
//        System.out.println("search");
//        String category = "idos";
//        Object key = 1;
//        OsController instance = new OsController(tools.HibernateUtil.getSessionFactory());
//        List<Object> result = instance.search(category, key);
//        assertNotNull(result);
//    }

    /**
     * Test of getAutoId method, of class OsController.
     */
    @Test
    public void testGetAutoId() {
        System.out.println("===================================================");
        OsController instance = new OsController(tools.HibernateUtil.getSessionFactory());
        Object result = instance.getAutoId();
        assertNotNull(result);
        System.out.println("getAutoId berhasil");
    }
}
