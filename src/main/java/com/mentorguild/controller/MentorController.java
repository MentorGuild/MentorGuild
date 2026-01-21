package com.mentorguild.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mentorguild.model.Mentor;
import com.mentorguild.service.MentorService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/mentors")
public class MentorController {
    private final MentorService mentorService;

@Autowired
public MentorController(MentorService mentorService){
    this.mentorService = mentorService;
}

    //GET /api/mentors
@GetMapping("")
    public ResponseEntity<List<Mentor>> getAllMentors(){
    List<Mentor> mentors = mentorService.getAllMentors();
    return ResponseEntity.ok(mentors);
}
    @GetMapping("/{id}")
    public ResponseEntity<Mentor> getMentorById(@PathVariable UUID id) {
        Mentor mentor = mentorService.getMentorById(id);
        if (mentor == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(mentor);
    }

}
