<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta content="IE=edge" http-equiv="X-UA-Compatible">
    <meta content="width=device-width, initial-scale=1, shrink-to-fit=no" name="viewport">
    <meta content="" name="description">
    <meta content="" name="author">

    <title>Danh sách sản phẩm</title>

    <!-- Custom fonts for this template -->
    <link href="../../vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="../../css/sb-admin-2.min.css" rel="stylesheet">

    <!-- Custom styles for this page -->
    <link href="../../vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css" integrity="sha512-HK5fgLBL+xu6dm/Ii3z4xhlSUyZgTT9tuc/hSrtw6uzJOvgRr2a9jyxxT1ely+B+xFAmJKVSTbpM/CuL7qxO8w==" crossorigin="anonymous" />
</head>

<body id="page-top">

<!-- Page Wrapper -->
<div id="wrapper">

    <!-- Sidebar -->
    <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

        <!-- Sidebar - Brand -->
        <a class="sidebar-brand d-flex align-items-center justify-content-center" href="../index.html">
            <div class="sidebar-brand-icon rotate-n-15">
                <i class="fab fa-phoenix-framework"></i>
            </div>
            <div class="sidebar-brand-text mx-3">QUẢN LÍ BÁN HÀNG</div>
        </a>

        <!-- Divider -->
        <hr class="sidebar-divider my-0">
        <li class="nav-item active">
            <a class="nav-link" href="../home.html">
                <i class="fas fa-fw fa-tachometer-alt"></i>
                <span>Home</span></a>
        </li>
        <!-- Divider -->
        <hr class="sidebar-divider my-0">
        <!-- Nav Item - Dashboard -->
        <li class="nav-item">
            <a class="nav-link" href="../index.html">
                <i class="fas fa-fw fa-tachometer-alt"></i>
                <span>Dashboard</span></a>
        </li>

        <!-- Divider -->
        <hr class="sidebar-divider">

        <!-- Heading -->
        <div class="sidebar-heading">
            Addons
        </div>

        <!-- Nav Item - Pages Collapse Menu -->
        <li class="nav-item">
            <a aria-controls="collapsePages" aria-expanded="true" class="nav-link collapsed"
               data-target="#collapsePages"
               data-toggle="collapse" href="#">
                <i class="fas fa-fw fa-folder"></i>
                <span>Pages</span>
            </a>
            <div aria-labelledby="headingPages" class="collapse" data-parent="#accordionSidebar" id="collapsePages">
                <div class="bg-white py-2 collapse-inner rounded">
                    <h6 class="collapse-header">Login Screens:</h6>

                    <a class="collapse-item" href="../login/register.html">Register</a>
                    <a class="collapse-item" href="../login/forgot-password.html">Forgot Password</a>
                    <div class="collapse-divider"></div>

                </div>
            </div>
        </li>


        <!-- Nav Item - Tables Product -->
        <li class="nav-item">
            <a class="nav-link" href="list-edit-del-product.html">
                <i class="fas fa-fw fa-table"></i>
                <span>Product Management</span></a>
        </li>
        <!-- Nav Item - Tables Customer -->
        <li class="nav-item">
            <a class="nav-link" href="list-customer.html">
                <i class="fas fa-fw fa-table"></i>
                <span>Customer Management</span></a>
        </li>

        <!-- Divider -->
        <hr class="sidebar-divider d-none d-md-block">

        <!-- Sidebar Toggler (Sidebar) -->
        <div class="text-center d-none d-md-inline">
            <button class="rounded-circle border-0" id="sidebarToggle"></button>
        </div>

    </ul>
    <!-- End of Sidebar -->

    <!-- Content Wrapper -->
    <div class="d-flex flex-column" id="content-wrapper">

        <!-- Main Content -->
        <div id="content">

            <!-- Topbar -->
            <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                <!-- Sidebar Toggle (Topbar) -->
                <form class="form-inline">
                    <button class="btn btn-link d-md-none rounded-circle mr-3" id="sidebarToggleTop">
                        <i class="fa fa-bars"></i>
                    </button>
                </form>

                <!-- Topbar Create -->
                <form>
                    <div class="input-group-append">
                        <a class="btn btn-primary" href="add-product.html" type="button">
                            <i class="fas fa-plus-circle"></i>
                        </a>
                    </div>
                </form>

                <!-- Topbar Navbar -->
                <ul class="navbar-nav ml-auto">

                    <!-- Nav Item - Search Dropdown (Visible Only XS) -->
                    <li class="nav-item dropdown no-arrow d-sm-none">
                        <a aria-expanded="false" aria-haspopup="true" class="nav-link dropdown-toggle"
                           data-toggle="dropdown"
                           href="#" id="searchDropdown" role="button">
                            <i class="fas fa-search fa-fw"></i>
                        </a>
                        <!-- Dropdown - Messages -->
                        <div aria-labelledby="searchDropdown"
                             class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in">
                            <form class="form-inline mr-auto w-100 navbar-search">
                                <div class="input-group">
                                    <input aria-describedby="basic-addon2" aria-label="Search"
                                           class="form-control bg-light border-0 small" placeholder="Search for..."
                                           type="text">
                                    <div class="input-group-append">
                                        <button class="btn btn-primary" type="button">
                                            <i class="fas fa-search fa-sm"></i>
                                        </button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </li>
                    <!-- Nav Item - User Information -->
                    <li class="nav-item dropdown no-arrow">
                        <a aria-expanded="false" aria-haspopup="true" class="nav-link dropdown-toggle"
                           data-toggle="dropdown"
                           href="#" id="userDropdown" role="button">
                            <span class="mr-2 d-none d-lg-inline text-gray-600 small"></span>
                            <img class="img-profile rounded-circle"
                                 src="../../img/undraw_profile.svg">
                        </a>
                        <!-- Dropdown - User Information -->
                        <div aria-labelledby="userDropdown"
                             class="dropdown-menu dropdown-menu-right shadow animated--grow-in">
                            <a class="dropdown-item" href="#">
                                <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                                Profile
                            </a>
                            <a class="dropdown-item" href="#">
                                <i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
                                Settings
                            </a>
                            <a class="dropdown-item" href="#">
                                <i class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i>
                                Activity Log
                            </a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" data-target="#logoutModal" data-toggle="modal"
                               href="../login/login.html">
                                <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                Logout
                            </a>
                        </div>
                    </li>

                </ul>

            </nav>
            <!-- End of Topbar -->

            <!-- Begin Page Content -->
            <div class="container-fluid">

                <!-- Page Heading -->
                <h1 class="h3 mb-2 text-gray-800">List Product</h1>

                <!-- DataTales  -->
                <div class="card shadow mb-4">
                    <div class="card-body">
                        <div class="table-responsive">
                            <table cellspacing="0" class="table table-bordered" id="dataTable" width="100%">
                                <thead>
                                <tr>
                                    <th>Id</th>
                                    <th>Name_Product</th>
                                    <th>Price</th>
                                    <th>Origin</th>
                                    <th>Description</th>
                                    <th>Image</th>
                                </tr>
                                </thead>
                                <tfoot>
                                <tr>
                                    <th>Id</th>
                                    <th>Name_Product</th>
                                    <th>Price</th>
                                    <th>Origin</th>
                                    <th>Description</th>
                                    <th>Image</th>
                                </tr>
                                </tfoot>
                                <!-- display list product -->
                                <tbody id="display-product">
                                <c:forEach items="${p}" var="product">
                                    <tr>
                                        <td>${product.getId()}</td>
                                        <td>${product.getName_product()}</td>
                                        <td>${product.getPrice()}</td>
                                        <td>${product.getOrigin()}</td>
                                        <td>${product.getDescription()}</td>
                                        <td>${product.getImage()}</td>
<%--                                        <td><a href="/products?action=edit&id=${product.getId()}">Edit</a></td>--%>
                                        <td><button class="btn btn-info" data-toggle="modal" data-target="#exampleModal"><a href="/products?action=edit&id=${product.getId()}"></a>Edit</button></td>
                                        <td><a href="/products?action=delete&id=${product.getId()}">Delete</a></td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<button><a href="/products?action=create">Create new product</a></button>
<form action="/products">
    <input value="search" name="action" hidden>
    <input type="text" name="name_product" placeholder="Nhập tên">
    <input type="submit" value="Tìm kiếm">
</form>

<!-- Edit Modal -->
<div aria-hidden="true" aria-labelledby="exampleModalLabel" class="modal fade" id="exampleModal" tabindex="-1">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Edit Product</h5>
                <button aria-label="Close" class="close" data-dismiss="modal" type="button">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="col-lg-12">
                    <input class="form-control form-control-user" id="id-product" placeholder="Id" readonly
                           type="number">
                </div>
                <br>
                <div class="col-lg-12">
                    <input class="form-control form-control-user" id="name-product" placeholder="Name"
                           required
                           type="text">
                    <div id="name-invalid" style="color: red; font-size: small;"></div>
                </div>
                <br>
                <div class="col-lg-12">
                    <input class="form-control form-control-user" id="image-product" placeholder="Image"
                           required
                           type="text">
                    <div id="image-invalid" style="color: red; font-size: small;"></div>
                </div>
                <br>
                <div class="col-lg-12">
                    <input class="form-control form-control-user" id="quantity-product" placeholder="Quantity"
                           required type="number">
                    <div id="quantity-invalid" style="color: red; font-size: small;"></div>
                </div>
                <br>
                <div class="col-lg-12">
                    <input class="form-control form-control-user" id="price-product" placeholder="Price"
                           required type="number">
                    <div id="price-invalid" style="color: red; font-size: small;"></div>
                </div>
                <br>
                <div class="col-lg-12">
                    <select class="form-control form-control-user" id="origin-product" placeholder="Origin">
                        <option>Origin</option>
                        <option>Viet Nam</option>
                        <option>French</option>
                        <option>USA</option>
                        <option>England</option>
                    </select>
                    <div id="origin-invalid" style="color: red; font-size: small;"></div>
                </div>
                <br>
                <div class="col-lg-12">
                        <textarea class="form-control form-control-user" id="describe-product" placeholder="Describe"
                                  required rows="3"></textarea>
                    <div id="describe-invalid" style="color: red; font-size: small;"></div>
                </div>
            </div>
            <div class="modal-footer">
                <button class="btn btn-secondary" data-dismiss="modal" type="button"><i class="fas fa-window-close"></i></button>
                <button class="btn btn-primary" onclick="editProduct()" type="button"><i class="far fa-save"></i></button>
            </div>
        </div>
    </div>
</div>
<!-- Delete Modal -->
<div aria-hidden="true" aria-labelledby="exampleModalLabel" class="modal fade" id="exampleModal1" role="dialog"
     tabindex="-1">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Ready to Delete?</h5>
                <button aria-label="Close" class="close" data-dismiss="modal" type="button">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">Select icon "Delete" below if you are ready to delete your current product.</div>
            <div class="modal-footer">
                <button class="btn btn-secondary" data-dismiss="modal" type="button"><i class="fas fa-window-close"></i></button>
                <button class="btn btn-primary"  onclick="deleteProduct()" type="button"><i class="fas fa-trash-alt"></i></button>
            </div>
        </div>
    </div>
</div>
<!-- Footer -->
<footer class="sticky-footer bg-white">
    <div class="container my-auto">
        <div class="copyright text-center my-auto">
            <span>Copyright &copy; Website Of Trung Be</span>
        </div>
    </div>
</footer>
<!-- End of Footer -->
</div>
</div>
<!-- End of Page Wrapper -->

<!-- Scroll to Top Button-->
<a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
</a>

<!-- Logout Modal-->
<div aria-hidden="true" aria-labelledby="exampleModalLabel" class="modal fade" id="logoutModal" role="dialog"
     tabindex="-1">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                <button aria-label="Close" class="close" data-dismiss="modal" type="button">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
            <div class="modal-footer">
                <button class="btn btn-secondary" data-dismiss="modal" type="button">Cancel</button>
                <a class="btn btn-primary" href="../login/login.html" >Logout</a>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap core JavaScript-->
<script src="../../vendor/jquery/jquery.min.js"></script>
<script src="../../vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="../../vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom scripts for all pages-->
<script src="../../js/sb-admin-2.min.js"></script>

<!-- Page level plugins -->
<script src="../../vendor/datatables/jquery.dataTables.min.js"></script>
<script src="../../vendor/datatables/dataTables.bootstrap4.min.js"></script>

<!-- Page level custom scripts -->
<script src="../../js/demo/datatables-demo.js"></script>
<!-- scripts -->
<script src="product-Class.js"></script>
<script src="validate-form.js"></script>
<script src="list-edit-del-product.js"></script>
<script src="../login/login.js"></script>


</body>

</html>