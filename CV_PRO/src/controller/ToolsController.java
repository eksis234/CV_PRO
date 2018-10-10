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
import model.Tools;
import org.hibernate.SessionFactory;

/**
 *
 * @author Lenovo
 */
public class ToolsController {
    private InterfaceDAO dAO;

    public ToolsController(SessionFactory factory) {
    this.dAO = new GeneralDAO(factory, Tools.class);
    }
    /**
     * Method untuk melakukan penyimpanan data baru atau update data
     * @param idtool  dengan tipe data String
     * @param toolname  dengan tipe data String
     * @return iDAO mengembalikan nilai boolean
     */
    public boolean saveOrUpdate(String idtool, String toolname){
        Tools tools = new Tools(new BigDecimal(idtool), toolname);
        return dAO.saveOrUpdate(tools);
    }
    /**
     * Method untuk melakukan penghapusan data Region
     * @param idtool dengan tipe data String
     * @return iDAO mengembalikan nilai boolean
     */
    public boolean delete(String idtool){
        Tools tools = new Tools(new BigDecimal(idtool));
        return dAO.delete(tools);
    }
    /**
     * Method untuk menampilkan data Region berdasarkan IDnya
     * @param idtool  dengan tipe data String
     * @return iDAO mengembalikan nilai objek
     */
    public Tools getById (String idtool){
        return (Tools) dAO.getById(idtool);
    }
    
    /**
     * dok get by name
     * @param toolname  berupa string
     * @return get by name
     */
    public Tools getByName (String toolname){
        return (Tools) dAO.getByName(toolname);
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
        Tools tools =  (Tools) dAO.getLastId();
        BigDecimal one = new BigDecimal("1");
        return tools.getIdtool().add(one);
    }
    
}
