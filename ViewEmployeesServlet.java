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
 * Servlet implementation class ViewEmployeesServlet.
 * This servlet handles requests to view all employees in the system.
 * 
 * @author angel
 */
@WebServlet("/viewEmployees")
public class ViewEmployeesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeDAO employeeDAO;

    /**
     * Initializes the servlet by creating an instance of EmployeeDAO to interact with the database.
     */
    public void init() {
        employeeDAO = new EmployeeDAO();
    }

    /**
     * Handles GET requests by fetching the list of all employees and displaying them in an HTML table.
     *
     * @param request  The HttpServletRequest object that contains the request the client made.
     * @param response The HttpServletResponse object that contains the response the servlet returns.
     * @throws ServletException If the request could not be handled.
     * @throws IOException If an input or output error is detected when the servlet handles the request.
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Fetch the latest list of employees from the database
		List<Employee> employees = employeeDAO.getAllEmployees();  

        // Set the response content type to HTML and initialize a PrintWriter to build the response
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Start building the HTML structure for the employee list display
        out.println("<html><head><title>Employees</title></head><body>");
        out.println("<h1>Employees</h1>");
        out.println("<table border='1'>");
        out.println("<tr><th>Employee ID</th><th>First Name</th><th>Last Name</th><th>Department ID</th><th>Salary</th></tr>");

        // Loop through the list of employees and generate a row for each
        for (Employee employee : employees) {
            out.println("<tr>");
            out.println("<td>" + employee.getEmployeeId() + "</td>");
            out.println("<td>" + employee.getFirstName() + "</td>");
            out.println("<td>" + employee.getLastName() + "</td>");
            out.println("<td>" + employee.getDepartmentId() + "</td>");
            out.println("<td>" + employee.getSalary() + "</td>");
            out.println("</tr>");
        }

        // Close the table and provide a link to return to the homepage
        out.println("</table>");
        out.println("<br><a href='index.html'>Back to Home</a>");
        out.println("</body></html>");
    }
}
