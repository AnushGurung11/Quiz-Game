package quiz.controller;


import quiz.dao.QuestionDao;
import quiz.model.Question;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class QuestionController {
    public ArrayList<Question> getQuestions() {
        ArrayList<Question> questionsList = new ArrayList<>();

        try {
            QuestionDao questiondao = new QuestionDao();
            ResultSet questionSet = questiondao.loadQuestions();
            while(questionSet.next()){
                //TITLE, OPTIONS(1-4), CORRECT OPTION
                Question question = new Question(
                        questionSet.getString("question"),
                        questionSet.getInt("option_1"),
                        questionSet.getInt("option_2"),
                        questionSet.getInt("option_3"),
                        questionSet.getInt("option_4"),
                        questionSet.getInt("correct_option"));
                questionsList.add(question);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return questionsList;
    }
}

