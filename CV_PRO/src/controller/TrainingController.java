/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import daos.GeneralDAO;
import daos.InterfaceDAO;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import model.Training;
import model.Trainingdetails;
import org.hibernate.SessionFactory;

/**
 *
 * @author X453MA
 */
public class TrainingController {

    private InterfaceDAO idao;
    private SessionFactory factory;

    public TrainingController(SessionFactory factory) {
        this.factory = factory;
        idao = new GeneralDAO(factory, Training.class);
    }

    public List<Object> getAll() {
        return idao.getAll();
    }

    public Object getById(String id) {
        return idao.getById(id);
    }

    public List<Object> search(String category, String key) {
        return idao.search(category, key);
    }

    public boolean saveOrUpdate(String trainingId, String trainingName, String trainingOrganization, String startDate, String endDate) {
        List<Trainingdetails> trainingdetailsList = (List<Trainingdetails>) new Trainingdetails(new BigDecimal(trainingId));
        Training training = new Training(new BigDecimal(trainingId), trainingName, trainingOrganization, new Date(startDate), new Date(endDate), trainingdetailsList);
        return idao.saveOrUpdate(training);
    }

}
