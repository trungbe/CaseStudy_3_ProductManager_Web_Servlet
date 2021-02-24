package controller.dashboard;

import model.Product;
import service.product.IProductService;
import service.product.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/dashboard/product")
public class ProductServlet extends HttpServlet {
    IProductService serviceProduct =new ProductService();
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
            case "search":
                searchByName(request,response);
                break;
            default:
                showFindAll(request,response);
                break;
        }
    }

    private void searchByName(HttpServletRequest request, HttpServletResponse response) {
        String name= request.getParameter("name_product");
        List<Product>products= serviceProduct.findByName(name);
        request.setAttribute("p",products);
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("product/list.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
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
//        int id= Integer.parseInt(request.getParameter("id"));
//        RequestDispatcher requestDispatcher;
//        if (product==null){
//            requestDispatcher =request.getRequestDispatcher("404.jsp");
//        }else {
//            request.setAttribute("p",product);
//            requestDispatcher=request.getRequestDispatcher("product/delete.jsp");
//            try {
//                requestDispatcher.forward(request,response);
//            } catch (ServletException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
        int id=Integer.parseInt(request.getParameter("id"));
        serviceProduct.findById(id);
        serviceProduct.delete(id);
        try {
            response.sendRedirect("/dashboard/product");
        } catch (IOException e) {
            e.printStackTrace();
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
        RequestDispatcher requestDispatcher= request.getRequestDispatcher("product/createProduct.jsp");
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
        int id=Integer.parseInt(request.getParameter("id"));
        serviceProduct.delete(id);
        try {

            response.sendRedirect("/dashboard/product");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void editProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name= request.getParameter("name_product");
        int price= Integer.parseInt(request.getParameter("price"));
        String origin=request.getParameter("origin");
        String description=request.getParameter("description");
        String image=request.getParameter("image");
        serviceProduct.edit(new Product(id,name,price,origin,description,image));
        try {
            response.sendRedirect("/dashboard/product");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) {
        String name_product=request.getParameter("name_product");
        int price= Integer.parseInt(request.getParameter("price"));
        String origin=request.getParameter("origin");
        String description=request.getParameter("description");
        String image=request.getParameter("image");
        Product product=new Product(name_product,price,origin,description,image);
        serviceProduct.save(product);
        try {
            response.sendRedirect("/dashboard/product");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
