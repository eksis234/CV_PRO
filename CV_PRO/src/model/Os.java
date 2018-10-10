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
@Table(name = "OS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Os.findAll", query = "SELECT o FROM Os o")
    , @NamedQuery(name = "Os.findByIdos", query = "SELECT o FROM Os o WHERE o.idos = :idos")
    , @NamedQuery(name = "Os.findByOsname", query = "SELECT o FROM Os o WHERE o.osname = :osname")})
public class Os implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "IDOS")
    private BigDecimal idos;
    @Column(name = "OSNAME")
    private String osname;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idos", fetch = FetchType.LAZY)
    private List<Osdetails> osdetailsList;

    public Os() {
    }

    public Os(BigDecimal idos) {
        this.idos = idos;
    }

    public Os(BigDecimal idos, String osname) {
        this.idos = idos;
        this.osname = osname;
    }

    public Os(BigDecimal idos, String osname, List<Osdetails> osdetailsList) {
        this.idos = idos;
        this.osname = osname;
        this.osdetailsList = osdetailsList;
    }

    public BigDecimal getIdos() {
        return idos;
    }

    public void setIdos(BigDecimal idos) {
        this.idos = idos;
    }

    public String getOsname() {
        return osname;
    }

    public void setOsname(String osname) {
        this.osname = osname;
    }

    @XmlTransient
    public List<Osdetails> getOsdetailsList() {
        return osdetailsList;
    }

    public void setOsdetailsList(List<Osdetails> osdetailsList) {
        this.osdetailsList = osdetailsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idos != null ? idos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Os)) {
            return false;
        }
        Os other = (Os) object;
        if ((this.idos == null && other.idos != null) || (this.idos != null && !this.idos.equals(other.idos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Os[ idos=" + idos + " ]";
    }
    
}
