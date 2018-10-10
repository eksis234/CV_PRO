/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Lenovo
 */
@Entity
@Table(name = "TRAININGDETAILS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Trainingdetails.findAll", query = "SELECT t FROM Trainingdetails t")
    , @NamedQuery(name = "Trainingdetails.findByIdtrainingdetail", query = "SELECT t FROM Trainingdetails t WHERE t.idtrainingdetail = :idtrainingdetail")})
public class Trainingdetails implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "IDTRAININGDETAIL")
    private BigDecimal idtrainingdetail;
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

    public BigDecimal getIdtrainingdetail() {
        return idtrainingdetail;
    }

    public void setIdtrainingdetail(BigDecimal idtrainingdetail) {
        this.idtrainingdetail = idtrainingdetail;
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
    
}
