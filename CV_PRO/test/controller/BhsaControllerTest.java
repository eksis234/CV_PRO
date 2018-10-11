/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.Foreignlanguage;
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
public class BhsaControllerTest {

    public BhsaControllerTest() {
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
     * Test of saveOrUpdate method, of class BhsaController.
     */
    @Test
    public void testSaveOrUpdate() {
        System.out.println("===================================================");
        System.out.println("saveOrUpdate");
        String idflang = "3";
        String languagename = "Indonesia";
        BhsaController instance = new BhsaController(tools.HibernateUtil.getSessionFactory());
        for (int i = 0; i < 3; i++) {
            try {
                switch (i) {
                    case 1:
                        languagename = "2";
                        break;
                    case 2:
                        languagename = "b";
                        break;
                    default:
                        languagename = "1b";
                        break;
                }
                boolean result = instance.saveOrUpdate(idflang, languagename);
                assertTrue(result);
                System.out.println("berhasil simpan karena name = " + languagename);
            } catch (Exception e) {
                System.out.println("gagal karena name = " + languagename);
            }
        }
    }

    /**
     * Test of delete method, of class BhsaController.
     */
    @Test
    public void testDelete() {
        System.out.println("===================================================");
        System.out.println("delete");
        String idflang = "";
        BhsaController instance = new BhsaController(tools.HibernateUtil.getSessionFactory());
        for (int i = 0; i < 3; i++) {
            try {
                switch (i) {
                    case 1:
                        idflang = "3";
                        break;
                    case 2:
                        idflang = "b";
                        break;
                    default:
                        idflang = "1b";
                        break;
                }
                boolean result = instance.delete(idflang);
                assertTrue(result);
                System.out.println("berhasil hapus karna id = " + idflang);
            } catch (Exception e) {
                System.out.println("gagal hapus karna id = " + idflang);
            }
        }
    }

    /**
     * Test of getById method, of class BhsaController.
     */
//    @Test
//    public void testGetById() {
//        System.out.println("getById");
//        String idflang = "1";
//        BhsaController instance = new BhsaController(tools.HibernateUtil.getSessionFactory());
//        Foreignlanguage result = instance.getById(idflang);
//        assertNotNull(result);
//    }
//
//    /**
//     * Test of getByName method, of class BhsaController.
//     */
//    @Test
//    public void testGetByName() {
//        System.out.println("getByName");
//        String languagename = "";
//        BhsaController instance = null;
//        Foreignlanguage expResult = null;
//        Foreignlanguage result = instance.getByName(languagename);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
    /**
     * Test of getAll method, of class BhsaController.
     */
    @Test
    public void testGetAll() {
        System.out.println("===================================================");
        
        BhsaController instance = new BhsaController(tools.HibernateUtil.getSessionFactory());
        List<Object> result = instance.getAll();
        assertNotNull(result);
        System.out.println("getAll data bahasa asing berhasil");
    }

    /**
     * Test of search method, of class BhsaController.
     */
    @Test
    public void testSearch() {
        System.out.println("===================================================");
        System.out.println("search");
        String category = "languagename";
        Object key = "1";
        BhsaController instance = new BhsaController(tools.HibernateUtil.getSessionFactory());
        for (int i = 0; i < 3; i++) {
            try {
                switch (i) {
                    case 1:
                        key = "2";
                        break;
                    case 2:
                        key = "b";
                        break;
                    default:
                        key = "1b";
                        break;
                }
                List<Object> result = instance.search(category, key);
                assertNotNull(result);
                System.out.println("data berhasil ditemukan karna id = " + key);
            } catch (Exception e) {
                System.out.println("data gagal ditemukan karna id = " + key);
            }
        }
    }


/**
 * Test of getAutoId method, of class BhsaController.
 */
@Test
        public void testGetAutoId() {
        System.out.println("===================================================");
        BhsaController instance = new BhsaController(tools.HibernateUtil.getSessionFactory());
        Object result = instance.getAutoId();
        assertNotNull(result);
        System.out.println("getAutoId bahasa asing berhasil");
    }
}
