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
import model.Workingexperience;
import org.hibernate.SessionFactory;

/**
 *
 * @author chochong
 */
public class PengalamankerjaController {
    private InterfaceDAO idao;
    
    /**
     * constructor dari kelas PengalamanKerjaController 
     * @param sessionFactory bertipe sessiion factory
     */
    public PengalamankerjaController(SessionFactory sessionFactory) {
        this.idao = new GeneralDAO(sessionFactory, Workingexperience.class);
    }
   
    /**
     * method saveOrUppdate dari kelas PengalamankerjaController, digunakan untuk menyimpan data pengalaman kerja 
     * @param idpk bertipe string 
     * @param jobtitle bertipe string
     * @param employer bertipe string
     * @param city bertupe string
     * @param startdate bertipe date
     * @param enddate bertipe date
     * @param description bertipe string
     * @return mengembalikan nilai true or false
     */
    public boolean saveOrUpdate(String idpk, String jobtitle, String employer, String city, Date startdate, Date enddate, String description){
        Workingexperience workingexperience = new Workingexperience(new BigDecimal(""+idpk+""), jobtitle, employer, city, startdate, enddate, description);
        return idao.saveOrUpdate(workingexperience);
    }
    /**
     * Method untuk melakukan penghapusan data pengalaman pekerjaan
     * @param idpk dengan tipe data String
     * @return idao mengembalikan nilai boolean
     */
    public boolean delete(String idpk){
        Workingexperience workingexperience = new Workingexperience(new BigDecimal(""+idpk+""));
        return idao.delete(workingexperience);
    }
    /**
     * Method untuk menampilkan data pengalamankerja berdasarkan IDnya
     * @param idpk  dengan tipe data String
     * @return iDAO mengembalikan nilai objek
     */
    public Workingexperience getById (String idpk){
        return (Workingexperience) idao.getById(idpk);
    }
    
    /**
     * method get by name dari kelas PengalamanKerja
     * @param pkname  berupa string
     * @return get by 
     */
    public Workingexperience getByName (String pkname){
        return (Workingexperience) idao.getByName(pkname);
    }
    /**
     * Method untuk mengambil semua data yang ada pada tabel Region
     * @return iDAO mengembalikan nilai List
     */
    public List<Object> getAll(){
        return idao.getAll();
    }
    /**
     * Method untuk melakukan pencarian data Region berdasarkan kategori dan 
     * kata kunci
     * @param category dengan tipe data String, terdapat 2 kategori yaitu regionId 
     * dan regionName
     * @param key dengan tipe data key
     * @return iDAO mengembalikan nilai List
     */
    public List<Object> search(String category, Object key){
        return idao.search(category, key);
    }
    /**
     * Method untuk membuat id baru secara increment +1
     * @return iDAO mengembalikan nilai object
     */
    public Object getAutoId(){
        Workingexperience workingexperience =  (Workingexperience) idao.getLastId();
        BigDecimal one = new BigDecimal("1");
        return workingexperience.getIdworkingexperience().add(one);
    }
}
