<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<header>
	<!-- Topbar Start -->
	<div class="container-fluid">
		<div class="row bg-secondary py-2 px-xl-5">
			<div class="col-lg-6 d-none d-lg-block">
				<div class="d-inline-flex align-items-center">
					<a class="text-dark" href="">FAQs</a> <span class="text-muted px-2">|</span>
					<a class="text-dark" href="">Help</a> <span class="text-muted px-2">|</span>
					<a class="text-dark" href="">Support</a>
				</div>
			</div>
			<div class="col-lg-6 text-center text-lg-right">
				<div class="d-inline-flex align-items-center">
					<c:if test="${not empty LoginInfor }">
						<a class="text-dark px-2" href="">${LoginInfor.fullName}</a>

						<a class="text-dark px-2" href="<c:url value="/Home/Logout"/>">Log
							out</a>
					</c:if>
					<c:if test="${ empty LoginInfor }">
						<a class="text-dark px-2" href="<c:url value="Register"/>">Register</a>
					</c:if>

					<a class="text-dark px-2" href=""> <i class="fab fa-facebook-f"></i>
					</a> <a class="text-dark px-2" href=""> <i class="fab fa-twitter"></i>
					</a> <a class="text-dark px-2" href=""> <i
						class="fab fa-linkedin-in"></i>
					</a> <a class="text-dark px-2" href=""> <i class="fab fa-instagram"></i>
					</a> <a class="text-dark pl-2" href=""> <i class="fab fa-youtube"></i>
					</a>
				</div>
			</div>
		</div>
		<div class="row align-items-center py-3 px-xl-5">
			<div class="col-lg-3 d-none d-lg-block">
				<a href="" class="text-decoration-none">
					<h1 class="m-0 display-5 font-weight-semi-bold">
						<span class="text-primary font-weight-bold border px-3 mr-1">E</span>Shopper
					</h1>
				</a>
			</div>
			<div class="col-lg-6 col-6 text-left">
				<form action="">
					<div class="input-group">
						<input type="text" class="form-control"
							placeholder="Search for products">
						<div class="input-group-append">
							<span class="input-group-text bg-transparent text-primary">
								<i class="fa fa-search"></i>
							</span>
						</div>
					</div>
				</form>
			</div>
			<div class="col-lg-3 col-6 text-right">

				</a> <a href="<c:url value="List-cart"/>" class="btn border"> <i
					class="fas fa-shopping-cart text-primary"></i> <span class="badge">${TotalQuantity}</span>
				</a>
			</div>
		</div>
	</div>
	<!-- Topbar End -->
	<!-- Navbar Start -->
	<div class="container-fluid">
		<div class="row border-top px-xl-5">
			<div class="col-lg-3 d-none d-lg-block">
				<a
					class="btn shadow-none d-flex align-items-center justify-content-between bg-primary text-white w-100"
					data-toggle="collapse" href="#navbar-vertical"
					style="height: 65px; margin-top: -1px; padding: 0 30px;">
					<h6 class="m-0">Categories</h6> <i
					class="fa fa-angle-down text-dark"></i>
				</a>
				<nav
					class="collapse position-absolute navbar navbar-vertical navbar-light align-items-start p-0 border border-top-0 border-bottom-0 bg-light"
					id="navbar-vertical" style="width: calc(100% - 30px); z-index: 1;">
					<div class="navbar-nav w-100 overflow-hidden" style="height: 410px">
						<c:forEach items="${category}" var="c">
							<a href="<c:url value="/Home/product/${c.id}"/>"
								class="nav-item nav-link">${c.nameCategory}</a>
						</c:forEach>
					</div>
				</nav>
			</div>
			<div class="col-lg-9">
				<nav
					class="navbar navbar-expand-lg bg-light navbar-light py-3 py-lg-0 px-0">
					<a href="" class="text-decoration-none d-block d-lg-none">
						<h1 class="m-0 display-5 font-weight-semi-bold">
							<span class="text-primary font-weight-bold border px-3 mr-1">E</span>Shopper
						</h1>
					</a>
					<button type="button" class="navbar-toggler" data-toggle="collapse"
						data-target="#navbarCollapse">
						<span class="navbar-toggler-icon"></span>
					</button>
					<div class="collapse navbar-collapse justify-content-between"
						id="navbarCollapse">
						<div class="navbar-nav mr-auto py-0">
							<a href="<c:url value="/Home/"/>"
								class="nav-item nav-link active">Home</a> <a
								href="<c:url value="/Home/productList/"/>"
								class="nav-item nav-link">Shop</a> <a
								href="<c:url value="/Home/productList/"/>"
								class="nav-item nav-link ">Shop Details</a>
							<div class="nav-item dropdown">
								<a href="#" class="nav-link dropdown-toggle"
									data-toggle="dropdown">Pages</a>
								<div class="dropdown-menu rounded-0 m-0">
									<a href="cart.html" class="dropdown-item">Shopping Cart</a> <a
										href="checkout.html" class="dropdown-item">Checkout</a>
								</div>
							</div>
							<a href="contact.html" class="nav-item nav-link">Contact</a>
						</div>
						<c:if test="${empty LoginInfor }">
							<div class="navbar-nav ml-auto py-0">
								<a href="Login" class="nav-item nav-link">Login</a>
							</div>
						</c:if>
						<c:if test="${not empty LoginInfor }">
							<a href="" class="nav-item nav-link">${LoginInfor.fullName}</a>
						</c:if>
					</div>
				</nav>
			</div>
		</div>
	</div>
	<!-- Navbar End -->
</header>