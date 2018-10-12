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
public class EducationControllerTest {

    public EducationControllerTest() {
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
     * Test of getAll method, of class EducationController.
     */
    @Test
    public void testGetAll() {
        System.out.println("===================================================");
        EducationController instance = new EducationController(tools.HibernateUtil.getSessionFactory());
        List<Object> result = instance.getAll();
        assertNotNull(result);
        System.out.println("getAll education berhasil");
    }

    /**
     * Test of saveOrUpdate method, of class EducationController.
     */
    @Test
    public void testSaveOrUpdate() {
        System.out.println("===================================================");
        System.out.println("saveOrUpdate");
        String idEducation = "1";
        String instansi = "USD";
        String LevelEducation = "S1";
        String gpa = "3.5";
        String yearIn = "2014";
        String graduation = "2017";
        String major = "TI";
        EducationController instance = new EducationController(tools.HibernateUtil.getSessionFactory());
        for (int i = 0; i < 3; i++) {
            try {
                switch (i) {
                    case 1:
                        idEducation = "2";
                        break;
                    case 2:
                        idEducation = "b";
                        break;
                    default:
                        idEducation = "1b";
                        break;
                }
                boolean result = instance.saveOrUpdate(idEducation, instansi, LevelEducation);
                assertTrue(result);
                System.out.println("berhasil simpan karena ID = " + idEducation);
            } catch (Exception e) {
                System.out.println("gagal karena ID = " + idEducation);
            }
        }
    }

    /**
     * Test of getAutoId method, of class EducationController.
     */
    @Test
    public void testGetAutoId() {
        System.out.println("===================================================");
        EducationController instance = new EducationController(tools.HibernateUtil.getSessionFactory());
        Object result = instance.getAutoId();
        assertNotNull(result);
        System.out.println("getAutoId berhasil");
    }
}
