/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import daos.GeneralDAO;
import daos.InterfaceDAO;
import java.math.BigDecimal;
import model.*;
import org.hibernate.SessionFactory;

/**
 *
 * @author Lenovo
 */
public class GetIdController {
    private InterfaceDAO idao;
    private final SessionFactory factory;

    public GetIdController(SessionFactory factory) {
        this.factory = factory;
        idao = new GeneralDAO(factory, Organization.class);
    }
    
       /**
     * Method untuk membuat id baru secara increment +1
     * @return iDAO mengembalikan nilai object
     */
    public Object getAutoId(){
        Organization organization =  (Organization) idao.getLastId();
        BigDecimal one = new BigDecimal("1");
        return organization.getIdorganization().add(one);
    }
    /**
     * Method untuk membuat id baru secara increment +1
     * @return iDAO mengembalikan nilai object
     */
    public Object getLastId(){
        idao = new GeneralDAO(factory, Organization.class);
        Organization organization =  (Organization) idao.getLastId();
        return organization.getIdorganization();
    }
    
    /**
     * Method untuk membuat id baru secara increment +1
     * @return iDAO mengembalikan nilai object
     */
    public Object getAutoId1(){
        idao = new GeneralDAO(factory, Organizationdetails.class);
        Organizationdetails organizationdetails = (Organizationdetails) idao.getLastId();
        BigDecimal one = new BigDecimal("1");
        return organizationdetails.getIdorgdetail().add(one);
    }
    
    /**
     * Method untuk membuat id baru secara increment +1
     * @return iDAO mengembalikan nilai object
     */
    public Object getAutoId2(){
        idao = new GeneralDAO(factory, Experiencedetails.class);
        Experiencedetails experiencedetails = (Experiencedetails) idao.getLastId();
        BigDecimal one = new BigDecimal("1");
        return experiencedetails.getIdexpdetail().add(one);
    }
    
    /**
     * Method untuk membuat id baru secara increment +1
     * @return iDAO mengembalikan nilai object
     */
    public Object getLastId2(){
        idao = new GeneralDAO(factory, Workingexperience.class);
        Workingexperience workingexperience =  (Workingexperience) idao.getLastId();
        return workingexperience.getIdworkingexperience();
    }
    
    /**
     * Method untuk membuat id baru secara increment +1
     * @return iDAO mengembalikan nilai object
     */
    public Object getLastId3(){
        idao = new GeneralDAO(factory, Personaldata.class);
        Personaldata personaldata =  (Personaldata) idao.getLastId();
        return personaldata.getIdpersonal();
    }
    
    /**
     * Method untuk membuat id baru secara increment +1
     * @return iDAO mengembalikan nilai object
     */
    public Object getAutoId4(){
        idao = new GeneralDAO(factory, Educationdetails.class);
        Educationdetails educationdetails = (Educationdetails) idao.getLastId();
        BigDecimal bd = new BigDecimal("1");
        return educationdetails.getIdedudetail().add(bd);
    }
    
    /**
     * Method untuk membuat id baru secara increment +1
     * @return iDAO mengembalikan nilai object
     */
    public Object getLastId4(){
        idao = new GeneralDAO(factory, Education.class);
        Education education = (Education) idao.getLastId();
        return education.getIdeducation();
    }
    
    /**
     * Method untuk membuat id baru secara increment +1
     * @return iDAO mengembalikan nilai object
     */
    public Object getAutoId5(){
        idao = new GeneralDAO(factory, Achievementdetails.class);
        Achievementdetails achievementdetails = (Achievementdetails) idao.getLastId();
        BigDecimal bd = new BigDecimal("1");
        return achievementdetails.getIdachdetail().add(bd);
    }
    
    /**
     * Method untuk membuat id baru secara increment +1
     * @return iDAO mengembalikan nilai object
     */
    public Object getLastId5(){
        idao = new GeneralDAO(factory, Achievement.class);
        Achievement achievement = (Achievement) idao.getLastId();
        return achievement.getIdachievement();
    }
    
    /**
     * Method untuk membuat id baru secara increment +1
     * @return iDAO mengembalikan nilai object
     */
    public Object getAutoId6(){
        idao = new GeneralDAO(factory, Trainingdetails.class);
        Trainingdetails trainingdetails = (Trainingdetails) idao.getLastId();
        BigDecimal bd = new BigDecimal("1");
        return trainingdetails.getIdtrainingdetail().add(bd);
    }
    
    /**
     * Method untuk membuat id baru secara increment +1
     * @return iDAO mengembalikan nilai object
     */
    public Object getLastId6(){
        idao = new GeneralDAO(factory, Training.class);
        Training training = (Training) idao.getLastId();
        return training.getIdtraining();
    }
    
    /**
     * Method untuk membuat id baru secara increment +1
     * @return iDAO mengembalikan nilai object
     */
    public Object getAutoId7(){
        idao = new GeneralDAO(factory, Programmingdetails.class);
        Programmingdetails p = (Programmingdetails) idao.getLastId();
        BigDecimal bd = new BigDecimal("1");
        return p.getIdprogdetail().add(bd);
    }
    
    /**
     * Method untuk membuat id baru secara increment +1
     * @return iDAO mengembalikan nilai object
     */
    public Object getLastId7(){
        idao = new GeneralDAO(factory, Programming.class);
        Programming p = (Programming) idao.getLastId();
        return p.getIdprogramming();
    }
    
    /**
     * Method untuk membuat id baru secara increment +1
     * @return iDAO mengembalikan nilai object
     */
    public Object getAutoId8(){
        idao = new GeneralDAO(factory, Networkingdetails.class);
        Networkingdetails n = (Networkingdetails) idao.getLastId();
        BigDecimal bd = new BigDecimal("1");
        return n.getIdnetdetail().add(bd);
    }
    
    /**
     * Method untuk membuat id baru secara increment +1
     * @return iDAO mengembalikan nilai object
     */
    public Object getLastId8(){
        idao = new GeneralDAO(factory, Networking.class);
        Networking n = (Networking) idao.getLastId();
        return n.getIdnetworking();
    }
}
