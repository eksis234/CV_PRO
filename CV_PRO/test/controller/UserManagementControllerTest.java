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
public class UserManagementControllerTest {

    public UserManagementControllerTest() {
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
     * Test of saveOrUpdate method, of class UserManagementController.
     */
    @Test
    public void testSaveOrUpdate() {
        System.out.println("saveOrUpdate");
        String id = "2";
        String username = "aw";
        String password = "aw";
        String role = "admin";
        UserManagementController instance = new UserManagementController(tools.HibernateUtil.getSessionFactory());
        boolean result = instance.saveOrUpdate(id, username, password, role);
        assertTrue(result);
    }

    /**
     * Test of getAll method, of class UserManagementController.
     */
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        UserManagementController instance = new UserManagementController(tools.HibernateUtil.getSessionFactory());
        List<Object> result = instance.getAll();
        assertNotNull(result);
    }

    /**
     * Test of getByName method, of class UserManagementController.
     */
    @Test
    public void testGetByName() {
        System.out.println("getByName");
        String username = "aw";
        UserManagementController instance = new UserManagementController(tools.HibernateUtil.getSessionFactory());
        Object result = instance.getByName(username);
        assertNotNull(result);
    }

    /**
     * Test of login method, of class UserManagementController.
     */
    @Test
    public void testLogin() {
        System.out.println("login");
        String username = "aw";
        String password = "aw";
        UserManagementController instance = new UserManagementController(tools.HibernateUtil.getSessionFactory());
        for (int i = 0; i < 3; i++) {
            try {
                switch (i) {
                    case 1:
                        username = "aw";
                        break;
                    case 2:
                        username = "aw";
                        break;
                    default:
                        username = "aw";
                        break;
                }
                boolean result = instance.login(username, password);
                assertTrue(result);
                System.out.println("berhasil login karena username = " + username);
            } catch (Exception e) {
                System.out.println("gagal login karena username = " + username);
            }
        }
    }

    /**
     * Test of getAutoId method, of class UserManagementController.
     */
    @Test
    public void testGetAutoId() {
        System.out.println("getAutoId");
        UserManagementController instance = new UserManagementController(tools.HibernateUtil.getSessionFactory());
        Object result = instance.getAutoId();
        assertNotNull(result);
    }

}
