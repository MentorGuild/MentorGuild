package com.mentorguild.controller;

import com.mentorguild.dto.LessonRequest;
import com.mentorguild.dto.LessonResponse;
import com.mentorguild.mapper.LessonMapper;
import com.mentorguild.model.Lesson;
import com.mentorguild.model.Mentor;
import com.mentorguild.service.LessonService;
import java.net.URI;
import java.util.List;
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
  public ResponseEntity<LessonResponse> displayLesson(@PathVariable("id") UUID lessonId) {
    Lesson lesson = lessonService.getLessonById(lessonId);

    if (lesson == null) {
      return ResponseEntity.notFound().build();
    }

    return ResponseEntity.ok(LessonMapper.toLessonResponse(lesson));
  }

  @PostMapping()
  public ResponseEntity<LessonResponse> createLesson(@RequestBody LessonRequest request) {
    // create mentor (temporary for now)
    Mentor mentor = new Mentor("Professor Air Fryer", "Everything is better at 180 degrees.");
    Lesson lesson = LessonMapper.toLesson(request, mentor);
    Lesson savedLesson = lessonService.addLesson(lesson);
    return ResponseEntity.created(URI.create("/api/lessons/" + savedLesson.getLessonId()))
        .body(LessonMapper.toLessonResponse(savedLesson));
  }

  @GetMapping
  public List<LessonResponse> getAllLessons() {
    return lessonService.getAllLessons().stream().map(LessonMapper::toLessonResponse).toList();
  }
}
