package mod05_OYO_02;

/**
 * Represents an Employee entity with attributes such as
 * ID, first name, last name, department ID, and salary.
 * 
 * @author angel
 */
public class Employee {
    private int employeeId;
    private String firstName;
    private String lastName;
    private int departmentId;
    private double salary;

    /**
     * Constructor to create an Employee object without an employee ID.
     * Typically used when inserting a new employee record.
     *
     * @param firstName   The first name of the employee.
     * @param lastName    The last name of the employee.
     * @param departmentId The department ID that the employee belongs to.
     * @param salary      The salary of the employee.
     */
    public Employee(String firstName, String lastName, int departmentId, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.departmentId = departmentId;
        this.salary = salary;
    }

    /**
     * Constructor to create an Employee object with an employee ID.
     * Typically used when retrieving or updating an existing employee record.
     *
     * @param employeeId  The unique ID of the employee.
     * @param firstName   The first name of the employee.
     * @param lastName    The last name of the employee.
     * @param departmentId The department ID that the employee belongs to.
     * @param salary      The salary of the employee.
     */
    public Employee(int employeeId, String firstName, String lastName, int departmentId, double salary) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.departmentId = departmentId;
        this.salary = salary;
    }

    // Getters and Setters

    /**
     * Gets the employee ID.
     * 
     * @return The employee's ID.
     */
    public int getEmployeeId() {
        return employeeId;
    }

    /**
     * Sets the employee ID.
     * 
     * @param employeeId The unique ID of the employee.
     */
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * Gets the first name of the employee.
     * 
     * @return The employee's first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the employee.
     * 
     * @param firstName The first name of the employee.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name of the employee.
     * 
     * @return The employee's last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the employee.
     * 
     * @param lastName The last name of the employee.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the department ID that the employee belongs to.
     * 
     * @return The department ID.
     */
    public int getDepartmentId() {
        return departmentId;
    }

    /**
     * Sets the department ID that the employee belongs to.
     * 
     * @param departmentId The ID of the department.
     */
    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    /**
     * Gets the salary of the employee.
     * 
     * @return The employee's salary.
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Sets the salary of the employee.
     * 
     * @param salary The salary of the employee.
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }
}
