public class Main {
    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager(5);
        manager.addEmployee(new Employee(101, "Priya", "Manager", 75000));
        manager.addEmployee(new Employee(102, "Janu", "Developer", 60000));
        manager.addEmployee(new Employee(103, "Kavya", "Tester", 50000));
        System.out.println("== All Employees ==");

        
        manager.displayAllEmployees();
        System.out.println("\n== Search Employee with ID 102 ==");
        Employee found = manager.searchEmployee(102);
        System.out.println(found != null ? "Found: " + found : "Not Found");
        System.out.println("\n== Delete Employee with ID 102 ==");
        boolean deleted = manager.deleteEmployee(102);
        System.out.println(deleted ? "Deleted successfully." : "Delete failed.");

        System.out.println("\n== Employees After Deletion ==");
        manager.displayAllEmployees();
    }
}

