package quiz.controller;

import quiz.dao.UserDao;
import quiz.model.Users;
import quiz.view.GameMasterView;
import quiz.view.PlayerView;

import java.sql.SQLException;

public class UserController {
    private final UserDao userdao = new UserDao();

    public UserController() throws SQLException, ClassNotFoundException {
    }

    public boolean signUp(String username, String password) throws SQLException, ClassNotFoundException {

        boolean isSignedUp ;
        Users user = new Users(password,username);
        userdao.insertUser(user);
        isSignedUp = userdao.insertUser(user);
        if (isSignedUp){
            return true;
        }else {
            return false;
        }

    }

    public boolean logIn(String username, String password) throws SQLException, ClassNotFoundException {
        Users user = userdao.checkUser(username, password);
            if(user != null){
                if(user.isGameMaster()){
                    GameMasterView.show();
                }else{
                    PlayerView.gameStart();
                }
                return true;
            }
        return false;
    }
}





