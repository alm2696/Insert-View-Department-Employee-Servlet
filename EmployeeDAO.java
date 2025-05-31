package mod05_OYO_02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Data Access Object class for handling employee-related
 * database operations. This class contains methods to insert 
 * new employees and retrieve all employees from the database.
 * 
 * @author angel
 */
public class EmployeeDAO {

    // SQL query to select all employee records
    private static final String Select_All_Employees = "SELECT employee_id, first_name, last_name, department_id, salary FROM employees";

    // SQL query to insert a new employee into the database
    private static final String Insert_Employee_SQL = "INSERT INTO employees (first_name, last_name, department_id, salary) VALUES (?, ?, ?, ?)";

    /**
     * Retrieves all employee records from the database.
     *
     * @return A list of Employee objects containing employee data.
     */
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        
        // Establish connection and execute the query to fetch employee data
        try (Connection connection = DatabaseConnectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(Select_All_Employees)) {

            ResultSet rs = preparedStatement.executeQuery();

            // Iterate through the result set and create Employee objects
            while (rs.next()) {
                int id = rs.getInt("employee_id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                int departmentId = rs.getInt("department_id");
                double salary = rs.getDouble("salary");
                
                // Add each employee to the list
                employees.add(new Employee(id, firstName, lastName, departmentId, salary));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    /**
     * Inserts a new employee into the database.
     *
     * @param employee The Employee object to be inserted into the database.
     */
    public void insertEmployee(Employee employee) {
        
        // Establish connection and execute the insert statement
        try (Connection connection = DatabaseConnectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(Insert_Employee_SQL)) {

            // Set parameters for the prepared statement based on the Employee object
            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setInt(3, employee.getDepartmentId());
            preparedStatement.setDouble(4, employee.getSalary());

            // Execute the update query to insert the employee record
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
