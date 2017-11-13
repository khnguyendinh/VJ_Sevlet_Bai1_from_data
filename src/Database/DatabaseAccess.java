package Database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 * Created by KHOAND on 11/13/2017.
 */
@WebServlet(name = "DatabaseAccess", urlPatterns = {"/DatabaseAccess"})
public class DatabaseAccess extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Ten cua driver va dia chi URL cua co so du lieu
        final String JDBC_DRIVER="com.mysql.jdbc.Driver";
        final String DB_URL="jdbc:mysql://localhost/test";
        Connection conn = null;
        Statement stmt = null;
        //  Ten nguoi dung va mat khau cua co so du lieu
        final String USER = "root";
        final String PASS = "root";

        // Set response content type
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String title = "Database Result";
        String docType =
                "<!doctype html public \"-//w3c//dtd html 4.0 " +
                        "transitional//en\">\n";
        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n");
        try{
            // Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            // Open a connection
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            // Execute SQL query
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT id, age, first, last FROM Employees";
            ResultSet rs = stmt.executeQuery(sql);

            // Extract data from result set
            while(rs.next()){
                // Lay du lieu boi su dung ten cot
                int id  = rs.getInt("id");
                int age = rs.getInt("age");
                String first = rs.getString("first");
                String last = rs.getString("last");

                // Hien thi cac gia tri
                out.println("ID: " + id + "<br>");
                out.println(", Age: " + age + "<br>");
                out.println(", First: " + first + "<br>");
                out.println(", Last: " + last + "<br>");
            }
            out.println("</body></html>");

            // Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            // Xu ly cac loi cho JDBC
            se.printStackTrace();
        }catch(Exception e){
            // Xu ly cac loi cho Class.forName
            e.printStackTrace();
        }finally{
            // Khoi finally duoc su dung de dong cac resource
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }// Ket thuc khoi finally
        } // Ket thuc khoi try
    }
}
