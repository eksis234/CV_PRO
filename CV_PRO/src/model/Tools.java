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
@Table(name = "TOOLS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tools.findAll", query = "SELECT t FROM Tools t")
    , @NamedQuery(name = "Tools.findByIdtool", query = "SELECT t FROM Tools t WHERE t.idtool = :idtool")
    , @NamedQuery(name = "Tools.findByToolname", query = "SELECT t FROM Tools t WHERE t.toolname = :toolname")})
public class Tools implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "IDTOOL")
    private BigDecimal idtool;
    @Column(name = "TOOLNAME")
    private String toolname;
    @OneToMany(mappedBy = "idtool", fetch = FetchType.LAZY)
    private List<Tooldetails> tooldetailsList;

    public Tools() {
    }

    public Tools(BigDecimal idtool) {
        this.idtool = idtool;
    }

    public Tools(BigDecimal idtool, String toolname, List<Tooldetails> tooldetailsList) {
        this.idtool = idtool;
        this.toolname = toolname;
        this.tooldetailsList = tooldetailsList;
    }

    public Tools(BigDecimal idtool, String toolname) {
        this.idtool = idtool;
        this.toolname = toolname;
    }
    
    public BigDecimal getIdtool() {
        return idtool;
    }

    public void setIdtool(BigDecimal idtool) {
        this.idtool = idtool;
    }

    public String getToolname() {
        return toolname;
    }

    public void setToolname(String toolname) {
        this.toolname = toolname;
    }

    @XmlTransient
    public List<Tooldetails> getTooldetailsList() {
        return tooldetailsList;
    }

    public void setTooldetailsList(List<Tooldetails> tooldetailsList) {
        this.tooldetailsList = tooldetailsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtool != null ? idtool.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tools)) {
            return false;
        }
        Tools other = (Tools) object;
        if ((this.idtool == null && other.idtool != null) || (this.idtool != null && !this.idtool.equals(other.idtool))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Tools[ idtool=" + idtool + " ]";
    }
    
}
