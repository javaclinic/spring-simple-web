package example.services;


import java.util.Date;
import java.util.logging.Logger;

/**
 * TimeService implementation. It returns the current timestamp, as Date and as String.
 * 
 * @author nevenc
 *
 */
public class TimeServiceImpl implements TimeService {

    private static final Logger LOGGER = Logger.getLogger(TimeServiceImpl.class.getCanonicalName());

    public TimeServiceImpl() {
        LOGGER.info("Inside " + this.getClass().getSimpleName() + "() constructor method. Instantiating service.");
    }

    @Override
    public Date getCurrentDate() {
        LOGGER.info("Inside " + this.getClass().getSimpleName() + ".getCurrentDate() business method. Processing business call.");
        Date now = new Date();
        return now;
    }

    @Override
    public String getCurrentTimestamp() {
        LOGGER.info("Inside " + this.getClass().getSimpleName() + ".getCurrentTimestamp() business method. Processing business call.");
        Date now = new Date();
        return now.toString();
    }

}
