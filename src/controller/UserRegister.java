package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.beans.User;
import modelo.daos.UserDaoImpl;
import services.utils.Logic;

@WebServlet("/UserRegister")
public class UserRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserRegister() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		UserDaoImpl userDao = new UserDaoImpl();
		String page = "register.jsp";
		
		String name = request.getParameter("userName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String rePassword = request.getParameter("rePassword");
		
		boolean userExists = userDao.findByName(name) != null;
		boolean userRegistered = userDao.findByNameOrEmail(email) != null;
		boolean passwordsDifferent = !password.equals(rePassword);
		
		boolean[] errores = { 
			userExists, 
			userRegistered, 
			passwordsDifferent, 
		};
				
		if(userExists)
			request.setAttribute("usuarioExiste","El usuario ya existe.");
		if(userRegistered)
			request.setAttribute("emailError", "Ya existe el usuario con este email");
		if(passwordsDifferent)
			request.setAttribute("passwordsDifferent", "Contrase�a no coincide.");
		
		if(Logic.isAllFalse(errores)) {
			page = "index.jsp";
			User user = new User(email, name, password);
			userDao.insert(user);
			request.setAttribute("message", "El usuario se ha creado correctamente.");
		}
		request.getRequestDispatcher(page).forward(request, response);
	}

}
