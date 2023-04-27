import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class Menu {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

    }


    public static void quiz(Connection conn, String userName, DBInteraction dbInteraction, int whichPart) throws SQLException {
        int number = 0;
        int score = 0;
        int numCorrectAnswers = 0;

        ArrayList<String> wrongAnswers = new ArrayList<>();
        ResultSet resultSet;
        if (whichPart == 0) {
            resultSet = dbInteraction.getQuestions(conn);
        } else {
            resultSet = dbInteraction.getQuestions(conn, whichPart);
        }

        while (resultSet.next()) {
            number++;
            String output = number + " Question : " + resultSet.getString("question");
            System.out.println(output);

            //memorise correct answer
            String correctAnswer = resultSet.getString("correct_answer");

            //Use ArrayList because we can shuffle it
            ArrayList<String> answers = new ArrayList<>();
            answers.add(resultSet.getString("correct_answer"));
            answers.add(resultSet.getString("answer2"));
            answers.add(resultSet.getString("answer3"));
            answers.add(resultSet.getString("answer4"));

            Collections.shuffle(answers);

            Map<String, String> mapAnswers = new HashMap<>();

            //put letters and shuffled answers in Map
            for (int i = 0; i < answers.size(); i++) {
                mapAnswers.put(String.valueOf((char) (i + 65)), answers.get(i));
            }
            //print answers
            for (Map.Entry<String, String> entry : mapAnswers.entrySet()) {
                System.out.println(entry.getKey() + ") " + entry.getValue());
            }
            ;

            //get answer from user
            String usersAnswer = scanner.nextLine().toUpperCase();

            //Compare users answer with correct answer
            if (mapAnswers.containsKey(usersAnswer)) { //Check if Map contains the Key
                if (mapAnswers.get(usersAnswer).equals(correctAnswer)) { //Got correct answer
                    //System.out.println(mapAnswers.get(usersAnswer));
                    score += resultSet.getInt("score");
                    numCorrectAnswers++;
                    //System.out.println(score);
                } else {
                    wrongAnswers.add(resultSet.getString("question"));
                }
                ;
            } else {
                System.out.println("Incorrect value");
            }
        }

        showUserResult(number, numCorrectAnswers, score, wrongAnswers);

    }

    public static void showUserResult(int numQuestions, int numCorrectAnswers, int score, ArrayList<String> wrongAnswers) {
        System.out.println("Quiz result:");
        System.out.println("Total questions: " + numQuestions);
        System.out.println("HEY, you have "  + numCorrectAnswers + " correct answers");
        System.out.println("Your full score is: " + score);

        if (!wrongAnswers.isEmpty()) {
            System.out.println("Here you was wrong:");
            for (int i = 0; i < wrongAnswers.size(); i++) {
                System.out.println((i+1) + ") " + wrongAnswers.get(i));
            }
        } else {
            System.out.println("Congratulations! You answered all questions correctly!");
        }
    }

    /*public static void showRaiting(Connection conn){
        //to show data, that was got from dbInteraction
    }*/
}
