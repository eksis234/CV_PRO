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
@Table(name = "NETWORKING")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Networking.findAll", query = "SELECT n FROM Networking n")
    , @NamedQuery(name = "Networking.findByIdnetworking", query = "SELECT n FROM Networking n WHERE n.idnetworking = :idnetworking")
    , @NamedQuery(name = "Networking.findByNetworkingskill", query = "SELECT n FROM Networking n WHERE n.networkingskill = :networkingskill")})
public class Networking implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "IDNETWORKING")
    private BigDecimal idnetworking;
    @Column(name = "NETWORKINGSKILL")
    private String networkingskill;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idnetworking", fetch = FetchType.LAZY)
    private List<Networkingdetails> networkingdetailsList;

    public Networking() {
    }

    public Networking(BigDecimal idnetworking) {
        this.idnetworking = idnetworking;
    }

    public BigDecimal getIdnetworking() {
        return idnetworking;
    }

    public void setIdnetworking(BigDecimal idnetworking) {
        this.idnetworking = idnetworking;
    }

    public String getNetworkingskill() {
        return networkingskill;
    }

    public void setNetworkingskill(String networkingskill) {
        this.networkingskill = networkingskill;
    }

    @XmlTransient
    public List<Networkingdetails> getNetworkingdetailsList() {
        return networkingdetailsList;
    }

    public void setNetworkingdetailsList(List<Networkingdetails> networkingdetailsList) {
        this.networkingdetailsList = networkingdetailsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idnetworking != null ? idnetworking.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Networking)) {
            return false;
        }
        Networking other = (Networking) object;
        if ((this.idnetworking == null && other.idnetworking != null) || (this.idnetworking != null && !this.idnetworking.equals(other.idnetworking))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Networking[ idnetworking=" + idnetworking + " ]";
    }
    
}
