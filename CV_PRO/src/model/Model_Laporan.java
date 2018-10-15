/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.controller_laporan;
import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.hibernate.SessionFactory;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;
import tools.HibernateUtil;
import view.cv_kandidat;

public class Model_Laporan implements controller_laporan {

    JasperReport jasperReport;
    JasperDesign jasperDesign;
    JasperPrint jasperPrint;
    private final SessionFactory sf;

    public Model_Laporan(SessionFactory sf) {
        this.sf = HibernateUtil.getSessionFactory();
    }

    Map<String, Object> parameter = new HashMap<String, Object>();

    @Override
    public void Tampilkan(cv_kandidat lp) throws SQLException {
        Connection connection = null;
        try {
            connection = sf.getSessionFactoryOptions().getServiceRegistry().getService(ConnectionProvider.class).getConnection();
            parameter.put("idPersonal", lp.id);
            File file = new File("src\\view\\report\\cv_kandidat.jrxml");
            jasperDesign = JRXmlLoader.load(file);
            jasperReport = JasperCompileManager.compileReport(jasperDesign);
            jasperPrint = JasperFillManager.fillReport(jasperReport, parameter, connection);
            JasperViewer.viewReport(jasperPrint, false);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }

    }

}
