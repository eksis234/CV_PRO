/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.Organization;
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
public class OrganizationControllerTest {

    public OrganizationControllerTest() {
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
     * Test of saveOrUpdate method, of class OrganizationController.
     */
    @Test
    public void testSaveOrUpdate() {
        System.out.println("===================================================");
        System.out.println("saveOrUpdate");
        String idorganisai = "";
        String organisainame = "HMJTI";
        OrganizationController instance = new OrganizationController(tools.HibernateUtil.getSessionFactory());
        for (int i = 0; i < 3; i++) {
            try {
                switch (i) {
                    case 1:
                        idorganisai = "2";
                        break;
                    case 2:
                        idorganisai = "b";
                        break;
                    default:
                        idorganisai = "1b";
                        break;
                }
                boolean result = instance.saveOrUpdate(idorganisai, organisainame);
                assertTrue(result);
                System.out.println("berhasil simpan karna id = " + idorganisai);
            } catch (Exception e) {
                System.out.println("gagal karna id = " + idorganisai);
            }
        }
    }

    /**
     * Test of delete method, of class OrganizationController.
     */
    @Test
    public void testDelete() {
        System.out.println("===================================================");
        System.out.println("delete");
        String idorganisai = "";
        OrganizationController instance = new OrganizationController(tools.HibernateUtil.getSessionFactory());
        for (int i = 0; i < 3; i++) {
            try {
                switch (i) {
                    case 1:
                        idorganisai = "2";
                        break;
                    case 2:
                        idorganisai = "b";
                        break;
                    default:
                        idorganisai = "1b";
                        break;
                }
                boolean result = instance.delete(idorganisai);
                assertTrue(result);
                System.out.println("berhasil hapus karna id = " + idorganisai);
            } catch (Exception e) {
                System.out.println("gagal hapus karna id = " + idorganisai);
            }
        }
    }

    /**
     * Test of getAll method, of class OrganizationController.
     */
    @Test
    public void testGetAll() {
        System.out.println("===================================================");
        try {
            OrganizationController instance = new OrganizationController(tools.HibernateUtil.getSessionFactory());
            List<Object> result = instance.getAll();
            assertNotNull(result);
            System.out.println("getAll berhasil");
        } catch (Exception e) {
            System.out.println("getAll gagal");
        }
    }

    /**
     * Test of getAutoId method, of class OrganizationController.
     */
    @Test
    public void testGetAutoId() {
        try {
            OrganizationController instance = new OrganizationController(tools.HibernateUtil.getSessionFactory());
            Object result = instance.getAutoId();
            assertNotNull(result);
            System.out.println("getAutoId berasil");
        } catch (Exception e) {
            System.out.println("getAutoId gagal");
        }

    }
//    
}
