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
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns = "/login")

public class UserServlet extends HttpServlet {
    private static final IUserService userService = new UserService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "show": {
                showAllUser(request, response);
                break;
            }
            case "register": {
                showCreateForm(request, response);
                break;
            }
            case "login": {
                showLogin(request, response);
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

    private void showAllUser(HttpServletRequest request, HttpServletResponse response) {
        List<User> userList = userService.findAll();
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/userList.jsp");
        request.setAttribute("userList", userList);
        try {
            requestDispatcher.forward(request, response);
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
        User user = userService.login(username, password);
        if (user == null) {
            response.sendRedirect("login?action=login");
        } else {
            if (user.getId_role() == 1) {
                response.sendRedirect("dashboard/index.jsp");
            } else {
                response.sendRedirect("home.jsp");
            }

        }
    }

    private void createUser(HttpServletRequest request, HttpServletResponse response) {
//        int id = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String fullname = request.getParameter("fullname");
        String birthday = request.getParameter("birthday");
        String address = request.getParameter("address");
        int id_role = 2;
        User user = new User(username, password, fullname, birthday, address, id_role);
        User user1 = userService.create(user);
        RequestDispatcher dispatcher;
        if (user1 != null) {
            dispatcher = request.getRequestDispatcher("login/loading.jsp");
        } else {
            dispatcher = request.getRequestDispatcher("login/register.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


