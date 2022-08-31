<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" href="/ASS_PH17480/css/bootstrap.min.css">
<form method="Post" action="/ASS_PH17480/users/store">
	<div class=row>
		<div class="card border-dark mt-1">
			<h5 class="card-header" style="font-size: x-large;">
				<a class="text-danger" style="text-decoration: none; color: black;">Hoàng
					Việt Đức</a>
			</h5>
			<div class="card-body">
				<div class="form-group mt-3">
					<label class="col-3">Họ tên</label> <input class="col-9"
						type="text" name="hoTen" />
				</div>
				<div class="form-group mt-3">
					<label class="col-3">Địa chỉ</label> <input class="col-9"
						type="text" name="diaChi" />
				</div>
				<div class="form-group mt-3">
					<label class="col-3">Email</label> <input class="col-9"
						type="email" name="email" />
				</div>
				<div class="form-group mt-3">
					<label class="col-3">Password</label> <input class="col-9"
						type="password" name="password" />
				</div>
				<div class="form-group mt-3">
					<label class="col-3">SĐT</label> <input class="col-9" type="text"
						name="sdt" />
				</div>
				<div class="row mt-1">
					<div>
						<button>Thêm mới</button>
						<button type="reset">Xóa form</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</form>
<script src="/ASS_PH17480/js/jquery.min.js"></script>
<script src="/ASS_PH17480/js/popper.min.js"></script>
<script src="/ASS_PH17480/js/bootstra.min.js"></script>