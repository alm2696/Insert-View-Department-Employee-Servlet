package mod05_OYO_02;

/**
 * This class is used to store department information for the company database.
 * It provides constructors to create department objects with and without
 * an ID and methods to get and set the department's ID, name, and location.
 * 
 * @author angel
 * 
 */
public class Department {
    // Unique identifier for the department
    private int departmentId;
    
    // Name of the department
    private String departmentName;
    
    // Location of the department
    private String location;

    /**
     * Constructor to create a Department without specifying an ID.
     * The ID is typically generated automatically.
     *
     * @param departmentName The name of the department
     * @param location       The location of the department
     */
    public Department(String departmentName, String location) {
        this.departmentName = departmentName;
        this.location = location;
    }

    /**
     * Constructor to create a Department with a specified ID.
     *
     * @param departmentId   The unique ID of the department
     * @param departmentName The name of the department
     * @param location       The location of the department
     */
    public Department(int departmentId, String departmentName, String location) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.location = location;
    }

    /**
     * Returns the department's unique ID.
     *
     * @return The ID of the department
     */
    public int getDepartmentId() {
        return departmentId;
    }

    /**
     * Sets the department's unique ID.
     *
     * @param departmentId The new ID of the department
     */
    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    /**
     * Returns the department's name.
     *
     * @return The name of the department
     */
    public String getDepartmentName() {
        return departmentName;
    }

    /**
     * Sets the department's name.
     *
     * @param departmentName The new name of the department
     */
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    /**
     * Returns the department's location.
     *
     * @return The location of the department
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets the department's location.
     *
     * @param location The new location of the department
     */
    public void setLocation(String location) {
        this.location = location;
    }
}
