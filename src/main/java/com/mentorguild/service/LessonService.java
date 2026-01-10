package com.mentorguild.service;

import com.mentorguild.model.Lesson;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface LessonService {

    int addLesson(Lesson lesson);
    List<Lesson> getAllLessons();
    Lesson getLessonById (int lessonId);

}
