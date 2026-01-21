package com.mentorguild.service.impl;

import com.mentorguild.model.Lesson;

import com.mentorguild.repository.LessonRepository;
import com.mentorguild.service.LessonService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

//Gives control over lessons
@Service
public class LessonServiceImpl implements LessonService {

    private final LessonRepository lessonRepository;

//Constructor injection (Spring will provide InMemoryLessonRepository automatically)
    public LessonServiceImpl(LessonRepository lessonRepository){
        this.lessonRepository = lessonRepository;
    }

    @Override
    public UUID addLesson(Lesson lesson){
        return lessonRepository.save(lesson); //storage delegated to repository
    }

    @Override
    public List<Lesson> getAllLessons(){
        return lessonRepository.findAll();
    }

    @Override
    public Lesson getLessonById(UUID lessonId){
        //delegate; return null for now (better: throw exception later)
        return lessonRepository.findById(lessonId).orElse(null);
    }
}
