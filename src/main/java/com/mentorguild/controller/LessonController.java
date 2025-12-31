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
import com.mentorguild.model.Mentor;
import com.mentorguild.service.LessonService;
import com.mentorguild.service.MentorService;

//Right now (before Spring), your “controller” is basically: a class that accepts requests (from your main method / menu / later HTTP) and delegates to services.
@RestController
@RequestMapping("/lessons")
public class LessonController {
    private final LessonService lessonService;
    private  final MentorService mentorService;
//constructor
    @Autowired
    public LessonController(LessonService lessonService, MentorService mentorService){
        this.lessonService = lessonService;
        this.mentorService = mentorService;

    }

//Methods
   @GetMapping("/")
   public String health() {
        return "I'm alive!";
   }

    public Lesson getLessonById(int lessonId){
        return lessonService.getLessonById(lessonId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> displayLesson(
        @PathVariable("id") int lessonId
    ){
        Lesson lesson = lessonService.getLessonById(lessonId);
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
        int newId = lessonService.addLesson(lesson);

        return ResponseEntity.ok("Lesson created " + newId);
    }

}
