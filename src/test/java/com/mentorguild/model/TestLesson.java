package com.mentorguild.model;

public class TestLesson {
  public static void main(String[] args) {

    Mentor mentor = new Mentor("Professor Firewall", "Trust nothing. Verify everything.");

    String[] tags = {"cybersecurity", "networking", "basics"};

    Lesson lesson =
        new Lesson(
            mentor,
            "Intro to Network Security",
            "Cybersecurity",
            """
                        In this lesson, we cover the fundamentals of protecting networks.

                        Network security is the practice of protecting computer networks from unauthorized access, misuse, or disruption.
                        It combines hardware, software, and security policies to ensure that data stays confidential, intact, and available only to those who are allowed to see it.
                        Tools like firewalls, encryption, and intrusion detection systems act as digital gatekeepers, watching traffic and blocking suspicious behavior.
                        What makes network security challenging is that attackers only need one mistake to succeed, while defenders must protect everything at all times.
                        This lesson introduces the core ideas behind network security and starts training you to think critically about how systems can fail—and how to stop that from happening.
                        """,
            tags);

    System.out.println("=== Lesson Test ===");

    // Getter sanity checks
    System.out.println("\n=== Getter Checks ===");
    System.out.println("Lesson ID: " + lesson.getLessonId());
    System.out.println("Title: " + lesson.getTitle());
    System.out.println("Topic: " + lesson.getTopic());
    System.out.println("Mentor Name: " + lesson.getMentor().getName());
    System.out.println("Content: " + lesson.getContent());
  }
}
