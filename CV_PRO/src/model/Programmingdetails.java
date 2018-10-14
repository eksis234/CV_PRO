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
@Table(name = "PROGRAMMINGDETAILS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Programmingdetails.findAll", query = "SELECT p FROM Programmingdetails p")
    , @NamedQuery(name = "Programmingdetails.findByIdprogdetail", query = "SELECT p FROM Programmingdetails p WHERE p.idprogdetail = :idprogdetail")
    , @NamedQuery(name = "Programmingdetails.findByBhsaprog", query = "SELECT p FROM Programmingdetails p WHERE p.bhsaprog = :bhsaprog")})
public class Programmingdetails implements Serializable {

    @Column(name = "BHSAPROG")
    private String bhsaprog;

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "IDPROGDETAIL")
    private BigDecimal idprogdetail;
    @Column(name = "STATUS")
    private String status;
    @JoinColumn(name = "IDPERSONAL", referencedColumnName = "IDPERSONAL")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Personaldata idpersonal;
    @JoinColumn(name = "IDPROGRAMMING", referencedColumnName = "IDPROGRAMMING")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Programming idprogramming;

    public Programmingdetails() {
    }

    public Programmingdetails(BigDecimal idprogdetail) {
        this.idprogdetail = idprogdetail;
    }

    public Programmingdetails(String bhsaprog, BigDecimal idprogdetail, String status, Personaldata idpersonal, Programming idprogramming) {
        this.bhsaprog = bhsaprog;
        this.idprogdetail = idprogdetail;
        this.status = status;
        this.idpersonal = idpersonal;
        this.idprogramming = idprogramming;
    }

    public BigDecimal getIdprogdetail() {
        return idprogdetail;
    }

    public void setIdprogdetail(BigDecimal idprogdetail) {
        this.idprogdetail = idprogdetail;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Personaldata getIdpersonal() {
        return idpersonal;
    }

    public void setIdpersonal(Personaldata idpersonal) {
        this.idpersonal = idpersonal;
    }

    public Programming getIdprogramming() {
        return idprogramming;
    }

    public void setIdprogramming(Programming idprogramming) {
        this.idprogramming = idprogramming;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idprogdetail != null ? idprogdetail.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Programmingdetails)) {
            return false;
        }
        Programmingdetails other = (Programmingdetails) object;
        if ((this.idprogdetail == null && other.idprogdetail != null) || (this.idprogdetail != null && !this.idprogdetail.equals(other.idprogdetail))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Programmingdetails[ idprogdetail=" + idprogdetail + " ]";
    }

    public String getBhsaprog() {
        return bhsaprog;
    }

    public void setBhsaprog(String bhsaprog) {
        this.bhsaprog = bhsaprog;
    }
    
}
