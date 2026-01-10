package com.mentorguild.service.impl;

import com.mentorguild.model.Lesson;

import com.mentorguild.service.LessonService;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


//Gives control over lessons
@Service
public class LessonServiceImpl implements LessonService {

    //this is an example of polymorphism. Same interface, different behavior.
    private final List<Lesson> lessons = new ArrayList<>();

    @Override
    public int addLesson(Lesson lesson){
        lessons.add(lesson);
        return 0; // TODO: Fix this
    }

    @Override
    public List<Lesson> getAllLessons(){
        return lessons;
    }

    @Override
    public Lesson getLessonById(int lessonId){
        for(Lesson lesson: lessons){
            if(lesson.getLessonId() == lessonId){
                return lesson;
            }
        }
        return null;
    }
}
