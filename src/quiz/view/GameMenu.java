package quiz.view;

import com.mysql.cj.log.Log;
import quiz.controller.UserController;

import java.sql.SQLException;
import java.util.Scanner;

public class GameMenu {

    public static void showSignUpMenu() throws SQLException, ClassNotFoundException {
        //Creating an object of the controller


        Scanner scan = new Scanner(System.in);
        System.out.println("Are you ready for the quizzes!!");
        System.out.println("1. Sign up");
        System.out.println("2. Log in");
        System.out.println("3. Exit");

        int option = Integer.parseInt(scan.nextLine());

        if (option == 1){
            SignUpView.signUpView();
        } else if (option == 2) {
            LoginView.loginView();
        }

    }
}
