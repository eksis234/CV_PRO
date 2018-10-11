
import controller.EducationController;
import controller.PengalamankerjaController;
import daos.GeneralDAO;
import daos.InterfaceDAO;
import model.*;
import tools.HibernateUtil;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lenovo
 */
public class MainTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("heloo");
//        InterfaceDAO iDAO = new GeneralDAO(HibernateUtil.getSessionFactory(), Achievement.class);
//        for (Object object : iDAO.getAll()) {
//            Achievement achievement = (Achievement) object;
//            System.out.println(achievement.getAchievementname()+" - "+achievement.getIdachievement());
//        }
    InterfaceDAO iDAO = new GeneralDAO(HibernateUtil.getSessionFactory(), Workingexperience.class);
//    Workingexperience w = new Workingexperience();
//    PengalamankerjaController pc = new PengalamankerjaController(HibernateUtil.getSessionFactory());
//    w = (Workingexperience) pc.getById("1");
    
        for (Object object : iDAO.getAll()) {
            Workingexperience w = (Workingexperience) object;
            System.out.println(w.getIdworkingexperience()+" - "+w.getEmployer());
        }
//        System.out.println(w.getIdworkingexperience()+" - "+w.getEmployer());
    }
    
}
