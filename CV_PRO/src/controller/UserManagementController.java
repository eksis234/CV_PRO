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

    public UserManagementController(SessionFactory factory) {
        this.factory = factory;
        idao = new GeneralDAO(factory, UserManagement.class);
    }

    public boolean saveOrUpdate(String id, String username, String password, String role) {
        String pass = BCrypt.hashpw(password, BCrypt.gensalt());
        UserManagement management = new UserManagement(new Long(id), username, pass, role, 'A');
        return idao.saveOrUpdate(management);
    }

    public List<Object> getAll() {
        return idao.getAll();
    }

    public Object getByName(String username) {
        UserManagement um = null;
        for (Object object : idao.search("username", username)) {
            um = (UserManagement) object;
        }
        return um;
    }

    public boolean login(String username, String password) {
        UserManagement login = (UserManagement) getByName(username);
        return BCrypt.checkpw(password, login.getPassword());
    }

    public Object getAutoId() {
        UserManagement management = (UserManagement) idao.getLastId();
        return management.getId() + 1;
    }

}
