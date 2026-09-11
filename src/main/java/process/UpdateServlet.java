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

@WebServlet("/updateStudent")
public class UpdateServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private static final String URL =
            "jdbc:oracle:thin:@localhost:1521:XE";

    private static final String USERNAME = "system";

    private static final String PASSWORD =
            "your_password";


    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();


        // Get values from form

        String rollno =
                request.getParameter("rollno");

        String name =
                request.getParameter("name");

        String section =
                request.getParameter("section");

        String cgpaValue =
                request.getParameter("cgpa");

        String domain =
                request.getParameter("domain");

        String course =
                request.getParameter("course");


        try {

            double cgpa =
                    Double.parseDouble(cgpaValue);


            // Load Oracle Driver

            Class.forName(
                    "oracle.jdbc.driver.OracleDriver"
            );


            // Database connection

            Connection con =
                    DriverManager.getConnection(
                            URL,
                            USERNAME,
                            PASSWORD
                    );


            // Update query

            String sql =
                    "UPDATE STUDENT_REGISTRATION SET "
                    + "NAME = ?, "
                    + "SECTION = ?, "
                    + "CGPA = ?, "
                    + "INTERESTED_DOMAIN = ?, "
                    + "COURSE = ? "
                    + "WHERE ROLLNO = ?";


            PreparedStatement ps =
                    con.prepareStatement(sql);


            // Set values

            ps.setString(1, name);

            ps.setString(2, section);

            ps.setDouble(3, cgpa);

            ps.setString(4, domain);

            ps.setString(5, course);

            ps.setString(6, rollno);


            // Execute update

            int result =
                    ps.executeUpdate();


            if (result > 0) {

                out.println(
                        "<html><body>"
                );

                out.println(
                        "<h2>Student Updated Successfully!</h2>"
                );

                out.println(
                        "<p>Roll No: "
                        + rollno
                        + "</p>"
                );

                out.println(
                        "<p>Name: "
                        + name
                        + "</p>"
                );

                out.println(
                        "<p>Section: "
                        + section
                        + "</p>"
                );

                out.println(
                        "<p>CGPA: "
                        + cgpa
                        + "</p>"
                );

                out.println(
                        "<p>Interested Domain: "
                        + domain
                        + "</p>"
                );

                out.println(
                        "<p>Course: "
                        + course
                        + "</p>"
                );

                out.println(
                        "<br><a href='update.html'>"
                        + "Update Another Student"
                        + "</a>"
                );

                out.println(
                        "</body></html>"
                );


            } else {

                out.println(
                        "<h2>Student Not Found!</h2>"
                );

                out.println(
                        "<p>No student exists with Roll No: "
                        + rollno
                        + "</p>"
                );

                out.println(
                        "<br><a href='update.html'>"
                        + "Try Again"
                        + "</a>"
                );

            }


            ps.close();

            con.close();


        } catch (NumberFormatException e) {

            out.println(
                    "<h2>Invalid CGPA!</h2>"
            );


        } catch (Exception e) {

            out.println(
                    "<h2>Error!</h2>"
            );

            out.println(
                    "<p>"
                    + e.getMessage()
                    + "</p>"
            );

            e.printStackTrace();

        }

    }

}