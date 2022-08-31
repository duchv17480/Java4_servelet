<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<c:if test="${empty ds}">
	<p class="alert alert-warning">Không có dữ liệu</p>
</c:if>
<a class="btn btn-success" href="/ASS_PH17480/cate/create">Them moi
</a>
<c:if test="${!empty ds}">
	<table class="table table-success table-striped">
		<thead>
			<th>Tên Danh Mục</th>
			<th>Người Tạo</th>
			<th>Thao Tac</th>
			<th></th>
		</thead>
		<tbody>
			<c:forEach items="${ ds }" var="obj">
				<tr>
					<td>${obj.ten }</td>
					<td>${obj.user.hoTen }</td>
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
											href="/ASS_PH17480/cate/delete?id=${obj.id}">Xóa</a>
									</div>
								</div>
							</div>
						</div></td>
					<td><a class="btn btn-info"
						href="/ASS_PH17480/cate/edit?id=${obj.id}">Cập nhập</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</c:if>