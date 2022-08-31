<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="/ASS_PH17480/css/bootstrap.min.css">
<body>
	<form method="POST" action="/ASS_PH17480/loginServlet">
		<div class="row">
			<div class="card border-dark mt-1">
				<h5 class="card-header" style="font-size: x-large;">
					<a class="text-danger" style="text-decoration: none; color: black;">Hoàng
						Việt Đức</a>
				</h5>
				<div class="card-body">
					<div class="form-group mt-3">
						<label class="col-3">Email</label> <input class="col-9" type="email" name="email">
					</div>
					<div class="form-group mt-3">
						<label class="col-3">PassWord</label> <input class="col-9" type="password" name="password">
					</div>
					<button>login</button>
					<div class="row mt-1"></div>
				</div>
			</div>
	</form>
</body>
<script src="/ASS_PH17480/js/jquery.min.js"></script>
<script src="/ASS_PH17480/js/popper.min.js"></script>
<script src="/ASS_PH17480/js/bootstra.min.js"></script>
</html>