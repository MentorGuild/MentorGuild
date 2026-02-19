package com.mentorguild.dto;

import java.util.UUID;

public class MentorResponse {
    private final UUID id;
    private final String name;
    private final String catchphrase;

    public MentorResponse(UUID id, String name, String catchphrase) {
        this.id = id;
        this.name = name;
        this.catchphrase = catchphrase;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCatchphrase() {
        return catchphrase;
    }
}
