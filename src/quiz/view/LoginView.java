package quiz.view;

import quiz.controller.UserController;

import java.sql.SQLException;
import java.util.Scanner;

public class LoginView {
    public static void loginView() throws SQLException, ClassNotFoundException {
        Scanner scan = new Scanner(System.in);
        UserController userController = new UserController();
        System.out.println("User name");
        String userName = scan.nextLine();
        System.out.println("Password");
        String password = scan.nextLine();


        if((!userController.logIn(password,userName))){
            System.out.println("Login Failed");
        }
    }
}

