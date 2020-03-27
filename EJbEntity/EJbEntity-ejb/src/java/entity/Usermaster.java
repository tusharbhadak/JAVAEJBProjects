/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author root
 */
@Entity
@Table(name = "USERMASTER")
@NamedQueries({
    @NamedQuery(name = "Usermaster.findAll", query = "SELECT u FROM Usermaster u"),
    @NamedQuery(name = "Usermaster.findByUsername", query = "SELECT u FROM Usermaster u WHERE u.username = :username"),
    @NamedQuery(name = "Usermaster.findByEmail", query = "SELECT u FROM Usermaster u WHERE u.email = :email"),
    @NamedQuery(name = "Usermaster.findByLastname", query = "SELECT u FROM Usermaster u WHERE u.lastname = :lastname"),
    @NamedQuery(name = "Usermaster.findByPassword", query = "SELECT u FROM Usermaster u WHERE u.password = :password"),
    @NamedQuery(name = "Usermaster.findByFirstname", query = "SELECT u FROM Usermaster u WHERE u.firstname = :firstname"),
    @NamedQuery(name = "Usermaster.findByAboutme", query = "SELECT u FROM Usermaster u WHERE u.aboutme = :aboutme")})
public class Usermaster implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "USERNAME")
    private String username;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "LASTNAME")
    private String lastname;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Column(name = "ABOUTME")
    private String aboutme;

    public Usermaster() {
    }

    public Usermaster(String username) {
        this.username = username;
    }
public Usermaster(String firstname, String lastname, String email,
                String username, String password, String aboutme)
	{
		if ((email == null || email.length() == 0) || (username == null || username.length() == 0) || (password == null || password.length() == 0))
		{
			throw new IllegalArgumentException("Email, Username or Password cannot be left empty");
		}
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.username = username;
		this.password = password;
		this.aboutme = aboutme;
	}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getAboutme() {
        return aboutme;
    }

    public void setAboutme(String aboutme) {
        this.aboutme = aboutme;
    }
public boolean isMatchingPassword(String password)
	{
		return this.password.equals(password);
	}
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usermaster)) {
            return false;
        }
        Usermaster other = (Usermaster) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Usermaster[username=" + username + "]";
    }

}
