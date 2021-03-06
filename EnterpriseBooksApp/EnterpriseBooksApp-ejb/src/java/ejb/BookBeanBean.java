/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import javax.ejb.Stateless;
import java.util.Vector;
import entity.BookMaster;
import java.util.List;
import javax.annotation.Resource;

import javax.ejb.SessionContext;
import javax.persistence.*;


/**
 *
 * @author root
 */

@Stateless(mappedName="ejb/mybookbean")

public class BookBeanBean implements BookBeanRemote {
//    @Resource
//private SessionContext sctx;
  //  @Resource
   // private WebServiceContext wctx;
    // Add business logic below. (Right-click in editor and choose
    // "EJB Methods > Add Business Method" or "Web Service > Add Operation")
 @PersistenceContext(unitName="bookPU")
    private EntityManager em;
   // private Vector v;

  
    public void addBook(String bookName,String authorName,String publisherName, 
            String synopsis){
     
                if(bookName.length() > 0 && synopsis.length() > 0 && authorName.length() > 0 
                     && publisherName.length() > 0) {
              BookMaster bm=new BookMaster(bookName,authorName,publisherName,synopsis);
                    em.persist(bm);
                }
        

    }

   public void updateBook(Integer bookID,String bookName,String authorName,String publisherName, String synopsis)   
   {
                
                BookMaster bm=em.find(BookMaster.class,bookID);
                 bm.setBookName(bookName);
                 bm.setAuthorName(authorName);
                 bm.setPublisherName(publisherName);
                 bm.setSynopsis(synopsis);
              em.merge(bm);
                
   }

   public void removeBook(Integer bookID)
   {
       BookMaster bm=em.find(BookMaster.class,bookID);
                em.remove(bm);
       
   }
  // public BookMaster[] getAllBooks() {
   //@RolesAllowed({"admin"})
  
  public List<BookMaster> getAllBooks() {
      
       List<BookMaster> books=null;
   books = em.createNamedQuery("BookMaster.findAll").getResultList();
  
return books;
}

}