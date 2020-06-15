package services.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.RandomStringUtils;

import modelo.beans.User;
import modelo.daos.UserDaoImpl;

public class PasswordService {
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	public PasswordService(HttpServletRequest request, HttpServletResponse response) {		
		this.request = request;
		this.response = response;
	}
	
	public static String resetPassword(User user, String email) {
		UserDaoImpl userDao = new UserDaoImpl();
	    String randomPassword = RandomStringUtils.randomAlphanumeric(10);

	    user.setPassword(randomPassword);
	    userDao.update(user);
	     
	    return randomPassword;
	}
	
	public String changePassword(User user) {
		UserDaoImpl userDao = new UserDaoImpl();
		
		String password = user.getPassword(); 
		String passwordInput = request.getParameter("password");
		String rePassword = request.getParameter("rePassword");
		String pattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$";
		String newPassword = request.getParameter("newPassword") != null ? request.getParameter("newPassword") : "";
		boolean passwordIncorrect = !password.equals(passwordInput);
		boolean passwordsDiffer = !newPassword.equals(rePassword);
		boolean passwordPatternWrong = !newPassword.matches(pattern); 
		if(passwordIncorrect) 
			return "Contrase�a de usuario incorrecta"; 
		if (passwordsDiffer) 
			return "Los campos con nueva contrase�a no coinciden.";
		if (passwordPatternWrong)
			return "La contrase�a debe tener al menos 8 letras de varios tama�os, 1 n�mero, sin espacios";
					
		user.setPassword(newPassword);
		userDao.update(user);
		return "La contrase�a se ha cambiado correctamente.";
	}
}
