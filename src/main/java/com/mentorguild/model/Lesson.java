package com.mentorguild.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;

public class Lesson {
  // Fields
  private UUID lessonId;

  @JsonProperty("mentor")
  private final Mentor mentor;

  @JsonProperty("title")
  private final String title;

  @JsonProperty("topic")
  private final String topic;

  @JsonProperty("content")
  private final String content;

  @JsonProperty("tags")
  private final String[] tags;

  @JsonCreator
  public Lesson(
      @JsonProperty("mentor") Mentor mentor,
      @JsonProperty("title") String title,
      @JsonProperty("topic") String topic,
      @JsonProperty("content") String content,
      @JsonProperty("tags") String[] tags) {
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
    return tags;
  }

  public UUID getLessonId() {
    return lessonId;
  }

  // Setters
  public void setLessonId(UUID lessonId) {
    this.lessonId = lessonId;
  }
}
