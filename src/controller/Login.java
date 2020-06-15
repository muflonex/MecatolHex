package controller;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.beans.User;
import modelo.daos.UserDaoImpl;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Login() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserDaoImpl userDao = new UserDaoImpl();
		
		String page = "index.jsp";
		User user = null;
		Boolean isAdmin = false;
		Boolean passCorrect = false;
		String pass = request.getParameter("password");
		String userName = request.getParameter("userName");
		user = userDao.findByNameOrEmail(userName);

		isAdmin = user != null ? user.getIsAdmin() != 0 : false;
		passCorrect = Objects.nonNull(user) ? pass.equals(user.getPassword()) : false;
		
		if(Objects.isNull(user))
			request.setAttribute("userNonExistent","El usuario no existe.");

		if(!passCorrect)
			request.setAttribute("passwordIncorrect", "Contraseña incorrecta.");
		
		if(Objects.nonNull(user) && passCorrect ) {
			if(isAdmin) {
				session.setAttribute("isAdmin", isAdmin);
			}
			session.setAttribute("user", user);
			page = "home.jsp";
		} 
		request.getRequestDispatcher(page).forward(request, response);
	}

}
