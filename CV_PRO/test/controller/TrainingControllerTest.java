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
        System.out.println("getAll");
        TrainingController instance = new TrainingController(tools.HibernateUtil.getSessionFactory());
        List<Object> result = instance.getAll();
        assertNotNull(result);
    }

    /**
     * Test of getById method, of class TrainingController.
     */
//    @Test
//    public void testGetById() {
//        System.out.println("getById");
//        String id = "";
//        TrainingController instance = null;
//        Object expResult = null;
//        Object result = instance.getById(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of search method, of class TrainingController.
//     */
//    @Test
//    public void testSearch() {
//        System.out.println("search");
//        String category = "";
//        String key = "";
//        TrainingController instance = null;
//        List<Object> expResult = null;
//        List<Object> result = instance.search(category, key);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of saveOrUpdate method, of class TrainingController.
//     */
//    @Test
//    public void testSaveOrUpdate() {
//        System.out.println("saveOrUpdate");
//        String trainingId = "";
//        String trainingName = "";
//        String trainingOrganization = "";
//        String startDate = "";
//        String endDate = "";
//        TrainingController instance = null;
//        boolean expResult = false;
//        boolean result = instance.saveOrUpdate(trainingId, trainingName, trainingOrganization, startDate, endDate);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getAutoId method, of class TrainingController.
//     */
//    @Test
//    public void testGetAutoId() {
//        System.out.println("getAutoId");
//        TrainingController instance = null;
//        Object expResult = null;
//        Object result = instance.getAutoId();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getByName method, of class TrainingController.
//     */
//    @Test
//    public void testGetByName() {
//        System.out.println("getByName");
//        String name = "";
//        TrainingController instance = null;
//        Object expResult = null;
//        Object result = instance.getByName(name);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of delete method, of class TrainingController.
//     */
//    @Test
//    public void testDelete() {
//        System.out.println("delete");
//        String id = "";
//        TrainingController instance = null;
//        boolean expResult = false;
//        boolean result = instance.delete(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
