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
import model.*;
import org.hibernate.SessionFactory;

/**
 *
 * @author Lenovo
 */
public class BhsaController {
    private final InterfaceDAO dAO;

    public BhsaController(SessionFactory factory) {
        this.dAO = new GeneralDAO(factory, Foreignlanguage.class);
    }
    
    /**
     * Method untuk melakukan penyimpanan data baru atau update data
     * @param idflang    dengan tipe data String
     * @param languagename   dengan tipe data String
     * @return iDAO mengembalikan nilai boolean
     */
    public boolean saveOrUpdate(String idflang, String languagename){
        Foreignlanguage fl = new Foreignlanguage(new BigDecimal(idflang), languagename);
        return dAO.saveOrUpdate(fl);
    }
    /**
     * Method untuk melakukan penghapusan data Region
     * @param idflang  dengan tipe data String
     * @return iDAO mengembalikan nilai boolean
     */
    public boolean delete(String idflang){
        Foreignlanguage fl = new Foreignlanguage(new BigDecimal(idflang));
        return dAO.delete(fl);
    }
    /**
     * Method untuk menampilkan data Region berdasarkan IDnya
     * @param idflang   dengan tipe data String
     * @return iDAO mengembalikan nilai objek
     */
    public Foreignlanguage getById (String idflang){
        return (Foreignlanguage) dAO.getById(idflang);
    }
    
    /**
     * dok get by name
     * @param languagename   berupa string
     * @return get by name
     */
    public Foreignlanguage getByName (String languagename){
        return (Foreignlanguage) dAO.getByName(languagename);
    }
    /**
     * Method untuk mengambil semua data yang ada pada tabel Region
     * @return iDAO mengembalikan nilai List
     */
    public List<Object> getAll(){
        return dAO.getAll();
    }
    /**
     * Method untuk melakukan pencarian data Region berdasarkan kategori dan kata kunci
     * @param category dengan tipe data String, terdapat 2 kategori yaitu regionId dan regionName
     * @param key dengan tipe data key
     * @return iDAO mengembalikan nilai List
     */
    public List<Object> search(String category, Object key){
        return dAO.search(category, key);
    }
    /**
     * Method untuk membuat id baru secara increment +1
     * @return iDAO mengembalikan nilai object
     */
    public Object getAutoId(){
       Foreignlanguage fl =  (Foreignlanguage) dAO.getLastId();
        BigDecimal one = new BigDecimal("1");
        return fl.getIdflang().add(one);
    }
}
