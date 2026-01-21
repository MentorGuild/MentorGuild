package com.mentorguild.service;

import com.mentorguild.model.Mentor;
import java.util.List;
import java.util.UUID;

public interface MentorService {
    UUID addMentor(Mentor mentor);
    Mentor getMentorById(UUID idNumber);
    List<Mentor> getAllMentors();


}
