package process;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deleteStudent")
public class DeleteServlet extends HttpServlet {

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
                    "DELETE FROM STUDENT_REGISTRATION " +
                    "WHERE ROLLNO = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, rollno);

            int result = ps.executeUpdate();

            if (result > 0) {

                out.println("<h2>Student Deleted Successfully!</h2>");

                out.println("<p>Roll No: " + rollno +
                            " has been deleted.</p>");

            } else {

                out.println("<h2>Student Not Found!</h2>");
            }

            out.println("<br>");
            out.println("<a href='delete.html'>Delete Another Student</a>");
            out.println("<br><br>");
            out.println("<a href='search.html'>Search Student</a>");

            ps.close();
            con.close();

        } catch (Exception e) {

            out.println("<h2>Error!</h2>");
            out.println("<p>" + e.getMessage() + "</p>");

            e.printStackTrace();
        }
    }
}