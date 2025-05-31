package mod05_OYO_02;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This servlet provides a form to input department details and submits them to the database.
 * It handles both GET requests to display the form and POST requests to insert the department data.
 * 
 * @author angel
 */
@WebServlet("/insertDepartment")
public class InsertDepartmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Handles GET requests to display the form for inserting a new department.
     *
     * @param request           The HttpServletRequest object
     * @param response          The HttpServletResponse object
     * @throws ServletException If an input or output error is detected when the servlet handles the GET request
     * @throws IOException      If an I/O error occurs while handling the request
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set the content type to HTML and obtain the PrintWriter for generating the response
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Build the HTML form for inserting a new department
        out.println("<html><head><title>Insert New Department</title></head><body>");
        out.println("<h1>Insert Department</h1>");
        out.println("<form method='POST' action='insertDepartment'>");
        out.println("Name: <input type='text' name='department_name'><br>");
        out.println("Location: <input type='text' name='location'><br>");
        out.println("<input type='submit' value='Insert'>");
        out.println("</form>");
        out.println("<br><a href='index.html'>Back to Home</a>");
        out.println("</body></html>");
    }

    /**
     * Handles POST requests to insert a new department into the database.
     *
     * @param request           The HttpServletRequest object
     * @param response          The HttpServletResponse object
     * @throws ServletException If an input or output error is detected when the servlet handles the POST request
     * @throws IOException      If an I/O error occurs while handling the request
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form parameters for department name and location
        String name = request.getParameter("department_name");
        String location = request.getParameter("location");

        // Create a Department object with the retrieved values
        Department department = new Department(name, location);

        // Insert the new department into the database using DepartmentDAO
        DepartmentDAO departmentDAO = new DepartmentDAO();
        departmentDAO.insertDepartment(department);

        // Redirect to the department list page after successful insertion
        response.sendRedirect("viewDepartments");
    }
}
