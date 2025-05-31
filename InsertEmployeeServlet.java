package mod05_OYO_02;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InsertEmployeeServlet.
 * This servlet handles the insertion of new employees into the system.
 * 
 * @author angel
 */
@WebServlet("/insertEmployee")
public class InsertEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Handles the HTTP GET request by generating a form to input employee details.
     *
     * @param request  The HttpServletRequest object that contains the request the client made.
     * @param response The HttpServletResponse object that contains the response the servlet returns.
     * @throws ServletException If the request could not be handled.
     * @throws IOException If an input or output error is detected when the servlet handles the request.
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set the response content type to HTML
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Build the HTML form for inserting a new employee
        out.println("<html><head><title>Insert New Employees</title></head><body>");
        out.println("<h1>Insert Employee</h1>");
        out.println("<form method='POST' action='insertEmployee'>");
        out.println("First Name: <input type='text' name='first_name'><br>");
        out.println("Last Name: <input type='text' name='last_name'><br>");
        out.println("Department ID: <input type='number' name='department_id'><br>");
        out.println("Salary: <input type='number' step='0.01' name='salary'><br>");
        out.println("<input type='submit' value='Insert'>");
        out.println("</form>");
        out.println("<br><a href='index.html'>Back to Home</a>");
        out.println("</body></html>");
    }

    /**
     * Handles the HTTP POST request by inserting the new employee data into the database.
     *
     * @param request  The HttpServletRequest object that contains the request the client made.
     * @param response The HttpServletResponse object that contains the response the servlet returns.
     * @throws ServletException If the request could not be handled.
     * @throws IOException If an input or output error is detected when the servlet handles the request.
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve employee details from the submitted form
        String firstName = request.getParameter("first_name");
        String lastName = request.getParameter("last_name");
        int departmentId = Integer.parseInt(request.getParameter("department_id"));
        double salary = Double.parseDouble(request.getParameter("salary"));

        // Create a new Employee object and save it to the database
        Employee employee = new Employee(firstName, lastName, departmentId, salary);
        EmployeeDAO employeeDAO = new EmployeeDAO();
        employeeDAO.insertEmployee(employee);

        // Redirect to the viewEmployees servlet to display the updated employee list
        response.sendRedirect("viewEmployees");
    }
}
