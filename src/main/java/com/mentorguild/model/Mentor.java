package com.mentorguild.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;

public class Mentor {
  // Fields
  private final UUID idNumber;

  @JsonProperty("name")
  private final String name;

  @JsonProperty("catchphrase")
  private final String catchphrase;

  // Constructor
  @JsonCreator
  public Mentor(
      @JsonProperty("name") String name, @JsonProperty("catchphrase") String catchphrase) {
    this.idNumber = UUID.randomUUID();

    this.name = name;
    this.catchphrase = catchphrase;
  }

  // Getters
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
