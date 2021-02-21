package controller;

import model.Product;
import service.IServiceProduct;
import service.ServiceProduct;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/products")
public class ProductServlet extends HttpServlet {
    IServiceProduct serviceProduct =new ServiceProduct();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        if (action==null){
            action="";
        }
        switch (action){
            case "create":
                showCreateForm(request,response);
                break;
            case "edit":
                showEditForm(request,response);
                break;
            case "delete":
                showDeleteForm(request,response);
                break;
            default:
                showFindAll(request,response);
                break;
        }
    }

    private void showFindAll(HttpServletRequest request, HttpServletResponse response) {
        List<Product>products= serviceProduct.findAll();
        request.setAttribute("p",products);
        RequestDispatcher dispatcher=request.getRequestDispatcher("product/list.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        int id= Integer.parseInt(request.getParameter("id"));
        Product product= serviceProduct.findById(id);
        RequestDispatcher requestDispatcher;
        if (product==null){
            requestDispatcher=request.getRequestDispatcher("404.jsp");
        }else {
            request.setAttribute("p",product);
            requestDispatcher=request.getRequestDispatcher("product/delete.jsp");
            try {
                requestDispatcher.forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id= Integer.parseInt(request.getParameter("id"));
        Product product= serviceProduct.findById(id);
        RequestDispatcher requestDispatcher;
        if (product==null){
            requestDispatcher=request.getRequestDispatcher("404.jsp");
        }else {
            request.setAttribute("p",product);
            requestDispatcher=request.getRequestDispatcher("product/edit.jsp");
            try {
                requestDispatcher.forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher= request.getRequestDispatcher("product/create.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        if (action==null){
            action="";
        }
        switch (action){
            case "create":
                createProduct(request,response);
                break;
            case "edit":
                editProduct(request,response);
                break;
            case "delete":
                deleteProduct(request,response);
                break;
            default:
                break;
        }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {

    }

    private void editProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name= request.getParameter("name_product");
        int price= Integer.parseInt(request.getParameter("price"));
        String origin=request.getParameter("origin");
        String description=request.getParameter("description");
        serviceProduct.edit(id,new Product(id,name,price,origin,description));
        try {
            response.sendRedirect("/products");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) {
        int id= Integer.parseInt(request.getParameter("id"));
        String name_product=request.getParameter("name_product");
        int price= Integer.parseInt(request.getParameter("price"));
        String origin=request.getParameter("origin");
        String description=request.getParameter("description");
        Product product=new Product(id,name_product,price,origin,description);
        serviceProduct.save(product);
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("product/create.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
