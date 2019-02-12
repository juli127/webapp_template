package ua.test.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.test.controllers.UserController;
import ua.test.models.User;

@WebServlet (urlPatterns="/userservlet")
public class UserServlet extends HttpServlet {

	// deploy on Tomacat: *.war -> <Tomcat folder>/webapps
	// verification: http://localhost:8080/webapp_template/userservlet?name=julia
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 1. get data from client
		String name = req.getParameter("name");

		// 2. Controller prepares response using data (parameters) from request
		UserController userContr = new UserController();
		User user = userContr.getUser(name);
		user.setAge(33);
		RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/views/userview.jsp");
		req.setAttribute("user", user);
		
		// 3. send prepared response data for VIEW
		rd.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}
