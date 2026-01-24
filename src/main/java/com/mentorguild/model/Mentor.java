package com.mentorguild.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;

public class Mentor {
    //Fields
    private final UUID idNumber;

    @JsonProperty("Name")
    private final String name;

    @JsonProperty("Catchphrase")
    private final String catchphrase;

    //Constructor
    @JsonCreator
    public Mentor(
            @JsonProperty("Name") String name,
            @JsonProperty("Catchphrase") String catchphrase
    ) {
        this.idNumber = UUID.randomUUID();

        this.name = name;
        this.catchphrase = catchphrase;
    }

    //Getters
    public String getName() {
        return this.name;
    }

    public String getCatchphrase() {
        return this.catchphrase;
    }

    public UUID getIdNumber() {
        return this.idNumber;
    }
}
