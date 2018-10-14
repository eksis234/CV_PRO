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
        BigDecimal one = new BigDecimal("1");
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
        BigDecimal one = new BigDecimal("1");
        return workingexperience.getIdworkingexperience();
    }
}
