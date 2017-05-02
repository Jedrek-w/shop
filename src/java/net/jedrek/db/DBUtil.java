package net.jedrek.db;

/**
 * Created by Jedrek on 2017/4/25.
 */
import java.sql.*;

public class DBUtil {

    public static Connection getConn() throws SQLException {
        String user = "root";
        String passwd = "150601";
        String url = "jdbc:mysql://127.0.0.1:3306/shopping";

       // String sql = " select * from customer ";
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection = DriverManager.getConnection(url, user, passwd);
        return connection;
    }


    public static void allClose(PreparedStatement pstmt, ResultSet rs, Connection conn)
                                                                    throws SQLException{
        if(pstmt != null) {
            pstmt.close();
        }
        if(rs != null) {
            rs.close();
        }
        if(conn != null) {
            conn.close();
        }
    }

    /*
     * 关闭增、删、改资源。
     */
    public static void close(PreparedStatement pstmt,Connection conn) throws SQLException {
        if(pstmt != null) {
            pstmt.close();
        }
        if(conn != null) {
            conn.close();
        }
    }

    public static void close(PreparedStatement pstmtOrder, PreparedStatement pstmtCommodity,
                             Connection conn) throws SQLException {

        if(pstmtOrder != null) {
            pstmtOrder.close();
        }
        if(pstmtCommodity != null) {
            pstmtCommodity.close();
        }
        if(conn != null) {
            conn.close();
        }


    }



}

