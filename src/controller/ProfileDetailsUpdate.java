package controller;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.beans.Address;
import modelo.beans.User;
import modelo.daos.UserDaoImpl;

@WebServlet("/ProfileDetailsUpdate")
public class ProfileDetailsUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ProfileDetailsUpdate() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserDaoImpl userDao = new UserDaoImpl();
		User user = (User) session.getAttribute("user");
		double lat = Double.parseDouble(request.getParameter("lat"));
		double lng = Double.parseDouble(request.getParameter("lng"));
		String address = request.getParameter("address");
		boolean addressChanged = !user.getAddress().getAddress().equals(address); 
		
		if(addressChanged) { 
			Address userAddress = user.getAddress() != null ? user.getAddress() : new Address();
		
			userAddress.setAddress(address);
			userAddress.setLat(lat);
			userAddress.setLng(lng);
			user.setAddress(userAddress);
		}
		
		String email = request.getParameter("email");
		if(!user.getEmail().equals(email)) {
			boolean emailNotOwned = Objects.isNull(userDao.findByEmail(email));
			String message = emailNotOwned 
			? "Direcci�n e-mail cambiada correctamente."
			: "El e-mail proporcionado ya est� en uso.";
			
			request.setAttribute("message", message);
			
			if(emailNotOwned)
				user.setEmail(email);
		}

		userDao.update(user);
		
		request.getRequestDispatcher("profile-edit.jsp").forward(request,response);
	}

}
