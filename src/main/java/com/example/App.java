package com.voting;

import java.util.ArrayList;
import java.util.List;

class Voter {
    private String name;
    private int age;
    private String citizenship;
    private boolean hasVoterId;
    private boolean isIdValid;

    public Voter(String name, int age, String citizenship, boolean hasVoterId, boolean isIdValid) {
        this.name = name;
        this.age = age;
        this.citizenship = citizenship;
        this.hasVoterId = hasVoterId;
        this.isIdValid = isIdValid;
    }

    public String checkEligibility() {
        List<String> reasons = new ArrayList<>();

        if (age < 18) {
            reasons.add("Underage (" + age + ")");
        }
        if (citizenship == null || !citizenship.equalsIgnoreCase("Indian")) {
            reasons.add("Non-citizen (" + citizenship + ")");
        }
        if (!hasVoterId) {
            reasons.add("No Voter ID");
        } else if (!isIdValid) {
            reasons.add("Invalid ID");
        }

        if (reasons.isEmpty()) {
            return "Eligible to vote.";
        } else {
            return "Ineligible: " + String.join(", ", reasons);
        }
    }

    public String getName() { return name; }
}

public class App {
    public static void main(String[] args) {
        // Sample voters
        Voter v1 = new Voter("Amit", 25, "Indian", true, true);
        Voter v2 = new Voter("Sara", 16, "Indian", false, false);
        Voter v3 = new Voter("John", 30, "Canadian", true, true);
        
        System.out.println(v1.getName() + ": " + v1.checkEligibility());
        System.out.println(v2.getName() + ": " + v2.checkEligibility());
        System.out.println(v3.getName() + ": " + v3.checkEligibility());
    }
}
