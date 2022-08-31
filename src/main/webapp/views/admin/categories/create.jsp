<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="POST"
		action="/ASS_PH17480/cate/store">
		<div>
			<label>Tên danh mục</label>
			<input type="text" name="ten" />
		</div>
		<div>
			<label>Người tạo</label>
			<select name="user_id">
				<c:forEach items="${ ds }" var="user">
					<option value="${ user.id }">
						${ user.hoTen }
					</option>
				</c:forEach>
			</select>
		</div>
		
		<button>Thêm mới</button>
	</form>
</body>
</html>