class Employee {
    private int employeeId;
    private String name;
    private String position;
    private double salary;

    public Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee ID: " + employeeId + ", Name: " + name + ", Position: " + position + ", Salary: $" + salary;
    }
}

class EmployeeManagementSystem {
    private Employee[] employees;
    private int size;
    private int capacity;

    public EmployeeManagementSystem(int capacity) {
        this.capacity = capacity;
        this.employees = new Employee[capacity];
        this.size = 0;
    }

    public boolean addEmployee(Employee employee) {
        if (size >= capacity) {
            System.out.println("Employee array is full. Cannot add more employees.");
            return false;
        }
        employees[size] = employee;
        size++;
        return true;
    }

    public Employee searchEmployee(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                return employees[i];
            }
        }
        return null;
    }

    public void traverseEmployees() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    public boolean deleteEmployee(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                for (int j = i; j < size - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[size - 1] = null;
                size--;
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        EmployeeManagementSystem system = new EmployeeManagementSystem(5);

        Employee emp1 = new Employee(1, "John Doe", "Developer", 75000);
        Employee emp2 = new Employee(2, "Jane Smith", "Manager", 85000);
        Employee emp3 = new Employee(3, "Emily Davis", "Designer", 65000);

        system.addEmployee(emp1);
        system.addEmployee(emp2);
        system.addEmployee(emp3);

        System.out.println("Traversing employees:");
        system.traverseEmployees();

        System.out.println("\nSearching for employee with ID 2:");
        Employee searchedEmployee = system.searchEmployee(2);
        if (searchedEmployee != null) {
            System.out.println("Found: " + searchedEmployee);
        } else {
            System.out.println("Employee not found.");
        }

        System.out.println("\nDeleting employee with ID 1:");
        if (system.deleteEmployee(1)) {
            System.out.println("Employee deleted successfully.");
        } else {
            System.out.println("Employee not found.");
        }

        System.out.println("\nTraversing employees:");
        system.traverseEmployees();
    }
}
