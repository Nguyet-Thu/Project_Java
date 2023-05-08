<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<title>Check out</title>
<body>
	<div class="container-fluid pt-5">
		<div class="row px-xl-5">
			<div class="col-lg-8">
				<div class="mb-4">
					<h4 class="font-weight-semi-bold mb-4">Register Account</h4>
					<form:form action="Checkout" method="POST" modelAttribute="bill">
						<div class="mb-5">
							<div class="control-group">
								<label>Full Name</label>
								<form:input path="fullName" class="form-control" type="text"
									placeholder="Please enter your full name" />
							</div>
							<div class="control-group">
								<label>Email</label>
								<form:input path="email" class="form-control" type="text"
									placeholder="Please enter your email" />
							</div>
							<div class="control-group">
								<label>Address</label>
								<form:textarea path="address" class="form-control" rows="5"
									cols="30" type="text" placeholder="Please enter your address" />
							</div>
							<div class="control-group">
								<label>Number Phone</label>
								<form:input path="phone" class="form-control" type="number"
									min="0" placeholder="Please enter your number phone" />
							</div>
						</div>
						<div>
							<a href="<c:url value=""/>" type="button">
								<button type="submit" class="btn btn-primary py-2 px-4">Thanh
									toan</button>
							</a>

						</div>
					</form:form>
				</div>

			</div>
			<div class="col-lg-4">
				<div class="card border-secondary mb-5">
					<div class="card-header bg-secondary border-0">
						<h4 class="font-weight-semi-bold m-0">Order Total</h4>
					</div>
					<div class="card-body">
						<h5 class="font-weight-medium mb-3">Products</h5>
						<div class="d-flex justify-content-between">
							<p>Colorful Stylish Shirt 1</p>
							<p>$150</p>
						</div>
						<div class="d-flex justify-content-between">
							<p>Colorful Stylish Shirt 2</p>
							<p>$150</p>
						</div>
						<div class="d-flex justify-content-between">
							<p>Colorful Stylish Shirt 3</p>
							<p>$150</p>
						</div>
						<hr class="mt-0">
						<div class="d-flex justify-content-between mb-3 pt-1">
							<h6 class="font-weight-medium">Subtotal</h6>
							<h6 class="font-weight-medium">${TotalQuantity}</h6>
						</div>
						<div class="d-flex justify-content-between">
							<h6 class="font-weight-medium">Shipping</h6>
							<h6 class="font-weight-medium">${TotalPrice}</h6>
						</div>
					</div>
					<div class="card-footer border-secondary bg-transparent">
						<div class="d-flex justify-content-between mt-2">
							<h5 class="font-weight-bold">Total</h5>
							<h5 class="font-weight-bold">$160</h5>
						</div>
					</div>
				</div>
				<div class="card border-secondary mb-5">
					<div class="card-header bg-secondary border-0">
						<h4 class="font-weight-semi-bold m-0">Payment</h4>
					</div>
					<div class="card-body">
						<div class="form-group">
							<div class="custom-control custom-radio">
								<input type="radio" class="custom-control-input" name="payment"
									id="paypal"> <label class="custom-control-label"
									for="paypal">Paypal</label>
							</div>
						</div>
						<div class="form-group">
							<div class="custom-control custom-radio">
								<input type="radio" class="custom-control-input" name="payment"
									id="directcheck"> <label class="custom-control-label"
									for="directcheck">Direct Check</label>
							</div>
						</div>
						<div class="">
							<div class="custom-control custom-radio">
								<input type="radio" class="custom-control-input" name="payment"
									id="banktransfer"> <label class="custom-control-label"
									for="banktransfer">Bank Transfer</label>
							</div>
						</div>
					</div>
					<div class="card-footer border-secondary bg-transparent">
						<button
							class="btn btn-lg btn-block btn-primary font-weight-bold my-3 py-3">Place
							Order</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Checkout End -->

</body>
