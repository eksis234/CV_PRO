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
import java.util.List;
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

    public boolean saveOrUpdate(String idEducation, String instansi, String LevelEducation, String gpa, String yearIn, String graduation, String major) {
        List<Educationdetails> educationDetails = (List<Educationdetails>) new Educationdetails(new BigDecimal(idEducation));
        Education education = new Education(new BigDecimal(idEducation), instansi, LevelEducation, new Double(gpa), new BigInteger(gpa), new BigInteger(yearIn), major, educationDetails);
        return idao.saveOrUpdate(education);
    }
}
