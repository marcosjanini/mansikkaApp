package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import java.util.List;

import com.google.gson.Gson;

import data_access.ClientDAO;
import model.Client;


@WebServlet("/clients")
public class ClientListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/json");
		response.setCharacterEncoding("UTF-8");
				
		ClientDAO clientDAO = new ClientDAO();
		List<Client>clientList = clientDAO.getAllClients();

		Gson gson = new Gson();
		String jsonString = gson.toJson(clientList); 
						
		out.println(jsonString);
	}
}
// End