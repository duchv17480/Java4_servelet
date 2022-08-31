package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import DAO.categoryDao;
import DAO.productDao;
import entities.Category;
import entities.Product;

@WebServlet({"/product/index",
	"/product/store",
	"/product/create",
	"/product/edit",
	"/product/update",
	"/product/delete",
})
public class productServlet extends HttpServlet {
	private productDao prodao;
	private categoryDao catedao;
    public productServlet() {
    	this.prodao= new productDao();
    	this.catedao= new categoryDao();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		if (uri.contains("index")) {
			this.index(request, response);
		} else if (uri.contains("create")) {
			this.create(request, response);
		} else if (uri.contains("edit")) {
			this.edit(request, response);
		} else if (uri.contains("delete")) {
			try {
				this.delete(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private void delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		Product entity = this.prodao.findById(id);
		this.prodao.delete(entity);
		response.sendRedirect("/ASS_PH17480/product/index");
		
	}
	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Category> ds = this.catedao.getAll();
		request.setAttribute("ds", ds);
		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);
		Product entity = this.prodao.findById(id);

		Category categories = entity.getCate();
		request.setAttribute("categories", categories);
		request.setAttribute("product", entity);
		request.setAttribute("view", "/views/admin/product/edit.jsp");
		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
		
	}
	private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Category> ds = this.catedao.getAll();
		System.out.println(ds);
		request.setAttribute("ds", ds);
		request.setAttribute("view", "/views/admin/product/create.jsp");
		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
		
	}
	private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Product> ds = this.prodao.getAll();
		request.setAttribute("ds", ds);
		request.setAttribute("view", "/views/admin/product/index.jsp");
		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		if (uri.contains("store")) {
			this.store(request, response);
		} else if (uri.contains("update")) {
			this.update(request, response);
		}
	}
	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			String CateIdStr = request.getParameter("category_Id");
			int cateId = Integer.parseInt(CateIdStr);
			Category cate = this.catedao.finById(cateId);

			Product entity = prodao.findById(Integer.parseInt(request.getParameter("id")));
			entity.setCate(cate);
			BeanUtils.populate(entity, request.getParameterMap());
			this.prodao.update(entity);
			response.sendRedirect("/ASS_PH17480/product/index");
		} catch (Exception e) {
			e.printStackTrace();
			String id = request.getParameter("id");
			response.sendRedirect("/ASS_PH17480/product/edit?id=" + id);
		}
	}
	
	private void store(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		try {
			String CateIdStr = request.getParameter("category_Id");
			int cateId = Integer.parseInt(CateIdStr);
			Category cate = this.catedao.finById(cateId);
			Product entity = new Product();
			entity.setCate(cate);
			BeanUtils.populate(entity, request.getParameterMap());
			this.prodao.create(entity);
			session.setAttribute("message", "Thêm mới thành công");
			response.sendRedirect("/ASS_PH17480/product/index");
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("error", "Thêm mới thất bại");
			response.sendRedirect("/ASS_PH17480/product/create");
		}
		
	}

}
