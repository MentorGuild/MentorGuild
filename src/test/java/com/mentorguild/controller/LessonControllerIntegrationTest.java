package com.mentorguild.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mentorguild.dto.LessonRequest;
import com.mentorguild.dto.LessonResponse;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@SpringBootTest // loads full Spring context (real controller + service + repo)
@AutoConfigureMockMvc // enables MockMvc for HTTP testing
class LessonControllerIntegrationTest {

  @Autowired private MockMvc mockMvc; // used to simulate HTTP requests

  @Autowired private ObjectMapper objectMapper; // converts objects <-> JSON

  @Test
  void createAndRetrieveLesson() throws Exception {

    // =========================
    // 1. CREATE LESSON (POST)
    // =========================

    // Create request DTO (mimics frontend API payload)
    LessonRequest request =
        new LessonRequest(
            UUID.randomUUID(),
            "Intro to Security",
            "Cybersecurity",
            "Content here",
            new String[] {"security", "basics"});

    // Convert Java object -> JSON string
    String jsonPayload = objectMapper.writeValueAsString(request);

    // Perform POST request to create lesson
    MvcResult createResult =
        mockMvc
            .perform(
                post("/api/lessons").contentType(MediaType.APPLICATION_JSON).content(jsonPayload))
            .andExpect(status().isCreated()) // should return 201
            .andExpect(jsonPath("$.lessonId").exists()) // backend generates ID
            .andExpect(jsonPath("$.title").value("Intro to Security"))
            .andReturn();

    // =========================
    // 2. EXTRACT ID FROM RESPONSE
    // =========================

    // Get raw JSON response
    String responseJson = createResult.getResponse().getContentAsString();

    // Convert JSON -> Lesson object
    LessonResponse created = objectMapper.readValue(responseJson, LessonResponse.class);

    // Extract generated ID
    UUID lessonId = created.getLessonId();

    // =========================
    // 3. FETCH LESSON (GET)
    // =========================

    mockMvc
        .perform(get("/api/lessons/{id}", lessonId))
        .andExpect(status().isOk()) // ✅ FIX: was isCreated() ❌
        .andExpect(jsonPath("$.lessonId").value(lessonId.toString()))
        .andExpect(jsonPath("$.title").value("Intro to Security"))
        .andExpect(jsonPath("$.topic").value("Cybersecurity"))
        .andExpect(jsonPath("$.content").value("Content here"))
        .andExpect(jsonPath("$.tags[0]").value("security"))
        .andExpect(jsonPath("$.mentor.name").exists());
  }

  @Test
  void getLessonById_WhenNotFound_Returns404() throws Exception {

    // Generate random ID that does NOT exist
    UUID nonExistentId = UUID.randomUUID();

    // Expect 404 when lesson not found
    mockMvc.perform(get("/api/lessons/{id}", nonExistentId)).andExpect(status().isNotFound());
  }
}
