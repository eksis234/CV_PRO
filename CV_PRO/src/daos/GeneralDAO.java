/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.sql.*;
import java.util.*;
import org.hibernate.*;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;

/**
 *
 * @author Lenovo
 */
public class GeneralDAO implements InterfaceDAO {

    private final FunctionDAO gdao;
    private final Class type;
    private SessionFactory sf;
    private Connection c;

    public GeneralDAO(SessionFactory sessionFactory, Class type) {
        this.gdao = new FunctionDAO(sessionFactory);
        this.type = type;
        this.sf = sessionFactory;
    }

    @Override
    public boolean saveOrUpdate(Object object) {
        return (boolean) gdao.execute(0, object, type, null, null);
    }

    @Override
    public boolean delete(Object object) {
        return (boolean) gdao.execute(1, object, type, null, null);
    }

    @Override
    public List<Object> getAll() {
        return (List<Object>) gdao.execute(6, null, type, null, null);
    }

    @Override
    public List<Object> search(String category, Object key) {
        return (List<Object>) gdao.execute(3, null, type, category, key);
    }

    @Override
    public Object getById(Object id) {
        return gdao.execute(2, null, type, type.getSimpleName().toLowerCase() + "Id", id);
    }

    @Override
    public Object getLastId() {
        return gdao.execute(4, null, type, null, null);
    }

    @Override
    public Object getByName(Object name) {
        return gdao.execute(5, null, type, type.getSimpleName().toLowerCase() + "Name", name);
    }

    @Override
    public List<Object> getDataNonExpired(String category) {
        return (List<Object>) gdao.execute(7, null, type, category, null);
    }

    public int addRegion1(String regionName) throws SQLException {
        Connection con = sf.getSessionFactoryOptions().getServiceRegistry().
                getService(ConnectionProvider.class).getConnection();

        CallableStatement callableStatement
                = con.prepareCall("{call hr.addRegions1(?,?)}");
        callableStatement.setString(1, regionName);
        callableStatement.registerOutParameter(2, Types.INTEGER);
        callableStatement.execute();

        return callableStatement.getInt(2);
    }

    public boolean addRegion2(String regionName) throws SQLException {
        boolean hasil = true;
        Connection con = sf.getSessionFactoryOptions().getServiceRegistry().
                getService(ConnectionProvider.class).getConnection();

        CallableStatement callableStatement = con.prepareCall("{call hr.addRegions(?)}");
        callableStatement.setString(1, regionName);
        hasil = callableStatement.execute();
        return hasil;
    }

    public int jmlRegions() throws SQLException {
        this.c = sf.getSessionFactoryOptions()
                .getServiceRegistry().getService(ConnectionProvider.class)
                .getConnection();
        CallableStatement cs = c.prepareCall("{call hr.updateUser(?,?,?,?)}");
        cs.execute();
        return cs.getInt(5);
    }
}
