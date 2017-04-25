package net.jedrek.db;

/**
 * Created by Jedrek on 2017/4/25.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBUtil {

    public static void getConn() throws Exception {
        String user = "root";
        String passwd = "150601";
        String url = "jdbc:mysql://127.0.0.1:3306/shopping";

        String sql = " select * from customer ";

        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, user, passwd);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next()) {
            System.out.println(resultSet.getInt("id"));
            System.out.println(resultSet.getString("customer_name"));
            System.out.println(resultSet.getString("customer_password"));
            System.out.println(resultSet.getString("phone_number"));
            System.out.println(resultSet.getString("realName"));
        }
    }

    public static void main(String[] args) throws Exception {
        getConn();
    }
}
