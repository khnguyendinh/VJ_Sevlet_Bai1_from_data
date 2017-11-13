package HitCounter;


import javax.servlet.*;
import java.io.IOException;

/**
 * Created by KHOAND on 11/13/2017.
 */
public class SiteHitCounter implements Filter {
    private int hitCount;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Reset hit counter.
        hitCount = 0;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // increase counter by one
        hitCount++;

        // Print the counter.
        System.out.println("Site visits count :"+ hitCount );

        // Pass request back down the filter chain
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
