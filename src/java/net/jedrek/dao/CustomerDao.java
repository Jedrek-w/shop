package net.jedrek.dao;

import net.jedrek.db.DBUtil;
import net.jedrek.entity.Customer;

import java.sql.*;
import java.util.Objects;

/**
 * Created by Jedrek on 2017/4/28.
 */

public class CustomerDao {
    /*
    获取单个顾客信息
     */

    public Customer getCustomer(String account, String password) {

            Customer customer = null;
        try{
            Connection connection = DBUtil.getConn();
            String sql = " SELECT account,userName,phone,address FROM customer "
                    + " WHERE account = ? AND password = ?; ";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, account);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet == null) {
                System.out.println("输入的参数错误");
            }
            while (resultSet.next()) {
                customer.setAccount(resultSet.getString(1));
                customer.setName(resultSet.getString(2));
                customer.setPhone(resultSet.getString(3));
                customer.setAddress(resultSet.getString(4));
            }
            DBUtil.allClose(statement, resultSet, connection);

        }catch(SQLException e) {
            e.getErrorCode();
        }
        return customer;
    }

    /*
    判断用户是否存在
     */
    public boolean ExitCustomer(String name) {
        try {
            Connection connection = DBUtil.getConn();
            String sql = " SELECT account FROM customer "+
                    " WHERE userName = ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,name);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(!resultSet.next()) {
                return true;
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /*
    插入一条顾客信息
     */
    public void saveCustomer(Customer customer) throws SQLException {
        Connection conn = DBUtil.getConn();
        String sql = " INSERT INTO customer(account,username,password,phone,address) "
                +" values(?,?,?,?,?); ";
        PreparedStatement statement = conn.prepareStatement(sql);

        statement.setString(1,customer.getAccount());
        statement.setString(2,customer.getName());
        statement.setString(3,customer.getPassword());
        statement.setString(4,customer.getPhone());
        statement.setString(5,customer.getAddress());

        statement.executeUpdate();
        DBUtil.close(statement,conn);

    }
    /*
    校验密码
     */
    public boolean confirmPassword(String password,String rePassword) {
        return Objects.equals(password,rePassword);
    }

}

