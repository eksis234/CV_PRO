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
@Table(name = "FOREIGNLANGUAGEDETAILS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Foreignlanguagedetails.findAll", query = "SELECT f FROM Foreignlanguagedetails f")
    , @NamedQuery(name = "Foreignlanguagedetails.findByIdflangdetail", query = "SELECT f FROM Foreignlanguagedetails f WHERE f.idflangdetail = :idflangdetail")
    , @NamedQuery(name = "Foreignlanguagedetails.findByStatus", query = "SELECT f FROM Foreignlanguagedetails f WHERE f.status = :status")
    , @NamedQuery(name = "Foreignlanguagedetails.findByLanguagename", query = "SELECT f FROM Foreignlanguagedetails f WHERE f.languagename = :languagename")})
public class Foreignlanguagedetails implements Serializable {

    @Column(name = "LANGUAGENAME")
    private String languagename;

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "IDFLANGDETAIL")
    private BigDecimal idflangdetail;
    @Column(name = "STATUS")
    private String status;
    @JoinColumn(name = "IDFLANG", referencedColumnName = "IDFLANG")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Foreignlanguage idflang;
    @JoinColumn(name = "IDPERSONAL", referencedColumnName = "IDPERSONAL")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Personaldata idpersonal;

    public Foreignlanguagedetails() {
    }

    public Foreignlanguagedetails(BigDecimal idflangdetail) {
        this.idflangdetail = idflangdetail;
    }

    public Foreignlanguagedetails(String languagename, BigDecimal idflangdetail, String status, Foreignlanguage idflang, Personaldata idpersonal) {
        this.languagename = languagename;
        this.idflangdetail = idflangdetail;
        this.status = status;
        this.idflang = idflang;
        this.idpersonal = idpersonal;
    }

    public BigDecimal getIdflangdetail() {
        return idflangdetail;
    }

    public void setIdflangdetail(BigDecimal idflangdetail) {
        this.idflangdetail = idflangdetail;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Foreignlanguage getIdflang() {
        return idflang;
    }

    public void setIdflang(Foreignlanguage idflang) {
        this.idflang = idflang;
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
        hash += (idflangdetail != null ? idflangdetail.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Foreignlanguagedetails)) {
            return false;
        }
        Foreignlanguagedetails other = (Foreignlanguagedetails) object;
        if ((this.idflangdetail == null && other.idflangdetail != null) || (this.idflangdetail != null && !this.idflangdetail.equals(other.idflangdetail))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Foreignlanguagedetails[ idflangdetail=" + idflangdetail + " ]";
    }

    public String getLanguagename() {
        return languagename;
    }

    public void setLanguagename(String languagename) {
        this.languagename = languagename;
    }
    
}
