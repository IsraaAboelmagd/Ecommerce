<%-- 
    Document   : index
    Created on : May 4, 2023, 8:52:45 PM
    Author     : omoor
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="tele.iti.dao.*"%>
<%@page import="tele.iti.data.*"%>
<%@page import="tele.iti.connection.DB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
user auth = (user) request.getSession().getAttribute("auth");
if (auth != null) {
    request.setAttribute("person", auth);
}
productDao pd = new productDao(DB.getConnection());
List<product> products = pd.getAllProducts();
ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
if (cart_list != null) {
	request.setAttribute("cart_list", cart_list);
}

%>
<!DOCTYPE html>
<html>
<head>
<title>JSP Page</title>
<%@include file="includes/head.jsp"%>
</head>
<body>
<%@include file="includes/navbar.jsp"%>

<div class="container">
		<div class="card-header my-3">All Products</div>
		<div class="row">
                    <%
                        if(!products.isEmpty())
                        {
                        for(product p:products){
                        %><div class="col-md-3 my-3">
				<div class="card w-100">
                                    <img class="card-img-top" src="product-image/<%= p.getImage()%>"alt="Card image cap">
					<div class="card-body">
						<h5 class="card-title"><%= p.getName() %></h5>
						<h6 class="price">Price: $<%= p.getPrice() %></h6>
						<h6 class="category">Category:<%= p.getCategory() %></h6>
						<div class="mt-3 d-flex justify-content-between">
							<a href="add-to-cart?id=<%= p.getId()%>" class="btn btn-dark" href="add-to-cart?id=">Add to Cart</a> <a
                                                            class="btn btn-primary" href="order-now?quantity=1&id=<%=p.getId()%>">Buy Now</a>
						</div>
					</div>
				</div>
			</div>
                    <%}
                    } else {
			out.println("There is no proucts");
			}
                        
                    %>
			
	
		</div>
	</div>
<%@include file="includes/footer.jsp"%>

</body>
</html>
