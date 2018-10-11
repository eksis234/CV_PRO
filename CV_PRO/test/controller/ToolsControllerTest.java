/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.Tools;
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
public class ToolsControllerTest {
    
    public ToolsControllerTest() {
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
     * Test of saveOrUpdate method, of class ToolsController.
     */
    @Test
    public void testSaveOrUpdate() {
        System.out.println("saveOrUpdate");
        String idtool = "3";
        String toolname = "b";
        ToolsController instance = new ToolsController(tools.HibernateUtil.getSessionFactory());
        boolean result = instance.saveOrUpdate(idtool, toolname);
        assertTrue(result);
    }

    /**
     * Test of delete method, of class ToolsController.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        String idtool = "3";
        ToolsController instance = new ToolsController(tools.HibernateUtil.getSessionFactory());
        boolean result = instance.delete(idtool);
        assertTrue(result);
    }

    /**
     * Test of getById method, of class ToolsController.
     */
//    @Test
//    public void testGetById() {
//        System.out.println("getById");
//        String idtool = "";
//        ToolsController instance = null;
//        Tools expResult = null;
//        Tools result = instance.getById(idtool);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of getByName method, of class ToolsController.
     */
//    @Test
//    public void testGetByName() {
//        System.out.println("getByName");
//        String toolname = "";
//        ToolsController instance = null;
//        Tools expResult = null;
//        Tools result = instance.getByName(toolname);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of getAll method, of class ToolsController.
     */
//    @Test
//    public void testGetAll() {
//        System.out.println("getAll");
//        ToolsController instance = null;
//        List<Object> expResult = null;
//        List<Object> result = instance.getAll();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of search method, of class ToolsController.
     */
//    @Test
//    public void testSearch() {
//        System.out.println("search");
//        String category = "";
//        Object key = null;
//        ToolsController instance = null;
//        List<Object> expResult = null;
//        List<Object> result = instance.search(category, key);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of getAutoId method, of class ToolsController.
     */
//    @Test
//    public void testGetAutoId() {
//        System.out.println("getAutoId");
//        ToolsController instance = null;
//        Object expResult = null;
//        Object result = instance.getAutoId();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
