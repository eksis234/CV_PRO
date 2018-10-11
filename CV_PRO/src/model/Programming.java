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
 * @author Martin
 */
@Entity
@Table(name = "PROGRAMMING")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Programming.findAll", query = "SELECT p FROM Programming p")
    , @NamedQuery(name = "Programming.findByIdprogramming", query = "SELECT p FROM Programming p WHERE p.idprogramming = :idprogramming")
    , @NamedQuery(name = "Programming.findByProgramminglanguage", query = "SELECT p FROM Programming p WHERE p.programminglanguage = :programminglanguage")})
public class Programming implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "IDPROGRAMMING")
    private BigDecimal idprogramming;
    @Column(name = "PROGRAMMINGLANGUAGE")
    private String programminglanguage;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idprogramming", fetch = FetchType.LAZY)
    private List<Programmingdetails> programmingdetailsList;

    public Programming() {
    }

    public Programming(BigDecimal idprogramming) {
        this.idprogramming = idprogramming;
    }

    public Programming(BigDecimal idprogramming, String programminglanguage) {
        this.idprogramming = idprogramming;
        this.programminglanguage = programminglanguage;
    }

    public BigDecimal getIdprogramming() {
        return idprogramming;
    }

    public void setIdprogramming(BigDecimal idprogramming) {
        this.idprogramming = idprogramming;
    }

    public String getProgramminglanguage() {
        return programminglanguage;
    }

    public void setProgramminglanguage(String programminglanguage) {
        this.programminglanguage = programminglanguage;
    }

    @XmlTransient
    public List<Programmingdetails> getProgrammingdetailsList() {
        return programmingdetailsList;
    }

    public void setProgrammingdetailsList(List<Programmingdetails> programmingdetailsList) {
        this.programmingdetailsList = programmingdetailsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idprogramming != null ? idprogramming.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Programming)) {
            return false;
        }
        Programming other = (Programming) object;
        if ((this.idprogramming == null && other.idprogramming != null) || (this.idprogramming != null && !this.idprogramming.equals(other.idprogramming))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Programming[ idprogramming=" + idprogramming + " ]";
    }
    
}
