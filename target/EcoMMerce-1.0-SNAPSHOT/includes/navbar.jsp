<%-- 
    Document   : navbar
    Created on : May 4, 2023, 9:53:57 PM
    Author     : omoor
--%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container">
        <a class="navbar-brand" href="index.jsp">E-commerce Shopping Cart</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="index.jsp">Home 
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="cart.jsp">Cart<span class="badge badge-danger">${cart_list.size()}</span></a>
                </li>   
                <li class="nav-item">
                    <a class="nav-link disabled" href="orders.jsp">Orders</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link disabled" href="log-out">Logout</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link disabled" href="login.jsp">Login</a>
                </li>
            </ul>
            <form class="form-inline my-2 my-lg-0">
                <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>
