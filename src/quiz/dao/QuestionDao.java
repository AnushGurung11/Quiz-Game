package quiz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QuestionDao {

    private Connection conn;

    public QuestionDao() throws SQLException, ClassNotFoundException {
        this.conn = DatabaseConnection.connect();
    }
    public ResultSet loadQuestions(){
        ResultSet questionSet = null;
        String query = "Select * from questions";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            questionSet = ps.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return questionSet;
    }
}
