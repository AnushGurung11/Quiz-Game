package quiz.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    private static String dbName = "quizdb";
    private static String path = "";
    private static String userName = "root";
    private static String password ="";

    public static Connection connect() throws ClassNotFoundException, SQLException {
        Connection conn= null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizdb", userName, password);
        return conn;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection conn = DataBaseConnection.connect();
        if(conn!=null){
            System.out.println("SuccessFul");
        }else{
            System.out.println("Fail");
        }

    }
}
