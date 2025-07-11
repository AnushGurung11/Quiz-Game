package quiz.dao;

import quiz.model.Question;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

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

    public boolean insertQuestions(ArrayList<Question> questions) throws SQLException, ClassNotFoundException {
        Connection conn = DatabaseConnection.connect();
        
        boolean isQuestionInserted = false;
        int rows = 0;
        for (Question each : questions){
            String query = "INSERT INTO questions (question, option_1, option_2,option_3,option_4,correct_option ) VALUES(?,?,?,?,?,?)";

            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString(1, each.getTitle());

            ps.setString(2, each.getOptions_1());
            ps.setString(3, each.getOptions_2());
            ps.setString(4, each.getOptions_3()); 
            ps.setString(5, each.getOptions_4());
            ps.setString(6, String.valueOf(each.getCorrect_index()));

             rows = ps.executeUpdate();

            
        }
        if (rows >0 ){
            isQuestionInserted = true;
        }

        return isQuestionInserted;
    }

    public boolean deletion() throws SQLException, ClassNotFoundException {
        boolean isDeleted = false;
        Connection conn = DatabaseConnection.connect();

        System.out.println("(y/n) Confirm for deletion");
        Scanner input = new Scanner(System.in);
        String option = input.nextLine().toLowerCase();

        if(option.equals("y")){
            String query = "TRUNCATE TABLE `quizdb`.`questions`";
            PreparedStatement ps = conn.prepareStatement(query);
            if(ps.executeUpdate()>0){
                isDeleted = true;
            }
        } else if (option.equals("n")) {
            System.out.println("Canceled");
        }else{
            System.out.println("Enter a valid input");
        }

        return isDeleted;

    }
}
