# Use official Java image
FROM eclipse-temurin:17-jdk

# Set working directory
WORKDIR /app

# Copy everything
COPY . .

# Build the app
RUN ./mvnw clean package -DskipTests

# Run the app
CMD ["sh", "-c", "java -jar target/*jar"]