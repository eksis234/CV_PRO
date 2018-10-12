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
public class AchievementControllerTest {

    public AchievementControllerTest() {
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
     * Test of saveOrUpdate method, of class AchievementController.
     */
    @Test
    public void testSaveOrUpdate() {
        System.out.println("===================================================");
        System.out.println("saveOrUpdate angka");
        String idAchv = "";
        String achvName = "dimas";
        String eventName = "7 belas agustus";
        String year = "2019";
        AchievementController instance = new AchievementController(tools.HibernateUtil.getSessionFactory());
        for (int i = 0; i < 3; i++) {
            try {
                switch (i) {
                    case 1:
                        idAchv = "2";
                        break;
                    case 2:
                        idAchv = "b";
                        break;
                    default:
                        idAchv = "1b";
                        break;
                }
                boolean result = instance.saveOrUpdate(idAchv, achvName, eventName, year);
                assertTrue(result);
                System.out.println("berhasil simpan karna id = " + idAchv);
            } catch (Exception e) {
                System.out.println("gagal karna id = " + idAchv);
            }
        }
    }

    /**
     * Test of delete method, of class AchievementController.
     */
    @Test
    public void testDelete() {
        System.out.println("===================================================");
        System.out.println("delete");
        String idAchv = "";
        AchievementController instance = new AchievementController(tools.HibernateUtil.getSessionFactory());
        for (int i = 0; i < 3; i++) {
            try {
                switch (i) {
                    case 1:
                        idAchv = "2";
                        break;
                    case 2:
                        idAchv = "b";
                        break;
                    default:
                        idAchv = "1b";
                        break;
                }
                boolean result = instance.delete(idAchv);
                assertTrue(result);
                System.out.println("berhasil hapus karna id = " + idAchv);
            } catch (Exception e) {
                System.out.println("gagal hapus karna id = " + idAchv);
            }
        }
    }

    /**
     * Test of getAll method, of class AchievementController.
     */
    @Test
    public void testGetAll() {
        System.out.println("===================================================");
        try {
            AchievementController instance = new AchievementController(tools.HibernateUtil.getSessionFactory());
            List<Object> result = instance.getAll();
            assertNotNull(result);
            System.out.println("getAll berhasil");
        } catch (Exception e) {
            System.out.println("getAll gagal");
        }

    }

    /**
     * Test of search method, of class AchievementController.
     */
    @Test
    public void testSearch() {
        System.out.println("===================================================");
        System.out.println("search");
        String category = "idachievement";
        Object key = "";
        AchievementController instance = new AchievementController(tools.HibernateUtil.getSessionFactory());

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
                System.out.println("data berhasil ditemukan karna id = " + key);
            } catch (Exception e) {
                System.out.println("data gagal ditemukan karna id = " + key);
            }
        }
    }

    /**
     * Test of getAutoId method, of class AchievementController.
     */
    @Test
    public void testGetAutoId() {
        System.out.println("===================================================");
        try {
            AchievementController instance = new AchievementController(tools.HibernateUtil.getSessionFactory());
            Object result = instance.getAutoId();
            assertNotNull(result);
            System.out.println("getAutoId berhasil");
        } catch (Exception e) {
            System.out.println("getAutoId gagal");
        }

    }
//    
}
