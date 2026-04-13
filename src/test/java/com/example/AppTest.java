package com.voting;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class AppTest {

    @Test
    public void testEligibleVoter() {
        Voter voter = new Voter("Rahul", 20, "Indian", true, true);
        assertEquals("Eligible to vote.", voter.checkEligibility());
    }

    @Test
    public void testUnderageVoter() {
        Voter voter = new Voter("Priya", 17, "Indian", true, true);
        String result = voter.checkEligibility();
        assertTrue(result.contains("Ineligible") && result.contains("Underage"));
    }

    @Test
    public void testNonCitizen() {
        Voter voter = new Voter("Mike", 25, "German", true, true);
        String result = voter.checkEligibility();
        assertTrue(result.contains("Ineligible") && result.contains("Non-citizen"));
    }

    @Test
    public void testInvalidId() {
        Voter voter = new Voter("Ali", 30, "Indian", true, false);
        String result = voter.checkEligibility();
        assertTrue(result.contains("Ineligible") && result.contains("Invalid ID"));
    }

    @Test
    public void testMultipleFailures() {
        // Underage AND No ID
        Voter voter = new Voter("Kid", 12, "Indian", false, false);
        String result = voter.checkEligibility();
        assertTrue(result.contains("Underage") && result.contains("No Voter ID"));
    }
}
