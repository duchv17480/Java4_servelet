<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<c:if test="${ !empty sessionScope.error }">
	<div class="alert alert-danger">${sessionScope.error }</div>
	<c:remove var="error" scope="session"></c:remove>
</c:if>

<c:if test="${ !empty sessionScope.message }">
	<div class="alert alert-success">${sessionScope.message }</div>
	<c:remove var="message" scope="session"></c:remove>
</c:if>
<c:if test="${empty ds}">
	<p class="alert alert-warning">Không có dữ liệu</p>
</c:if>
<a class="btn btn-success" href="/ASS_PH17480/product/create">Them
	moi </a>
<c:if test="${!empty ds}">
	<table class="table table-success table-striped">
		<thead>
			<th>Tên sản phẩm</th>
			<th>Thể loại</th>
			<th>Đơn giá</th>
			<th>Kích thước</th>
			<th>Màu sắc</th>
			<th>Số lượng</th>
			<th>Img</th>
			<th colspan="2">Thao tác</th>

		</thead>
		<tbody>
			<c:forEach items="${ ds }" var="obj">
				<tr>
					<td>${ obj.ten }</td>
					<td>${ obj.cate.ten }</td>
					<td>${ obj.donGia }</td>
					<td>${ obj.kichThuoc }</td>
					<td>${ obj.mauSac }</td>
					<td>${ obj.soLuong }</td>
					<td>${ obj.img }</td>
					<td><a class="btn btn-primary"
						href="/ASS_PH17480/product/edit?id=${obj.id }">Cập nhật</a></td>
					<td><button type="button" class="btn btn-danger"
							data-bs-toggle="modal" data-bs-target="#p${obj.id}">Xóa</button>
						<!-- Modal -->
						<div class="modal fade" id="p${obj.id}" tabindex="-1"
							aria-labelledby="exampleModalLabel" aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title" id="exampleModalLabel">Bạn có
											chắc muốn xóa</h5>
										<button type="button" class="btn-close"
											data-bs-dismiss="modal" aria-label="Close"></button>
									</div>
									<div class="modal-body">Xóa mất luôn đấy đại ka cẩn thận</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-secondary"
											data-bs-dismiss="modal">Close</button>
										<a class="btn btn-danger"
											href="/ASS_PH17480/product/delete?id=${obj.id}">Xóa</a>
									</div>
								</div>
							</div>
						</div>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</c:if>