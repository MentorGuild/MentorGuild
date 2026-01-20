package com.mentorguild.service;

import com.mentorguild.model.Mentor;
import java.util.Collection;
import java.util.UUID;

public interface MentorService {
    UUID addMentor(Mentor mentor);
    Mentor getMentorById(UUID idNumber);
    Collection<Mentor> getAllMentors();


}
