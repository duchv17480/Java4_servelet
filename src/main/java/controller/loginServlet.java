package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.userDao;
import entities.User;
import utils.EncryptUtil;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private userDao userDao;

	public loginServlet() {
		super();
		this.userDao=new userDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("view","/views/login.jsp");
		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String pass = request.getParameter("password");
		System.out.print(email + "_" + pass);
		User u = this.userDao.findByEmail(email);

		HttpSession session = request.getSession();
		boolean check = EncryptUtil.check(pass, u.getPassword());
		if (check == true) {
			session.setAttribute("user", u);
			request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
		} else {
			System.out.println("Lỗi r đại ka");
		}
	}

}
