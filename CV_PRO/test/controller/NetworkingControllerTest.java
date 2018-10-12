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
public class NetworkingControllerTest {

    public NetworkingControllerTest() {
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
     * Test of saveOrUpdate method, of class NetworkingController.
     */
    @Test
    public void testSaveOrUpdate() {
        System.out.println("===================================================");
        System.out.println("saveOrUpdate");
        String idNetworking = "2";
        String networkingSkill = "lari-lari";
        NetworkingController instance = new NetworkingController(tools.HibernateUtil.getSessionFactory());

        for (int i = 0; i < 3; i++) {
            try {
                switch (i) {
                    case 1:
                        idNetworking = "2";
                        break;
                    case 2:
                        idNetworking = "b";
                        break;
                    default:
                        idNetworking = "1b";
                        break;
                }
                boolean result = instance.saveOrUpdate(idNetworking, networkingSkill);
                assertTrue(result);
                System.out.println("berhasil simpan karna id = " + idNetworking);
            } catch (Exception e) {
                System.out.println("gagal karna id = " + idNetworking);
            }
        }
    }

    /**
     * Test of delete method, of class NetworkingController.
     */
    @Test
    public void testDelete() {
        System.out.println("===================================================");
        System.out.println("delete");
        String idNetworking = "";
        NetworkingController instance = new NetworkingController(tools.HibernateUtil.getSessionFactory());

        for (int i = 0; i < 3; i++) {
            try {
                switch (i) {
                    case 1:
                        idNetworking = "2";
                        break;
                    case 2:
                        idNetworking = "b";
                        break;
                    default:
                        idNetworking = "1b";
                        break;
                }
                boolean result = instance.delete(idNetworking);
                assertTrue(result);
                System.out.println("berhasil hapus karna id = " + idNetworking);
            } catch (Exception e) {
                System.out.println("gagal hapus karna id = " + idNetworking);
            }
        }
    }

    /**
     * Test of getAll method, of class NetworkingController.
     */
    @Test
    public void testGetAll() {
        System.out.println("===================================================");
        try {
            NetworkingController instance = new NetworkingController(tools.HibernateUtil.getSessionFactory());
            List<Object> result = instance.getAll();
            assertNotNull(result);
            System.out.println("getAll berhasil");
        } catch (Exception e) {
            System.out.println("getAll gagal");
        }

    }

    /**
     * Test of search method, of class NetworkingController.
     */
    @Test
    public void testSearch() {
        System.out.println("===================================================");
        System.out.println("search");
        String category = "idnetworking";
        Object key = 1;
        NetworkingController instance = new NetworkingController(tools.HibernateUtil.getSessionFactory());

        for (int i = 0; i < 3; i++) {
            try {
                switch (i) {
                    case 1:
                        key = 2;
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
                System.out.println("data berhasil ditemukan karena id = " + key);
            } catch (Exception e) {
                System.out.println("data gagal ditemukan karena id = " + key);
            }
        }
    }

    /**
     * Test of getAutoId method, of class NetworkingController.
     */
    @Test
    public void testGetAutoId() {
        System.out.println("===================================================");
        try {
            NetworkingController instance = new NetworkingController(tools.HibernateUtil.getSessionFactory());
            Object result = instance.getAutoId();
            assertNotNull(result);
            System.out.println("getAutoId berhasil");
        } catch (Exception e) {
            System.out.println("getAutoId gagal");
        }

    }
}
