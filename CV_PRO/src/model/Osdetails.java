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
 * @author Martin
 */
@Entity
@Table(name = "OSDETAILS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Osdetails.findAll", query = "SELECT o FROM Osdetails o")
    , @NamedQuery(name = "Osdetails.findByIdosdetail", query = "SELECT o FROM Osdetails o WHERE o.idosdetail = :idosdetail")})
public class Osdetails implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "IDOSDETAIL")
    private BigDecimal idosdetail;
    @JoinColumn(name = "IDOS", referencedColumnName = "IDOS")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Os idos;
    @JoinColumn(name = "IDPERSONAL", referencedColumnName = "IDPERSONAL")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Personaldata idpersonal;

    public Osdetails() {
    }

    public Osdetails(BigDecimal idosdetail) {
        this.idosdetail = idosdetail;
    }

    public BigDecimal getIdosdetail() {
        return idosdetail;
    }

    public void setIdosdetail(BigDecimal idosdetail) {
        this.idosdetail = idosdetail;
    }

    public Os getIdos() {
        return idos;
    }

    public void setIdos(Os idos) {
        this.idos = idos;
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
        hash += (idosdetail != null ? idosdetail.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Osdetails)) {
            return false;
        }
        Osdetails other = (Osdetails) object;
        if ((this.idosdetail == null && other.idosdetail != null) || (this.idosdetail != null && !this.idosdetail.equals(other.idosdetail))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Osdetails[ idosdetail=" + idosdetail + " ]";
    }
    
}
