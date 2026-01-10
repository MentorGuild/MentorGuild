package com.mentorguild.service;

import com.mentorguild.model.Mentor;
import java.util.Collection;

public interface MentorService {
    void addMentor(Mentor mentor);
    Mentor getMentorById(int idNumber);
    Collection<Mentor> getAllMentors();


}
