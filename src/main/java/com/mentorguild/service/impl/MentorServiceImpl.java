package com.mentorguild.service.impl;

import com.mentorguild.model.Mentor;

import com.mentorguild.repository.MentorRepository;
import com.mentorguild.service.MentorService;
import org.springframework.stereotype.Service;
import java.util.Collection;

@Service
public class MentorServiceImpl implements MentorService {
    private final MentorRepository mentorRepository;

    public MentorServiceImpl(MentorRepository mentorRepository) {
        this.mentorRepository = mentorRepository;
    }
    @Override
    public int addMentor(Mentor mentor) {
        if (mentor == null) {
            throw new IllegalArgumentException("Mentor cannot be null");
        }
        return mentorRepository.save(mentor);
    }

    //example of autoboxing
   @Override
    public Mentor getMentorById(int idNumber){
        return mentorRepository.findById(idNumber).orElse(null);
    }

    @Override
    public Collection<Mentor> getAllMentors(){
        return mentorRepository.findAll();
    }

}
