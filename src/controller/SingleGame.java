package controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.beans.Copy;
import modelo.beans.Game;
import modelo.beans.Loan;
import modelo.beans.User;
import modelo.daos.CopyDaoImpl;
import modelo.daos.GameDaoImpl;
import modelo.daos.LoanDaoImpl;

@WebServlet("/SingleGame")
public class SingleGame extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public SingleGame() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		GameDaoImpl gameDao = new GameDaoImpl();
		CopyDaoImpl copyDao = new CopyDaoImpl();
		LoanDaoImpl loanDao = new LoanDaoImpl();
		String page = "game.jsp";

		User user = (User) session.getAttribute("user");
		int userId = user.getUserId();
		
		int gameId = Integer.parseInt(request.getParameter("gameId"));
		
		boolean performsAction = request.getParameter("action") != null;
		boolean hasLoans = !loanDao.findUserActiveLoans(userId).isEmpty();
		if(performsAction) {
			if(!hasLoans) {
				int copyId = Integer.parseInt(request.getParameter("copyId"));
				Copy copy = copyDao.findById(copyId);			
				Loan loan = new Loan(new Date(), copy, user);
				loanDao.insert(loan);
				request.setAttribute("message", "Copia prestada con éxito.");
			}
		}
		
		Game game = gameDao.findById(gameId);
		List<Loan> allActiveLoans = loanDao.findAllActive();
		request.setAttribute("previousPage", request.getHeader("Referer"));
		request.setAttribute("game", game);
		request.setAttribute("hasLoans", hasLoans);
		request.setAttribute("allActiveLoans", allActiveLoans);
		request.getRequestDispatcher(page).forward(request,response);
	}

}
