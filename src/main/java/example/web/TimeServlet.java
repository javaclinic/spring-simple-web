package example.web;

import java.io.IOException;
import java.util.Date;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import example.services.TimeService;

/**
 * TimeServlet servlet calls the backend service and outputs the result.
 * 
 * @author nevenc
 *
 */
@WebServlet("/time")
public class TimeServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private static final Logger LOGGER = Logger.getLogger(TimeServlet.class.getCanonicalName());

    private WebApplicationContext springContext;

    public TimeServlet() {
        LOGGER.info("Inside " + this.getClass().getSimpleName() +"() constructor method. Instantiating TimeServlet instance.");
    }

    @Override
    public void init() throws ServletException {
        LOGGER.info("Inside " + this.getClass().getSimpleName() + ".init() method. Initializing TimeServlet instance.");
        springContext = WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext());
    }

    /**
     * Processes GET requests. Finds a service, calls the service, binds the results into view, forwards to a view.
     * 
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        LOGGER.info("Inside " + this.getClass().getSimpleName() + ".doGet(...) method. Processing GET request.");

        try {
            // get a service from Spring application context
            TimeService service = springContext.getBean(TimeService.class);
            // call the business method
            Date now = service.getCurrentDate();
            // bind the results into the view
            request.setAttribute("NOW", now);
            // forward to a view
            request.getRequestDispatcher("/WEB-INF/views/time.jsp").forward(request, response);
        } catch (Exception e) {
            // in case of an exception, log the error and forward to an error view
            LOGGER.warning("Error: " + e.getMessage());
            request.setAttribute("ERROR", e.getMessage());
            request.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(request, response);
        }

    }

}
