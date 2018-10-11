/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
@Table(name = "EDUCATIONDETAILS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Educationdetails.findAll", query = "SELECT e FROM Educationdetails e")
    , @NamedQuery(name = "Educationdetails.findByIdedudetail", query = "SELECT e FROM Educationdetails e WHERE e.idedudetail = :idedudetail")
    , @NamedQuery(name = "Educationdetails.findByStatus", query = "SELECT e FROM Educationdetails e WHERE e.status = :status")
    , @NamedQuery(name = "Educationdetails.findByIpk", query = "SELECT e FROM Educationdetails e WHERE e.ipk = :ipk")
    , @NamedQuery(name = "Educationdetails.findByAngkatan", query = "SELECT e FROM Educationdetails e WHERE e.angkatan = :angkatan")
    , @NamedQuery(name = "Educationdetails.findByTahunlulus", query = "SELECT e FROM Educationdetails e WHERE e.tahunlulus = :tahunlulus")
    , @NamedQuery(name = "Educationdetails.findByJurusan", query = "SELECT e FROM Educationdetails e WHERE e.jurusan = :jurusan")})
public class Educationdetails implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "IDEDUDETAIL")
    private BigDecimal idedudetail;
    @Column(name = "STATUS")
    private String status;
    @Column(name = "IPK")
    private Double ipk;
    @Column(name = "ANGKATAN")
    private BigInteger angkatan;
    @Column(name = "TAHUNLULUS")
    private BigInteger tahunlulus;
    @Column(name = "JURUSAN")
    private BigInteger jurusan;
    @JoinColumn(name = "IDEDUCATION", referencedColumnName = "IDEDUCATION")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Education ideducation;
    @JoinColumn(name = "IDPERSONAL", referencedColumnName = "IDPERSONAL")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Personaldata idpersonal;

    public Educationdetails() {
    }

    public Educationdetails(BigDecimal idedudetail) {
        this.idedudetail = idedudetail;
    }

    public BigDecimal getIdedudetail() {
        return idedudetail;
    }

    public void setIdedudetail(BigDecimal idedudetail) {
        this.idedudetail = idedudetail;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getIpk() {
        return ipk;
    }

    public void setIpk(Double ipk) {
        this.ipk = ipk;
    }

    public BigInteger getAngkatan() {
        return angkatan;
    }

    public void setAngkatan(BigInteger angkatan) {
        this.angkatan = angkatan;
    }

    public BigInteger getTahunlulus() {
        return tahunlulus;
    }

    public void setTahunlulus(BigInteger tahunlulus) {
        this.tahunlulus = tahunlulus;
    }

    public BigInteger getJurusan() {
        return jurusan;
    }

    public void setJurusan(BigInteger jurusan) {
        this.jurusan = jurusan;
    }

    public Education getIdeducation() {
        return ideducation;
    }

    public void setIdeducation(Education ideducation) {
        this.ideducation = ideducation;
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
        hash += (idedudetail != null ? idedudetail.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Educationdetails)) {
            return false;
        }
        Educationdetails other = (Educationdetails) object;
        if ((this.idedudetail == null && other.idedudetail != null) || (this.idedudetail != null && !this.idedudetail.equals(other.idedudetail))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Educationdetails[ idedudetail=" + idedudetail + " ]";
    }
    
}
