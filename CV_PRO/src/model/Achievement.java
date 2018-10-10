/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
@Table(name = "ACHIEVEMENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Achievement.findAll", query = "SELECT a FROM Achievement a")
    , @NamedQuery(name = "Achievement.findByIdachievement", query = "SELECT a FROM Achievement a WHERE a.idachievement = :idachievement")
    , @NamedQuery(name = "Achievement.findByAchievementname", query = "SELECT a FROM Achievement a WHERE a.achievementname = :achievementname")
    , @NamedQuery(name = "Achievement.findByEventname", query = "SELECT a FROM Achievement a WHERE a.eventname = :eventname")
    , @NamedQuery(name = "Achievement.findByYear", query = "SELECT a FROM Achievement a WHERE a.year = :year")})
public class Achievement implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "IDACHIEVEMENT")
    private BigDecimal idachievement;
    @Column(name = "ACHIEVEMENTNAME")
    private String achievementname;
    @Column(name = "EVENTNAME")
    private String eventname;
    @Column(name = "YEAR")
    private BigInteger year;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idachievement", fetch = FetchType.LAZY)
    private List<Achievementdetails> achievementdetailsList;

    public Achievement() {
    }

    public Achievement(BigDecimal idachievement) {
        this.idachievement = idachievement;
    }

    public BigDecimal getIdachievement() {
        return idachievement;
    }

    public void setIdachievement(BigDecimal idachievement) {
        this.idachievement = idachievement;
    }

    public String getAchievementname() {
        return achievementname;
    }

    public void setAchievementname(String achievementname) {
        this.achievementname = achievementname;
    }

    public String getEventname() {
        return eventname;
    }

    public void setEventname(String eventname) {
        this.eventname = eventname;
    }

    public BigInteger getYear() {
        return year;
    }

    public void setYear(BigInteger year) {
        this.year = year;
    }

    @XmlTransient
    public List<Achievementdetails> getAchievementdetailsList() {
        return achievementdetailsList;
    }

    public void setAchievementdetailsList(List<Achievementdetails> achievementdetailsList) {
        this.achievementdetailsList = achievementdetailsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idachievement != null ? idachievement.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Achievement)) {
            return false;
        }
        Achievement other = (Achievement) object;
        if ((this.idachievement == null && other.idachievement != null) || (this.idachievement != null && !this.idachievement.equals(other.idachievement))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Achievement[ idachievement=" + idachievement + " ]";
    }
    
}
