public class Main {
    public static void main(String[] args) {
        Student student = new Student("Vineela", "S101", "A");
        StudentView view = new StudentView();

        StudentController controller = new StudentController(student, view);
        System.out.println("== Initial Student Data ==");
        controller.updateView();
        controller.setStudentName("Sahithi");
        controller.setStudentGrade("A+");

        System.out.println("\n== Updated Student Data ==");
        controller.updateView();
    }
}

