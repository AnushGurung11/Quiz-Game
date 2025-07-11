package quiz.controller;


import quiz.dao.QuestionDao;
import quiz.model.Question;
import quiz.model.Users;
import quiz.service.QuestionService;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class QuestionController {
    private final QuestionService questionService = new QuestionService();

    public void  startGame(Users user){
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

    public void createQuestion() throws SQLException, ClassNotFoundException {
        Scanner input = new Scanner(System.in);

//        Creating an array list for the question objects
        ArrayList<Question> questions = new ArrayList<>();

        boolean isLooping = true;
        while (isLooping){
            System.out.println("Enter the question : ");
            String question = input.nextLine();
            System.out.println("Enter the option 1 : ");
            String option_1 = input.nextLine();
            System.out.println("Enter the option 2 : ");
            String option_2 = input.nextLine();
            System.out.println("Enter the option 3 : ");
            String option_3 = input.nextLine();
            System.out.println("Enter the option 4 : ");
            String option_4 = input.nextLine();
            System.out.println("Enter the correct option number (1,2,3,4)");
            String correctOption = input.nextLine();

//            creating a question object
            Question created = new Question(question, option_1,option_2,option_3,option_4,correctOption);

            questions.add(created);


            System.out.println("Add another question(y/n)");
            String choice = input.nextLine().toLowerCase();

            if (choice.equals("y")){
                continue;
            }else {
                isLooping = false;
            }

        }
        QuestionDao questionDao = new QuestionDao();
        if(questionDao.insertQuestions(questions)){
            System.out.println("Questions Added.");
        }else {
            System.out.println("Connection failed");
        }


    }

    public void deleteAllQuestions() throws SQLException, ClassNotFoundException {
        QuestionDao questionDao = new QuestionDao();
        if(questionDao.deletion()){
            System.out.println("All questions deleted");
        }else{
            System.out.println("Deletion Cancelled");
        }
    }


}

