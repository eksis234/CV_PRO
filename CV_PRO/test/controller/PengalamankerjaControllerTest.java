/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Date;
import java.util.List;
import model.Workingexperience;
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
public class PengalamankerjaControllerTest {

    public PengalamankerjaControllerTest() {
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
     * Test of saveOrUpdate method, of class PengalamankerjaController.
     */
    @Test
    public void testSaveOrUpdate() {
        System.out.println("===================================================");
        System.out.println("saveOrUpdate");
        String idpk = "1";
        String namaPerusahaan = "";
        String city = "";
        Date startdate = null;
        Date enddate = null;
        String description = "";
        PengalamankerjaController instance = new PengalamankerjaController(tools.HibernateUtil.getSessionFactory());
        for (int i = 0; i < 3; i++) {
            try {
                switch (i) {
                    case 1:
                        idpk = "2";
                        break;
                    case 2:
                        idpk = "b";
                        break;
                    default:
                        idpk = "1b";
                        break;
                }
                boolean result = instance.saveOrUpdate(idpk, namaPerusahaan, city);
                assertTrue(result);
                System.out.println("berhasil simpan karena id = " + idpk);
            } catch (Exception e) {
                System.out.println("gagal simpan karena id = " + idpk);
            }
        }
    }

    /**
     * Test of delete method, of class PengalamankerjaController.
     */
    @Test
    public void testDelete() {
        System.out.println("===================================================");
        System.out.println("delete");
        String idpk = "";
        PengalamankerjaController instance = new PengalamankerjaController(tools.HibernateUtil.getSessionFactory());
        for (int i = 0; i < 3; i++) {
            try {
                switch (i) {
                    case 1:
                        idpk = "2";
                        break;
                    case 2:
                        idpk = "b";
                        break;
                    default:
                        idpk = "1b";
                        break;
                }
                boolean result = instance.delete(idpk);
                assertTrue(result);
                System.out.println("berhasil hapus karna id = " + idpk);
            } catch (Exception e) {
                System.out.println("gagal hapus karna id = " + idpk);
            }
        }
    }
//
//    /**
//     * Test of getById method, of class PengalamankerjaController.
//     */
//    @Test
//    public void testGetById() {
//        System.out.println("getById");
//        String idpk = "";
//        PengalamankerjaController instance = null;
//        Workingexperience expResult = null;
//        Workingexperience result = instance.getById(idpk);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getByName method, of class PengalamankerjaController.
//     */
//    @Test
//    public void testGetByName() {
//        System.out.println("getByName");
//        String pkname = "";
//        PengalamankerjaController instance = null;
//        Workingexperience expResult = null;
//        Workingexperience result = instance.getByName(pkname);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
    /**
     * Test of getAll method, of class PengalamankerjaController.
     */
    @Test
    public void testGetAll() {
        System.out.println("===================================================");
        PengalamankerjaController instance = new PengalamankerjaController(tools.HibernateUtil.getSessionFactory());
        List<Object> result = instance.getAll();
        assertNotNull(result);
        System.out.println("getAll berhasil");
    }
//
//    /**
//     * Test of search method, of class PengalamankerjaController.
//     */
//    @Test
//    public void testSearch() {
//        System.out.println("search");
//        String category = "";
//        Object key = null;
//        PengalamankerjaController instance = null;
//        List<Object> expResult = null;
//        List<Object> result = instance.search(category, key);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
    /**
     * Test of getAutoId method, of class PengalamankerjaController.
     */
//    @Test
//    public void testGetAutoId() {
//        System.out.println("===================================================");
//        PengalamankerjaController instance = new PengalamankerjaController(tools.HibernateUtil.getSessionFactory());
//        Object result = instance.getAutoId();
//        assertNotNull(result);
//        System.out.println("getAutoId berhasil");
//    }

}
