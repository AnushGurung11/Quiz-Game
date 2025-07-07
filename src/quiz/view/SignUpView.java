package quiz.view;

import quiz.controller.UserController;

import java.sql.SQLException;
import java.util.Scanner;

public class SignUpView {
    public static void signUpView() throws SQLException, ClassNotFoundException {
        Scanner scan = new Scanner(System.in);
        UserController userController = new UserController();
        System.out.println("User name");
        String userName = scan.nextLine();
        System.out.println("Password");
        String password = scan.nextLine();

        if((userController.signUp(password,userName))){
            System.out.println("Successfully Signed in");
        }else {
            System.out.println(" Signed in Unsuccessful");

        }

    }
}
