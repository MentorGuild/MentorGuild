package com.mentorguild.service.impl;

import com.mentorguild.model.Lesson;
import com.mentorguild.repository.LessonRepository;
import com.mentorguild.service.LessonService;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

// Gives control over lessons
@Service
public class LessonServiceImpl implements LessonService {

  private final LessonRepository lessonRepository;

  // Constructor injection (Spring will provide InMemoryLessonRepository automatically)
  public LessonServiceImpl(LessonRepository lessonRepository) {
    this.lessonRepository = lessonRepository;
  }

  @Override
  public Lesson addLesson(Lesson lesson) {
     lessonRepository.save(lesson); // repository assigns UUID
      return lesson;
  }

  @Override
  public List<Lesson> getAllLessons() {
    return lessonRepository.findAll();
  }

  @Override
  public Lesson getLessonById(UUID lessonId) {
    // delegate; return null for now (better: throw exception later)
    return lessonRepository.findById(lessonId).orElse(null);
  }
}
