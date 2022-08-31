<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
		href="/Assignment/css/bootstrap.min.css" />
</head>
<body>
	<form method="POST" action="/ASS_PH17480/product/update?id=${product.id}">
		<div class="col-4">
			<label>Tên sản phẩm</label> <input type="text" name="ten"  class="form-control" value="${product.ten}" required />
		</div>
		<div class="col-4">
			<label>Danh mục</label> 
			<select name="category_Id" class="form-select">
				<c:forEach items="${ ds }" var="categories">
					<option value="${ categories.id }" ${product.cate.id == categories.id ? "selected":"" }>${ categories.ten }</option>
				</c:forEach>
			</select>
		</div>
		<div class="col-4">
			<label>Số lượng</label> <input type="text" name="soLuong"  class="form-control"  value="${product.soLuong}" required />
		</div>
		<div class="col-4">
			<label>Đơn giá</label> <input type="text" name="donGia"  class="form-control" value="${product.donGia}" required />
		</div>
		<div class="col-4">
			<label>Màu sắc</label> <input type="text" name="mauSac"  class="form-control" value="${product.mauSac}" required />
		</div>
			<div class="col-4">
			<label>Kích thước</label> <input type="text" name="kichThuoc"  class="form-control" value="${product.kichThuoc}" required />
		</div>
			<div class="col-4">
			<label>Ảnh</label> <input type="file" name="img"  class="form-control" value="${product.img}" required />
		</div>
		
		<div class="mt-3">
		<button type="submit" class="btn btn-primary">Cập nhật</button>
		<button type="reset" class="btn btn-danger">Xóa form</button>
	</div>
	</form>
</body>
</html>