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
import model.Training;
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

    public Object getAll() {
        return idao.getAll();
    }

    public Object getById(String id) {
        return idao.getById(id);
    }

    public Object search(String category, String key) {
        return idao.search(category, key);
    }

    public Object saveOrUpdate(String trainingName, String trainingOrganization, String startDate, String endDate) {
        Training training = new Training(BigDecimal.TEN, trainingName, trainingOrganization, new Date(startDate), new Date(endDate));
        return idao.saveOrUpdate(training);
    }

}
