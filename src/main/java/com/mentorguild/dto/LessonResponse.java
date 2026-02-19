package com.mentorguild.dto;

import java.util.UUID;

public class LessonResponse {
    private final UUID lessonId;
    private final MentorResponse mentor;
    private final String title;
    private final String topic;
    private final String content;
    private final String[] tags;

    public LessonResponse(UUID lessonId, MentorResponse mentor, String title,
                          String topic, String content, String[] tags) {
        this.lessonId = lessonId;
        this.mentor = mentor;
        this.title = title;
        this.topic = topic;
        this.content = content;
        this.tags = tags != null ? tags.clone() : null;
    }

    public UUID getLessonId() {
        return lessonId;
    }

    public MentorResponse getMentor() {
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
}
