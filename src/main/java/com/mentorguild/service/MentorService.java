package com.mentorguild.service;

import com.mentorguild.model.Lesson;
import com.mentorguild.model.Mentor;

import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class MentorService {
   private final Map<Integer, Mentor> mentorsById = new HashMap<>();

   public void addMentor(Mentor mentor){
       if(mentor == null){
           throw new IllegalArgumentException("Mentor cannot be null");
       }
       if(mentorsById.containsKey(mentor.getIdNumber())){
           throw new IllegalArgumentException("Duplicate mentor ID");
       }
       mentorsById.put(mentor.getIdNumber(), mentor);
   }
   //example of autoboxing
   public Mentor getMentorById(int idNumber){
      return mentorsById.get(idNumber);
   }
   public Collection<Mentor> getAllMentors(){
        return mentorsById.values();
   }

}
