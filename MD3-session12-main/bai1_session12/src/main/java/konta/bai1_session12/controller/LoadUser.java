package konta.bai1_session12.controller;

import konta.bai1_session12.dao.impl.UserDAOImpl;
import konta.bai1_session12.entity.User;
import konta.bai1_session12.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LoadUser", value = "/LoadUser")
public class LoadUser extends HttpServlet {
    private UserDAOImpl userDAO = new UserDAOImpl();
    private UserServiceImpl userService = new UserServiceImpl();
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ServletException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "create":
                showCreateForm(request,response);
                break;
            case "edit":
//                showEditForm(request,response);
                break;
            case "delete":
//                deleteUser(request,response);
                break;
            case "details":
//                showDetail(request,response);
                break;
            case "search":
//                searchUsers(request,response);
                break;
            default:
                listUsers(request,response);
                break;
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "save":
                saveUser(request,response);
                break;
            case "update":
//                updateUser(request,response);
                break;
            default:
                listUsers(request,response);
                break;
        }
    }

    private void listUsers(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("users", userDAO.findAll());
        request.getRequestDispatcher("user-list.jsp").forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("user-form.jsp").forward(request,response);
    }

    private void saveUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String fullName = request.getParameter("fullName");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        User user = new User(1,username,password,fullName,address,email,phone);

        userService.add(user);

        response.sendRedirect("LoadUser");
    }

    public void destroy() {
    }
}
