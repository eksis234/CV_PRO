/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Martin
 */
@Entity
@Table(name = "PERSONALDATA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Personaldata.findAll", query = "SELECT p FROM Personaldata p")
    , @NamedQuery(name = "Personaldata.findByIdpersonal", query = "SELECT p FROM Personaldata p WHERE p.idpersonal = :idpersonal")
    , @NamedQuery(name = "Personaldata.findByName", query = "SELECT p FROM Personaldata p WHERE p.name = :name")
    , @NamedQuery(name = "Personaldata.findByDateofbirth", query = "SELECT p FROM Personaldata p WHERE p.dateofbirth = :dateofbirth")
    , @NamedQuery(name = "Personaldata.findByNationality", query = "SELECT p FROM Personaldata p WHERE p.nationality = :nationality")
    , @NamedQuery(name = "Personaldata.findByMaritalstatus", query = "SELECT p FROM Personaldata p WHERE p.maritalstatus = :maritalstatus")
    , @NamedQuery(name = "Personaldata.findByGender", query = "SELECT p FROM Personaldata p WHERE p.gender = :gender")
    , @NamedQuery(name = "Personaldata.findByPhonenumber", query = "SELECT p FROM Personaldata p WHERE p.phonenumber = :phonenumber")
    , @NamedQuery(name = "Personaldata.findByEmail", query = "SELECT p FROM Personaldata p WHERE p.email = :email")
    , @NamedQuery(name = "Personaldata.findByFoto", query = "SELECT p FROM Personaldata p WHERE p.foto = :foto")})
public class Personaldata implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "IDPERSONAL")
    private BigDecimal idpersonal;
    @Column(name = "NAME")
    private String name;
    @Column(name = "DATEOFBIRTH")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateofbirth;
    @Column(name = "NATIONALITY")
    private String nationality;
    @Column(name = "MARITALSTATUS")
    private String maritalstatus;
    @Column(name = "GENDER")
    private String gender;
    @Column(name = "PHONENUMBER")
    private String phonenumber;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "FOTO")
    private String foto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpersonal", fetch = FetchType.LAZY)
    private List<Programmingdetails> programmingdetailsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpersonal", fetch = FetchType.LAZY)
    private List<Networkingdetails> networkingdetailsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpersonal", fetch = FetchType.LAZY)
    private List<Educationdetails> educationdetailsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpersonal", fetch = FetchType.LAZY)
    private List<Achievementdetails> achievementdetailsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpersonal", fetch = FetchType.LAZY)
    private List<Foreignlanguagedetails> foreignlanguagedetailsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpersonal", fetch = FetchType.LAZY)
    private List<Trainingdetails> trainingdetailsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpersonal", fetch = FetchType.LAZY)
    private List<Experiencedetails> experiencedetailsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpersonal", fetch = FetchType.LAZY)
    private List<Osdetails> osdetailsList;
    @OneToMany(mappedBy = "idpersonal", fetch = FetchType.LAZY)
    private List<Tooldetails> tooldetailsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpersonal", fetch = FetchType.LAZY)
    private List<Organizationdetails> organizationdetailsList;

    public Personaldata() {
    }

    public Personaldata(BigDecimal idpersonal) {
        this.idpersonal = idpersonal;
    }

    public Personaldata(BigDecimal idpersonal, String name, Date dateofbirth, String nationality, String maritalstatus, String gender, String phonenumber, String email, String foto) {
        this.idpersonal = idpersonal;
        this.name = name;
        this.dateofbirth = dateofbirth;
        this.nationality = nationality;
        this.maritalstatus = maritalstatus;
        this.gender = gender;
        this.phonenumber = phonenumber;
        this.email = email;
        this.foto = foto;
    }

    
    public BigDecimal getIdpersonal() {
        return idpersonal;
    }

    public void setIdpersonal(BigDecimal idpersonal) {
        this.idpersonal = idpersonal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(Date dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getMaritalstatus() {
        return maritalstatus;
    }

    public void setMaritalstatus(String maritalstatus) {
        this.maritalstatus = maritalstatus;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @XmlTransient
    public List<Programmingdetails> getProgrammingdetailsList() {
        return programmingdetailsList;
    }

    public void setProgrammingdetailsList(List<Programmingdetails> programmingdetailsList) {
        this.programmingdetailsList = programmingdetailsList;
    }

    @XmlTransient
    public List<Networkingdetails> getNetworkingdetailsList() {
        return networkingdetailsList;
    }

    public void setNetworkingdetailsList(List<Networkingdetails> networkingdetailsList) {
        this.networkingdetailsList = networkingdetailsList;
    }

    @XmlTransient
    public List<Educationdetails> getEducationdetailsList() {
        return educationdetailsList;
    }

    public void setEducationdetailsList(List<Educationdetails> educationdetailsList) {
        this.educationdetailsList = educationdetailsList;
    }

    @XmlTransient
    public List<Achievementdetails> getAchievementdetailsList() {
        return achievementdetailsList;
    }

    public void setAchievementdetailsList(List<Achievementdetails> achievementdetailsList) {
        this.achievementdetailsList = achievementdetailsList;
    }

    @XmlTransient
    public List<Foreignlanguagedetails> getForeignlanguagedetailsList() {
        return foreignlanguagedetailsList;
    }

    public void setForeignlanguagedetailsList(List<Foreignlanguagedetails> foreignlanguagedetailsList) {
        this.foreignlanguagedetailsList = foreignlanguagedetailsList;
    }

    @XmlTransient
    public List<Trainingdetails> getTrainingdetailsList() {
        return trainingdetailsList;
    }

    public void setTrainingdetailsList(List<Trainingdetails> trainingdetailsList) {
        this.trainingdetailsList = trainingdetailsList;
    }

    @XmlTransient
    public List<Experiencedetails> getExperiencedetailsList() {
        return experiencedetailsList;
    }

    public void setExperiencedetailsList(List<Experiencedetails> experiencedetailsList) {
        this.experiencedetailsList = experiencedetailsList;
    }

    @XmlTransient
    public List<Osdetails> getOsdetailsList() {
        return osdetailsList;
    }

    public void setOsdetailsList(List<Osdetails> osdetailsList) {
        this.osdetailsList = osdetailsList;
    }

    @XmlTransient
    public List<Tooldetails> getTooldetailsList() {
        return tooldetailsList;
    }

    public void setTooldetailsList(List<Tooldetails> tooldetailsList) {
        this.tooldetailsList = tooldetailsList;
    }

    @XmlTransient
    public List<Organizationdetails> getOrganizationdetailsList() {
        return organizationdetailsList;
    }

    public void setOrganizationdetailsList(List<Organizationdetails> organizationdetailsList) {
        this.organizationdetailsList = organizationdetailsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpersonal != null ? idpersonal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Personaldata)) {
            return false;
        }
        Personaldata other = (Personaldata) object;
        if ((this.idpersonal == null && other.idpersonal != null) || (this.idpersonal != null && !this.idpersonal.equals(other.idpersonal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Personaldata[ idpersonal=" + idpersonal + " ]";
    }
    
}
