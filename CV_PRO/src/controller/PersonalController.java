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
import model.Personaldata;
import model.Tools;
import org.hibernate.SessionFactory;

/**
 *
 * @author Lenovo
 */
public class PersonalController {
    private final InterfaceDAO dAO;
    public PersonalController(SessionFactory factory) {
        this.dAO = new GeneralDAO(factory, Personaldata.class);
        
    }
   /**
    * 
    * @param idpersonal
    * @param name
    * @param dateofbirth
    * @param nationality
    * @param maritalstatus
    * @param gender
    * @param phonenumber
    * @param email
    * @param foto
    * @return 
    */
    public boolean saveOrUpdate(String idpersonal, String name, String dateofbirth, String nationality, String maritalstatus, String gender, String phonenumber, String email, String foto){
        Personaldata pdata = new Personaldata(new BigDecimal(idpersonal), name, new Date (dateofbirth), nationality, maritalstatus, gender, phonenumber, email, foto);
        return dAO.saveOrUpdate(pdata);
    }
    /**
     * Method untuk melakukan penghapusan data Region
     * @param idpersonal  dengan tipe data String
     * @return iDAO mengembalikan nilai boolean
     */
    public boolean delete(String idpersonal){
        Personaldata pdata = new Personaldata(new BigDecimal(idpersonal));
        return dAO.delete(pdata);
    }
    /**
     * Method untuk menampilkan data Region berdasarkan IDnya
     * @param idPersonal   dengan tipe data String
     * @return iDAO mengembalikan nilai objek
     */
    public Personaldata getById (String idPersonal){
        return (Personaldata) dAO.getById(idPersonal);
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
        Personaldata pdata =  (Personaldata) dAO.getLastId();
        BigDecimal one = new BigDecimal("1");
        return pdata.getIdpersonal().add(one);
    }
    
}
