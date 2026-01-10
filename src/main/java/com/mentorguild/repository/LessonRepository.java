package com.mentorguild.repository;
import com.mentorguild.model.Lesson;

import java.util.Optional;
import java.util.List;
//Interface defines what not how
public interface LessonRepository {
    int save(Lesson lesson);              // saves a lesson & returns generated id
    Optional<Lesson> findById(int id); //finds a lesson by ID
    List<Lesson> findAll(); //Retrieves all lessons
}


