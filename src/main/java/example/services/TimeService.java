package example.services;


import java.util.Date;

/**
 * Simple time service interface.
 * 
 * @author nevenc
 *
 */
public interface TimeService {
    Date getCurrentDate();
    String getCurrentTimestamp();
}
