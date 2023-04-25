import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class Menu {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

    }


    public static void quiz(Connection conn, String userName) throws SQLException {
        int number = 0;
        int score = 0;

        //instead of this should be method what make request in DB and return ResultSet with data
        String sql = "SELECT * FROM questions";
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);


        while (resultSet.next()) {
            number ++;
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
            for(int i = 0; i<answers.size(); i++){
                mapAnswers.put(String.valueOf((char) (i+65)) ,answers.get(i));
            }
            //print answers
            for(Map.Entry<String, String> entry: mapAnswers.entrySet()){
                System.out.println(entry.getKey() + ") " + entry.getValue());
            };

            //get answer from user
            String usersAnswer = scanner.nextLine().toUpperCase();

            //Compare users answer with correct answer
            if (mapAnswers.containsKey(usersAnswer)) { //Check if Map contains the Key
                if (mapAnswers.get(usersAnswer).equals(correctAnswer)) { //Got correct answer
                    //System.out.println(mapAnswers.get(usersAnswer));
                    score += resultSet.getInt("score");
                    //System.out.println(score);
                };
            }else {
                System.out.println("Incorrect value");
            };

        }
        // method that record the result in DB in table quizes (userName, score)

        //It's just for checking, should be method
        System.out.println("Your full score " + score);
    }

    /*public static void showRaiting(Connection conn){
        //to show data, that was got from dbInteraction
    }*/
}
