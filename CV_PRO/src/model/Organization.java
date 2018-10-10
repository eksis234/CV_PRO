/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Lenovo
 */
@Entity
@Table(name = "ORGANIZATION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Organization.findAll", query = "SELECT o FROM Organization o")
    , @NamedQuery(name = "Organization.findByIdorganization", query = "SELECT o FROM Organization o WHERE o.idorganization = :idorganization")
    , @NamedQuery(name = "Organization.findByOrganizationname", query = "SELECT o FROM Organization o WHERE o.organizationname = :organizationname")
    , @NamedQuery(name = "Organization.findByPosition", query = "SELECT o FROM Organization o WHERE o.position = :position")
    , @NamedQuery(name = "Organization.findByStartdate", query = "SELECT o FROM Organization o WHERE o.startdate = :startdate")
    , @NamedQuery(name = "Organization.findByEnddate", query = "SELECT o FROM Organization o WHERE o.enddate = :enddate")})
public class Organization implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "IDORGANIZATION")
    private BigDecimal idorganization;
    @Column(name = "ORGANIZATIONNAME")
    private String organizationname;
    @Column(name = "POSITION")
    private String position;
    @Column(name = "STARTDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startdate;
    @Column(name = "ENDDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date enddate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idorganization", fetch = FetchType.LAZY)
    private List<Organizationdetails> organizationdetailsList;

    public Organization() {
    }

    public Organization(BigDecimal idorganization) {
        this.idorganization = idorganization;
    }

    public Organization(BigDecimal idorganization, String organizationname) {
        this.idorganization = idorganization;
        this.organizationname = organizationname;
    }

    public Organization(BigDecimal idorganization, String organizationname, String position) {
        this.idorganization = idorganization;
        this.organizationname = organizationname;
        this.position = position;
    }

    public Organization(BigDecimal idorganization, String organizationname, String position, Date startdate) {
        this.idorganization = idorganization;
        this.organizationname = organizationname;
        this.position = position;
        this.startdate = startdate;
    }

    public Organization(BigDecimal idorganization, String organizationname, String position, Date startdate, Date enddate) {
        this.idorganization = idorganization;
        this.organizationname = organizationname;
        this.position = position;
        this.startdate = startdate;
        this.enddate = enddate;
    }

    public Organization(BigDecimal idorganization, String organizationname, String position, Date startdate, Date enddate, List<Organizationdetails> organizationdetailsList) {
        this.idorganization = idorganization;
        this.organizationname = organizationname;
        this.position = position;
        this.startdate = startdate;
        this.enddate = enddate;
        this.organizationdetailsList = organizationdetailsList;
    }

    public BigDecimal getIdorganization() {
        return idorganization;
    }

    public void setIdorganization(BigDecimal idorganization) {
        this.idorganization = idorganization;
    }

    public String getOrganizationname() {
        return organizationname;
    }

    public void setOrganizationname(String organizationname) {
        this.organizationname = organizationname;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    @XmlTransient
    public List<Organizationdetails> getOrganizationdetailsList() {
        return organizationdetailsList;
    }

    public void setOrganizationdetailsList(List<Organizationdetails> organizationdetailsList) {
        this.organizationdetailsList = organizationdetailsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idorganization != null ? idorganization.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Organization)) {
            return false;
        }
        Organization other = (Organization) object;
        if ((this.idorganization == null && other.idorganization != null) || (this.idorganization != null && !this.idorganization.equals(other.idorganization))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Organization[ idorganization=" + idorganization + " ]";
    }
    
}
