import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Quiz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String dbURL = "jdbc:mysql://localhost:3306/javaquiz";
        // !!!Attention. It's necessary to fill out next two fields with your data
        String username = "";
        String password = "";
        Menu menu = new Menu();

        System.out.println("Welcome to the JAVA Quiz Game! ");
        System.out.println("What is your name?");

        String userName = scanner.nextLine();
        System.out.println("Hello, " + userName + ", let's try to complete JavaQuiz!");
        System.out.println("Please choose a part of Java course: \n1 - first part of a course, \n2 - second part part of a course, \n0 - all course");
        int part = scanner.nextInt();
        if (part != 1 && part != 2){
            part = 0;
        }

         DBInteraction dbInteraction = new DBInteraction();

        // Try to connect with DB
        try (Connection conn = DriverManager.getConnection(dbURL, username, password)) {

            menu.quiz(conn, userName, dbInteraction, part);

            scanner.nextLine();
            System.out.println("Would you like to see the rating?(y/n)");
            String show = scanner.nextLine();
            if (show.charAt(0) ==('y')) {
                System.out.println("__________________________________");
                menu.showRating(conn, dbInteraction, userName);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }



}
