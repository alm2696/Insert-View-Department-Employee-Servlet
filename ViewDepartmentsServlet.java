package mod05_OYO_02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This servlet fetches department data from the database using the DepartmentDAO
 * and generates a simple HTML page to display the department details in a table.
 * 
 * @author angel
 */
@WebServlet("/viewDepartments")
public class ViewDepartmentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DepartmentDAO departmentDAO;

    /**
     * Initializes the servlet and creates an instance of DepartmentDAO for database access.
     */
    public void init() {
        departmentDAO = new DepartmentDAO(); // Initialize DAO for accessing department data
    }

    /**
     * Handles GET requests to retrieve and display a list of departments.
     *
     * @param request           The HttpServletRequest object
     * @param response          The HttpServletResponse object
     * @throws ServletException If an input or output error is detected when the servlet handles the GET request
     * @throws IOException      If an I/O error occurs while handling the request
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Fetch the list of departments from the database
        List<Department> departments = departmentDAO.getAllDepartments();  

        // Set the content type for the HTTP response and get the PrintWriter to write HTML
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Build the HTML structure for displaying the department list
        out.println("<html><head><title>Departments</title></head><body>");
        out.println("<h1>Department List</h1>");
        out.println("<table border='1'>");
        out.println("<tr><th>Department ID</th><th>Department Name</th><th>Location</th></tr>");

        // Loop through the list of departments and add each to the HTML table
        for (Department department : departments) {
            out.println("<tr>");
            out.println("<td>" + department.getDepartmentId() + "</td>");
            out.println("<td>" + department.getDepartmentName() + "</td>");
            out.println("<td>" + department.getLocation() + "</td>");
            out.println("</tr>");
        }

        // End the HTML table and add a link back to the homepage
        out.println("</table>");
        out.println("<br><a href='index.html'>Back to Home</a>");
        out.println("</body></html>");
    }
}
