JAVA QUIZ

This is a final project of the 5th groupe for the Java course in the "She Goes Tech" program.

The goal was to сonsolidate knowledge of Java in a game form and to gain an experience in Java creating software code.

As a result we have a small program with abilities:
- to customize quizzes by selecting difficulty levels
- to take quizzes with multiple-choice questions
- to view quiz result including questions, that were failed
- to view quiz scores and rating

Java Quiz description:

A quiz program interacts with  MySql database which includes two tables with questions and quiz results stored. Different set of questions can be retrieved from the database, the answer choices are shuffled for each question.
Then the questions and answer choices are presented to the user, and the user's correct answers are being counted as a score. Finally the user's quiz results are retrieved from the database and according to the choice of the user the rating is presented.

Block diagram
![image](https://user-images.githubusercontent.com/78532062/235372602-f8de0c3e-3908-40a5-9610-0c8018d230a3.png)

Data Base structure

![image](https://user-images.githubusercontent.com/78532062/235373640-86ad3227-fb0a-41c6-bc9b-70b726e871c6.png)

Getting Started

To launch the program you have to create a new MySQL Data Base called javaquiz, to create the necessary tables and fields execute script from Final-project-Group-5/SQL/fill_DB_javaquiz.sql
Don't forget to establish a connection to the MySQL database through JDBC.
The program is run from Final-project-Group-5/src/Quiz.java

Built with
- Java + IntelliJ
- MySQL + MySQL Workbench

Contributing

See the list of contributors who participated in this project.
