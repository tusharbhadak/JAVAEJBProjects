
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

//package ejb;javaee-endorsed-api-6.0

import java.util.Date;
import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Stateless;

/**
 *
 * @author root
 */
@Startup
@Singleton
@LocalBean
public class SchedulerBean {
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
@PostConstruct
void initialize()
    {
   // speakOnSchedule();
    }
public void hi()
    {
    // System.out.println("executing on my schedule "+ new Date());
    return;
    }

@Schedule(dayOfWeek="*",month="*",year="*", hour="0-23", minute="58", second="*/5")
void speakOnSchedule()
    {
    System.out.println("executing on my schedule "+ new Date());
    }
}


