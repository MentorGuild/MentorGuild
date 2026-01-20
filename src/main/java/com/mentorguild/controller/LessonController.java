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
import com.mentorguild.service.impl.LessonServiceImpl;
import com.mentorguild.service.impl.MentorServiceImpl;

import java.util.UUID;

@RestController
@RequestMapping("/api/lessons")
public class LessonController {
    private final LessonServiceImpl lessonServiceImpl;
    private  final MentorServiceImpl mentorServiceImpl;
//constructor
    @Autowired
    public LessonController(LessonServiceImpl lessonServiceImpl, MentorServiceImpl mentorServiceImpl){
        this.lessonServiceImpl = lessonServiceImpl;
        this.mentorServiceImpl = mentorServiceImpl;

    }

//Methods
//    public Lesson getLessonById(UUID lessonId){
//        return lessonService.getLessonById(lessonId);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<String> displayLesson(
        @PathVariable("id") UUID lessonId
    ){
        Lesson lesson = lessonServiceImpl.getLessonById(lessonId);
        if(lesson == null){
            return ResponseEntity.ok("Lesson not found"); // TODO: This should be 404
        }
        //lesson.displayLesson();

        return ResponseEntity.ok("Displaying lesson");
    }

    @PutMapping("/create")
    public ResponseEntity<String> createLesson(
            @RequestBody Lesson lesson
    ){
        //store via service
       UUID newId = lessonServiceImpl.addLesson(lesson);

        return ResponseEntity.ok("Lesson created " + newId);
    }

}
