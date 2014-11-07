<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:useBean id="date" class="java.util.Date" />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta charset="utf-8">
    	<meta http-equiv="X-UA-Compatible" content="IE=edge">
   		<meta name="viewport" content="width=device-width, initial-scale=1">
   		
   		<!-- Bootstrap CSS -->
		<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
		
		<!-- EyeChamp CSS -->
		<link href="<c:url value="/resources/css/EyeChamp.css" />" rel="stylesheet">
				
		<title>EyeChamp - Oops!</title>
	</head>

	<body>
	
		<div class="container">
	        <h1>Oops, ${statusCode}</h1>
	        <h3>Something went wrong while requesting this page</h3>
	        <c:if test="${not empty message}">
	        	 <h5>Some small information about the exception:</h5>
	       		 <p>
	       		 	<code>${message}</code>
	       		 </p>
	       		 
	       		<h5>StackTrace</h5>
	       		 <p>
	       		 	<code>${stackTrace}</code>
	       		 </p>		       		 
	        </c:if>	       
	        <p><a class="btn btn-success" href="<c:url value="/" />" role="button">Go back home</a></p>
	        
	        <div class="footer">
				<p>&copy; EyeChamp <fmt:formatDate value="${date}" pattern="yyyy" /></p>
			</div>      			
      	</div>
      	
		<script src="<c:url value="/resources/js/jquery.min.js" />"></script>
		<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
	</body>
</html>
