<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="date" class="java.util.Date" />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link href="<c:url value="/resources/css/bootstrap.min.css" />"	rel="stylesheet">

<!-- EyeChamp CSS -->
<link href="<c:url value="/resources/css/EyeChamp.css" />" rel="stylesheet">

<script>
 var path = window.location.pathname.substring(0,window.location.pathname.substring(1).indexOf("/")+1);
</script>

<title>EyeChamp</title>
</head>

<body>
	<div class="container">
		<h1>EyeChamp</h1>
		<div class="row">
			<div class="col-md-8"> </div>
			<div class="col-md-4 border-left"> 
				<div class="row">
					<div class="col-md-6">
						<p><a class="btn btn-success btn-lg" id="newPlayerBtn" href="#" role="button">Add Player</a></p>
					</div>
					<div class="col-md-6">
						<p><a class="btn btn-success btn-lg" href="#" role="button">Toggle</a></p>
					</div>
				</div>
				<form role="form" class="hide" id="newPlayerForm">
					<div class="form-group">
						<label for="nameInput">Name</label>
						<input type="text" class="form-control" id="nameInput" placeholder="Enter name" />
					</div>
				</form>
				<c:forEach var="player" items="${players}" varStatus="i">
					<c:if test="${i.count % 2 != 0}">
						<div class="row">
					</c:if>
					<div class="col-md-6">
						<p>
                            <a class="btn btn-default btn-lg" href="#" role="button"><strong>${i.count}</strong> ${player.name}</a>
                            <a href="<c:url value="/player/remove/${player.name}" />" title="Delete user">X</a>
                        </p>
					</div>
					<c:if test="${i.count % 2 == 0}">
						</div>
					</c:if>
				</c:forEach>
			</div>
		</div>
		<div class="footer text-right">
			<p>
				&copy; EyeChamp
				<fmt:formatDate value="${date}" pattern="yyyy" />
			</p>
		</div>
	</div>

	<script src="<c:url value="/resources/js/jquery.min.js" />"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
	<script src="<c:url value="/resources/js/EyeChamp.js" />" ></script>
</body>
</html>