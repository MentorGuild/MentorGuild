package com.mentorguild.service;

import com.mentorguild.model.Lesson;
import java.util.List;

public interface LessonService {

    int addLesson(Lesson lesson); //returns generated id
    List<Lesson> getAllLessons();
    Lesson getLessonById (int lessonId); //return null if not found (for now)

}
