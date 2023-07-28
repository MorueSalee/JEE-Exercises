package fr.eni.ecole.ihm;

import java.io.IOException;
import java.net.http.HttpRequest;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.ecole.bo.Page;

/**
 * Servlet Filter implementation class Page10Filter
 */
@WebFilter("/*")
public class Page10Filter implements Filter {

    /**
     * Default constructor. 
     */
    public Page10Filter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// Cast ServletRequest and ServletResponse to HttpServletRequest and HttpServletResponse
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // Get the session
       // HttpSession session = httpRequest.getSession();

        // Get the pageNumber parameter from the session
        Integer pageNumber = Integer.parseInt(httpRequest.getParameter("pageNumber"));
        //Integer currentPage = (Integer) session.getAttribute("pageNumber");
        
        // If pageNumber is not less than 10, redirect to an error page or return an error message
        if (pageNumber == null || pageNumber >= 10) {
        	System.out.println("hjgbf");
            // You can customize this part based on your application requirements
            httpResponse.sendRedirect("/error-page");
            return;
        }

        // Continue the request-response chain
        chain.doFilter(request, response);
    }


	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
