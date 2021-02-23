package controller;

import model.User;
import service.login.ILoginService;
import service.login.LoginService;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")

public class LoginServlet extends HttpServlet {
    private static final ILoginService loginService = new LoginService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "": {
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



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "": {
                login(request, response);
                break;
            }
        }

    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = loginService.login(username, password);
        if (user == null) {
            response.sendRedirect("/login");
        }
        else {
            if (user.getId_role() == 1){
//                response.sendRedirect("dashboard/index.jsp");
                response.sendRedirect("/dashboard");
            }else {
                try {
                    request.setAttribute("username", user.getUsername());
                    request.setAttribute("idRole", user.getId_role());
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/home.jsp");
                    requestDispatcher.forward(request, response);
                } catch (Exception exception){

                }
            }

        }
    }

}


