package com.mentorguild.service;

import com.mentorguild.model.Lesson;
import java.util.List;
import java.util.UUID;

public interface LessonService {

    void addLesson(Lesson lesson); //returns generated id
    List<Lesson> getAllLessons();
    Lesson getLessonById (UUID lessonId); //return null if not found (for now)

}
