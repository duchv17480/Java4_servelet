package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.productDao;
import entities.Product;

/**
 * Servlet implementation class banHangServlet
 */
@WebServlet({"/banHang/index"})
public class banHangServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    productDao proDao;
    public banHangServlet() {
        super();
        this.proDao= new productDao();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		if(uri.contains("index")) {
			this.index(request,response);
		}
	}

	private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Product> listPro = this.proDao.getAll();

		request.setAttribute("ds", listPro);

		request.setAttribute("view", "/views/banHang.jsp");

		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
