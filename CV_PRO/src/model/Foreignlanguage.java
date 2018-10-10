/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Lenovo
 */
@Entity
@Table(name = "FOREIGNLANGUAGE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Foreignlanguage.findAll", query = "SELECT f FROM Foreignlanguage f")
    , @NamedQuery(name = "Foreignlanguage.findByIdflang", query = "SELECT f FROM Foreignlanguage f WHERE f.idflang = :idflang")
    , @NamedQuery(name = "Foreignlanguage.findByLanguagename", query = "SELECT f FROM Foreignlanguage f WHERE f.languagename = :languagename")})
public class Foreignlanguage implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "IDFLANG")
    private BigDecimal idflang;
    @Column(name = "LANGUAGENAME")
    private String languagename;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idflang", fetch = FetchType.LAZY)
    private List<Foreignlanguagedetails> foreignlanguagedetailsList;

    public Foreignlanguage() {
    }

    public Foreignlanguage(BigDecimal idflang) {
        this.idflang = idflang;
    }

    public Foreignlanguage(BigDecimal idflang, String languagename) {
        this.idflang = idflang;
        this.languagename = languagename;
    }

    public Foreignlanguage(BigDecimal idflang, String languagename, List<Foreignlanguagedetails> foreignlanguagedetailsList) {
        this.idflang = idflang;
        this.languagename = languagename;
        this.foreignlanguagedetailsList = foreignlanguagedetailsList;
    }
    
    public BigDecimal getIdflang() {
        return idflang;
    }

    public void setIdflang(BigDecimal idflang) {
        this.idflang = idflang;
    }

    public String getLanguagename() {
        return languagename;
    }

    public void setLanguagename(String languagename) {
        this.languagename = languagename;
    }

    @XmlTransient
    public List<Foreignlanguagedetails> getForeignlanguagedetailsList() {
        return foreignlanguagedetailsList;
    }

    public void setForeignlanguagedetailsList(List<Foreignlanguagedetails> foreignlanguagedetailsList) {
        this.foreignlanguagedetailsList = foreignlanguagedetailsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idflang != null ? idflang.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Foreignlanguage)) {
            return false;
        }
        Foreignlanguage other = (Foreignlanguage) object;
        if ((this.idflang == null && other.idflang != null) || (this.idflang != null && !this.idflang.equals(other.idflang))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Foreignlanguage[ idflang=" + idflang + " ]";
    }
    
}
