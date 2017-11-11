import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DemoServlet" ,urlPatterns = {"/demo"})
public class DemoServlet extends HttpServlet {
    private String message;


    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        message = "hello world ";
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();
        printWriter.println("<h1>"+message+"</h1>");
        printWriter.flush();
    }
}
