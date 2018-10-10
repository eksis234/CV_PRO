
import daos.GeneralDAO;
import daos.InterfaceDAO;
import model.Achievement;
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
        InterfaceDAO iDAO = new GeneralDAO(HibernateUtil.getSessionFactory(), Achievement.class);
        for (Object object : iDAO.getAll()) {
            Achievement achievement = (Achievement) object;
            System.out.println(achievement.getAchievementname()+" - "+achievement.getIdachievement());
        }
        System.out.println("heloo");
    }
    
}
