package controller.home;

import model.Product;
import service.product.IProductService;
import service.product.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HomeServlet", value = "/home")

public class HomeServlet extends HttpServlet {
    IProductService serviceProduct = new ProductService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "": {
                showHome(request, response);
                break;
            }
            case "detail": {
                showDetail(request, response);
                break;
            }

        }

    }

    private void showDetail(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = serviceProduct.findById(id);
        RequestDispatcher requestDispatcher;
        request.setAttribute("p",product);
        requestDispatcher = request.getRequestDispatcher("detail/detail.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    private void showHome(HttpServletRequest request, HttpServletResponse response) {
        List<Product> products = serviceProduct.findAll();
        request.setAttribute("p", products);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/home.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
