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
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import javax.swing.JComboBox;
import model.Personaldata;
import model.*;
import org.hibernate.SessionFactory;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;

/**
 *
 * @author Lenovo
 */
public class PersonalController {
    private final InterfaceDAO dAO;
    private final ToolsController tc;
    private final OsController oc;
    private final BhsaController fl;
    private final ProgrammingController pc;
    private final EducationController ec;
    private final AchievementController ac;
    private final NetworkingController nc;
    private final OrganizationController oc1;
    private final PengalamankerjaController pc1;
    private final TrainingController tc1;
    
    public PersonalController(SessionFactory factory) {
        this.dAO = new GeneralDAO(factory, Personaldata.class);
        tc = new ToolsController(factory);
        oc = new OsController(factory);
        fl = new BhsaController(factory);
        pc = new ProgrammingController(factory);
        ec = new EducationController(factory);
        ac = new AchievementController(factory);
        nc = new NetworkingController(factory);
        oc1 = new OrganizationController(factory);
        pc1 = new PengalamankerjaController(factory);
        tc1 = new TrainingController(factory);
    }

    public boolean saveOrUpdate(String idpersonal, String name, String dateofbirth, String nationality,
        String maritalstatus, String gender, String phonenumber, String email, String foto){
        Personaldata pdata = new Personaldata(new BigDecimal(idpersonal), name, new Date (dateofbirth), nationality, maritalstatus, gender, phonenumber, email, foto);
        return dAO.saveOrUpdate(pdata);
    }
    
    public boolean saveOrUpdate1(String idedudetail, String status, String ipk, String angkatan, String tahunlulus, String jurusan, String ideducation, String idpersonal) {
        System.out.println(idedudetail+"-"+status+"-"+angkatan+"-"+tahunlulus+"-"+jurusan+"-"+ideducation+"-"+idpersonal);
        Education education = new Education(new BigDecimal(ideducation+""));
        Personaldata personaldata = new Personaldata(new BigDecimal(idpersonal+""));
//        personaldata.setIdpersonal();
//        Educationdetails educationdetails = new Educationdetails();
//        educationdetails.setIdeducation(education);educationdetails.setIdpersonal(personaldata);
        Educationdetails educa; 
        educa = new Educationdetails(new BigDecimal(idedudetail), status, new Double(ipk), new BigInteger(angkatan), new BigInteger(tahunlulus), 
                jurusan, education, personaldata);
        return dAO.saveOrUpdate(educa);
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
    
    public void loadCmbTools(JComboBox cmb, String model){
        switch (model) {
            case "tool":
                {
                    List<Object> objects = (List<Object>) tc.getAll();
                    objects.stream().map((object) -> (Tools) object).forEachOrdered((tools) -> {
                        cmb.addItem(tools.getToolname());
                    });     break;
                }
            case "os":
                {
                    List<Object> objects = (List<Object>) oc.getAll();
                    objects.stream().map((object) -> (Os) object).forEachOrdered((os) -> {
                        cmb.addItem(os.getOsname());
                    });     break;
                }
            case "bahasa1":
                {
                    List<Object> objects = (List<Object>) fl.getAll();
                    objects.stream().map((object) -> (Foreignlanguage) object).forEachOrdered((fla) -> {
                        cmb.addItem(fla.getLanguagename());
                    });     break;
                }
            case "bhsProg":
                {
                    List<Object> objects = (List<Object>) pc.getAll();
                    objects.stream().map((object) -> (Programming) object).forEachOrdered((pg) -> {
                        cmb.addItem(pg.getProgramminglanguage());
                    });     break;
                }
            case "edul":
                {
                    List<Object> objects = (List<Object>) ec.getAll();
                    objects.stream().map((object) -> (Education) object).forEachOrdered((ed) -> {
                        cmb.addItem(ed.getLeveleducation());
                    });     break;
                }
            case "eventPh":
                {
                    List<Object> objects = (List<Object>) ac.getAll();
                    objects.stream().map((object) -> (Achievement) object).forEachOrdered((ach) -> {
                        cmb.addItem(ach.getEventname());
                    });     break;
                }
            case "insta":
                {
                    List<Object> objects = (List<Object>) ec.getAll();
                    objects.stream().map((object) -> (Education) object).forEachOrdered((ed) -> {
                        cmb.addItem(ed.getInstansi());
                    });     break;
                }
            case "naOr":
                {
                    List<Object> objects = (List<Object>) oc1.getAll();
                    objects.stream().map((object) -> (Organization) object).forEachOrdered((or1) -> {
                        cmb.addItem(or1.getOrganizationname());
                    });     break;
                }
            case "network":
                {
                    List<Object> objects = (List<Object>) nc.getAll();
                    objects.stream().map((object) -> (Networking) object).forEachOrdered((net) -> {
                        cmb.addItem(net.getNetworkingskill());
                    });     break;
                }
            case "namaPr":
                {
                    List<Object> objects = (List<Object>) pc1.getAll();
                    objects.stream().map((object) -> (Workingexperience) object).forEachOrdered((prsh) -> {
                        cmb.addItem(prsh.getNamaperusahaan());
                    });     break;
                }
            case "city":
                {
                    List<Object> objects = (List<Object>) pc1.getAll();
                    objects.stream().map((object) -> (Workingexperience) object).forEachOrdered((prsh) -> {
                        cmb.addItem(prsh.getCity());
                    });     break;
                }
            case "nmPenghargaan":
                {
                    List<Object> objects = (List<Object>) ac.getAll();
                    objects.stream().map((object) -> (Achievement) object).forEachOrdered((ach) -> {
                        cmb.addItem(ach.getAchievementname());
                    });     break;
                }
            case "evPenghargaan":
                {
                    List<Object> objects = (List<Object>) ac.getAll();
                    objects.stream().map((object) -> (Achievement) object).forEachOrdered((ach) -> {
                        cmb.addItem(ach.getEventname());
                    });     break;
                }
            case "thPenghargaan":
                {
                    List<Object> objects = (List<Object>) ac.getAll();
                    objects.stream().map((object) -> (Achievement) object).forEachOrdered((ach) -> {
                        cmb.addItem(ach.getYear());
                    });     break;
                }
            case "nmTrain":
                {
                    List<Object> objects = (List<Object>) tc1.getAll();
                    objects.stream().map((object) -> (Training) object).forEachOrdered((tra) -> {
                        cmb.addItem(tra.getTrainingname());
                    });     break;
                }
            case "lgTrain":
                {
                    List<Object> objects = (List<Object>) tc1.getAll();
                    objects.stream().map((object) -> (Training) object).forEachOrdered((tra) -> {
                        cmb.addItem(tra.getTrainingorganization());
                    });     break;
                }
            default:
                break;
        }
    }
}
