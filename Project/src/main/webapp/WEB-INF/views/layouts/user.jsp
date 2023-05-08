<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<title><decorator:title default="Mater-Layout"></decorator:title></title>
<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta content="Free HTML Templates" name="keywords">
<meta content="Free HTML Templates" name="description">

<!-- Favicon -->
<link href="<c:url value="/assets/user/ img/favicon.ico"/>" rel="icon">

<!-- Google Web Fonts -->
<link rel="preconnect" href="<c:url value="https://fonts.gstatic.com"/>">
<link
	href="<c:url value="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap"/>"
	rel="stylesheet">

<!-- Font Awesome -->
<link
	href="<c:url value="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css"/>"
	rel="stylesheet">

<!-- Libraries Stylesheet -->
<link
	href="<c:url value="/assets/user/lib/owlcarousel/assets/owl.carousel.min.css"/>"
	rel="stylesheet">

<!-- Customized Bootstrap Stylesheet -->
<link href="<c:url value="/assets/user/css/style.css"/>"
	rel="stylesheet">
</head>

<body>
	<%@include file="/WEB-INF/views/layouts/user/header.jsp"%>
	<decorator:body />
	<%@include file="/WEB-INF/views/layouts/user/footer.jsp"%>

	<!-- JavaScript Libraries -->
	<script
		src="<c:url value="https://code.jquery.com/jquery-3.4.1.min.js"/>"></script>
	<script
		src="<c:url value="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"/>"></script>
	<script src="<c:url value="/assets/user/lib/easing/easing.min.js"/>"></script>
	<script
		src="<c:url value="/assets/user/lib/owlcarousel/owl.carousel.min.js"/>"></script>
	<!-- Contact Javascript File -->
	<script
		src="<c:url value="/assets/user/mail/jqBootstrapValidation.min.js"/>"></script>
	<script src="<c:url value="/assets/user/mail/contact.js"/>"></script>

	<!-- Template Javascript -->
	<script src="<c:url value="/assets/user/js/main.js"/>"></script>
	<decorator:getProperty property="page.script"></decorator:getProperty>
</body>

</html>