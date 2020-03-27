/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import javax.ejb.Remote;

/**
 *
 * @author root
 */
@Remote
public interface TimerEJBRemote {
    void speakonTimeout();
    void hi();
}
