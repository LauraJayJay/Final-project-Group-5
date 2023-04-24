import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class Quiz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String dbURL = "jdbc:mysql://localhost:3306/java35";
        String username = "root";
        String password = "rooter";


        System.out.println("Wellcome to the JAVA Quize Game! ");
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
