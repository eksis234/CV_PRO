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
import javax.persistence.Lob;
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
 * @author Lenovo
 */
@Entity
@Table(name = "WORKINGEXPERIENCE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Workingexperience.findAll", query = "SELECT w FROM Workingexperience w")
    , @NamedQuery(name = "Workingexperience.findByIdworkingexperience", query = "SELECT w FROM Workingexperience w WHERE w.idworkingexperience = :idworkingexperience")
    , @NamedQuery(name = "Workingexperience.findByJobtitle", query = "SELECT w FROM Workingexperience w WHERE w.jobtitle = :jobtitle")
    , @NamedQuery(name = "Workingexperience.findByEmployer", query = "SELECT w FROM Workingexperience w WHERE w.employer = :employer")
    , @NamedQuery(name = "Workingexperience.findByCity", query = "SELECT w FROM Workingexperience w WHERE w.city = :city")
    , @NamedQuery(name = "Workingexperience.findByStartdate", query = "SELECT w FROM Workingexperience w WHERE w.startdate = :startdate")
    , @NamedQuery(name = "Workingexperience.findByEnddate", query = "SELECT w FROM Workingexperience w WHERE w.enddate = :enddate")})
public class Workingexperience implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "IDWORKINGEXPERIENCE")
    private BigDecimal idworkingexperience;
    @Column(name = "JOBTITLE")
    private String jobtitle;
    @Column(name = "EMPLOYER")
    private String employer;
    @Column(name = "CITY")
    private String city;
    @Column(name = "STARTDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startdate;
    @Column(name = "ENDDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date enddate;
    @Lob
    @Column(name = "DESCRIPTION")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idworkingexperience", fetch = FetchType.LAZY)
    private List<Experiencedetails> experiencedetailsList;

    public Workingexperience() {
    }

    public Workingexperience(BigDecimal idworkingexperience) {
        this.idworkingexperience = idworkingexperience;
    }

    public Workingexperience(BigDecimal idworkingexperience, String jobtitle, String employer, String city, Date startdate, Date enddate, String description) {
        this.idworkingexperience = idworkingexperience;
        this.jobtitle = jobtitle;
        this.employer = employer;
        this.city = city;
        this.startdate = startdate;
        this.enddate = enddate;
        this.description = description;
    }

    public Workingexperience(BigDecimal idworkingexperience, String jobtitle, String employer, String city, Date startdate, Date enddate, String description, List<Experiencedetails> experiencedetailsList) {
        this.idworkingexperience = idworkingexperience;
        this.jobtitle = jobtitle;
        this.employer = employer;
        this.city = city;
        this.startdate = startdate;
        this.enddate = enddate;
        this.description = description;
        this.experiencedetailsList = experiencedetailsList;
    }
    
    

    public BigDecimal getIdworkingexperience() {
        return idworkingexperience;
    }

    public void setIdworkingexperience(BigDecimal idworkingexperience) {
        this.idworkingexperience = idworkingexperience;
    }

    public String getJobtitle() {
        return jobtitle;
    }

    public void setJobtitle(String jobtitle) {
        this.jobtitle = jobtitle;
    }

    public String getEmployer() {
        return employer;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public List<Experiencedetails> getExperiencedetailsList() {
        return experiencedetailsList;
    }

    public void setExperiencedetailsList(List<Experiencedetails> experiencedetailsList) {
        this.experiencedetailsList = experiencedetailsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idworkingexperience != null ? idworkingexperience.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Workingexperience)) {
            return false;
        }
        Workingexperience other = (Workingexperience) object;
        if ((this.idworkingexperience == null && other.idworkingexperience != null) || (this.idworkingexperience != null && !this.idworkingexperience.equals(other.idworkingexperience))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Workingexperience[ idworkingexperience=" + idworkingexperience + " ]";
    }
    
}
