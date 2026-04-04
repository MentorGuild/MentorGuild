package com.mentorguild.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mentorguild.dto.LessonRequest;
import com.mentorguild.model.Lesson;
import com.mentorguild.model.Mentor;
import com.mentorguild.service.LessonService;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(LessonController.class)
class LessonControllerTest {

  @Autowired private MockMvc mockMvc;
  @Autowired private ObjectMapper objectMapper;

  @MockBean private LessonService lessonService;

  @Test
  void displayLesson_WhenLessonExists_ReturnsOkWithLesson() throws Exception {

    UUID lessonId = UUID.randomUUID();

    Mentor mentor = new Mentor("Professor Firewall", "Trust nothing.");
    Lesson lesson =
        new Lesson(
            mentor,
            "Intro to Security",
            "Cybersecurity",
            "Content here",
            new String[] {"security", "basics"});
    lesson.setLessonId(lessonId);

    when(lessonService.getLessonById(lessonId)).thenReturn(lesson);

    mockMvc
        .perform(get("/api/lessons/{id}", lessonId))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.lessonId").value(lessonId.toString()))
        .andExpect(jsonPath("$.title").value("Intro to Security"))
        .andExpect(jsonPath("$.topic").value("Cybersecurity"))
        .andExpect(jsonPath("$.content").value("Content here"))
        .andExpect(jsonPath("$.tags[0]").value("security"));

    verify(lessonService).getLessonById(lessonId);
  }

  @Test
  void displayLesson_WhenLessonNotFound_Returns404() throws Exception {
    UUID missingId = UUID.randomUUID();

    when(lessonService.getLessonById(missingId)).thenReturn(null);

    mockMvc.perform(get("/api/lessons/{id}", missingId)).andExpect(status().isNotFound());

    verify(lessonService).getLessonById(missingId);
  }

  @Test
  void displayLesson_WithInvalidUuid_Returns400() throws Exception {
    mockMvc.perform(get("/api/lessons/{id}", "not-a-uuid")).andExpect(status().isBadRequest());
  }

  @Test
  void createLesson_WithValidPayload_ReturnsCreatedWithCorrectFields() throws Exception {

    UUID mentorId = UUID.randomUUID();

    LessonRequest request =
        new LessonRequest(
            mentorId,
            "Intro to Security",
            "Cybersecurity",
            "Content here",
            new String[] {"security"});

    String jsonPayload = objectMapper.writeValueAsString(request);

    // since service is void, just say "do nothing"
    doNothing().when(lessonService).addLesson(any(Lesson.class));

    mockMvc
        .perform(post("/api/lessons").contentType(MediaType.APPLICATION_JSON).content(jsonPayload))
        .andExpect(status().isCreated())
        .andExpect(jsonPath("$.title").value("Intro to Security"))
        .andExpect(jsonPath("$.topic").value("Cybersecurity"));

    verify(lessonService).addLesson(any(Lesson.class));
  }

  @Test
  void createLesson_WithNoBody_Returns400() throws Exception {
    mockMvc
        .perform(post("/api/lessons").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isBadRequest());
  }
}
