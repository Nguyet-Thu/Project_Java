<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Trang chủ</title>
<body>
	<h1>${allproductbyId.size()}</h1>
	<!-- Shop Start -->
	<div class="container-fluid pt-5">
		<div class="row px-xl-5">
			<!-- Shop Sidebar Start -->
			<div class="col-lg-3 col-md-12"></div>
			<!-- Shop Sidebar End -->


			<!-- Shop Product Start -->
			<div class="col-lg-9 col-md-12">
				<div class="row pb-3">
					<div class="col-12 pb-1">
						<div
							class="d-flex align-items-center justify-content-between mb-4">
							<form action="">
								<div class="input-group">
									<input type="text" class="form-control"
										placeholder="Search by name">
									<div class="input-group-append">
										<span class="input-group-text bg-transparent text-primary">
											<i class="fa fa-search"></i>
										</span>
									</div>
								</div>
							</form>
							<div class="dropdown ml-4">
								<button class="btn border dropdown-toggle" type="button"
									id="triggerId" data-toggle="dropdown" aria-haspopup="true"
									aria-expanded="false">Sort by</button>
								<div class="dropdown-menu dropdown-menu-right"
									aria-labelledby="triggerId">
									<a class="dropdown-item" href="#">Latest</a> <a
										class="dropdown-item" href="#">Popularity</a> <a
										class="dropdown-item" href="#">Best Rating</a>
								</div>
							</div>
						</div>
					</div>

					<c:if test="${productsPaginate.size()>0 }">
						<div class="col-lg-4 col-md-6 col-sm-12 pb-1">
							<c:forEach var="p" items="${productsPaginate}" varStatus="loop">
								<div class="card product-item border-0 mb-4">
									<div
										class="card-header product-img position-relative overflow-hidden bg-transparent border p-0">
										<img class=" " width="300" height="300"
											src="<c:url value="/assets/user/img/product/${p.image}"/>"
											alt="">
									</div>
									<div
										class="card-body border-left border-right text-center p-0 pt-4 pb-3">
										<h6 class="text-truncate mb-3">${p.productName}</h6>
										<div class="d-flex justify-content-center">
											<h6>${p.price}</h6>

										</div>
									</div>
									<div
										class="card-footer d-flex justify-content-between bg-light border">
										<a href="<c:url value="/Home/product_detail/${p.id}"/>"
											class="btn btn-sm text-dark p-0"><i
											class="fas fa-eye text-primary mr-1"></i>View Detail</a> <a
											href="<c:url value="/AddCart/${p.id}"/>"
											class="btn btn-sm text-dark p-0"><i
											class="fas fa-shopping-cart text-primary mr-1"></i>Add To
											Cart</a>
									</div>
								</div>
								<c:if
									test="${ (loop.index + 1) % 2 == 0 || (loop.index + 1)  == productsPaginate.size() }">
									</ul>
						</div>
						<c:if test="${ (loop.index + 1) < productsPaginate.size() }">
							<div class="col-lg-4 col-md-6 col-sm-12 pb-1">
						</c:if>
					</c:if>
					</c:forEach>

					</c:if>

					<div class="col-12 pb-1">
						<nav aria-label="Page navigation">
							<ul class="pagination justify-content-center mb-3">
								<li class="page-item disabled"><a class="page-link"
									href="#" aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
										<span class="sr-only">Previous</span>
								</a></li>
								<c:forEach var="p" begin="1" end="${paginateInfo.totalPage}"
									varStatus="loop">
									<c:if test="${(loop.index ) == paginateInfo.currentPage}">
										<li class="page-item active"><a class="page-link"
											href="<c:url value="/Home/product/${idCategory}/${loop.index}" />">${loop.index}</a></li>
									</c:if>
									<c:if test="${ (loop.index ) != paginateInfo.currentPage}">
										<li class="page-item"><a class="page-link"
											href="<c:url value="/Home/product/${idCategory}/${loop.index}" />">${loop.index}</a></li>
									</c:if>

								</c:forEach>
								<li class="page-item"><a class="page-link" href="#"
									aria-label="Next"> <span aria-hidden="true">&raquo;</span>
										<span class="sr-only">Next</span>
								</a></li>
							</ul>
						</nav>
					</div>


				</div>
			</div>
			<!-- Shop Product End -->
		</div>
	</div>
	<!-- Shop End -->




	<!-- Back to Top -->
	<a href="#" class="btn btn-primary back-to-top"><i
		class="fa fa-angle-double-up"></i></a>


	<!-- JavaScript Libraries -->
	<script src="/assets/https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script
		src="/assets/https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
	<script src="/assets/lib/easing/easing.min.js"></script>
	<script src="/assets/lib/owlcarousel/owl.carousel.min.js"></script>

	<!-- Contact Javascript File -->
	<script src="/assets/mail/jqBootstrapValidation.min.js"></script>
	<script src="/assets/mail/contact.js"></script>

	<!-- Template Javascript -->
	<script src="/assets/js/main.js"></script>

</body>