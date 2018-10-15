/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import daos.GeneralDAO;
import daos.InterfaceDAO;
import java.util.List;
import model.UserManagement;
import org.hibernate.SessionFactory;
import tools.BCrypt;

/**
 *
 * @author X453MA
 */
public class UserManagementController {

    private SessionFactory factory;
    private InterfaceDAO idao;

    /**
     *  Konstruktor kelas UserManagement berparameter
     * @param factory - SessionFactory
     */
    public UserManagementController(SessionFactory factory) {
        this.factory = factory;
        idao = new GeneralDAO(factory, UserManagement.class);
    }

    /**
     * Fungsi untuk menyimpan/melakukan update data
     * @param id - id user
     * @param username - username
     * @param password - password
     * @param role - role dari user
     * @return apakah proses save/update berhasil dilakukan
     */
    public boolean saveOrUpdate(String id, String username, String password, String role) {
        String pass = BCrypt.hashpw(password, BCrypt.gensalt());
        UserManagement management = new UserManagement(new Long(id), username, pass, role, 'A');
        return idao.saveOrUpdate(management);
    }

    /**
     * Fungsi untuk mendapatkan semua data user
     * @return semua data user dalam bentuk List<Object>
     */
    public List<Object> getAll() {
        return idao.getAll();
    }

    /**
     * Fungsi untuk mendapatkan data berdasarkan username
     * @param username - username
     * @return object UserManagement
     */
    public Object getByName(String username) {
        UserManagement um = null;
        for (Object object : idao.search("username", username)) {
            um = (UserManagement) object;
        }
        return um;
    }

    /**
     * Fungsi untuk mengecek apakah proses login berhasil/tidak
     * @param username - username
     * @param password - password
     * @return boolean apakah proses login berhasil/tidak
     */
    public boolean login(String username, String password) {
        UserManagement login = (UserManagement) getByName(username);
        System.out.println(BCrypt.checkpw(password, login.getPassword()));
        return BCrypt.checkpw(password, login.getPassword());
    }

    /**
     * Fungsi untuk mendapatkan id secara otomatis
     * @return id selanjutnya hasil increment
     */
    public Object getAutoId() {
        UserManagement management = (UserManagement) idao.getLastId();
        return management.getId() + 1;
    }
    
    /**
     * Fungsi untuk mendapatkan username untuk kandidat dengan format namadepan+id
     * @param name - nama lengkap kandidat
     * @return username baru milik kandidat
     */
    public String getNewUsername(String name) {
        String result = "";
        int index = name.indexOf(" ");
        result = name.substring(0, index).toLowerCase() + getAutoId() + "";
        return result;
    }
    
    /**
     * Fungsi untuk mendapatkan password baru untuk kandidat dengan format MM-dd-YYYY+id personal kandidat
     * @param date - date of birth
     * @param id - id personal data
     * @return password baru milik kandidat
     */
    public String getNewPassword(String date, String id) {
        String pass = "";
        String arr[] = date.split("/");
        pass = arr[0] + arr[1] + arr[2] + id + "";
        return pass;
    }

}
