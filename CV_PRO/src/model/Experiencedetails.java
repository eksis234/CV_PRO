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
@Table(name = "EXPERIENCEDETAILS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Experiencedetails.findAll", query = "SELECT e FROM Experiencedetails e")
    , @NamedQuery(name = "Experiencedetails.findByIdexpdetail", query = "SELECT e FROM Experiencedetails e WHERE e.idexpdetail = :idexpdetail")})
public class Experiencedetails implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "IDEXPDETAIL")
    private BigDecimal idexpdetail;
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

    public Experiencedetails(BigDecimal idexpdetail, Personaldata idpersonal) {
        this.idexpdetail = idexpdetail;
        this.idpersonal = idpersonal;
    }

    public Experiencedetails(BigDecimal idexpdetail, Personaldata idpersonal, Workingexperience idworkingexperience) {
        this.idexpdetail = idexpdetail;
        this.idpersonal = idpersonal;
        this.idworkingexperience = idworkingexperience;
    }
    
    public BigDecimal getIdexpdetail() {
        return idexpdetail;
    }

    public void setIdexpdetail(BigDecimal idexpdetail) {
        this.idexpdetail = idexpdetail;
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
