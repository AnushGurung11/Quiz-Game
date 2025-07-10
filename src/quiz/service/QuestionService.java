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
                        questionSet.getString("title"),
                        questionSet.getInt("option1"),
                        questionSet.getInt("option2"),
                        questionSet.getInt("option3"),
                        questionSet.getInt("option4"),
                        questionSet.getInt("correctOption"));
                questionsList.add(question);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return questionsList;
    }

}
