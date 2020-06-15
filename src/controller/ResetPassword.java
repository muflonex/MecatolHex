package controller;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.beans.User;
import modelo.daos.UserDaoImpl;
import services.mail.EmailUtility;
import services.utils.PasswordService;
 
@WebServlet("/ResetPassword")
public class ResetPassword extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    private String host;
    private String port;
    private String email;
    private String name;
    private String pass;
 
    public void init() {
        // reads SMTP server setting from web.xml file
        ServletContext context = getServletContext();
        host = context.getInitParameter("host");
        port = context.getInitParameter("port");
        email = context.getInitParameter("email");
        name = context.getInitParameter("name");
        pass = context.getInitParameter("pass");
    }
 
    public ResetPassword() {
    }
 
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	String page = "reset.jsp";
    	
    	UserDaoImpl userDao = new UserDaoImpl();
		User user = null;
		
        String recipientEmail = request.getParameter("email");
        user = userDao.findByEmail(recipientEmail);
        
        if(Objects.isNull(user))
			request.setAttribute("emailNotRegistered","Este email no tiene ningún usuario asociado.");
        
        if(Objects.nonNull(user)) {
	        String subject = "Mecatol Hex — Cambio de contraseña";
	 
	        String newPassword = PasswordService.resetPassword(user, recipientEmail);
	 
	        String content = "Hola, esta es tu nueva contraseña: " + newPassword;
	        content += "\nAviso: por motivos de seguridad, "
	                + "tienes que cambiar la contraseña después de ingresar.";
	 
	        String message = "";
	 
	        try {
	            EmailUtility.sendEmail(host, port, email, name, pass,
	                    recipientEmail, subject, content);
	            message = "Tu contraseña ha sido cambiada. Comprueba tu buzón e-mail.";
	        } catch (Exception ex) {
	            ex.printStackTrace();
	            message = "Ha occurrido un error: " + ex.getMessage();
	        } finally {
	            request.setAttribute("message", message);
	        }
        }
        request.getRequestDispatcher(page).forward(request, response);
    }
 
}
