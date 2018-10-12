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
public class TrainingControllerTest {

    public TrainingControllerTest() {
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
     * Test of getAll method, of class TrainingController.
     */
    @Test
    public void testGetAll() {
        System.out.println("====================================================");
        try {
            TrainingController instance = new TrainingController(tools.HibernateUtil.getSessionFactory());
            List<Object> result = instance.getAll();
            assertNotNull(result);
            System.out.println("getAll berhasil");
        } catch (Exception e) {
            System.out.println("getAll gagal");
        }
    }

    /**
     * Test of saveOrUpdate method, of class TrainingController.
     */
    @Test
    public void testSaveOrUpdate() {
        System.out.println("====================================================");
        System.out.println("saveOrUpdate");
        String trainingId = "";
        String trainingName = "leo";
        String trainingOrganization = "leo";
        TrainingController instance = new TrainingController(tools.HibernateUtil.getSessionFactory());

        for (int i = 0; i < 3; i++) {
            try {
                switch (i) {
                    case 1:
                        trainingId = "3";
                        break;
                    case 2:
                        trainingId = "b";
                        break;
                    default:
                        trainingId = "1b";
                        break;
                }
                boolean result = instance.saveOrUpdate(trainingId, trainingName, trainingOrganization);
                assertTrue(result);
                System.out.println("berhasil simpan karena id = " + trainingId);
            } catch (Exception e) {
                System.out.println("gagal simpan karena id = " + trainingId);
            }
        }
    }

    /**
     * Test of getAutoId method, of class TrainingController.
     */
    @Test
    public void testGetAutoId() {
        System.out.println("====================================================");
        try {
            TrainingController instance = new TrainingController(tools.HibernateUtil.getSessionFactory());
            Object result = instance.getAutoId();
            assertNotNull(result);
            System.out.println("getAutoId berhasil");
        } catch (Exception e) {
            System.out.println("getAutoId gagal");
        }

    }

    /**
     * Test of delete method, of class TrainingController.
     */
    @Test
    public void testDelete() {
        System.out.println("====================================================");
        try {
            String id = "1";
            TrainingController instance = new TrainingController(tools.HibernateUtil.getSessionFactory());
            boolean result = instance.delete(id);
            assertTrue(result);
            System.out.println("delete berhasil");
        } catch (Exception e) {
            System.out.println("delete gagal");
        }

    }

}
