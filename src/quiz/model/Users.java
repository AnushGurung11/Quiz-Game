package quiz.model;

public class Users {
//    Setting the attributes

    private String userName ;
    private String password;
    private boolean isGameMaster;

    public Users( String password, String userName) {

        this.password = password;
        this.userName = userName;

    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }



    public boolean isGameMaster() {
        return isGameMaster;
    }



    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setGameMaster(boolean gameMaster) {
        isGameMaster = gameMaster;
    }
}
