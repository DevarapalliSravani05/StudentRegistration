package process;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/searchStudent")
public class SearchServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private static final String URL =
            "jdbc:oracle:thin:@localhost:1521:XE";

    private static final String USERNAME = "system";

    private static final String PASSWORD = "your_password";

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        String rollno = request.getParameter("rollno");

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection con = DriverManager.getConnection(
                    URL,
                    USERNAME,
                    PASSWORD
            );

            String sql =
                    "SELECT * FROM STUDENT_REGISTRATION " +
                    "WHERE ROLLNO = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, rollno);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                out.println("<h2>Student Found</h2>");

                out.println("<p>Name: "
                        + rs.getString("NAME") + "</p>");

                out.println("<p>Roll No: "
                        + rs.getString("ROLLNO") + "</p>");

                out.println("<p>Section: "
                        + rs.getString("SECTION") + "</p>");

                out.println("<p>CGPA: "
                        + rs.getDouble("CGPA") + "</p>");

                out.println("<p>Interested Domain: "
                        + rs.getString("INTERESTED_DOMAIN")
                        + "</p>");

                out.println("<p>Course: "
                        + rs.getString("COURSE") + "</p>");

            } else {

                out.println("<h2>Student Not Found</h2>");
            }

            out.println("<br>");
            out.println("<a href='search.html'>Search Again</a>");

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {

            out.println("<h2>Error!</h2>");
            out.println("<p>" + e.getMessage() + "</p>");

            e.printStackTrace();
        }
    }
}