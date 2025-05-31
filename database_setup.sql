-- Creating the 'departments' table
CREATE TABLE departments (
    department_id INT AUTO_INCREMENT PRIMARY KEY,
    department_name VARCHAR(100) NOT NULL,
    location VARCHAR(100) NOT NULL
);

-- Creating the 'employees' table with a foreign key to 'departments'
CREATE TABLE employees (
    employee_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    department_id INT,
    salary DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (department_id) REFERENCES departments(department_id)
);

-- Insert records into the 'departments' table
INSERT INTO departments (department_name, location) VALUES
('HR', 'New York'),
('Engineering', 'San Francisco'),
('Marketing', 'Chicago'),
('Finance', 'Boston'),
('IT', 'Seattle');

-- Insert records into the 'employees' table
INSERT INTO employees (first_name, last_name, department_id, salary) VALUES
('John', 'Richards', 1, 60000),
('Jane', 'Simons', 2, 75000),
('Alice', 'Smith', 3, 50000),
('Bob', 'Williams', 4, 80000),
('Charlie', 'Davis', 5, 65000);
