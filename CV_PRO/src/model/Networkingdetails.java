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
@Table(name = "NETWORKINGDETAILS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Networkingdetails.findAll", query = "SELECT n FROM Networkingdetails n")
    , @NamedQuery(name = "Networkingdetails.findByIdnetdetail", query = "SELECT n FROM Networkingdetails n WHERE n.idnetdetail = :idnetdetail")
    , @NamedQuery(name = "Networkingdetails.findByStatus", query = "SELECT n FROM Networkingdetails n WHERE n.status = :status")})
public class Networkingdetails implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "IDNETDETAIL")
    private BigDecimal idnetdetail;
    @Column(name = "STATUS")
    private String status;
    @JoinColumn(name = "IDNETWORKING", referencedColumnName = "IDNETWORKING")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Networking idnetworking;
    @JoinColumn(name = "IDPERSONAL", referencedColumnName = "IDPERSONAL")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Personaldata idpersonal;

    public Networkingdetails() {
    }

    public Networkingdetails(BigDecimal idnetdetail) {
        this.idnetdetail = idnetdetail;
    }

    public BigDecimal getIdnetdetail() {
        return idnetdetail;
    }

    public void setIdnetdetail(BigDecimal idnetdetail) {
        this.idnetdetail = idnetdetail;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Networking getIdnetworking() {
        return idnetworking;
    }

    public void setIdnetworking(Networking idnetworking) {
        this.idnetworking = idnetworking;
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
        hash += (idnetdetail != null ? idnetdetail.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Networkingdetails)) {
            return false;
        }
        Networkingdetails other = (Networkingdetails) object;
        if ((this.idnetdetail == null && other.idnetdetail != null) || (this.idnetdetail != null && !this.idnetdetail.equals(other.idnetdetail))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Networkingdetails[ idnetdetail=" + idnetdetail + " ]";
    }
    
}
