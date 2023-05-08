<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<title>Insert title here</title>
</head>
<body>
	<!-- Cart Start -->
	<div class="container-fluid pt-5">
		<div class="row px-xl-5">
			<div class="col-lg-8 table-responsive mb-5">
				<table class="table table-bordered text-center mb-0">
					<thead class="bg-secondary text-dark">
						<tr>
							<th>Products</th>
							<th>Price</th>
							<th>Quantity</th>
							<th>Total</th>
							<th></th>
						</tr>
					</thead>
					<tbody class="align-middle">
						<c:forEach var="item" items="${Cart}">
							<tr>
								<td class="align-middle"><img
									src="${item.value.product.image }" alt="" style="width: 50px;">${ item.value.product.productName }</td>
								<td class="align-middle">$ <fmt:formatNumber type="number"
										groupingUsed="true" value="${item.value.product.price}" /></td>
								<td class="align-middle">
									<div class="input-group quantity mx-auto" style="width: 100px;">
										<div class="input-group-btn">
											<button class="btn btn-sm btn-primary btn-minus">
												<i class="fa fa-minus"></i>
											</button>
										</div>
										<input type="number" min="0" max="1000"
											class="form-control form-control-sm bg-secondary text-center"
											id="quantity-cart-${ item.key }"
											value="${ item.value.quantity }">

										<div class="input-group-btn">
											<button class="btn btn-sm btn-primary btn-plus">
												<i class="fa fa-plus"></i>
											</button>
										</div>
									</div>
								</td>
								<td class="align-middle"><fmt:formatNumber type="number"
										groupingUsed="true" value="${item.value.totalPrice}" /></td>
								<td class="align-middle"><a>
										<button class="btn btn-sm btn-primary edit-cart"
											data-id="${item.key }">
											<i class="fa fa-sync"></i>
										</button>
								</a> <a href="<c:url value="/Home/DeleteCart/${ item.key }"/>"
									type="button">
										<button class="btn btn-sm btn-primary">
											<i class="fa fa-times"></i>
										</button>
								</a></td>
							</tr>

						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="col-lg-4">
				<form class="mb-5" action="">
					<div class="input-group">
						<input type="text" class="form-control p-4"
							placeholder="Coupon Code">
						<div class="input-group-append">
							<button class="btn btn-primary">Apply Coupon</button>
						</div>
					</div>
				</form>
				<div class="card border-secondary mb-5">
					<div class="card-header bg-secondary border-0">
						<h4 class="font-weight-semi-bold m-0">Cart Summary</h4>
					</div>
					<div class="card-body">
						<div class="d-flex justify-content-between mb-3 pt-1">
							<h6 class="font-weight-medium">Subtotal</h6>
							<h6 class="font-weight-medium"></h6>
						</div>
						<div class="d-flex justify-content-between">
							<h6 class="font-weight-medium">Shipping</h6>
							<h6 class="font-weight-medium">$10</h6>
						</div>
					</div>
					<div class="card-footer border-secondary bg-transparent">
						<div class="d-flex justify-content-between mt-2">
							<h5 class="font-weight-bold">Total</h5>
							<h5 class="font-weight-bold">${item.totalPrice}</h5>
						</div>

						<a href="<c:url value="Checkout"/>" type="button">
							<button type="submit" id="submitAccount"
								class="btn btn-block btn-primary my-3 py-3">Proceed To
								Checkout</button>
						</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Cart End -->
	<content tag="script"> <script>
    		$(".edit-cart").on("click",function(){
    			var id = $(this).data("id");
    			var quantity = $("#quantity-cart-"+id).val();
    			window.location = "EditCart/"+id+"/"+quantity;
    		});
    	</script> </content>


</body>
