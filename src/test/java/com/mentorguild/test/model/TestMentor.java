package com.mentorguild.test.model;

import com.mentorguild.model.Mentor;

public class TestMentor {
  public static void main(String[] args) {
    Mentor mentor = new Mentor("Chaos Goblin", "Security is just vibes with paperwork.");

    // Basic getter tests
    System.out.println("=== Mentor Test ===");
    System.out.println("ID: " + mentor.getIdNumber());
    System.out.println("Name: " + mentor.getName());
    System.out.println("Catchphrase:");

    // Expected output check
    System.out.println("\nExpected:");
    System.out.println("ID: 1");
    System.out.println("Name: Chaos Goblin");
    System.out.println("Catchphrase:");
    System.out.println("Security is just vibes with paperwork.");
  }
}
