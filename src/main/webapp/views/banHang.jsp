<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<article class="row">
	<div class="col-md-9 col-md-offset-10 ">
		<div class="row p-4">
			<div class="card card-body">
				<div class="container ">
					<div class="row text-center ">
						<c:forEach items="${ ds}" var="obj">
							<div class="row">
								<div class="card col-3" style="width: 19rem;">

									<div class="card-header">
										<h5>${ obj.ten }</h5>
									</div>
									<img src="img/images.png" class="card-img-top"
										style="height: 250px;">
									<div class="card-body"></div>
									<div class="card-footer">
										<button class="btn btn-success">Thêm</button>
										<button class="btn btn-primary">Xem chi tiết</button>
									</div>

								</div>
						</c:forEach>

					</div>

					<br>
					<nav aria-label="Page navigation example">
						<ul class="pagination"
							style="position: relative; left: 36%; padding-top: 20px;">
							<li class="page-item"><a class="page-link" href="#">Previous</a></li>
							<li class="page-item"><a class="page-link" href="#">1</a></li>
							<li class="page-item"><a class="page-link" href="#">2</a></li>
							<li class="page-item"><a class="page-link" href="#">3</a></li>
							<li class="page-item"><a class="page-link" href="#">Next</a></li>
						</ul>
					</nav>
				</div>
			</div>
		</div>
	</div>

	</div>

</article>


