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
public class PersonalControllerTest {

    public PersonalControllerTest() {
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
     * Test of saveOrUpdate method, of class PersonalController.
     */
    @Test
    public void testSaveOrUpdate() {
        System.out.println("====================================================");
        System.out.println("saveOrUpdate");
        String idpersonal = "2";
        String name = "leo";
        String dateofbirth = "02/12/1996";
        String nationality = "indonesia";
        String maritalstatus = "Single";
        String gender = "M";
        String phonenumber = "0987654321";
        String email = "leo@leo";
        String foto = "d:\\img\\pp.jpg";
        PersonalController instance = new PersonalController(tools.HibernateUtil.getSessionFactory());
        for (int i = 0; i < 3; i++) {
            try {
                switch (i) {
                    case 1:
                        phonenumber = "2";
                        break;
                    case 2:
                        phonenumber = "b";
                        break;
                    default:
                        phonenumber = "1b";
                        break;
                }
                boolean result = instance.saveOrUpdate(idpersonal, name, dateofbirth, nationality, maritalstatus, gender, phonenumber, email, foto);
                assertTrue(result);
                System.out.println("berhasil simpan karena phonenumber = " + phonenumber);
            } catch (Exception e) {
                System.out.println("gagal simpan karena phonenumber = " + phonenumber);
            }
        }
    }

    /**
     * Test of delete method, of class PersonalController.
     */
    @Test
    public void testDelete() {
        System.out.println("====================================================");
        System.out.println("delete");
        String idpersonal = "";
        PersonalController instance = new PersonalController(tools.HibernateUtil.getSessionFactory());

        for (int i = 0; i < 3; i++) {
            try {
                switch (i) {
                    case 1:
                        idpersonal = "1";
                        break;
                    case 2:
                        idpersonal = "b";
                        break;
                    default:
                        idpersonal = "1b";
                        break;
                }
                boolean result = instance.delete(idpersonal);
                assertTrue(result);
                System.out.println("berhasil hapus karena id = " + idpersonal);
            } catch (Exception e) {
                System.out.println("gagal hapus karena id = " + idpersonal);
            }
        }
    }

    /**
     * Test of getAll method, of class PersonalController.
     */
    @Test
    public void testGetAll() {
        System.out.println("====================================================");
        System.out.println("getAll");
        PersonalController instance = new PersonalController(tools.HibernateUtil.getSessionFactory());
        List<Object> result = instance.getAll();
        assertNotNull(result);
    }


    /**
     * Test of getAutoId method, of class PersonalController.
     */
    @Test
    public void testGetAutoId() {
        System.out.println("====================================================");
        System.out.println("getAutoId");
        PersonalController instance = new PersonalController(tools.HibernateUtil.getSessionFactory());
        Object result = instance.getAutoId();
        assertNotNull(result);
    }

}
