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
@Table(name = "ORGANIZATIONDETAILS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Organizationdetails.findAll", query = "SELECT o FROM Organizationdetails o")
    , @NamedQuery(name = "Organizationdetails.findByIdorgdetail", query = "SELECT o FROM Organizationdetails o WHERE o.idorgdetail = :idorgdetail")})
public class Organizationdetails implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "IDORGDETAIL")
    private BigDecimal idorgdetail;
    @JoinColumn(name = "IDORGANIZATION", referencedColumnName = "IDORGANIZATION")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Organization idorganization;
    @JoinColumn(name = "IDPERSONAL", referencedColumnName = "IDPERSONAL")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Personaldata idpersonal;

    public Organizationdetails() {
    }

    public Organizationdetails(BigDecimal idorgdetail) {
        this.idorgdetail = idorgdetail;
    }

    public Organizationdetails(BigDecimal idorgdetail, Organization idorganization) {
        this.idorgdetail = idorgdetail;
        this.idorganization = idorganization;
    }

    public Organizationdetails(BigDecimal idorgdetail, Organization idorganization, Personaldata idpersonal) {
        this.idorgdetail = idorgdetail;
        this.idorganization = idorganization;
        this.idpersonal = idpersonal;
    }

    public BigDecimal getIdorgdetail() {
        return idorgdetail;
    }

    public void setIdorgdetail(BigDecimal idorgdetail) {
        this.idorgdetail = idorgdetail;
    }

    public Organization getIdorganization() {
        return idorganization;
    }

    public void setIdorganization(Organization idorganization) {
        this.idorganization = idorganization;
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
        hash += (idorgdetail != null ? idorgdetail.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Organizationdetails)) {
            return false;
        }
        Organizationdetails other = (Organizationdetails) object;
        if ((this.idorgdetail == null && other.idorgdetail != null) || (this.idorgdetail != null && !this.idorgdetail.equals(other.idorgdetail))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Organizationdetails[ idorgdetail=" + idorgdetail + " ]";
    }
    
}
