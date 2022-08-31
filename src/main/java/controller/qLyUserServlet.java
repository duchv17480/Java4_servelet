package controller;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import DAO.userDao;

import entities.User;
import utils.EncryptUtil;

@WebServlet({ "/users/index", "/users/create", "/users/store", "/users/edit", "/users/update", "/users/delete" })
public class qLyUserServlet extends HttpServlet {
	private userDao usDao;

	public qLyUserServlet() {
		super();
		usDao = new userDao();
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		if (uri.contains("store")) {
			this.store(request, response);
		} else if (uri.contains("update")) {
			this.update(request, response);
		}
	}

	private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> ds = this.usDao.getAll();
		request.setAttribute("ds", ds);
		request.setAttribute("view", "/views/admin/users/index.jsp");
		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
	}

	private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("view", "/views/admin/users/create.jsp");
		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idSTr = request.getParameter("id");
		int id = Integer.parseInt(idSTr);
		User entity = this.usDao.findById(id);
		request.setAttribute("user", entity);
		request.setAttribute("view", "/views/admin/users/edit.jsp");
		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		User entity = this.usDao.findById(id);
		this.usDao.delete(entity);
		response.sendRedirect("/ASS_PH17480/users/index");
	}

	private void store(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		
		try {
			User entity = new User();
			BeanUtils.populate(entity, request.getParameterMap());
			String encryted = EncryptUtil.encrypt(request.getParameter("password"));
			entity.setPassword(encryted);
			this.usDao.create(entity);
			session.setAttribute("message", "Thêm mới thành công");
			response.sendRedirect("/ASS_PH17480/users/index");
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("error", "Thêm mới thất bại");
			response.sendRedirect("/ASS_PH17480/users/create");
		}
//		HttpSession session = request.getSession();
//		String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
//				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
//		String sdt = "^[0-9]{1}\\d{8}$";
//		Pattern pt = Pattern.compile(sdt);
//
//		try {
//			User entity = new User();
//			BeanUtils.populate(entity, request.getParameterMap());
//			Matcher matcher = pt.matcher(entity.getSdt());
//			String encrypted = EncryptUtil.encrypt(request.getParameter("password"));
//
//			if (entity.getHoTen().isEmpty() || entity.getDiaChi().isEmpty() || entity.getEmail().isEmpty()
//					|| entity.getPassword().isEmpty() || entity.getSdt().isEmpty()) {
//				session.setAttribute("error", "Nhập đầy đủ thông tin");
//				response.sendRedirect("/ASS_PH17480/users/create");
//
//			} else {
//				if (EMAIL_PATTERN.matches(entity.getEmail())) {
//					session.setAttribute("error", "Sai email");
//					response.sendRedirect("/ASS_PH17480/users/create");
//
//				} else {
//					if (matcher.find()) {
//						entity.setPassword(encrypted);
//						this.usDao.create(entity);
//						session.setAttribute("message", "Thêm mới thành công");
//						response.sendRedirect("/ASS_PH17480/users/index");
//					} else {
//						session.setAttribute("error", "Sai số điện thoại");
//						response.sendRedirect("/ASS_PH17480/users/create");
//
//					}
//				}
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			session.setAttribute("error", "Thêm mới thất bại");
//			response.sendRedirect("/ASS_PH17480/users/create");
//		}
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			User entity = new User();
			BeanUtils.populate(entity, request.getParameterMap());
			this.usDao.update(entity);
			response.sendRedirect("/ASS_PH17480/users/index");

		} catch (Exception e) {
			e.printStackTrace();
			String id = request.getParameter("id");
			response.sendRedirect("/ASS_PH17480/users/edit?id=" + id);
		}
	}

}
