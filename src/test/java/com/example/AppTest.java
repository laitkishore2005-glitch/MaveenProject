public class AppTest {
    public static void main(String[] args) {
        testAttendanceCalculation();
        testEligibilityLogic();
        System.out.println("All tests passed!");
    }

    public static void testAttendanceCalculation() {
        Student s = new Student("Test User");
        s.markAttendance(true);
        s.markAttendance(false);
        
        // Expected: 1/2 = 50%
        assert s.getPercentage() == 50.0 : "Math Error: Percentage calculation failed.";
        System.out.println("Test 1: Attendance Calculation [PASSED]");
    }

    public static void testEligibilityLogic() {
        Student s = new Student("Candidate");
        
        // Mark 4 classes: 3 Present, 1 Absent (75%)
        s.markAttendance(true);
        s.markAttendance(true);
        s.markAttendance(true);
        s.markAttendance(false);
        
        assert s.getStatus().equals("Eligible") : "Status Error: 75% should be Eligible.";
        
        // Mark 1 more Absent: 3/5 (60%)
        s.markAttendance(false);
        assert s.getStatus().contains("WARNING") : "Status Error: <75% should trigger Warning.";
        
        System.out.println("Test 2: Eligibility & Warning Logic [PASSED]");
    }
}
