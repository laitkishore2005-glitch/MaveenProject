import java.util.*;

class Student {
    private String name;
    private int attended;
    private int total;

    public Student(String name) {
        this.name = name;
        this.attended = 0;
        this.total = 0;
    }

    public void markAttendance(boolean isPresent) {
        total++;
        if (isPresent) attended++;
    }

    public double getPercentage() {
        return (total == 0) ? 0.0 : ((double) attended / total) * 100;
    }

    public String getStatus() {
        if (total == 0) return "No Data";
        return (getPercentage() < 75.0) ? "WARNING: Ineligible" : "Eligible";
    }

    public String getName() { return name; }
    public int getAttended() { return attended; }
    public int getTotal() { return total; }
}

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Student> registry = new HashMap<>();

        System.out.println("=== Student Attendance Analyzer ===");

        while (true) {
            System.out.println("\n1. Add Student | 2. Mark Attendance | 3. Report | 4. Exit");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                registry.putIfAbsent(name, new Student(name));
            } else if (choice.equals("2")) {
                registry.values().forEach(s -> {
                    System.out.print("Is " + s.getName() + " present? (y/n): ");
                    s.markAttendance(scanner.nextLine().equalsIgnoreCase("y"));
                });
            } else if (choice.equals("3")) {
                printReport(registry);
            } else if (choice.equals("4")) {
                break;
            }
        }
        scanner.close();
    }

    public static void printReport(Map<String, Student> registry) {
        System.out.printf("%-15s | %-10s | %-10s | %-15s%n", "Name", "Attended", "%", "Status");
        System.out.println("-".repeat(55));
        for (Student s : registry.values()) {
            System.out.printf("%-15s | %-10d | %-9.2f%% | %-15s%n", 
                s.getName(), s.getAttended(), s.getPercentage(), s.getStatus());
        }
    }
}
