package net.jedrek.service;

import net.jedrek.dao.CustomerDao;
import net.jedrek.entity.Customer;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Jedrek on 2017/5/3.
 */
public class HandleLogin extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
                    throws IOException,ServletException {
        /*
        //test: the servlet is working ok
        PrintWriter out = response.getWriter();
        request.getRequestDispatcher("jsp/message.jsp").forward(request,response);
        */
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        CustomerDao dao = new CustomerDao();

        String account = request.getParameter("account");
        String password = request.getParameter("password");

        if (account != null && !account.isEmpty()) {
            Customer customer = new Customer();
            customer = dao.getCustomer(account, password);
            request.setAttribute("LogStatus","you logging in our website");
            request.getRequestDispatcher("jsp/LogSuccess.jsp").forward(request,response);

        } else {
            request.getRequestDispatcher("jsp/Login.jsp").forward(request, response);
        }
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException,ServletException {
        doPost(request,response);
    }




}
