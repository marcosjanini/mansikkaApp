package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data_access.ClientDAO;

/**
 * Servlet implementation class ClientDeleteServlet
 */
@WebServlet("/deleteClient")
public class ClientDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
	
		int id =Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
		
		ClientDAO clientDAO = new ClientDAO();
			
		int result = clientDAO.deleteClient(id);
		
		out.println(result);		
	}
}

