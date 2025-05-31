package mod05_OYO_02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class provides methods to interact with the 'departments' table in the database.
 * It supports retrieving all departments and inserting a new department.
 * 
 * @author angel
 */
public class DepartmentDAO {

    // SQL query to retrieve all departments from the database
    private static final String Select_All_Departments = "SELECT department_id, department_name, location FROM departments";
    
    // SQL query to insert a new department into the database
    private static final String Insert_Department_SQL = "INSERT INTO departments (department_name, location) VALUES (?, ?)";

    /**
     * Retrieves all departments from the database.
     * 
     * @return A list of Department objects, each representing a department record
     */
    public List<Department> getAllDepartments() {
        List<Department> departments = new ArrayList<>();
        
        // Establish a connection and execute the query
        try (Connection connection = DatabaseConnectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(Select_All_Departments)) {
             
            // Execute the query and process the result set
            ResultSet rs = preparedStatement.executeQuery();
            
            // Loop through the result set and populate the list of departments
            while (rs.next()) {
                int id = rs.getInt("department_id");
                String name = rs.getString("department_name");
                String location = rs.getString("location");
                departments.add(new Department(id, name, location));
            }
        } catch (SQLException e) {
            // Print the SQL exception if an error occurs
            e.printStackTrace();
        }
        return departments;
    }

    /**
     * Inserts a new department into the database.
     * 
     * @param department The Department object containing the department's name and location
     */
    public void insertDepartment(Department department) {
        
        // Establish a connection and execute the insert statement
        try (Connection connection = DatabaseConnectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(Insert_Department_SQL)) {

            // Set the department's name and location into the SQL insert statement
            preparedStatement.setString(1, department.getDepartmentName());
            preparedStatement.setString(2, department.getLocation());
            
            // Execute the update to insert the department
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // Print the SQL exception if an error occurs
            e.printStackTrace();
        }
    }
}
