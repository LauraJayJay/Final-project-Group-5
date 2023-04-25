import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class Quiz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String dbURL = "jdbc:mysql://localhost:3306/javaquiz";
        // !!!Attention. It's necessary to fill out next two fields with your data
        String username = "root";
        String password = "rooter";
        Menu menu = new Menu();

        System.out.println("Welcome to the JAVA Quize Game! ");
        System.out.println("What is your name?");

        String userName = scanner.nextLine();
        System.out.println("Hello, " + userName + ", let's try to complete JavaQuiz!");


        // Try to connect with DB
        try (Connection conn = DriverManager.getConnection(dbURL, username, password)) {
            System.out.println("Connected to db");

            menu.quiz(conn, userName);

            //Show users result of the quiz

            //Would you like to look at the raiting?
            //menu.showRaiting

        } catch (Exception e) {
            System.out.println(e);
        }
    }


    //DBClass -> methods getting and writing in DB


}
