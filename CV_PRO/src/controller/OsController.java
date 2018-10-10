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
public class OsController {
    private final InterfaceDAO dAO;

    public OsController(SessionFactory factory) {
        this.dAO = new GeneralDAO(factory, Os.class);
    }
    
    /**
     * Method untuk melakukan penyimpanan data baru atau update data
     * @param idos   dengan tipe data String
     * @param osname  dengan tipe data String
     * @return iDAO mengembalikan nilai boolean
     */
    public boolean saveOrUpdate(String idos, String osname){
        Os os = new Os(new BigDecimal(idos), osname);
        return dAO.saveOrUpdate(os);
    }
    /**
     * Method untuk melakukan penghapusan data Region
     * @param idtool dengan tipe data String
     * @return iDAO mengembalikan nilai boolean
     */
    public boolean delete(String idos){
        Os os = new Os(new BigDecimal(idos));
        return dAO.delete(os);
    }
    /**
     * Method untuk menampilkan data Region berdasarkan IDnya
     * @param idos  dengan tipe data String
     * @return iDAO mengembalikan nilai objek
     */
    public Os getById (String idos){
        return (Os) dAO.getById(idos);
    }
    
    /**
     * dok get by name
     * @param osname  berupa string
     * @return get by name
     */
    public Os getByName (String osname){
        return (Os) dAO.getByName(osname);
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
       Os os =  (Os) dAO.getLastId();
        BigDecimal one = new BigDecimal("1");
        return os.getIdos().add(one);
    }
}
