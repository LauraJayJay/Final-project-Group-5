import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBInteraction {

    public static ResultSet getQuestions (Connection conn)  throws SQLException {
        String sql = "SELECT * FROM questions order by part, score";
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        return resultSet;
    }

    //insert result in quizes table
    //show results from quizes table ordered by fullScore

}
