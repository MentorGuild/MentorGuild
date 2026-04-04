package com.mentorguild.controller;

import com.mentorguild.model.Lesson;
import com.mentorguild.service.LessonService;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/lessons")
public class LessonController {
  private final LessonService lessonService;

  // constructor
  @Autowired
  public LessonController(LessonService lessonService) {
    this.lessonService = lessonService;
  }

  @GetMapping("/{id}")
  public ResponseEntity<Lesson> displayLesson(@PathVariable("id") UUID lessonId) {
    Lesson lesson = lessonService.getLessonById(lessonId);

    if (lesson == null) {
      return ResponseEntity.notFound().build();
    }

    return ResponseEntity.ok(lesson);
  }

  @PostMapping("")
  public ResponseEntity<Lesson> createLesson(@RequestBody Lesson lesson) {
    // store via service
    lessonService.addLesson(lesson);

    return ResponseEntity.ok(lesson);
  }
}
