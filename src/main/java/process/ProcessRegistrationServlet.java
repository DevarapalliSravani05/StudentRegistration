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

@WebServlet("/processRegistration")
public class ProcessRegistrationServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    // Oracle Database details
    private static final String URL =
            "jdbc:oracle:thin:@localhost:1521:XE";

    private static final String USERNAME = "system";

    private static final String PASSWORD = "your_password";

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        // Get data from HTML form
        String name = request.getParameter("name");
        String rollno = request.getParameter("rollno");
        String section = request.getParameter("section");
        String cgpaValue = request.getParameter("cgpa");
        String domain = request.getParameter("domain");
        String course = request.getParameter("course");

        try {

            // Convert CGPA to double
            double cgpa = Double.parseDouble(cgpaValue);

            // Load Oracle JDBC Driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Connect to Oracle
            Connection con = DriverManager.getConnection(
                    URL,
                    USERNAME,
                    PASSWORD
            );

            // SQL query
            String sql =
                    "INSERT INTO STUDENT_REGISTRATION " +
                    "(NAME, ROLLNO, SECTION, CGPA, " +
                    "INTERESTED_DOMAIN, COURSE) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            // Set values
            ps.setString(1, name);
            ps.setString(2, rollno);
            ps.setString(3, section);
            ps.setDouble(4, cgpa);
            ps.setString(5, domain);
            ps.setString(6, course);

            // Execute query
            int result = ps.executeUpdate();

            if (result > 0) {

                out.println("<html>");
                out.println("<body>");

                out.println("<h2>Registration Successful!</h2>");

                out.println("<p>Name: " + name + "</p>");
                out.println("<p>Roll No: " + rollno + "</p>");
                out.println("<p>Section: " + section + "</p>");
                out.println("<p>CGPA: " + cgpa + "</p>");
                out.println("<p>Interested Domain: " + domain + "</p>");
                out.println("<p>Course: " + course + "</p>");

                out.println("</body>");
                out.println("</html>");

            } else {

                out.println("<h2>Registration Failed!</h2>");
            }

            // Close resources
            ps.close();
            con.close();

        } catch (Exception e) {

            out.println("<h2>Error!</h2>");
            out.println("<p>" + e.getMessage() + "</p>");

            e.printStackTrace();
        }
    }
}