package quiz.view;

import java.util.Scanner;

public class QuizGame {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Are you ready for the quizzes!!");
        System.out.println("1. Sign up");
        System.out.println("2. Log in");
        System.out.println("3. Exit");

        int option = Integer.parseInt(scan.nextLine());

        if (option == 1){
            System.out.println("User name");
            String userName = scan.nextLine();
            System.out.println("Password");
            String password = scan.nextLine();

        }

    }
}
