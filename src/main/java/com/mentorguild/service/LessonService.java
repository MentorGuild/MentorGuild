package com.mentorguild.service;

import com.mentorguild.model.Lesson;
import com.mentorguild.model.Mentor;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


//Gives control over lessons
@Service
public class LessonService {

    //this is an example of polymorphism. Same interface, different behavior.
   private final List<Lesson> lessons = new ArrayList<>();

    public int addLesson(Lesson lesson){
        lessons.add(lesson);
        return 0; // TODO: Fix this
    }
    public List<Lesson> getAllLessons(){
        return lessons;
    }
    public Lesson getLessonById(int lessonId){
        for(Lesson lesson: lessons){
        if(lesson.getLessonId() == lessonId){
            return lesson;
        }
        }
        return null;
    }
}
