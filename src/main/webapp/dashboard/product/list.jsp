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

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css"
          integrity="sha512-HK5fgLBL+xu6dm/Ii3z4xhlSUyZgTT9tuc/hSrtw6uzJOvgRr2a9jyxxT1ely+B+xFAmJKVSTbpM/CuL7qxO8w=="
          crossorigin="anonymous"/>
</head>

<body id="page-top">

<!-- Page Wrapper -->
<div id="wrapper">

    <!-- Sidebar -->
    <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

        <!-- Sidebar - Brand -->
        <a class="sidebar-brand d-flex align-items-center justify-content-center" href="/dashboard">
            <div class="sidebar-brand-icon rotate-n-15">
                <i class="fab fa-phoenix-framework"></i>
            </div>
            <div class="sidebar-brand-text mx-3">QUẢN LÍ BÁN HÀNG</div>
        </a>

        <!-- Divider -->
        <hr class="sidebar-divider my-0">
        <li class="nav-item active">
            <a class="nav-link" href="/home">
                <a class="nav-link" href="/">
                    <i class="fas fa-fw fa-tachometer-alt"></i>
                    <span>Home</span></a>
        </li>
        <!-- Divider -->
        <hr class="sidebar-divider my-0">
        <!-- Nav Item - Dashboard -->
        <li class="nav-item active">
            <a class="nav-link" href="/dashboard">
                <i class="fas fa-fw fa-tachometer-alt"></i>
                <span>Dashboard</span></a>
        </li>

        <!-- Divider -->
        <hr class="sidebar-divider">


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

                    <a class="collapse-item" href="login/register.html">Register</a>
                    <a class="collapse-item" href="login/forgot-password.html">Forgot Password</a>
                    <div class="collapse-divider"></div>

                </div>
            </div>
        </li>


        <!-- Nav Item - Tables Product -->
        <li class="nav-item">
            <a class="nav-link" href="/dashboard/product?action=showAll">
                <i class="fas fa-fw fa-table"></i>
                <span>Product Management</span></a>
        </li>
        <!-- Nav Item - Tables Customer -->
        <li class="nav-item">
            <a class="nav-link" href="/dashboard/user?action=showAll">
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
                <button class="btn btn-link d-md-none rounded-circle mr-3" id="sidebarToggleTop">
                    <i class="fa fa-bars"></i>
                </button>

                <!-- Topbar Search -->
                <form
                        class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
                    <div class="input-group">
                        <input aria-describedby="basic-addon2" aria-label="Search"
                               class="form-control bg-light border-0 small"
                               placeholder="Search for..." type="text">
                        <div class="input-group-append">
                            <button class="btn btn-primary" type="button">
                                <i class="fas fa-search fa-sm"></i>
                            </button>
                        </div>
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

                    <!-- Nav Item - Alerts -->
                    <li class="nav-item dropdown no-arrow mx-1">
                        <a aria-expanded="false" aria-haspopup="true" class="nav-link dropdown-toggle"
                           data-toggle="dropdown"
                           href="#" id="alertsDropdown" role="button">
                            <i class="fas fa-bell fa-fw"></i>
                            <!-- Counter - Alerts -->
                            <span class="badge badge-danger badge-counter">3+</span>
                        </a>
                        <!-- Dropdown - Alerts -->
                        <div aria-labelledby="alertsDropdown"
                             class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in">
                            <h6 class="dropdown-header">
                                Alerts Center
                            </h6>
                            <a class="dropdown-item d-flex align-items-center" href="#">
                                <div class="mr-3">
                                    <div class="icon-circle bg-primary">
                                        <i class="fas fa-file-alt text-white"></i>
                                    </div>
                                </div>
                                <div>
                                    <div class="small text-gray-500">December 12, 2019</div>
                                    <span class="font-weight-bold">A new monthly report is ready to download!</span>
                                </div>
                            </a>
                            <a class="dropdown-item d-flex align-items-center" href="#">
                                <div class="mr-3">
                                    <div class="icon-circle bg-success">
                                        <i class="fas fa-donate text-white"></i>
                                    </div>
                                </div>
                                <div>
                                    <div class="small text-gray-500">December 7, 2019</div>
                                    $290.29 has been deposited into your account!
                                </div>
                            </a>
                            <a class="dropdown-item d-flex align-items-center" href="#">
                                <div class="mr-3">
                                    <div class="icon-circle bg-warning">
                                        <i class="fas fa-exclamation-triangle text-white"></i>
                                    </div>
                                </div>
                                <div>
                                    <div class="small text-gray-500">December 2, 2019</div>
                                    Spending Alert: We've noticed unusually high spending for your account.
                                </div>
                            </a>
                            <a class="dropdown-item text-center small text-gray-500" href="#">Show All Alerts</a>
                        </div>
                    </li>

                    <!-- Nav Item - Messages -->
                    <li class="nav-item dropdown no-arrow mx-1">
                        <a aria-expanded="false" aria-haspopup="true" class="nav-link dropdown-toggle"
                           data-toggle="dropdown"
                           href="#" id="messagesDropdown" role="button">
                            <i class="fas fa-envelope fa-fw"></i>
                            <!-- Counter - Messages -->
                            <span class="badge badge-danger badge-counter">7</span>
                        </a>
                        <!-- Dropdown - Messages -->
                        <div aria-labelledby="messagesDropdown"
                             class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in">
                            <h6 class="dropdown-header">
                                Message Center
                            </h6>
                            <a class="dropdown-item d-flex align-items-center" href="#">
                                <div class="dropdown-list-image mr-3">
                                    <img alt="" class="rounded-circle"
                                         src="../img/undraw_profile_1.svg">
                                    <div class="status-indicator bg-success"></div>
                                </div>
                                <div class="font-weight-bold">
                                    <div class="text-truncate">Hi there! I am wondering if you can help me with a
                                        problem I've been having.
                                    </div>
                                    <div class="small text-gray-500">Emily Fowler · 58m</div>
                                </div>
                            </a>
                            <a class="dropdown-item d-flex align-items-center" href="#">
                                <div class="dropdown-list-image mr-3">
                                    <img alt="" class="rounded-circle"
                                         src="../img/undraw_profile_2.svg">
                                    <div class="status-indicator"></div>
                                </div>
                                <div>
                                    <div class="text-truncate">I have the photos that you ordered last month, how
                                        would you like them sent to you?
                                    </div>
                                    <div class="small text-gray-500">Jae Chun · 1d</div>
                                </div>
                            </a>
                            <a class="dropdown-item d-flex align-items-center" href="#">
                                <div class="dropdown-list-image mr-3">
                                    <img alt="" class="rounded-circle"
                                         src="../img/undraw_profile_3.svg">
                                    <div class="status-indicator bg-warning"></div>
                                </div>
                                <div>
                                    <div class="text-truncate">Last month's report looks great, I am very happy with
                                        the progress so far, keep up the good work!
                                    </div>
                                    <div class="small text-gray-500">Morgan Alvarez · 2d</div>
                                </div>
                            </a>
                            <a class="dropdown-item d-flex align-items-center" href="#">
                                <div class="dropdown-list-image mr-3">
                                    <img alt="" class="rounded-circle"
                                         src="https://source.unsplash.com/Mv9hjnEUHR4/60x60">
                                    <div class="status-indicator bg-success"></div>
                                </div>
                                <div>
                                    <div class="text-truncate">Am I a good boy? The reason I ask is because someone
                                        told me that people say this to all dogs, even if they aren't good...
                                    </div>
                                    <div class="small text-gray-500">Chicken the Dog · 2w</div>
                                </div>
                            </a>
                            <a class="dropdown-item text-center small text-gray-500" href="#">Read More Messages</a>
                        </div>
                    </li>

                    <div class="topbar-divider d-none d-sm-block"></div>

                    <!-- Nav Item - User Information -->
                    <li class="nav-item dropdown no-arrow">
                        <a aria-expanded="false" aria-haspopup="true" class="nav-link dropdown-toggle"
                           data-toggle="dropdown"
                           href="#" id="userDropdown" role="button">
                            <span class="mr-2 d-none d-lg-inline text-gray-600 small"></span>
                            <img class="img-profile rounded-circle"
                                 src="../img/undraw_profile.svg">
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
                            <a class="dropdown-item" data-target="#logoutModal" data-toggle="modal" href="/login">
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
                                    <th></th>
                                    <th></th>

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
                                    <th></th>
                                    <th></th>
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
                                        <td><img src="${product.getImage()}" alt=""
                                                 style="height:200px;object-fit: cover"></td>
                                        <td><a class="btn btn-info"
                                               href="/dashboard/product?action=edit&id=${product.getId()}">Edit</a></td>
                                        <td><a data-toggle="modal" data-target="#exampleModal1"
                                               onclick="showFormDelete(${product.getId()})"
                                               class="btn btn-danger">Delete</a></td>
                                    </tr>
                                    <div aria-hidden="true" aria-labelledby="exampleModalLabel" class="modal fade"
                                         id="exampleModal1" role="dialog"
                                         tabindex="-1">
                                        <div class="modal-dialog" role="document">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h5 class="modal-title" >Thông báo</h5>
                                                    <input type="hidden" id="idForDelete">
                                                    <button aria-label="Close" class="close" data-dismiss="modal"
                                                            type="button">
                                                        <span aria-hidden="true">×</span>
                                                    </button>
                                                </div>
                                                <div class="modal-body" id="exampleModalLabelX"></div>
                                                <div class="modal-footer">
                                                    <button class="btn btn-secondary" data-dismiss="modal"
                                                            type="button"><i class="fas fa-window-close"></i>
                                                    </button>
                                                    <button class="btn btn-primary"
                                                            onclick="deleteProduct()" type="button"><i
                                                            class="fas fa-trash-alt"></i></button>
                                                </div>
                                                <script>
                                                    function showFormDelete(id) {
                                                        $("#exampleModalLabelX").html('Bạn có muốn xóa sản phẩm có id = ' + id + '?')
                                                        $('#idForDelete').val(id)
                                                    }

                                                    function deleteProduct() {
                                                        window.location.href = '/dashboard/product?action=delete&id=' + $('#idForDelete').val();
                                                    }
                                                </script>
                                            </div>
                                        </div>
                                    </div>

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
<%--<form action="/dashboard/product">--%>
<%--    <input value="search" name="action" hidden>--%>
<%--    <input type="text" name="name_product" placeholder="Nhập tên">--%>
<%--    <input type="submit" value="Tìm kiếm">--%>
<%--</form>--%>
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
                <button class="btn btn-secondary" data-dismiss="modal" type="button"><i class="fas fa-window-close"></i>
                </button>
                <button class="btn btn-primary" onclick="editProduct()" type="button"><i class="far fa-save"></i>
                </button>
            </div>
        </div>
    </div>
</div>
<!-- Delete Modal -->
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
                <a class="btn btn-primary" href="/login">Logout</a>
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
