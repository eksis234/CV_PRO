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
@Table(name = "WORKINGEXPERIENCE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Workingexperience.findAll", query = "SELECT w FROM Workingexperience w")
    , @NamedQuery(name = "Workingexperience.findByIdworkingexperience", query = "SELECT w FROM Workingexperience w WHERE w.idworkingexperience = :idworkingexperience")
    , @NamedQuery(name = "Workingexperience.findByNamaperusahaan", query = "SELECT w FROM Workingexperience w WHERE w.namaperusahaan = :namaperusahaan")
    , @NamedQuery(name = "Workingexperience.findByCity", query = "SELECT w FROM Workingexperience w WHERE w.city = :city")})
public class Workingexperience implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "IDWORKINGEXPERIENCE")
    private BigDecimal idworkingexperience;
    @Column(name = "NAMAPERUSAHAAN")
    private String namaperusahaan;
    @Column(name = "CITY")
    private String city;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idworkingexperience", fetch = FetchType.LAZY)
    private List<Experiencedetails> experiencedetailsList;

    public Workingexperience() {
    }

    public Workingexperience(BigDecimal idworkingexperience) {
        this.idworkingexperience = idworkingexperience;
    }

    public Workingexperience(BigDecimal idworkingexperience, String namaperusahaan, String city) {
        this.idworkingexperience = idworkingexperience;
        this.namaperusahaan = namaperusahaan;
        this.city = city;
    }
    
    

    public BigDecimal getIdworkingexperience() {
        return idworkingexperience;
    }

    public void setIdworkingexperience(BigDecimal idworkingexperience) {
        this.idworkingexperience = idworkingexperience;
    }

    public String getNamaperusahaan() {
        return namaperusahaan;
    }

    public void setNamaperusahaan(String namaperusahaan) {
        this.namaperusahaan = namaperusahaan;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @XmlTransient
    public List<Experiencedetails> getExperiencedetailsList() {
        return experiencedetailsList;
    }

    public void setExperiencedetailsList(List<Experiencedetails> experiencedetailsList) {
        this.experiencedetailsList = experiencedetailsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idworkingexperience != null ? idworkingexperience.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Workingexperience)) {
            return false;
        }
        Workingexperience other = (Workingexperience) object;
        if ((this.idworkingexperience == null && other.idworkingexperience != null) || (this.idworkingexperience != null && !this.idworkingexperience.equals(other.idworkingexperience))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Workingexperience[ idworkingexperience=" + idworkingexperience + " ]";
    }
    
}
