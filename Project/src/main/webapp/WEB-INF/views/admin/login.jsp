<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<title>Insert title here</title>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="<c:url value="/assets/admin/css/style.css"/>"
	rel="stylesheet">


<!-- Latest compiled and minified CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
	rel="stylesheet">

</head>
<body>
	<section class="vh-100 gradient-custom">
		<div class="container py-5 h-100">
			<div
				class="row d-flex justify-content-center align-items-center h-100">
				<div class="col-12 col-md-8 col-lg-6 col-xl-5">
					<div class="card bg-dark text-white" style="border-radius: 1rem;">
						<%-- <div class="card-body p-5 text-center">
							<h1>${statusLogin}</h1>
							<form:form action="LoginAdmin" method="POST"
								modelAttribute="admin">
								
								<div class="mb-md-5 mt-md-4 pb-5">

									<h2 class="fw-bold mb-2 text-uppercase">Login</h2>
									<p class="text-white-50 mb-5">Please enter your login and
										password!</p>

									<div class="form-outline form-white mb-4">
										<form:input path="adminName" class="form-control" type="text"
											placeholder="Please enter your user name" />
										<label class="form-label" for="typeEmailX">Email</label>
									</div>

									<div class="form-outline form-white mb-4">
										<form:input path="password" class="form-control"
											type="password" placeholder="Please enter your password" />
										<label class="form-label" for="typePasswordX">Password</label>
									</div>

									<p class="small mb-5 pb-lg-2">
										<a class="text-white-50" href="#!">Forgot password?</a>
									</p>

									<button class="btn btn-outline-light btn-lg px-5" type="submit" id="sendMessageButton">Login</button>
							</form:form>
							<div class="d-flex justify-content-center text-center mt-4 pt-1">
								<a href="#!" class="text-white"><i
									class="fab fa-facebook-f fa-lg"></i></a> <a href="#!"
									class="text-white"><i
									class="fab fa-twitter fa-lg mx-4 px-2"></i></a> <a href="#!"
									class="text-white"><i class="fab fa-google fa-lg"></i></a>
							</div>

						</div> --%>
						<div class="mb-4">
							<h4 class="font-weight-semi-bold mb-4">Login Account</h4>
							<h1>${statusLogin}</h1>
							<form:form action="LoginAdmin" method="POST"
								modelAttribute="admin">
								<div class="mb-5">
									<div class="control-group">
										<label>User Name</label>
										<form:input path="adminName" class="form-control" type="text"
											placeholder="Please enter your user name" />
									</div>
									<div class="control-group">
										<label>Password</label>
										<form:input path="password" class="form-control"
											type="password" placeholder="Please enter your password" />
									</div>
								</div>
								<div>
									<button class="btn btn-primary py-2 px-4" type="submit"
										id="sendMessageButton">Login</button>
								</div>
							</form:form>
						</div>

						<div>
							<p class="mb-0">
								Don't have an account? <a href="#!"
									class="text-white-50 fw-bold">Sign Up</a>
							</p>
						</div>
					</div>

				</div>
			</div>
		</div>
		</div>
	</section>

	<!-- Latest compiled JavaScript -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
	<!------ Include the above in your HEAD tag ---------->
</body>

</html>
