/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import daos.GeneralDAO;
import daos.InterfaceDAO;
import java.math.BigDecimal;
import java.util.List;
import model.Programming;
import org.hibernate.SessionFactory;

/**
 *
 * @author chochong
 */
public class ProgrammingController {
    private InterfaceDAO idao;

    /**
     * constructor dari kelas ProgrammingController 
     * @param sessionFactory 
     */
    public ProgrammingController(SessionFactory sessionFactory) {
        this.idao = new GeneralDAO(sessionFactory, Programming.class);
    }
    
    /**
     * method saveOrUpdate dari kelas ProgrammingController menyimpan data 
     * organisasi baru kedalam database
     * @param idprogramming bertipe String
     * @param programmingname bertipe String
     * @return mengembalikan nilai true or false
     */
    public boolean saveOrUpdate(String idprogramming, String programmingname){
        Programming programming = new Programming(new BigDecimal(idprogramming), programmingname);
        return idao.saveOrUpdate(programming);
    }
    
    /**
     * Method untuk melakukan penghapusan data programming
     * @param idprogramming dengan tipe data String
     * @return iDAO mengembalikan nilai boolean
     */
    public boolean delete(String idprogramming){
        Programming programming = new Programming(new BigDecimal(idprogramming));
        return idao.delete(programming);
    }
    /**
     * Method untuk menampilkan data programming berdasarkan IDnya
     * @param idprogramming  dengan tipe data String
     * @return iDAO mengembalikan nilai objek
     */
    public Programming getById (String idorganisai){
        return (Programming) idao.getById(idorganisai);
    }
    
    /**
     * method get by name dari kelas ProgrammingController
     * @param programmingname  berupa string
     * @return get by name
     */
    public Programming getByName (String programmingname){
        return (Programming) idao.getByName(programmingname);
    }
    /**
     * Method untuk mengambil semua data yang ada pada tabel programming
     * @return idao mengembalikan nilai List
     */
    public List<Object> getAll(){
        return idao.getAll();
    }
    /**
     * Method untuk melakukan pencarian data programming berdasarkan kategori dan 
     * kata kunci
     * @param category dengan tipe data String, terdapat 2 kategori yaitu programmingId 
     * dan programmingName
     * @param key dengan tipe data key
     * @return idao mengembalikan nilai List
     */
    public List<Object> search(String category, Object key){
        return idao.search(category, key);
    }
    /**
     * Method untuk membuat id baru secara increment +1
     * @return idao mengembalikan nilai object
     */
    public Object getAutoId(){
        Programming programming =  (Programming) idao.getLastId();
        BigDecimal one = new BigDecimal("1");
        return programming.getIdprogramming().add(one);
    }
}
