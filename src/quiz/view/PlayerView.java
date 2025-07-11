package quiz.view;


import quiz.controller.QuestionController;
import quiz.model.Users;

import java.util.Scanner;

public class PlayerView {
    public static void gameStart(Users user){
        Scanner input = new Scanner(System.in);
        QuestionController questionController = new QuestionController();
        System.out.println("1. Start Game");
        System.out.println("2. View ScoreBoard");
        System.out.println("3. Exit");
        int option = Integer.parseInt(input.nextLine());

        if (option > 0){
            if(option == 1){
                questionController.startGame(user);
            } else if (option == 2) {
                System.out.println("Working on score boards");
            } else if (option == 3) {
                System.out.println("Exiting");
            }

        }else {
            System.out.println("Invalid Option");
        }

    }
}
