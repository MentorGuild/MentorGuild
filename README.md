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
## Prerequisites
- Java JDK 17+ installed
- Maven is **not** required — this project includes the Maven Wrapper (`mvnw`), which auto-downloads the correct Maven version

## Running the Database (Assumes you have Docker Desktop installed)
1. Pull down the Postgres container: `docker pull postgres`
2. Run Postgres: `docker run -d --name postgres -p 5432:5432 -e POSTGRES_PASSWORD=password postgres`

## Running the Application Locally (Manual Testing)
1. Navigate to project root
2. Clean and build application: `./mvnw clean install`
3. Start the Spring Boot application: `./mvnw spring-boot:run`
4. Open a browser and visit: http://localhost:8080/api/health
5. To test lesson endpoints (once lessons exist), visit: http://localhost:8080/api/lessons
   If the application is running correctly, the health endpoint should confirm that the server is alive.

## Swagger Endpoint
1. Build and run the project
2. Go to http://localhost:8080/swagger-ui/index.html

## Running Tests
From the project root directory, run: `./mvnw test`

This will compile the project, run all JUnit tests under `src/test/java`, and report results in the terminal.

## Code Formatting
This project uses [Spotless](https://github.com/diffplug/spotless) with Google Java Format to enforce consistent code style. CI will reject PRs with formatting violations.

Before submitting a PR, run:
```bash
./mvnw spotless:apply
```
This auto-formats all Java files. To check without modifying:
```bash
./mvnw spotless:check
```