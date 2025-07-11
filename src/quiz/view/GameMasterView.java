package quiz.view;

import quiz.controller.QuestionController;

import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class GameMasterView {
    public static void show() throws SQLException, ClassNotFoundException {
        System.out.println("GameMaster View");

        Scanner input = new Scanner(System.in);
        System.out.println("1. Add Questions");
        System.out.println("2. Delete Questions");
        System.out.println("3. Exit");

        int choice = Integer.parseInt(input.nextLine());
        QuestionController questionController = new QuestionController();
        if(choice == 1){
            QuestionController questionCreating = new QuestionController();
            questionCreating.createQuestion();
        } else if (choice == 2) {

            System.out.println("1. Delete all Questions.");
            System.out.println("2. Delete question with title.");
            int option = Integer.parseInt(input.nextLine());

            if(option == 1 ){
                QuestionController deleteControl = new QuestionController();
                deleteControl.deleteAllQuestions();
            } else if (option == 2) {

            }else {
                System.out.println("Enter the correct input");
            }
        }else if (choice == 3 ){
            System.out.println("Exiting");
        }else{
            System.out.println("Enter a valid option");
        }

    }
}
