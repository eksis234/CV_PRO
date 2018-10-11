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
import java.util.List;
import model.Achievement;
import org.hibernate.SessionFactory;
/**
 *
 * @author Lenovo
 */
public class AchievementController {
    private final InterfaceDAO idao;

    public AchievementController(SessionFactory sessionFactory) {
        this.idao = new GeneralDAO(sessionFactory,Achievement.class);
    }
    
    /**
     * Method untuk melakukan save atau update
     * @param idAchv (String) id achievement
     * @param achvName (String) nama achievement
     * @param eventName (String) nama event
     * @param year (String) tahun penerimaan achievement
     * @return mengembalikan nilai achievements ke fungsi saveOrUpdate
     */
    public boolean saveOrUpdate(String idAchv, String achvName, String eventName, String year){
        Achievement achievements = new Achievement(new BigDecimal(idAchv), achvName, eventName, new BigInteger(year));
        return idao.saveOrUpdate(achievements);
    }
    
    /**
     * Method untuk menghapus data
     * @param idAchv (String) id achievement
     * @return mengembalikan nilai achievements ke fungsi delete
     */
    public boolean delete(String idAchv){
        Achievement achievements = new Achievement(new BigDecimal(idAchv));
        return idao.delete(achievements);
    }
    
    /**
     * Method untuk mengambil ID
     * @param idAchv (String) id achievements
     * @return mengembalikan nilai idAchv ke fungsi getById
     */
    public Achievement getById (String idAchv){
        return (Achievement) idao.getById(idAchv);
    }
    
    /**
     * Method untuk mengambil nama
     * @param name (String) name
     * @return mengembalikan nilai name ke fungsi getByName
     */
    public Achievement getByName (String name){
        return (Achievement) idao.getByName(name);
    }
    
    /**
     * Method untuk mengambil seluruh data tabel
     * @return mengembalikan fungsi getAll
     */
    public List<Object> getAll(){
        return idao.getAll();
    }
    
    /**
     * Method untuk melakukan pencarian berdasarkan kategori
     * @param category (String) kategori
     * @param key (Object) yang ingin dicari
     * @return mengembalikan nilai category dan key ke fungsi search
     */
    public List<Object> search(String category, Object key){
        if(category.equalsIgnoreCase("idachievement")){
            return idao.search(category, new BigDecimal(key+""));
        }
        else if(category.equalsIgnoreCase("year")){
            return idao.search(category, new BigInteger(key+""));
        }
        else{
            return idao.search(category, key);
        }  
    }
    
    /**
     * Method untuk menambahkan id secara otomatis
     * @return mengembalikan fungsi getAutoId
     */
    public Object getAutoId(){
        Achievement achievements =  (Achievement) idao.getLastId();
        BigDecimal one = new BigDecimal("1");
        return achievements.getIdachievement().add(one);
    }
}
