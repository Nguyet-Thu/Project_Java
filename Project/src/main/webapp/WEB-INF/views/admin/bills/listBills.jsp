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
						<h1>User</h1>
					</div>
					<div class="col-sm-6">
						<ol class="breadcrumb float-sm-right">
							<li class="breadcrumb-item"><a href="#">Home</a></li>
							<li class="breadcrumb-item active">User</li>
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
								<th style="width: 10%">Id</th>
								<th style="width: 15%">Name Customer</th>
								<th style="width: 15%">Phone</th>
								<th style="width: 15%">Address</th>
								<th style="width: 15%">Total Price</th>
								<th style="width: 15%">Status</th>
								<th style="width: 20%">Detail</th>
								<th style="width: 30%"></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="b" items="${listBill}">
								<tr>
									<td>${b.id}</td>
									<td>${b.fullName}</td>
									<td>${b.phone}</td>
									<td>${b.total}</td>
									<td>${b.note}</td>
									<td>${b.status}</td>
									<td><a href="<c:url value="/Admin/BillDetails/${b.id}"/>"
										class="nav-item nav-link">Details</a></td>
									<td class="project-actions text-right"><a
										class="btn btn-primary btn-sm" href="#"> <i
											class="fas fa-folder"> </i> View
									</a> <a class="btn btn-danger btn-sm"
										href="<c:url value="/Admin/DeleteCustomer/${b.id}"/>"> <i
											class="fas fa-trash"> </i> Delete
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