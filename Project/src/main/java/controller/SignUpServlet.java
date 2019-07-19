package controller;

import com.google.gson.Gson;
import dao.DAO;
import model.Customer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


public class SignUpServlet extends HttpServlet {
    Gson mapper = new Gson();
    private DAO dao;
    @Override
    public void init() throws ServletException {
        dao = new DAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("customers", dao.getCustomerList());
        RequestDispatcher view = request.getRequestDispatcher("signUp.jsp");
        view.forward(request, response);
        String user = request.getParameter("customer");
        Customer customer = mapper.fromJson(user,Customer.class);


        List<Customer> customers = dao.getCustomerList();
        PrintWriter out = response.getWriter();


        for (Customer c : customers) {
            if (c.getUserName().equals(user)) {
             out.print(mapper.toJson(c));


            }


        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Customer customer = mapper.fromJson(request.getParameter("cust"), Customer.class);

        dao.getCustomerList().add(customer);

        PrintWriter out = response.getWriter();

        out.print(mapper.toJson(customer));
    }
}
