package fr.eni.ecole.ihm;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GuessNumberServlet
 */
@WebServlet("/GuessNumberServlet")
public class GuessNumberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Integer numberToGuess;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuessNumberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/guessNumber.jsp").forward(request, response);
		
        numberToGuess = getRandom();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer number = Integer.parseInt(request.getParameter("number"));
		String message;
		
		if(number > numberToGuess) {
			message = "Lower !";
		}else if(number < numberToGuess) {
			message = "Higher !";
		}else {
			message = "Bravo, it was " + numberToGuess + " ! Play again ?";
			numberToGuess = getRandom();
		}
		
		request.setAttribute("message", message);
		request.getRequestDispatcher("/WEB-INF/guessNumber.jsp").forward(request, response);
	}

	private Integer getRandom() {
		int min = 1; 
        int max = 100;  //
        Random random = new Random();
        
        return random.nextInt(max - min + 1) + min;
	}
}
