package com.mentorguild.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {
  @GetMapping("/api")
  public String home() {
    return "MentorGuild API is running 🚀";
  }
}
