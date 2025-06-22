public class Main {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        manager.addTask(1, "Design UI", "Pending");
        manager.addTask(2, "Implement backend", "In Progress");
        manager.addTask(3, "Write tests", "Pending");

        System.out.println("== All Tasks ==");
        manager.displayTasks();

        
        System.out.println("\n== Search Task ID 2 ==");
        Task found = manager.searchTask(2);
        System.out.println(found != null ? "Found: " + found : "Not Found");

        System.out.println("\n== Delete Task ID 2 ==");
        boolean deleted = manager.deleteTask(2);
        System.out.println(deleted ? "Deleted successfully." : "Delete failed.");

        System.out.println("\n== Tasks After Deletion ==");
        manager.displayTasks();
    }
}

