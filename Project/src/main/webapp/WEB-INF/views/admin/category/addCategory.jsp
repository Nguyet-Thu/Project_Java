<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<title>Add Category</title>
</head>
<body>
	<div class="content-wrapper">
		<!-- Content Header (Page header) -->
		<section class="content-header">
			<div class="container-fluid">
				<div class="row mb-2">
					<div class="col-sm-6">
						<h1>Add Category</h1>
					</div>
					<div class="col-sm-6">
						<ol class="breadcrumb float-sm-right">
							<li class="breadcrumb-item"><a href="#">Home</a></li>
							<li class="breadcrumb-item active">Category Add</li>
						</ol>
					</div>
				</div>
			</div>
			<!-- /.container-fluid -->
		</section>

		<!-- Main content -->
		<section class="content">
			<div class="row">
				<div class="col-lg-8">
					<div class="card-body">
						<form:form action="AddCategory" method="POST" modelAttribute="cat">
							<div class="form-group">
								<label for="inputName">Name Category</label>
								<form:input path="nameCategory" class="form-control" type="text"
									placeholder="Please enter name category" />
							</div>
							<div class="form-group">
								<label for="inputDescription">Description</label>
								<form:textarea path="description" type="text"
									class="form-control" rows="4" />
							</div>
							<div class="form-group">
								<label for="inputStatus">Status</label>
								<form:radiobutton path="status" value="1" />
								Còn Hàng
								<form:radiobutton path="status" value="0" />
								Hết Hàng
							</div>

							<div class="form-group">
								<input type="submit" value="Create new Project"
									class="btn btn-success" />
							</div>
						</form:form>
					</div>
					<!-- /.card-body -->

				</div>
				<!-- /.card -->
			</div>
	</div>
	<div class="row">
		<div class="col-12"></div>
	</div>
	</section>
	<!-- /.content -->
	</div>
	<!-- /.content-wrapper -->
</body>