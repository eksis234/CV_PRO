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
//import java.util.Date;
import java.util.List;
import model.*;
import org.hibernate.SessionFactory;

/**
 *
 * @author X453MA
 */
public class EducationController {

    private SessionFactory factory;
    private final InterfaceDAO idao;
    
    /**
     * Konstruktor kelas EducationController
     * @param factory - SessionFactory
     */
    public EducationController(SessionFactory factory) {
        this.factory = factory;
        idao = new GeneralDAO(factory, Education.class);
    }
    
    /**
     * Fungsi untuk mendapatkan semua data Education
     * @return semua data Education
     */
    public List<Object> getAll() {
        return idao.getAll();
    }
    
    /**
     * Fungsi untuk mendapatkan data Education berdasarkan ID
     * @param id - Education ID
     * @return data Education
     */
    public Object getById(String id) {
        return idao.getById(new BigDecimal(id));
    }
    
    /**
     * Fungsi untuk mencari data pada tabel Education
     * @param category - kategori yang akan dicari
     * @param key - kata kunci untuk kategori
     * @return List hasil pencarian
     */
    public List<Object> search(String category, Object key) {
        return idao.search(category, key);
    }
    
    /**
     * Fungsi untuk simpan atau update data
     * @param idEducation - education ID
     * @param instansi - nama instansi
     * @param LevelEducation - level pendidikan
     * @param gpa - ipk
     * @param yearIn - tahun masuk
     * @param graduation - tahun lulus
     * @param major - jurusan
     * @return boolean berhasil/tidak proses dieksekusi
     */
    public boolean saveOrUpdate(String idEducation, String instansi, String LevelEducation, String gpa, String yearIn, String graduation, String major) {
        Education education = new Education(new BigDecimal(idEducation), instansi, LevelEducation, new Double(gpa), new BigInteger(yearIn), new BigInteger(graduation), major);
        return idao.saveOrUpdate(education);
    }
    
    /**
     * Fungsi untuk mendapatkan ID selanjutnya auto increment
     * @return ID otomatis untuk data selanjutnya
     */
    public Object getAutoId(){
        Education education = (Education) idao.getLastId();
        BigDecimal bd = new BigDecimal("1");
        return education.getIdeducation().add(bd);
    }
    
    /**
     * Fungsi untuk mendapatkan data berdasarkan nama instansi
     * @param name - instansi
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
        Education edu = (Education) getById(id);
        return idao.delete(edu);
    }
}
