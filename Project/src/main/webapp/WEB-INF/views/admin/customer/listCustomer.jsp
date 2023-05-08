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
								<th style="width: 1%">Id</th>
								<th style="width: 15%">User Name</th>
								<th style="width: 20%">Full Name</th>
								<th style="width: 5%">Email</th>
								<th style="width: 5%">Gender</th>
								<th style="width: 5%">Address</th>
								<th style="width: 5%">Phone</th>
								<th style="width: 2%"></th>

							</tr>
						</thead>
						<tbody>
							<c:forEach var="c" items="${listCustomer}">
								<tr>
									<td>${c.id}</td>
									<td>${c.userName}</td>
									<td>${c.fullName}</td>
									<td>${c.email}</td>
									<td>${c.gender}</td>
									<td>${c.address}</td>
									<td>${c.phone}</td>
									<td class="project-actions text-right"><a
										class="btn btn-primary btn-sm" href="#"> <i
											class="fas fa-folder"> </i> View
									</a> <a class="btn btn-danger btn-sm"
										href="<c:url value="/Admin/DeleteCustomer/${c.id}"/>"> <i
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