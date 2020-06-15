package controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.beans.Loan;
import modelo.beans.User;
import modelo.daos.LoanDaoImpl;

@WebServlet("/ProfileLoans")
public class ProfileLoans extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProfileLoans() {
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		LoanDaoImpl loanDao = new LoanDaoImpl();
		String action = request.getParameter("action");
		Method method = null;
		boolean actionDataPresent = action != null && request.getParameter("id") != null;
				
		if( actionDataPresent) {
			int loanId = Integer.parseInt(request.getParameter("id"));
			Loan loan = loanDao.findById(loanId);
			try {
				method = loan.getClass().getMethod(action);
			} catch (SecurityException e) {
				request.setAttribute("message", e);
			} catch (NoSuchMethodException e) {
				request.setAttribute("message", e);
			}

			try {
				method.invoke(loan);
				loanDao.update(loan);
				String message = "Operación realizada con éxito.";
				request.setAttribute("message", message);
			} catch (IllegalAccessException e) {
				request.setAttribute("message", e);
			} catch (InvocationTargetException e) {
				request.setAttribute("message", e);
			}
		}
		if(user != null) {
			List<Loan> foundLoans = loanDao.findUserLoans(user.getUserId());
			List<Loan> allActiveLoans = loanDao.findAllActive();
			request.setAttribute("foundLoans", foundLoans);
			request.setAttribute("allActiveLoans", allActiveLoans);
		}
		
		request.getRequestDispatcher("profile-loans.jsp").forward(request,response);
	}

}
