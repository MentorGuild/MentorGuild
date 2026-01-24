package com.mentorguild.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;

public class Lesson {
    //Fields
    private UUID lessonId;

    @JsonProperty("Mentor")
    private final Mentor mentor;

    @JsonProperty("Title")
    private final String title;

    @JsonProperty("Topic")
    private final String topic;

    @JsonProperty("Content")
    private final String content;

    @JsonProperty("Tags")
    private final String[] tags;

    @JsonCreator
    public Lesson(
            @JsonProperty("Mentor") Mentor mentor,
            @JsonProperty("Title") String title,
            @JsonProperty("Topic") String topic,
            @JsonProperty("Content") String content,
            @JsonProperty("Tags") String[] tags
    ) {
        this.mentor = mentor;
        this.title = title;
        this.topic = topic;
        this.content = content;
        this.tags = tags;
    }

    //Getters
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

    //Setters
    public void setLessonId(UUID lessonId) {
        this.lessonId = lessonId;
    }
}

