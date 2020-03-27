/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import javax.ejb.Remote;
import entity.*;
/**
 *
 * @author root
 */
@Remote
public interface UserBeanRemote {
    
    void addUser(String firstname, String lastname, String email, 
            String username, String password, String aboutme);
    Usermaster checkLogin(String username, String Password);
    
    
}
