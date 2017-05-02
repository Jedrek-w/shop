package net.jedrek.service;

import net.jedrek.dao.CustomerDao;
import net.jedrek.entity.Customer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;


/**
 * Created by Jedrek on 2017/4/30.
 */
public class HandleRegister extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
                    throws ServletException,IOException {
/*
        PrintWriter out = response.getWriter();
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        out.print(account+"  "+password);
*/
        //response.setContentType("text/html;charset=UTF-8");
        //request.setCharacterEncoding("UTF-8");

        CustomerDao customerDao = new CustomerDao();

        String name = request.getParameter("name");
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        String userPassword2 = request.getParameter("repassword");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");

        if(name != null && !name.isEmpty()) {
            if(customerDao.ExitCustomer(name) && customerDao.confirmPassword(password,userPassword2)) {
                Customer customer = new Customer();

                customer.setName(name);
                customer.setAccount(account);
                customer.setPassword(password);
                customer.setPhone(phone);
                customer.setAddress(address);
                try{
                customerDao.saveCustomer(customer);
                }catch(SQLException e){
                    e.printStackTrace();
                }
                request.setAttribute("info","success");
            }else {
                if(!customerDao.ExitCustomer(name)) {
                    request.setAttribute("info","user name exited");
                }
                if(!customerDao.confirmPassword(password,userPassword2)) {
                    request.setAttribute("info","password is wrong");
                }
            }
        }
        request.getRequestDispatcher("/jsp/message.jsp").forward(request,response);



    }

}
