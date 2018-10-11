/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Martin
 */
@Entity
@Table(name = "EXPERIENCEDETAILS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Experiencedetails.findAll", query = "SELECT e FROM Experiencedetails e")
    , @NamedQuery(name = "Experiencedetails.findByIdexpdetail", query = "SELECT e FROM Experiencedetails e WHERE e.idexpdetail = :idexpdetail")
    , @NamedQuery(name = "Experiencedetails.findByStatus", query = "SELECT e FROM Experiencedetails e WHERE e.status = :status")
    , @NamedQuery(name = "Experiencedetails.findByJobtitle", query = "SELECT e FROM Experiencedetails e WHERE e.jobtitle = :jobtitle")
    , @NamedQuery(name = "Experiencedetails.findByStartdate", query = "SELECT e FROM Experiencedetails e WHERE e.startdate = :startdate")
    , @NamedQuery(name = "Experiencedetails.findByEnddate", query = "SELECT e FROM Experiencedetails e WHERE e.enddate = :enddate")
    , @NamedQuery(name = "Experiencedetails.findByDetails", query = "SELECT e FROM Experiencedetails e WHERE e.details = :details")})
public class Experiencedetails implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "IDEXPDETAIL")
    private BigDecimal idexpdetail;
    @Column(name = "STATUS")
    private String status;
    @Column(name = "JOBTITLE")
    private String jobtitle;
    @Column(name = "STARTDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startdate;
    @Column(name = "ENDDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date enddate;
    @Column(name = "DETAILS")
    private String details;
    @JoinColumn(name = "IDPERSONAL", referencedColumnName = "IDPERSONAL")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Personaldata idpersonal;
    @JoinColumn(name = "IDWORKINGEXPERIENCE", referencedColumnName = "IDWORKINGEXPERIENCE")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Workingexperience idworkingexperience;

    public Experiencedetails() {
    }

    public Experiencedetails(BigDecimal idexpdetail) {
        this.idexpdetail = idexpdetail;
    }

    public BigDecimal getIdexpdetail() {
        return idexpdetail;
    }

    public void setIdexpdetail(BigDecimal idexpdetail) {
        this.idexpdetail = idexpdetail;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getJobtitle() {
        return jobtitle;
    }

    public void setJobtitle(String jobtitle) {
        this.jobtitle = jobtitle;
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

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Personaldata getIdpersonal() {
        return idpersonal;
    }

    public void setIdpersonal(Personaldata idpersonal) {
        this.idpersonal = idpersonal;
    }

    public Workingexperience getIdworkingexperience() {
        return idworkingexperience;
    }

    public void setIdworkingexperience(Workingexperience idworkingexperience) {
        this.idworkingexperience = idworkingexperience;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idexpdetail != null ? idexpdetail.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Experiencedetails)) {
            return false;
        }
        Experiencedetails other = (Experiencedetails) object;
        if ((this.idexpdetail == null && other.idexpdetail != null) || (this.idexpdetail != null && !this.idexpdetail.equals(other.idexpdetail))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Experiencedetails[ idexpdetail=" + idexpdetail + " ]";
    }
    
}
