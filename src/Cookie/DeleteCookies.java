package Cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.*;
/**
 * Created by KHOAND on 11/11/2017.
 */
@WebServlet(name = "DeleteCookies", urlPatterns = {"/DeleteCookies"})
public class DeleteCookies extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = null;
        Cookie[] cookies = null;
        // Get an array of Cookies associated with this domain
        cookies = req.getCookies();

        // Set response content type
        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();
        String title = "Delete Cookies Example";
        String docType =
                "<!doctype html public \"-//w3c//dtd html 4.0 " +
                        "transitional//en\">\n";
        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" );
        if( cookies != null ){
            out.println("<h2> Cookies Name and Value</h2>");
            for (int i = 0; i < cookies.length; i++){
                cookie = cookies[i];
                if((cookie.getName( )).compareTo("first_name") == 0 ){
                    cookie.setMaxAge(0);
                    resp.addCookie(cookie);
                    out.print("Deleted cookie : " +
                            cookie.getName( ) + "<br/>");
                }
                out.print("Name : " + cookie.getName( ) + ",  ");
                out.print("Value: " + cookie.getValue( )+" <br/>");
            }
        }else{
            out.println(
                    "<h2>No cookies founds</h2>");
        }
        out.println("</body>");
        out.println("</html>");
    }
}
