package com.mentorguild.service.impl;

import com.mentorguild.model.Mentor;

import com.mentorguild.repository.MentorRepository;
import com.mentorguild.service.MentorService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class MentorServiceImpl implements MentorService {
    private final MentorRepository mentorRepository;

    public MentorServiceImpl(MentorRepository mentorRepository) {
        this.mentorRepository = mentorRepository;
    }
    @Override
    public UUID addMentor(Mentor mentor) {
        if (mentor == null) {
            throw new IllegalArgumentException("Mentor cannot be null");
        }
        return mentorRepository.save(mentor);
    }

    //example of autoboxing
   @Override
    public Mentor getMentorById(UUID idNumber){
        return mentorRepository.findById(idNumber).orElse(null);
    }

    @Override
    public List<Mentor> getAllMentors(){
        return mentorRepository.findAll();
    }

}
