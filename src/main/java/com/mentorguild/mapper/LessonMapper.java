package com.mentorguild.mapper;

import java.util.Objects;

import com.mentorguild.dto.LessonRequest;
import com.mentorguild.dto.LessonResponse;
import com.mentorguild.dto.MentorResponse;
import com.mentorguild.model.Lesson;
import com.mentorguild.model.Mentor;

public class LessonMapper {

    public static MentorResponse toMentorResponse(Mentor mentor) {
        if (mentor == null) {
            return null;
        }
        return new MentorResponse(
                mentor.getIdNumber(),
                mentor.getName(),
                mentor.getCatchphrase()
        );
    }

    public static LessonResponse toLessonResponse(Lesson lesson) {
        if (lesson == null) {
            return null;
        }
        return new LessonResponse(
                lesson.getLessonId(),
                toMentorResponse(lesson.getMentor()),
                lesson.getTitle(),
                lesson.getTopic(),
                lesson.getContent(),
                lesson.getTags()
        );
    }

    public static Lesson toLesson(LessonRequest request, Mentor mentor) {
        if (request == null) {
            return null;
        }
        Objects.requireNonNull(mentor, "Mentor must not be null when creating a Lesson");
        return new Lesson(
                mentor,
                request.getTitle(),
                request.getTopic(),
                request.getContent(),
                request.getTags()
        );
    }
}
