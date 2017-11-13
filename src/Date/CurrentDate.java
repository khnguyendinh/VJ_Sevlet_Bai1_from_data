package Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by KHOAND on 11/13/2017.
 */
@WebServlet(name = "CurrentDate" , urlPatterns = {"/CurrentDate"})
public class CurrentDate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Set response content type
        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();
        String title = "Display Current Date & Time";
//        Date date = new Date();
//        String docType =
//                "<!doctype html public \"-//w3c//dtd html 4.0 " +
//                        "transitional//en\">\n";
//        out.println(docType +
//                "<html>\n" +
//                "<head><title>" + title + "</title></head>\n" +
//                "<body bgcolor=\"#f0f0f0\">\n" +
//                "<h1 align=\"center\">" + title + "</h1>\n" +
//                "<h2 align=\"center\">" + date.toString() + "</h2>\n" +
//                "</body></html>");
        Date dNow = new Date( );
        SimpleDateFormat ft =
                new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
        String docType =
                "<!doctype html public \"-//w3c//dtd html 4.0 " +
                        "transitional//en\">\n";
        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n" +
                "<h2 align=\"center\">" + ft.format(dNow) + "</h2>\n" +
                "</body></html>");
    }
}
