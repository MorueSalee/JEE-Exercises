package fr.eni.ecole.ihm;

import java.io.IOException;
import java.util.Iterator;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.buf.MessageBytes;

/**
 * Servlet implementation class HangManServlet
 */
@WebServlet("/HangManServlet")
public class HangManServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String wordToGuess = getRandomWord();
	
	private char[] wordToGuessArray = wordToGuess.toCharArray();
	
	private char[] wordToGuessArrayHidden = initializeWordToGuessHidden(wordToGuessArray);
	
	private String hangMan;
	
	private Integer hangState = 0;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HangManServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String wordToGuessHidden = new String(wordToGuessArrayHidden);
		
		request.setAttribute("wordToGuess", wordToGuessHidden);
		request.getRequestDispatcher("/WEB-INF/hangMan.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Input verification
		String message = "";
		if (request.getParameter("letter").length() != 1) {
			message = "You can only insert one letter at a time !";
		} else if (request.getParameter("letter").matches("[a-zA-Z]+") == false) {
			message = "You can only insert letters !";
		}else {

			//Initialisation
			char letter = request.getParameter("letter").charAt(0);
			boolean wrongGuess = true;
			
			//Traitement
			for (int i = 0 ; i < wordToGuessArray.length ; i++) {
				if (letter == wordToGuessArray[i]) {
	            	message = "Good guess !";
	            	wordToGuessArrayHidden[i] = letter;
	            	wrongGuess = false;
				}
			}
			
			if(wrongGuess == true) {
				message = "Uh oh ! Try again !";
				hangMan = incrementHangMan(hangMan);
			}
			
			//Condition de victoire ou défaite
			if(isWin(wordToGuessArrayHidden) == true) {
				message = "Bravo, you win !";
			}
			if (hangState == 6) {
				message = "You lose !";
			}
		}
		
		//Affichage
		String wordToGuessHidden = new String(wordToGuessArrayHidden);
		
		request.setAttribute("message", message);
		request.setAttribute("wordToGuess", wordToGuessHidden);
		request.setAttribute("hangMan", hangMan);
		request.getRequestDispatcher("/WEB-INF/hangMan.jsp").forward(request, response);
	}

	private String incrementHangMan(String hangMan) {
		switch(hangState){
			case 0:
				hangMan = " +-----+<br>"
						+ "  |        |<br>"
						+ "  |    <br>"
						+ "  |    <br>"
						+ "  |    <br>"
						+ "  |    <br>"
						+ "=========";
				hangState++;
				break;
			case 1: 
				hangMan = " +-----+<br>"
						+ "  |        |<br>"
						+ "  |        o<br>"
						+ "  |    <br>"
						+ "  |    <br>"
						+ "  |    <br>"
						+ "=========";
				hangState++;
				break;
	   
	       case 2:
	    	   hangMan = " +-----+<br>"
						+ "  |        |<br>"
						+ "  |        o<br>"
						+ "  |        |<br>"
						+ "  |    <br>"
						+ "  |    <br>"
						+ "=========";
				hangState++;
				break;
	   
	       case 3:
	    	   hangMan = " +-----+<br>"
						+ "  |        |<br>"
						+ "  |        o<br>"
						+ "  |       /|<br>"
						+ "  |    <br>"
						+ "  |    <br>"
						+ "=========";
				hangState++;
				break;
				
	       case 4:
	    	   hangMan = " +-----+<br>"
						+ "  |        |<br>"
						+ "  |        o<br>"
						+ "  |       /|\\<br>"
						+ "  |    <br>"
						+ "  |    <br>"
						+ "=========";
				hangState++;
				break;
				
	       case 5:
	    	   hangMan = " +-----+<br>"
						+ "  |        |<br>"
						+ "  |        o<br>"
						+ "  |       /|\\<br>"
						+ "  |       /<br>"
						+ "  |    <br>"
						+ "=========";
				hangState++;
				break;
				
	       case 6:
	    	   hangMan = " +-----+<br>"
						+ "  |        |<br>"
						+ "  |        o<br>"
						+ "  |       /|\\<br>"
						+ "  |       / \\<br>"
						+ "  |    <br>"
						+ "=========";
				hangState++;
				break;
	   }
		
		return hangMan;
	}
	
	private char[] initializeWordToGuessHidden(char[] a) {
		char[] response = new char[a.length];
		for (int i = 0 ; i < response.length ; i++) {
			response[i] = '-';
		}
		return response;
	}
	
	private boolean isWin(char[] a) {
		boolean b = true;
		for (char letter : a) {
			if (letter == '-') {
				b = false;
			}
		}
		
		if (b == false) {
			return false;
		}else {
			return true;
		}
	
	}
	
	private String getRandomWord() {
		String[] words = {"babouin", "banane", "orange", "fruit", "java"};
		
		Random random = new Random();

        // Generate a random index to select a word from the array
        int randomIndex = random.nextInt(words.length);

        // Get the random word from the array
        return words[randomIndex];
	}

}
