package quiz.controller;

import quiz.dao.UserDao;
import quiz.model.Users;

import java.sql.SQLException;

public class UserController {
    private UserDao userdao = new UserDao();
    public boolean signUp(String username, String password) throws SQLException, ClassNotFoundException {

        boolean isSignedUp = false;
        Users user = new Users(password,username);
        userdao.insertUser(user);
        isSignedUp = userdao.insertUser(user);
        if (isSignedUp){
            return true;
        }else {
            return false;
        }

    }

    public boolean login(String username, String password){

        boolean isLogin = false;
        Users users = new Users(password,username);
        isLogin = userdao.checkUser(users);
        if (isLogin){
            return true;
        }else {
            return false;
        }


    }
}
