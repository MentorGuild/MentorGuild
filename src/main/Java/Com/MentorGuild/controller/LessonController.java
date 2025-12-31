package main.java.com.mentorguild.controller;

import main.java.com.mentorguild.model.Lesson;
import main.java.com.mentorguild.model.Mentor;
import main.java.com.mentorguild.service.LessonService;
import main.java.com.mentorguild.service.MentorService;

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
    public Lesson getLessonById(int lessonId){
        return lessonService.getLessonById(lessonId);
    }

    public void displayLesson(int lessonId){
        Lesson lesson = lessonService.getLessonById(lessonId);
        if(lesson == null){
            System.out.println("Lesson not found");
            return;
        }
        lesson.displayLesson();
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
