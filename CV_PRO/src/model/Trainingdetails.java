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
@Table(name = "TRAININGDETAILS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Trainingdetails.findAll", query = "SELECT t FROM Trainingdetails t")
    , @NamedQuery(name = "Trainingdetails.findByIdtrainingdetail", query = "SELECT t FROM Trainingdetails t WHERE t.idtrainingdetail = :idtrainingdetail")
    , @NamedQuery(name = "Trainingdetails.findByStatus", query = "SELECT t FROM Trainingdetails t WHERE t.status = :status")
    , @NamedQuery(name = "Trainingdetails.findByStartdate", query = "SELECT t FROM Trainingdetails t WHERE t.startdate = :startdate")
    , @NamedQuery(name = "Trainingdetails.findByEnddate", query = "SELECT t FROM Trainingdetails t WHERE t.enddate = :enddate")
    , @NamedQuery(name = "Trainingdetails.findByNametraining", query = "SELECT t FROM Trainingdetails t WHERE t.namatraining = :namatraining")
    , @NamedQuery(name = "Trainingdetails.findByLembagatraining", query = "SELECT t FROM Trainingdetails t WHERE t.lembagatraining = :lembagatraining")})
public class Trainingdetails implements Serializable {

    @Column(name = "NAMETRAINING")
    private String nametraining;
    @Column(name = "LEMBAGATRAINING")
    private String lembagatraining;

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "IDTRAININGDETAIL")
    private BigDecimal idtrainingdetail;
    @Column(name = "STATUS")
    private String status;
    @Column(name = "STARTDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startdate;
    @Column(name = "ENDDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date enddate;
    @JoinColumn(name = "IDPERSONAL", referencedColumnName = "IDPERSONAL")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Personaldata idpersonal;
    @JoinColumn(name = "IDTRAINING", referencedColumnName = "IDTRAINING")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Training idtraining;

    public Trainingdetails() {
    }

    public Trainingdetails(BigDecimal idtrainingdetail) {
        this.idtrainingdetail = idtrainingdetail;
    }

    public Trainingdetails(String nametraining, String lembagatraining, BigDecimal idtrainingdetail, String status, Date startdate, Date enddate, Personaldata idpersonal, Training idtraining) {
        this.nametraining = nametraining;
        this.lembagatraining = lembagatraining;
        this.idtrainingdetail = idtrainingdetail;
        this.status = status;
        this.startdate = startdate;
        this.enddate = enddate;
        this.idpersonal = idpersonal;
        this.idtraining = idtraining;
    }

    public BigDecimal getIdtrainingdetail() {
        return idtrainingdetail;
    }

    public void setIdtrainingdetail(BigDecimal idtrainingdetail) {
        this.idtrainingdetail = idtrainingdetail;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public Personaldata getIdpersonal() {
        return idpersonal;
    }

    public void setIdpersonal(Personaldata idpersonal) {
        this.idpersonal = idpersonal;
    }

    public Training getIdtraining() {
        return idtraining;
    }

    public void setIdtraining(Training idtraining) {
        this.idtraining = idtraining;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtrainingdetail != null ? idtrainingdetail.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trainingdetails)) {
            return false;
        }
        Trainingdetails other = (Trainingdetails) object;
        if ((this.idtrainingdetail == null && other.idtrainingdetail != null) || (this.idtrainingdetail != null && !this.idtrainingdetail.equals(other.idtrainingdetail))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Trainingdetails[ idtrainingdetail=" + idtrainingdetail + " ]";
    }

    public String getNametraining() {
        return nametraining;
    }

    public void setNametraining(String nametraining) {
        this.nametraining = nametraining;
    }

    public String getLembagatraining() {
        return lembagatraining;
    }

    public void setLembagatraining(String lembagatraining) {
        this.lembagatraining = lembagatraining;
    }
    
}
