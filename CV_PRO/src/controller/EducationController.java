/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import daos.GeneralDAO;
import daos.InterfaceDAO;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import model.*;
import org.hibernate.SessionFactory;

/**
 *
 * @author X453MA
 */
public class EducationController {
    private SessionFactory factory;
    private InterfaceDAO idao;
    
    public EducationController(SessionFactory factory){
        idao = new GeneralDAO(factory, Education.class);
    }
    
    public Object getAll(){
        return idao.getAll();
    }
    
    public Object getById(String id){
        return idao.getById(id);
    }
    
     public Object search(String category, String key) {
        return idao.search(category, key);
    }

    public Object saveOrUpdate(String idEducation, String instansi, String LevelEducation, String gpa, String yearIn, String graduation, String major) {
        Education education = new Education(BigDecimal.ZERO, instansi, LevelEducation, new Double(gpa), new BigInteger(gpa), BigInteger.TEN, major);
        return idao.saveOrUpdate(education);
    }
}
