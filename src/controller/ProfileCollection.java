package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.beans.Copy;
import modelo.beans.User;
import modelo.daos.CopyDaoImpl;

@WebServlet("/ProfileCollection")
public class ProfileCollection extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProfileCollection() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		CopyDaoImpl copyDao = new CopyDaoImpl(); 
		User user = (User) session.getAttribute("user");	
		String searchedGameTitle = request.getParameter("gameTitle");
		
		List<Copy> foundCopies = searchedGameTitle != null 
		? copyDao.findInUserByGameTitle(user.getUserId(), searchedGameTitle)
		: copyDao.findAllInUser(user.getUserId());
		
		request.setAttribute("foundCopies", foundCopies);
		request.setAttribute("gameTitle", searchedGameTitle);
		request.getRequestDispatcher("profile-collection.jsp").forward(request,response);
	}

}
