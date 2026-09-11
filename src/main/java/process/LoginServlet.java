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

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

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

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection con = DriverManager.getConnection(
                    URL,
                    USERNAME,
                    PASSWORD
            );

            String sql =
                    "SELECT * FROM LOGIN_USERS " +
                    "WHERE USERNAME = ? AND PASSWORD = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                out.println("<h2>Login Successful!</h2>");

                out.println("<p>Welcome, " + username + "</p>");

                out.println("<br>");

                out.println("<a href='registration.html'>Register Student</a>");
                out.println("<br><br>");

                out.println("<a href='search.html'>Search Student</a>");
                out.println("<br><br>");

                out.println("<a href='delete.html'>Delete Student</a>");

            } else {

                out.println("<h2>Invalid Username or Password!</h2>");

                out.println("<a href='login.html'>Try Again</a>");
            }

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