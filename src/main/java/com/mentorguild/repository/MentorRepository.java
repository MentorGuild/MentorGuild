package com.mentorguild.repository;

import com.mentorguild.model.Mentor;

import java.util.List;
import java.util.Optional;

public interface MentorRepository {
    int save(Mentor mentor);              // saves a mentor & returns generated id
    Optional<Mentor> findById(int id); //finds a mentor by ID
    List<Mentor> findAll(); //Retrieves all mentors
}
