package Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.Date;

/**
 * Created by KHOAND on 11/11/2017.
 */
public class LogFilter implements Filter {

//    @Override
//    public void init(ServletConfig config) throws ServletException {
//        // Get init parameter
//        String testParam = config.getInitParameter("test-param");
//
//        //Print the init parameter
//        System.out.println("Test Param: " + testParam);
//    }


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Get init parameter
        String testParam = filterConfig.getInitParameter("test-param");
        //Print the init parameter
        System.out.println("Test Param: " + testParam);
    }

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // Get the IP address of client machine.
        String ipAddress = servletRequest.getRemoteAddr();

        // Log the IP address and current timestamp.
        System.out.println("IP "+ ipAddress + ", Time "
                + new Date().toString());

        // Pass request back down the filter chain
        filterChain.doFilter(servletRequest,servletResponse);

    }
}
