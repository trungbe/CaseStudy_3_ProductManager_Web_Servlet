package controller;

import model.User;
import service.user.IUserService;
import service.user.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserServlet", urlPatterns = "/")

public class UserServlet extends HttpServlet {
    private static final IUserService userService = new UserService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "register": {
                showCreateForm(request, response);
                break;
            }
            case "edit": {
                //showUpdateForm(request, response);
                break;
            }
            case "login": {
                showLogin(request, response);
                break;
            }
            default: {
                //showAllUser(request, response);
                break;
            }
        }
    }

    private void showLogin(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("login/login.jsp");

        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("login/register.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "register": {
                createUser(request, response);
                break;
            }
            case "edit": {
                //   updateUser(request, response);
                break;
            }
            case "login": {
                login(request, response);
                break;
            }
        }

    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserService userService1 = new UserService();
        User user = userService1.login(username, password);
        if (user == null) response.sendRedirect("login/login.jsp");
        else response.sendRedirect("dashboard/index.jsp");
    }

    private void createUser(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String fullname = request.getParameter("fullname");
        int birthday = Integer.parseInt(request.getParameter("birthday"));
        String address = request.getParameter("address");
        int id_role = Integer.parseInt(request.getParameter("id_role"));
        User user = new User(id, username, password, fullname, birthday, address, id_role);
        userService.create(user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("login/register.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


