package com.mentorguild.model;

import java.util.UUID;

public class Lesson {
  // Fields
  private UUID lessonId;

  private final Mentor mentor;

  private final String title;

  private final String topic;

  private final String content;

  private final String[] tags;

  public Lesson(Mentor mentor, String title, String topic, String content, String[] tags) {
    this.mentor = mentor;
    this.title = title;
    this.topic = topic;
    this.content = content;
    this.tags = tags;
  }

  // Getters
  public Mentor getMentor() {
    return mentor;
  }

  public String getTitle() {
    return title;
  }

  public String getTopic() {
    return topic;
  }

  public String getContent() {
    return content;
  }

  public String[] getTags() {
      return tags != null ? tags.clone() : null;
  }

  public UUID getLessonId() {
    return lessonId;
  }

  // Setters
  public void setLessonId(UUID lessonId) {
    this.lessonId = lessonId;
  }
}
