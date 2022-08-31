<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HoangVietDuc</title>
<link rel="stylesheet" href="/ASS_PH17480/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<header class="row">
			<div id="carouselExampleControls" class="carousel slide"
				data-bs-ride="carousel">
				<div class="carousel-inner">
					<div class="carousel-item active">
						<img
							src="
              https://mdbcdn.b-cdn.net/img/Photos/Slides/img (15).webp"
							class="d-block w-100" alt="..." height="200px">
					</div>
				</div>
			</div>
		</header>
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<div class="container-fluid">
				<a class="navbar-brand" href="">Home</a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav me-auto mb-2 mb-lg-0">
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="/ASS_PH17480/users/index">User</a></li>
						<li class="nav-item"><a class="nav-link" href="/ASS_PH17480/cate/index">Category</a></li>
						<li class="nav-item"><a class="nav-link" href="/ASS_PH17480/product/index">Product</a></li>
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
							role="button" data-bs-toggle="dropdown" aria-expanded="false">
								Dropdown </a>
							<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
								<li><a class="dropdown-item" href="#">Action</a></li>
								<li><a class="dropdown-item" href="#">Another action</a></li>
								<li><hr class="dropdown-divider"></li>
								<li><a class="dropdown-item" href="#">Something else
										here</a></li>
							</ul></li>
						<li class="nav-item"><a class="nav-link disabled">Disabled</a>
						</li>
					</ul>
					<form class="d-flex">
						<input class="form-control me-2" type="search"
							placeholder="Search" aria-label="Search">
						<button class="btn btn-outline-success" type="submit">Search</button>
					</form>
				</div>
			</div>
		</nav>
		<div class="row m-0">
			<div class="col-3">
				<div class="card mt-2">
					<div class="card-body">
						<div class="row">
							<img src="image/ducPolyjpg.jpg" alt="">
							<div class="row text-center">
								<h4>Hoàng Việt Đức - PH17480</h4>
							</div>
						</div>
					</div>
				</div>
				<div class="list-group pt-2 ps-1">
					<p class="list-group-item">
						<b>Danh Mục</b>
					</p>
				</div>
			</div>
			<div class="col-9" style="background-color: #C0C0C0">
				<jsp:include page="${ view }"></jsp:include>
			</div>
		</div>
		<div class="row m-0" style="background-color: pink">
			<marquee>HoangVietDuc</marquee>
		</div>
	</div>
	<script src="/ASS_PH17480/js/jquery.min.js"></script>
	<script src="/ASS_PH17480/js/popper.min.js"></script>
	<script src="/ASS_PH17480/js/bootstrap.min.js"></script>
</body>
</html>