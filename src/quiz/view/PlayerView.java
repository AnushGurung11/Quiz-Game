package quiz.view;

import com.mysql.cj.BindValue;
import quiz.controller.QuestionController;
import quiz.model.Question;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class PlayerView {
    public static void gameStart(){
        Scanner input = new Scanner(System.in);
        QuestionController questionController = new QuestionController();
        System.out.println("1. Start Game");
        System.out.println("2. View ScoreBoard");
        System.out.println("3. Exit");
        int option = Integer.parseInt(input.nextLine());

        if (option > 0){
            if(option == 1){
                questionController.startGame();
            } else if (option == 2) {

            } else if (option == 3) {

            }

        }else {
            System.out.println("Invalid Option");
        }

    }
}
