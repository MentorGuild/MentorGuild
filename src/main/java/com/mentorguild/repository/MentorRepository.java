package com.mentorguild.repository;

import com.mentorguild.model.Mentor;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MentorRepository {
    UUID save(Mentor mentor);              // saves a mentor & returns generated id
    Optional<Mentor> findById(UUID id); //finds a mentor by ID
    List<Mentor> findAll(); //Retrieves all mentors
}
