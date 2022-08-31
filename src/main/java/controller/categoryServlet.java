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
import DAO.userDao;
import entities.Category;
import entities.User;

@WebServlet({ "/cate/index","/cate/index1", "/cate/create", "/cate/store", "/cate/edit", "/cate/update", "/cate/delete" })
public class categoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private userDao usdao;
	private categoryDao cateDao;

	public categoryServlet() {
		this.usdao = new userDao();
		this.cateDao = new categoryDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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

	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Category entity = this.cateDao.finById(id);
		this.cateDao.delete(entity);
		response.sendRedirect("/ASS_PH17480/cate/index");
	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr= request.getParameter("id");
		int id = Integer.parseInt(idStr);
		Category entity= cateDao.finById(id);
		User user = entity.getUser();
		request.setAttribute("user", user);
		request.setAttribute("cate", entity);
		request.setAttribute("view", "/views/admin/categories/edit.jsp");
		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);

	}

	private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> ds = this.usdao.getAll();
		request.setAttribute("ds", ds);
		request.setAttribute("view", "/views/admin/categories/create.jsp");
		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);

	}

	private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Category> ds = this.cateDao.getAll();
		request.setAttribute("ds", ds);
		request.setAttribute("view", "/views/admin/categories/index.jsp");
		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		if (uri.contains("store")) {
			this.store(request, response);
		} else if (uri.contains("update")) {
			this.update(request, response);
		}

	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		try {
			Category entity = cateDao.finById(Integer.parseInt(request.getParameter("id")));
			BeanUtils.populate(entity, request.getParameterMap());
			this.cateDao.update(entity);
			session.setAttribute("message", "Cập nhật thành công");
			response.sendRedirect("/ASS_PH17480/cate/index");
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("error", "Cập nhật thất bại");
			String id = request.getParameter("id");
			response.sendRedirect("/ASS_PH17480/cate/edit?id=" + id);
		}
	}

	private void store(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			String ten = request.getParameter("ten");
			String userIdStr = request.getParameter("user_id");
			int userId = Integer.parseInt(userIdStr);
			User u = this.usdao.findById(userId);
			Category entity = new Category();
			entity.setTen(ten);
			entity.setUser(u);
			BeanUtils.populate(entity, request.getParameterMap());
			this.cateDao.create(entity);
			response.sendRedirect("/ASS_PH17480/cate/index");
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
