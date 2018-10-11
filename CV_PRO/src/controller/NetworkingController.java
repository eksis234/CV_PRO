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
import model.Networking;
import org.hibernate.SessionFactory;
import tools.HibernateUtil;
/**
 *
 * @author Lenovo
 */
public class NetworkingController {
    private final InterfaceDAO idao;

    public NetworkingController(SessionFactory sessionFactory) {
        this.idao = new GeneralDAO(HibernateUtil.getSessionFactory(),Networking.class);
    }
    
    /**
     * Method untuk melakukan save atau update
     * @param idNetworking (String) id networking
     * @param networkingSkill (String) kemampuan networking
     * @return mengembalikan nilai networkings ke fungsi saveOrUpdate
     */
    public boolean saveOrUpdate(String idNetworking, String networkingSkill){
        Networking networkings = new Networking(new BigDecimal(idNetworking), networkingSkill);
        return idao.saveOrUpdate(networkings);
    }
    
    /**
     * Method untuk menghapus data
     * @param idNetworking  (String) id network
     * @return mengembalikan nilai networkings ke fungsi delete
     */
    public boolean delete(String idNetworking){
        Networking networkings = new Networking(new BigDecimal(idNetworking));
        return idao.delete(networkings);
    }
    
    /**
     * Method untuk mengambil ID
     * @param idNetworking  (String) id network
     * @return mengembalikan nilai idNetworking ke fungsi getById
     */
    public Networking getById (String idNetworking){
        return (Networking) idao.getById(idNetworking);
    }
    
    /**
     * Method untuk mengambil nama
     * @param name (String) name
     * @return mengembalikan nilai name ke fungsi getByName
     */
    public Networking getByName (String name){
        return (Networking) idao.getByName(name);
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
        if(category.equalsIgnoreCase("idnetworking")){
            return idao.search(category, new BigDecimal(key+""));
        }else{
            return idao.search(category, key);
        }
    }
    
    /**
     * Method untuk menambahkan id secara otomatis
     * @return mengembalikan fungsi getAutoId
     */
    public Object getAutoId(){
        Networking networkings =  (Networking) idao.getLastId();
        BigDecimal one = new BigDecimal("1");
        return networkings.getIdnetworking().add(one);
    }
}
