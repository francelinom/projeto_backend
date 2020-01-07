package com.ufrn.eaj.demo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorld
 */
@WebServlet("/HelloWorld")
public class HelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloWorld() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("nome");
		response.getWriter().append("Hello, " + name +".");
		

		Connection connection = null;
	    try {   
	    	connection = ConectaBanco.getConnection();
	    } catch (SQLException ex) {   
	    	response.getWriter().append("Connection Failed! Check output console");   
	    }
	    
	    if(connection!= null){
			response.getWriter().append("A conex�o com o banco foi realizada!");
	    }else{
	    	response.getWriter().append("A conex�o com o banco falhou!");
	    }
	    

		
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
