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
@Table(name = "ACHIEVEMENTDETAILS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Achievementdetails.findAll", query = "SELECT a FROM Achievementdetails a")
    , @NamedQuery(name = "Achievementdetails.findByIdachdetail", query = "SELECT a FROM Achievementdetails a WHERE a.idachdetail = :idachdetail")
    , @NamedQuery(name = "Achievementdetails.findByStatus", query = "SELECT a FROM Achievementdetails a WHERE a.status = :status")})
public class Achievementdetails implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "IDACHDETAIL")
    private BigDecimal idachdetail;
    @Column(name = "STATUS")
    private String status;
    @JoinColumn(name = "IDACHIEVEMENT", referencedColumnName = "IDACHIEVEMENT")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Achievement idachievement;
    @JoinColumn(name = "IDPERSONAL", referencedColumnName = "IDPERSONAL")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Personaldata idpersonal;

    public Achievementdetails() {
    }

    public Achievementdetails(BigDecimal idachdetail) {
        this.idachdetail = idachdetail;
    }

    public BigDecimal getIdachdetail() {
        return idachdetail;
    }

    public void setIdachdetail(BigDecimal idachdetail) {
        this.idachdetail = idachdetail;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Achievement getIdachievement() {
        return idachievement;
    }

    public void setIdachievement(Achievement idachievement) {
        this.idachievement = idachievement;
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
        hash += (idachdetail != null ? idachdetail.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Achievementdetails)) {
            return false;
        }
        Achievementdetails other = (Achievementdetails) object;
        if ((this.idachdetail == null && other.idachdetail != null) || (this.idachdetail != null && !this.idachdetail.equals(other.idachdetail))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Achievementdetails[ idachdetail=" + idachdetail + " ]";
    }
    
}
