package com.mentorguild.model;

import java.util.UUID;

public class Lesson {
//Fields
    private final Mentor mentor;
    private final String title;
    private final String topic;
    private final String content;
    private final String[] tags;
    private final UUID lessonId;



    //Constructor
  public  Lesson(Mentor mentor, String title, String topic, String content, String[] tags, UUID lessonId){
        this.mentor = mentor;
        this.title = title;
        this.topic = topic;
        this.content = content;
        this.tags = tags;
        this.lessonId = lessonId;
    }

//Getters
    public Mentor getMentor(){
      return mentor;
    }
    public String getTitle(){
        return title;
    }
    public String getTopic(){
        return topic;
    }
    public String getContent(){
        return content;
    }
    public String[] getTags(){
        return tags;
    }
    public UUID getLessonId(){
        return lessonId;
    }
//No setters we don't want people changing things

    //Methods
    public void displayLesson(){
        System.out.printf("Welcome to %s %s I'm your mentor %s \n", title, lessonId, mentor.getName() );
        System.out.printf("Today we will be discussing %s \n", topic);
        printTags();
        System.out.println(content);
    }
    public void printTags(){
      if(tags == null || tags.length == 0){
          System.out.println("Tags: none");
          return;
      }
        System.out.print("Tags: ");
      for(String tag:tags ){
          System.out.print(" #" + tag);

      }
        System.out.println(" ");
    }
}

