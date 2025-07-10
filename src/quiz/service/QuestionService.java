package quiz.service;

import quiz.dao.QuestionDao;
import quiz.model.Question;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class QuestionService {
    public ArrayList<Question> getQuestions() {
        ArrayList<Question> questionsList = new ArrayList<>();
        QuestionDao questiondao = null;
        try {
            questiondao = new QuestionDao();
            ResultSet questionSet = questiondao.loadQuestions();
            while(questionSet.next()){
                //TITLE, OPTIONS(1-4), CORRECT OPTION
                Question question = new Question(
                        questionSet.getString("question"),
                        questionSet.getString("option_1"),
                        questionSet.getString("option_2"),
                        questionSet.getString("option_3"),
                        questionSet.getString("option_4"),
                        questionSet.getString("correct_option"));
                questionsList.add(question);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return questionsList;
    }

}
