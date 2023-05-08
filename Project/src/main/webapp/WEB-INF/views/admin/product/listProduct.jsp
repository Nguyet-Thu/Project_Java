<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<title>Insert title here</title>
<body>
	<div class="content-wrapper">
		<!-- Content Header (Page header) -->
		<section class="content-header">
			<div class="container-fluid">
				<div class="row mb-2">
					<div class="col-sm-6">
						<h1>Projects</h1>
					</div>
					<div class="col-sm-6">
						<ol class="breadcrumb float-sm-right">
							<li class="breadcrumb-item"><a href="#">Home</a></li>
							<li class="breadcrumb-item active">Projects</li>
						</ol>
					</div>
				</div>
			</div>
			<!-- /.container-fluid -->
		</section>

		<!-- Main content -->
		<section class="content">

			<!-- Default box -->
			<div class="card">
				<div class="card-header">
					<h3 class="card-title">Projects</h3>

					<div class="card-tools">
						<button type="button" class="btn btn-tool"
							data-card-widget="collapse" title="Collapse">
							<i class="fas fa-minus"></i>
						</button>
						<button type="button" class="btn btn-tool"
							data-card-widget="remove" title="Remove">
							<i class="fas fa-times"></i>
						</button>
					</div>
				</div>
				<div class="card-body p-0">
					<table class="table table-striped projects">
						<thead>
							<tr>
								<th style="width: 1%">Id</th>
								<th style="width: 10%">Name Product</th>
								<th style="width: 10%">Product Content</th>
								<th style="width: 30%">Description</th>
								<th style="width: 10%">Price</th>
								<th style="width: 50%">Image</th>
								<th style="width: 20%">Quantity</th>
								<th style="width: 1%">Category</th>
								<th style="width: 10%" class="text-center">Status</th>
								<th style="width: 20%"></th>

							</tr>
						</thead>
						<tbody>
							<c:forEach var="product" items="${listProduct}">
								<tr style="">
									<td>${product.id}</td>
									<td>${product.productName}</td>
									<td>${product.productContent}</td>
									<td>${product.description}</td>
									<td>${product.price}</td>
									<td><img class="" width="300" height="300"
										src="<c:url value="/assets/user/img/product/${product.image}"/>"
										alt=""></td>
									<td>${product.quantity}</td>
									<td>${product.categoryName}</td>

									<td class="project-state">${product.status?"Còn hàng":"Hết hàng"}
									</td>
									<td class="project-actions text-right"><a
										class="btn btn-primary btn-sm" href="#"> <i
											class="fas fa-folder"> </i> View
									</a> <a class="btn btn-info btn-sm"
										href="<c:url value="/Admin/EditProduct/${product.id}"/>">
											<i class="fas fa-pencil-alt"> </i> Edit
									</a> <a class="btn btn-danger btn-sm"
										href="<c:url value="/Admin/DeleteProduct/${product.id}"/>">
											<i class="fas fa-trash"> </i> Delete
									</a></td>
								</tr>
							</c:forEach>
						</tbody>

					</table>
				</div>
				<!-- /.card-body -->
			</div>
			<!-- /.card -->

		</section>
		<!-- /.content -->
	</div>
</body>