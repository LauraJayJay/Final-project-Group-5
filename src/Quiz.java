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
        String username = "root";
        String password = "root12345";
        Menu menu = new Menu();

        System.out.println("Welcome to the JAVA Quiz Game! ");
        System.out.println("What is your name?");

        String userName = scanner.nextLine();
        System.out.println("Hello, " + userName + ", let's try to complete JavaQuiz!");
        System.out.println("Please choose a themes of a quiz: \n1 - first part of a course, \n2 - second part part of a course, \n0 - all course");
        int part = scanner.nextInt();

         DBInteraction dbInteraction = new DBInteraction();

        // Try to connect with DB
        try (Connection conn = DriverManager.getConnection(dbURL, username, password)) {
            System.out.println("Connected to db");

            menu.quiz(conn, userName, dbInteraction, part);

            //Show users result of the quiz

            //Would you like to look at the raiting?
            //menu.showRaiting

        } catch (Exception e) {
            System.out.println(e);
        }
    }


    //DBClass -> methods getting and writing in DB
    public static void insertScore (Connection conn, String username, int fullScore) throws SQLException {
        String sql = "INSERT INTO quizes (username, fullScore) VALUES (?,?)";

        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1, username);
        preparedStatement.setInt(2, fullScore);

        preparedStatement.executeUpdate();

    }

}
