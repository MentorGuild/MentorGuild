package com.mentorguild.model;

import java.util.UUID;

public class Mentor {
//Private data
    private final String name;
    private final String catchphrase;
    private final UUID idNumber;

//Constructor
public Mentor(UUID idNumber, String name, String catchphrase) {
    this.idNumber = idNumber;
    this.name = name;
    this.catchphrase = catchphrase;
}

//Getters
    public String getName(){
        return this.name;
    }
    public String getCatchphrase(){
        return this.catchphrase;
    }
    public UUID getIdNumber(){
        return this.idNumber;
    }

//No Setters we don't want them changing randomly

//Methods
    public void speak (){
       System.out.println(catchphrase);
    }

}
