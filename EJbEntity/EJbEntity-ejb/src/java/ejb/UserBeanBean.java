/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import javax.ejb.Stateless;
import javax.persistence.*;
import entity.Usermaster;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;

/**
 *
 * @author root
 */
@Stateless
//@RunAs("AdminRole")
@DeclareRoles({"Supervisory","AdminRole"})
public class UserBeanBean implements UserBeanRemote {
    
    @PersistenceContext(unitName="userpu")
    private EntityManager em;
    
 public UserBeanBean() {
     
 }
 @RolesAllowed({"AdminRole"})
 public void addUser(String firstname, String lastname, 
         String email, String username, String password, String aboutme)
 {
    Usermaster um = new Usermaster(firstname, lastname, email, 
            username, password, aboutme);

    em.persist(um); 

 }
//@PermitAll
 @RolesAllowed({"Supervisory"})
 public Usermaster checkLogin(String username, String password)
 {
     Usermaster um = em.find(Usermaster.class, username);

      if (um.isMatchingPassword(password))
      {
      return um;
        }
 return null;
 }
 
}
