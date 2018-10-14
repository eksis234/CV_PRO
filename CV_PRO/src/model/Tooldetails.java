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
@Table(name = "TOOLDETAILS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tooldetails.findAll", query = "SELECT t FROM Tooldetails t")
    , @NamedQuery(name = "Tooldetails.findByIdtooldetail", query = "SELECT t FROM Tooldetails t WHERE t.idtooldetail = :idtooldetail")
    , @NamedQuery(name = "Tooldetails.findBynametool", query = "SELECT t FROM Tooldetails t WHERE t.nametool = :nametool")})
public class Tooldetails implements Serializable {

    @Column(name = "NAMETOOL")
    private String nametool;

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "IDTOOLDETAIL")
    private BigDecimal idtooldetail;
    @JoinColumn(name = "IDPERSONAL", referencedColumnName = "IDPERSONAL")
    @ManyToOne(fetch = FetchType.LAZY)
    private Personaldata idpersonal;
    @JoinColumn(name = "IDTOOL", referencedColumnName = "IDTOOL")
    @ManyToOne(fetch = FetchType.LAZY)
    private Tools idtool;

    public Tooldetails() {
    }

    public Tooldetails(BigDecimal idtooldetail) {
        this.idtooldetail = idtooldetail;
    }

    public Tooldetails(String nametool, BigDecimal idtooldetail, Personaldata idpersonal, Tools idtool) {
        this.nametool = nametool;
        this.idtooldetail = idtooldetail;
        this.idpersonal = idpersonal;
        this.idtool = idtool;
    }

    public BigDecimal getIdtooldetail() {
        return idtooldetail;
    }

    public void setIdtooldetail(BigDecimal idtooldetail) {
        this.idtooldetail = idtooldetail;
    }

    public Personaldata getIdpersonal() {
        return idpersonal;
    }

    public void setIdpersonal(Personaldata idpersonal) {
        this.idpersonal = idpersonal;
    }

    public Tools getIdtool() {
        return idtool;
    }

    public void setIdtool(Tools idtool) {
        this.idtool = idtool;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtooldetail != null ? idtooldetail.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tooldetails)) {
            return false;
        }
        Tooldetails other = (Tooldetails) object;
        if ((this.idtooldetail == null && other.idtooldetail != null) || (this.idtooldetail != null && !this.idtooldetail.equals(other.idtooldetail))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Tooldetails[ idtooldetail=" + idtooldetail + " ]";
    }

    public String getNametool() {
        return nametool;
    }

    public void setNametool(String nametool) {
        this.nametool = nametool;
    }
    
}
