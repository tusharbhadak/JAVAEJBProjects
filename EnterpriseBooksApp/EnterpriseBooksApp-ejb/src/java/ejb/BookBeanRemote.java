/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import javax.ejb.Remote;
import entity.*;
import java.util.List;

/**
 *
 * @author root
 */
@Remote

public interface BookBeanRemote {
   
   public void addBook(String bookName,String authorName,String publisherName, String synopsis);
   public void updateBook(Integer BookID,String bookName,String authorName,String publisherName, String synopsis);   
   public void removeBook(Integer BookID);
   public List<BookMaster> getAllBooks();
}
