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
import model.*;
import org.hibernate.SessionFactory;

/**
 *
 * @author X453MA
 */
public class TrainingController {

    private final InterfaceDAO idao;
    private final SessionFactory factory;
    
    /**
     * Konstruktor kelas TrainingController berparameter
     * @param factory - SessionFactory
     */
    public TrainingController(SessionFactory factory) {
        this.factory = factory;
        idao = new GeneralDAO(factory, Training.class);
    }
    
    /**
     * Fungsi untuk mendapatkan semua data Education
     * @return semua data Education
     */
    public List<Object> getDatas() {
        return idao.getDataNonExpired("enddate");
    }
    
    public List<Object> getAll() {
        return idao.getAll();
    }
    
     /**
     * Fungsi untuk mendapatkan data Training berdasarkan ID
     * @param id - Training ID
     * @return data Training
     */
    public Object getById(String id) {
        return idao.getById(id);
    }
    
    /**
     * Fungsi untuk mencari data pada tabel Education
     * @param category - kategori yang akan dicari
     * @param key - kata kunci untuk kategori
     * @return List hasil pencarian
     */
    public List<Object> search(String category, String key) {
        return idao.search(category, key);
    }
    
    /**
     * 
     * @param trainingId
     * @param trainingName
     * @param trainingOrganization
     * @param startDate
     * @param endDate
     * @return 
     */
    public boolean saveOrUpdate(String trainingId, String trainingName, String trainingOrganization, String startDate, String endDate) {
        Training training = new Training(new BigDecimal(trainingId), trainingName, trainingOrganization, new Date(startDate), new Date(endDate));
        return idao.saveOrUpdate(training);
    }
    
    /**
     * Fungsi untuk mendapatkan ID selanjutnya auto increment
     * @return ID otomatis untuk data selanjutnya
     */
    public Object getAutoId() {
        Training training = (Training) idao.getLastId();
        BigDecimal bd = new BigDecimal("1");
        return training.getIdtraining().add(bd);
    }
    
    /**
     * Fungsi untuk mendapatkan data berdasarkan nama training
     * @param name - nama training
     * @return data hasil pencarian
     */
    public Object getByName(String name){
        return idao.getByName(name);
    }
    
    /**
     * Fungsi untuk menghapus data
     * @param id - id education
     * @return apakah proses delete berhasil/tidak
     */
    public boolean delete(String id){
        Training training = (Training) getById(id);
        return idao.delete(training);
    }

}
