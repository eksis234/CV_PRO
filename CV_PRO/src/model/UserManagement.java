/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Martin
 */
@Entity
@Table(name = "USER_MANAGEMENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserManagement.findAll", query = "SELECT u FROM UserManagement u")
    , @NamedQuery(name = "UserManagement.findById", query = "SELECT u FROM UserManagement u WHERE u.id = :id")
    , @NamedQuery(name = "UserManagement.findByUsername", query = "SELECT u FROM UserManagement u WHERE u.username = :username")
    , @NamedQuery(name = "UserManagement.findByPassword", query = "SELECT u FROM UserManagement u WHERE u.password = :password")
    , @NamedQuery(name = "UserManagement.findByRole", query = "SELECT u FROM UserManagement u WHERE u.role = :role")
    , @NamedQuery(name = "UserManagement.findByStatus", query = "SELECT u FROM UserManagement u WHERE u.status = :status")})
public class UserManagement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @Column(name = "USERNAME")
    private String username;
    @Basic(optional = false)
    @Column(name = "PASSWORD")
    private String password;
    @Basic(optional = false)
    @Column(name = "ROLE")
    private String role;
    @Basic(optional = false)
    @Column(name = "STATUS")
    private Character status;

    public UserManagement() {
    }

    public UserManagement(Long id) {
        this.id = id;
    }

    public UserManagement(Long id, String username, String password, String role, Character status) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserManagement)) {
            return false;
        }
        UserManagement other = (UserManagement) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.UserManagement[ id=" + id + " ]";
    }
    
}
