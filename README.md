## Spring Boot Quiz Application - Getting Started 🚀💻🚀

This document provides instructions on how to clone, build, and run a Spring Boot quiz application.

## Action Status
![Build-status](https://github.com/Bansikah/quiz-app-spring-boot/actions/workflows/maven.yaml/badge.svg?event=push)

## Prerequisites:

Java 11 or later [link](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
A command prompt or terminal window
Option 1: Cloning the Repository and Building the JAR (Recommended):

## Clone the Repository:

Open a terminal window and navigate to your desired project directory. Use Git to clone the repository using the following command:

# Bash
```
git clone https://github.com/Bansikah/quiz-app-spring-boot.git
```
Use code with caution.
Replace your-username with your actual GitHub username.

## Build the JAR:

Navigate to the project directory:

Bash
cd quiz-app-spring-boot
Use code with caution.
Run the following command to build the application using Maven:

## Bash
```
mvn clean package
```
Use code with caution.
This command will download dependencies, build the application, and create a JAR file (typically named quizapp-0.0.1-SNAPSHOT.jar) in the target directory.

## Option 2: Downloading a Pre-built JAR (if available):

If a pre-built JAR file is available (check project releases on GitHub), you can download it directly and skip the build step.
Running the Application from the JAR:

Open a terminal window and navigate to the directory containing the JAR file.

Run the application using the following command:

# Bash
```
java -jar spring-boot-quiz-app.jar
```
Use code with caution.
Replace quizapp-0.0.1-SNAPSHOT.jar with the actual filename of your JAR file if it differs.

This command will launch the application using the Java runtime environment. You should see logs indicating the application's status, and it will typically start on the default port (usually 8080) but we have 8081.

Accessing the Application:

Once the application starts successfully, you can access the quiz application in your web browser by visiting:
```
http://localhost:8081
```
## Additional Notes:

The application might require configuration for data sources (e.g., databases) depending on its implementation. Refer to the application's code or configuration files for specific instructions.
This documentation is intended as a general guide. You might find more detailed instructions or configuration options within the project itself.
Contributing:

Feel free to fork the repository on GitHub and contribute to the project. Pull requests are welcome!

## License:

This application is not licensed, it just a simple application in spring boot.
