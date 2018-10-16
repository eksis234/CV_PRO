
import controller.EducationController;
import controller.PengalamankerjaController;
import controller.PersonalController;
import controller.TrainingController;
import controller.UserManagementController;
import daos.GeneralDAO;
import daos.InterfaceDAO;
import java.util.List;
import model.*;
import tools.HibernateUtil;
import view.SerbaGuna;

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
        UserManagementController controller = new UserManagementController(tools.HibernateUtil.getSessionFactory());
//    Workingexperience w = new Workingexperience();
//    PengalamankerjaController pc = new PengalamankerjaController(HibernateUtil.getSessionFactory());
//    w = (Workingexperience) pc.getById("1");
    
//        for (Object object : iDAO.getAll()) {
//            Workingexperience w = (Workingexperience) object;
//            System.out.println(w.getIdworkingexperience()+" - "+w.getNamaperusahaan());
//        }
//        System.out.println(w.getIdworkingexperience()+" - "+w.getEmployer());
//        System.out.println(controller.saveOrUpdate("2", "user2", "E23sis,.", "admin"));
        
//        SerbaGuna sg = new SerbaGuna();
//        PersonalController personalController = new PersonalController(HibernateUtil.getSessionFactory());
//        Personaldata personalData = personalController.getIdPersonal("1");
//        System.out.println(sg.sendMessage(personalData));
    //List<Object> list = iDAO.getDataNonExpired("enddate");
        //System.out.println("dari DAO "+list.size());
        TrainingController tc = new TrainingController(HibernateUtil.getSessionFactory());
        List<Object> lis = tc.getDatas();
        List<Object> lis2 = tc.getAll();
        System.out.println("dari controller"+lis.size());
        System.out.println("getAll "+lis2.size());
    }
    
}
