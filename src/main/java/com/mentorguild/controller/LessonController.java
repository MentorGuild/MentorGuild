package com.mentorguild.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mentorguild.model.Lesson;
import com.mentorguild.service.LessonService;

import java.util.UUID;

@RestController
@RequestMapping("/api/lessons")
public class LessonController {
    private final LessonService lessonService;

    //constructor
    @Autowired
    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;

    }

    @GetMapping("/{id}")
    public ResponseEntity<Lesson> displayLesson(
            @PathVariable("id") UUID lessonId
    ) {
        Lesson lesson = lessonService.getLessonById(lessonId);

        if (lesson == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(lesson);
    }

    @PutMapping("/create")
    public ResponseEntity<Lesson> createLesson(
            @RequestBody Lesson lesson
    ) {
        //store via service
        lessonService.addLesson(lesson);

        return ResponseEntity.ok(lesson);
    }

}
