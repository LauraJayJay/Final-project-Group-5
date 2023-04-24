CREATE TABLE questions (
	questionID int AUTO_INCREMENT PRIMARY KEY,
    question varchar(1000) NOT NULL,
    score int NOT NULL,
    part int NOT NULL,
    correct_answer varchar(500) NOT NULL,
    answer2 varchar(500),
    answer3 varchar(500),
    answer4 varchar(500)
);

-- execute if you need to delete a table
-- DROP TABLE IF EXISTS questions;

CREATE TABLE quizes(
	quizeId int AUTO_INCREMENT PRIMARY KEY,
    username varchar(100),
    fullScore int
);

-- Insert data in questions table
INSERT INTO questions (question, score, part, correct_answer, answer2, answer3, answer4 )
	VALUES ('Which keyword is used to return a value inside a method?', 1, 1, 'return', 'get', 'break', 'void'),
			('What is the correct way to create an object called myObj of MyClass?', 2, 2, 'MyClass myObj = new MyClass();', 'class MyClass = new myObj();', 'class myObj  = new(MyClass);', 'new myObj  = MyClass;'),
            ('What is an exception in Java?',3 , 1, 'A runtime error that interrupts normal program flow', 'A syntax error in the code', 'A warning message from the compiler', 'An error that occurs when the program is compiled'),
            ('What is the difference between an abstract class and an interface in Java?', 3, 2, 'An abstract class can have concrete methods, while an interface cannot', 'An abstract class can have constructors, while an interface cannot', 'An interface can have instance variables, while an abstract class cannot', 'There is no difference'),
            ('Which of these keywords are used for the block to be examined for exceptions?', 2, 2, 'try', 'check', 'throw', 'catch'),
            ('What is the numerical range of a char data type in Java?', 3, 1, '0 to 65535', '0 to 256', '-128 to 127', '0 to 32767'),
            ('What is the purpose of the "public static void main(String[] args)" method in a Java program?', 2, 1, 'It is the entry point for the program','It is used to declare a variable','It is used to print output to the console','It is used to declare a class'),
            ('What is the purpose of the "if" statement in Java?', 1, 1, 'It is used to test a condition and execute code based on the result', 'It is used to declare a loop', 'It is used to declare a method', 'It is used to define a variable'),
            ('Which of the following is a principle of object-oriented programming?', 1, 2, 'Inheritance', 'Conditionals', 'Loops', 'Functions'),
            ('What is a constructor in OOP?', 2, 2, 'A method that is automatically called when an object is created', 'A method that is used to modify an objects properties', 'A method that is used to access an objects properties', 'A method that is used to delete an object from memory');

-- Insert in quizes table
INSERT INTO quizes (username, fullScore)
	VALUES ('Freddie Mercury', 100), ('Bryan May', 99);
 
 
 /*
 Add External Library for DB connection: 
 File -> Project structure -> Modules -> Dependencies (tab) -> + -> JARs or directories -> (find file mysql-connector-java-8.2.25.jar 
 on your computer (the path may be like "C:\Program Files (x86)\MySQL\Connector J 8.0\mysql-connector-java-8.0.25.jar")) -> Ok -> Check the added file -> Apply -> Ok
 or you can see a lesson 04/17 from 00:40:25 to 00:46:48
 */