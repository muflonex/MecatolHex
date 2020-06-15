package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.beans.User;
import services.utils.PasswordService;

@WebServlet("/ProfilePasswordChange")
public class ProfilePasswordChange extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProfilePasswordChange() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");	
		PasswordService ps = new PasswordService(request, response);
		String message = ps.changePassword(user);
		request.setAttribute("message", message);
		
		request.getRequestDispatcher("profile-change-password.jsp").forward(request,response);
	}

}
