/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
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
public class ProgrammingControllerTest {

    public ProgrammingControllerTest() {
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
     * Test of saveOrUpdate method, of class ProgrammingController.
     */
    @Test
    public void testSaveOrUpdate() {
        System.out.println("===================================================");
        System.out.println("saveOrUpdate");
        String idprogramming = "";
        String programmingname = "a";
        ProgrammingController instance = new ProgrammingController(tools.HibernateUtil.getSessionFactory());

        for (int i = 0; i < 3; i++) {
            try {
                switch (i) {
                    case 1:
                        idprogramming = "2";
                        break;
                    case 2:
                        idprogramming = "b";
                        break;
                    default:
                        idprogramming = "1b";
                        break;
                }
                boolean result = instance.saveOrUpdate(idprogramming, programmingname);
                assertTrue(result);
                System.out.println("berhasil simpan karena id = " + idprogramming);
            } catch (Exception e) {
                System.out.println("gagal simpan karena id = " + idprogramming);
            }
        }
    }

    /**
     * Test of delete method, of class ProgrammingController.
     */
    @Test
    public void testDelete() {
        System.out.println("===================================================");
        System.out.println("delete");
        String idprogramming = "3";
        ProgrammingController instance = new ProgrammingController(tools.HibernateUtil.getSessionFactory());

        for (int i = 0; i < 3; i++) {
            try {
                switch (i) {
                    case 1:
                        idprogramming = "2";
                        break;
                    case 2:
                        idprogramming = "b";
                        break;
                    default:
                        idprogramming = "1b";
                        break;
                }
                boolean result = instance.delete(idprogramming);
                assertTrue(result);
                System.out.println("berhasil hapus karna id = " + idprogramming);
            } catch (Exception e) {
                System.out.println("gagal hapus karna id = " + idprogramming);
            }
        }
    }

    /**
     * Test of getAll method, of class ProgrammingController.
     */
    @Test
    public void testGetAll() {
        System.out.println("====================================================");
        try {
            ProgrammingController instance = new ProgrammingController(tools.HibernateUtil.getSessionFactory());
            List<Object> result = instance.getAll();
            assertNotNull(result);
            System.out.println("getAll berhasil");
        } catch (Exception e) {
            System.out.println("getAll gagal");
        }
    }

    /**
     * Test of getAutoId method, of class ProgrammingController.
     */
    @Test
    public void testGetAutoId() {
        System.out.println("====================================================");
        try {
            ProgrammingController instance = new ProgrammingController(tools.HibernateUtil.getSessionFactory());
            Object result = instance.getAutoId();
            assertNotNull(result);
            System.out.println("getAutoId berhasil");
        } catch (Exception e) {
            System.out.println("getAutoId gagal");
        }

    }
}
