public class ConfirmationPrinter {
    public static void printConfirmation(StudentRecord rec, int totalStudents) {
        System.out.println("OK: created student " + rec.id);
        System.out.println("Saved. Total students: " + totalStudents);
        System.out.println("CONFIRMATION:");
        System.out.println(rec);
    }
}
