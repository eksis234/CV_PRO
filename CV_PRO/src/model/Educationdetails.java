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
@Table(name = "EDUCATIONDETAILS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Educationdetails.findAll", query = "SELECT e FROM Educationdetails e")
    , @NamedQuery(name = "Educationdetails.findByIdedudetail", query = "SELECT e FROM Educationdetails e WHERE e.idedudetail = :idedudetail")})
public class Educationdetails implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "IDEDUDETAIL")
    private BigDecimal idedudetail;
    @JoinColumn(name = "IDEDUCATION", referencedColumnName = "IDEDUCATION")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Education ideducation;
    @JoinColumn(name = "IDPERSONAL", referencedColumnName = "IDPERSONAL")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Personaldata idpersonal;

    public Educationdetails() {
    }

    public Educationdetails(BigDecimal idedudetail) {
        this.idedudetail = idedudetail;
    }

    public Educationdetails(BigDecimal idedudetail, Education ideducation) {
        this.idedudetail = idedudetail;
        this.ideducation = ideducation;
    }

    public Educationdetails(BigDecimal idedudetail, Education ideducation, Personaldata idpersonal) {
        this.idedudetail = idedudetail;
        this.ideducation = ideducation;
        this.idpersonal = idpersonal;
    }
    
    public BigDecimal getIdedudetail() {
        return idedudetail;
    }

    public void setIdedudetail(BigDecimal idedudetail) {
        this.idedudetail = idedudetail;
    }

    public Education getIdeducation() {
        return ideducation;
    }

    public void setIdeducation(Education ideducation) {
        this.ideducation = ideducation;
    }

    public Personaldata getIdpersonal() {
        return idpersonal;
    }

    public void setIdpersonal(Personaldata idpersonal) {
        this.idpersonal = idpersonal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idedudetail != null ? idedudetail.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Educationdetails)) {
            return false;
        }
        Educationdetails other = (Educationdetails) object;
        if ((this.idedudetail == null && other.idedudetail != null) || (this.idedudetail != null && !this.idedudetail.equals(other.idedudetail))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Educationdetails[ idedudetail=" + idedudetail + " ]";
    }
    
}
