package controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import modelo.beans.Game;
import modelo.daos.GameDaoImpl;

@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Search() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GameDaoImpl gameDao = new GameDaoImpl();
		String page = "search.jsp";
		Map params = request.getParameterMap();
		
		List<Game> games = gameDao.query(params);

		for (Object param: params.keySet()) {
			String key = (String) param;
			/*There can be more than 1 parameter of same key*/
			String[] values = (String[])params.get(key);
			request.setAttribute(key, values[0]);
		}
		
		request.setAttribute("foundGames", games);	
		request.getRequestDispatcher(page).forward(request, response);
	}

}
