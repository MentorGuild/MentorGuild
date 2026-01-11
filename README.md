# MentorGuild
MentorGuild is a fan-made, educational web platform that teaches technical concepts (starting with cybersecurity) through humorous, chaotic, fandom-inspired mentors. The core idea is to make difficult topics more approachable by having well-known or stylized figures explain concepts using unexpected, entertaining analogies. While the tone is playful and unhinged, the learning goals are serious.
The project is intentionally designed as a learning sandbox for Java, backend development, and object-oriented programming, while also simulating real-world software engineering practices (clean architecture, Git workflows, deployment, collaboration).

## Project Status
This project is under active development and is intended as a learning and experimentation platform.
Features and APIs may change frequently.
## Tech Stack
- Java
- Spring Boot
- Maven
- JUnit
## Prerequisites: 
Java JDK installed
Maven installed
(Optional) You can use Chocolatey on Windows to install Java and Maven


## Running the Application Locally (Manual Testing): 
1. Navigate to project root
2. Clean and build application: mvn clean install
3. Start the Spring Boot application: mvn spring-boot:run
4. Open a browser and visit: http://localhost:8080/api/health
5. To test lesson endpoints (once lessons exist), visit: http://localhost:8080/api/lessons
   If the application is running correctly, the health endpoint should confirm that the server is alive.

## Running Tests with Maven
From the project root directory, run: mvn test
    
This command will:
   1. Compile the project
   2. Run all JUnit tests located under src/test/java
   3. Report any test failures or errors in the terminal
   4. If the command finishes with BUILD SUCCESS, all tests passed.



