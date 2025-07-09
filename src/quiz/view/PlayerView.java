package quiz.view;

import quiz.controller.QuestionController;
import quiz.model.Question;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class PlayerView {
    public static void gameStart(){
        QuestionController questionController = new QuestionController();
        Scanner input = new Scanner(System.in);
        int answer = 0;

        ArrayList<Question> quizList = questionController.getQuestions();

        for (Question question : quizList){
            System.out.println(question.getTitle());
            question.showOptions();
            System.out.println("Choose an Option: ");

            answer = Integer.parseInt(input.nextLine());

            if(question.checkAnswer(answer)){
                System.out.println("Correct");
            }else {
                System.out.println("Incorrect");
            }
        }
    }
}
