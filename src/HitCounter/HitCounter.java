package HitCounter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by KHOAND on 11/13/2017.
 */
@WebServlet(name = "HitCounter", urlPatterns = {"/HitCounter"})
public class HitCounter extends HttpServlet{
    private int hitCount;

    public void init()
    {
        // Reset hit counter.
        hitCount = 0;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Set response content type
        resp.setContentType("text/html");
        // This method executes whenever the servlet is hit
        // increment hitCount
        hitCount++;
        PrintWriter out = resp.getWriter();
        String title = "Total Number of Hits";
        String docType =
                "<!doctype html public \"-//w3c//dtd html 4.0 " +
                        "transitional//en\">\n";
        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n" +
                "<h2 align=\"center\">" + hitCount + "</h2>\n" +
                "</body></html>");
    }

    public void destroy()
    {
        // This is optional step but if you like you
        // can write hitCount value in your database.
    }
}
