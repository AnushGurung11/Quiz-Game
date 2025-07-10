package quiz.controller;


import quiz.dao.QuestionDao;
import quiz.model.Question;
import quiz.service.QuestionService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class QuestionController {
    private final QuestionService questionService = new QuestionService();

    public void startGame(){
        Scanner input = new Scanner(System.in);
        int answer = 0;

        ArrayList<Question> quizList = questionService.getQuestions();
        for(Question question: quizList){
            System.out.println(question.getTitle());
            question.showOptions();
            System.out.println("Choose and Option: ");
            answer = Integer.parseInt(input.nextLine());

            if(question.checkAnswer(answer)){
//                TODO Create a scoreboard object which will invoke for each correct and incorrect answer.
//                TODO  the score board object will keep the record of the user and create a whole new leader board system.
//
                System.out.println("correct");
            }else {
                System.out.println("incorrect");
            }
        }
    }

    public void listQuestions(){
        ArrayList<Question> quizQuestion = questionService.getQuestions();
        int questionIndex = 1;
        for(Question ques: quizQuestion){
            System.out.println(questionIndex +". "+ ques.getTitle());
            ques.showOptions();
            System.out.println("Correct Option: "+ ques.getCorrect_index());
            questionIndex++;
        }
    }

    public void createQuestion(){
//        TODO Create questions
    }

    public void updateQuestion(){
//        TODO Update a single question or whole question set
    }


}

