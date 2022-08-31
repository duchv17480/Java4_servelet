<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<c:if test="${ !empty sessionScope.error }">
	<div class="alert alert-danger">${sessionScope.error }</div>
	<c:remove var="error" scope="session"></c:remove>
</c:if>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 style="text-align: center; color: blue;">Quản lý Product</h1>
	<form action="/ASS_PH17480/product/store" method="POST">
		<div class="form-group ms-4">
			<label>Tên sản phẩm </label> <input type="text" class="form-control"
				name="ten" />
		</div>
		<div class="form-group ms-4">
			<label>Danh mục</label> <select name="category_Id"
				class="form-select">
				<c:forEach items="${ ds }" var="cate">
					<option value="${ cate.id }">${ cate.ten }</option>
				</c:forEach>
			</select>
		</div>
		<div class="form-group ms-4">
			<label>Đơn giá</label> <input type="text" class="form-control"
				name="donGia" />
		</div>
		<div class="form-group ms-4">
			<label>Kích thước</label> <input type="text" class="form-control"
				name="kichThuoc" />
		</div>
		<div class="form-group ms-4">
			<label>Màu sắc</label> <input type="text" class="form-control"
				name="mauSac" />
		</div>
		<div class="form-group ms-4">
			<label>Số lượng</label> <input type="text" class="form-control"
				name="soLuong" />
		</div>

		<div class="form-group ms-4">
			<label for="image">Image</label> <input type="file"
				class="form-control" name="img" />
		</div>

		<div class="form-group ms-4 pt-3">
			<button class="btn btn-success">Đăng ký</button>
			<button class="btn btn-primary" type="reset">Xóa Form</button>
		</div>
	</form>
</body>
</html>