package com.mentorguild.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
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
        .andExpect(jsonPath("$.Title").value("Intro to Security"))
        .andExpect(jsonPath("$.Topic").value("Cybersecurity"))
        .andExpect(jsonPath("$.Content").value("Content here"))
        .andExpect(jsonPath("$.Tags[0]").value("security"))
        .andExpect(jsonPath("$.Mentor.Name").value("Professor Firewall"));
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
  void createLesson_WithValidPayload_ReturnsOkWithCorrectFields() throws Exception {
    Mentor mentor = new Mentor("Professor Firewall", "Trust nothing.");
    Lesson lesson =
        new Lesson(
            mentor,
            "Intro to Security",
            "Cybersecurity",
            "Content here",
            new String[] {"security"});
    UUID presetId = UUID.randomUUID();
    lesson.setLessonId(presetId);

    String jsonPayload = objectMapper.writeValueAsString(lesson);

    mockMvc
        .perform(
            put("/api/lessons/create").contentType(MediaType.APPLICATION_JSON).content(jsonPayload))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.lessonId").value(presetId.toString()))
        .andExpect(jsonPath("$.Title").value("Intro to Security"))
        .andExpect(jsonPath("$.Topic").value("Cybersecurity"))
        .andExpect(jsonPath("$.Mentor.Name").value("Professor Firewall"));

    verify(lessonService).addLesson(any(Lesson.class));
  }

  @Test
  void createLesson_WithNoBody_Returns400() throws Exception {
    mockMvc
        .perform(put("/api/lessons/create").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isBadRequest());
  }
}
