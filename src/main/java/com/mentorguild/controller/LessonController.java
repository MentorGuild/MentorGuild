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

//Right now (before Spring), your “controller” is basically: a class that accepts requests (from your main method / menu / later HTTP) and delegates to services.
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
//    public Lesson getLessonById(int lessonId){
//        return lessonService.getLessonById(lessonId);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<String> displayLesson(
        @PathVariable("id") int lessonId
    ){
        Lesson lesson = lessonServiceImpl.getLessonById(lessonId);
        if(lesson == null){
            return ResponseEntity.ok("Lesson not found"); // TODO: This shuold be 404
        }
        //lesson.displayLesson();

        return ResponseEntity.ok("Displaying lesson");
    }

    @PutMapping("/create")
    public ResponseEntity<String> createLesson(
            @RequestBody Lesson lesson
    ){
        //store via service
        int newId = lessonServiceImpl.addLesson(lesson);

        return ResponseEntity.ok("Lesson created " + newId);
    }

}
