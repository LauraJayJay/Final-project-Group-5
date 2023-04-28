import java.sql.*;

public class DBInteraction {

    public static ResultSet getQuestions (Connection conn)  throws SQLException {
        String sql = "SELECT * FROM questions order by part, score";
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        return resultSet;
    }
    public static ResultSet getQuestions (Connection conn, int whichPart)  throws SQLException {

        PreparedStatement statement = conn.prepareStatement("SELECT * from questions WHERE  part = ?");
        statement.setInt(1, whichPart);
        ResultSet resultSet = statement.executeQuery();
        return resultSet;
    }
    //insert result in quizes table

    //DBClass -> methods getting and writing in DB
    public  void insertScore (Connection conn, String username, int fullScore) throws SQLException {
        String sql = "INSERT INTO quizes (username, fullScore) VALUES (?,?)";

        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1, username);
        preparedStatement.setInt(2, fullScore);

        preparedStatement.executeUpdate();

    }
    //show results from quizes table ordered by fullScore

}
