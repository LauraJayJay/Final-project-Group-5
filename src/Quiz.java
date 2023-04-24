import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Quiz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String dbURL = "jdbc:mysql://localhost:3306/javaquiz";
        // !!!Attention. It's necessary to fill out next two fields with your data
        String username = "root";
        String password = "rooter";

        // Try to connect with DB

        try (Connection conn = DriverManager.getConnection(dbURL,username,password)){
            System.out.println("Connected to db");
            String sql = "SELECT * FROM questions";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                String output = "question : " + resultSet.getString("question") + "\ncorrect answer: " + resultSet.getString("correct_answer");
                System.out.println(output);
            }

        } catch (Exception e){
            System.out.println(e);
        }


        System.out.println("Welcome to the JAVA Quize Game! ");
        System.out.println("What is your name?");
        String userName = scanner.nextLine();

        //try (Connection conn = DriverManager.getConnection(dbURL,username,password)) {
            //connection to DB
       // }

        //ask name
        //menu method:
         /*     - quiz
                - show your results
                - show score of all
                - try again (y/n)
          */

        //loop with questions and answers
        //ask the answer
        //writing the answer in db
        //calc the full score of user
        //at the end writing results in db

    }


    //DBClass -> methods getting and writing in DB


}
