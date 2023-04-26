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
    //show results from quizes table ordered by fullScore

}
