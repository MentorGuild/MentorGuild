package com.mentorguild.dto;

import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class LessonRequest {
    @NotNull
    private UUID mentorId;

    @NotBlank
    private String title;

    @NotBlank
    private String topic;

    @NotBlank
    private String content;

    private String[] tags;

    public LessonRequest() {
    }

    public LessonRequest(UUID mentorId, String title, String topic, String content, String[] tags) {
        this.mentorId = mentorId;
        this.title = title;
        this.topic = topic;
        this.content = content;
        this.tags = tags;
    }

    public UUID getMentorId() {
        return mentorId;
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
}
