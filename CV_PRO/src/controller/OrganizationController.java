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
 * @author chochong
 */
public class OrganizationController {
    private InterfaceDAO idao;

    /**
     * constructor dari kelas oragizationController berbarameter sessionFactory 
     * sessionFactory
     * @param sessionFactory nemapung nilai sementara dari session
     */
    public OrganizationController(SessionFactory sessionFactory) {
        this.idao = new GeneralDAO(sessionFactory, Organization.class);
    } 
    
    /**
     * method saveOrUpdate dari kelas OrganizationController untuk 
     * @param idorganisai bertipe string
     * @param organisainame bertipe string
     * @param startdate bertipe date
     * @param enddate bertipe date
     * @return mengembalikan nilai true or false
     */
    public boolean saveOrUpdate(String idorganisai, String organisainame, String posisi, String dateStart, String dateEnd){
        Organization organization = new Organization(new BigDecimal(""+idorganisai+""), organisainame, posisi, new Date(dateStart), new Date(dateEnd));
        return idao.saveOrUpdate(organization);
    }
    /**
     * Method untuk melakukan penghapusan data oraganisasi
     * @param idorganisai dengan tipe data String
     * @return iDAO mengembalikan nilai boolean
     */
    public boolean delete(String idorganisai){
        Organization organization = new Organization(new BigDecimal(""+idorganisai+""));
        return idao.delete(organization);
    }
    /**
     * Method untuk menampilkan data organisasi berdasarkan IDnya
     * @param idorganisai  dengan tipe data String
     * @return iDAO mengembalikan nilai objek
     */
    public Organization getById (String idorganisai){
        return (Organization) idao.getById(new BigDecimal(""+idorganisai+""));
    }
    
    /**
     * dok get by name
     * @param organisasiname  berupa string
     * @return get by name
     */
    public Organization getByName (String organisasiname){
        return (Organization) idao.getByName(organisasiname);
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
        Organization organization =  (Organization) idao.getLastId();
        BigDecimal one = new BigDecimal("1");
        return organization.getIdorganization().add(one);
    }
}
