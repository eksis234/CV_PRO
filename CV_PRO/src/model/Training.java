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
 * @author Lenovo
 */
@Entity
@Table(name = "TRAINING")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Training.findAll", query = "SELECT t FROM Training t")
    , @NamedQuery(name = "Training.findByIdtraining", query = "SELECT t FROM Training t WHERE t.idtraining = :idtraining")
    , @NamedQuery(name = "Training.findByTrainingname", query = "SELECT t FROM Training t WHERE t.trainingname = :trainingname")
    , @NamedQuery(name = "Training.findByTrainingorganization", query = "SELECT t FROM Training t WHERE t.trainingorganization = :trainingorganization")
    , @NamedQuery(name = "Training.findByStartdate", query = "SELECT t FROM Training t WHERE t.startdate = :startdate")
    , @NamedQuery(name = "Training.findByEnddate", query = "SELECT t FROM Training t WHERE t.enddate = :enddate")})
public class Training implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "IDTRAINING")
    private BigDecimal idtraining;
    @Column(name = "TRAININGNAME")
    private String trainingname;
    @Column(name = "TRAININGORGANIZATION")
    private String trainingorganization;
    @Column(name = "STARTDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startdate;
    @Column(name = "ENDDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date enddate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtraining", fetch = FetchType.LAZY)
    private List<Trainingdetails> trainingdetailsList;

    public Training() {
    }

    public Training(BigDecimal idtraining) {
        this.idtraining = idtraining;
    }

    public BigDecimal getIdtraining() {
        return idtraining;
    }

    public void setIdtraining(BigDecimal idtraining) {
        this.idtraining = idtraining;
    }

    public String getTrainingname() {
        return trainingname;
    }

    public void setTrainingname(String trainingname) {
        this.trainingname = trainingname;
    }

    public String getTrainingorganization() {
        return trainingorganization;
    }

    public void setTrainingorganization(String trainingorganization) {
        this.trainingorganization = trainingorganization;
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

    @XmlTransient
    public List<Trainingdetails> getTrainingdetailsList() {
        return trainingdetailsList;
    }

    public void setTrainingdetailsList(List<Trainingdetails> trainingdetailsList) {
        this.trainingdetailsList = trainingdetailsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtraining != null ? idtraining.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Training)) {
            return false;
        }
        Training other = (Training) object;
        if ((this.idtraining == null && other.idtraining != null) || (this.idtraining != null && !this.idtraining.equals(other.idtraining))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Training[ idtraining=" + idtraining + " ]";
    }
    
}
