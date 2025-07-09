package quiz.dao;

import quiz.model.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    private Connection conn = null;
    public UserDao() throws SQLException, ClassNotFoundException {
        conn = DatabaseConnection.connect();
    }
    public boolean insertUser(Users user) throws SQLException, ClassNotFoundException {
        boolean isUserInserted = false;

        if( conn != null){
            String query = "INSERT INTO `user` (username, password,isgamemaster) VALUES (?,?,?)";
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString(1, user.getUserName());

            ps.setString(2, user.getPassword());
            ps.setBoolean(3, false);

            int rows = ps.executeUpdate();

            if (rows >0 ){
                isUserInserted = true;
            }
        }

        return isUserInserted;

    }
    public Users checkUser(String username, String password) throws SQLException, ClassNotFoundException {
        Users user = new Users();
        Connection conn =  DatabaseConnection.connect();


            String query = "Select username, password, isGameMaster from user where username = ? and password = ?";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1,username);
            ps.setString(2,password);
            ResultSet userSet = ps.executeQuery();
            while(userSet.next()){
                user.setUsername(userSet.getString("username"));
                user.setPassword(userSet.getString("password"));
                user.setGameMaster(userSet.getBoolean("isgamemaster"));
            }
            return user;

}
}

