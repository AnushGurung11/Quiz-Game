package quiz.dao;

import quiz.model.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDao {
    public boolean insertUser(Users user) throws SQLException, ClassNotFoundException {
        boolean isUserInserted = false;

        Connection conn = null;
        conn = DataBaseConnection.connect();
        if( conn != null){
            String query = "INSERT INTO user ( 'username', 'password') VALUES (?,?)";
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString(1, user.getUserName());
            ps.setString(2, user.getPassword());
            int rows = ps.executeUpdate();

            if (rows >0 ){
                isUserInserted = true;
            }
        }

        return isUserInserted;

    }
}
