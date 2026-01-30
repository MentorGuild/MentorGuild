package com.mentorguild.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mentorguild.model.Lesson;
import com.mentorguild.model.Mentor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class LessonControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void createAndRetrieveLesson() throws Exception {
        // 1. Create a lesson via PUT
        Mentor mentor = new Mentor("Professor Firewall", "Trust nothing.");
        Lesson lesson = new Lesson(mentor, "Intro to Security", "Cybersecurity",
                "Content here", new String[]{"security", "basics"});

        String jsonPayload = objectMapper.writeValueAsString(lesson);

        MvcResult createResult = mockMvc.perform(put("/api/lessons/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPayload))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.lessonId").exists())
                .andExpect(jsonPath("$.Title").value("Intro to Security"))
                .andReturn();

        // 2. Extract the generated lesson ID from the response
        String responseJson = createResult.getResponse().getContentAsString();
        Lesson created = objectMapper.readValue(responseJson, Lesson.class);
        UUID lessonId = created.getLessonId();

        // 3. Retrieve the lesson by ID and verify it matches
        mockMvc.perform(get("/api/lessons/{id}", lessonId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.lessonId").value(lessonId.toString()))
                .andExpect(jsonPath("$.Title").value("Intro to Security"))
                .andExpect(jsonPath("$.Topic").value("Cybersecurity"))
                .andExpect(jsonPath("$.Content").value("Content here"))
                .andExpect(jsonPath("$.Tags[0]").value("security"))
                .andExpect(jsonPath("$.Mentor.Name").value("Professor Firewall"));
    }

    @Test
    void getLessonById_WhenNotFound_Returns404() throws Exception {
        UUID nonExistentId = UUID.randomUUID();

        mockMvc.perform(get("/api/lessons/{id}", nonExistentId))
                .andExpect(status().isNotFound());
    }
}
