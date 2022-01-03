package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data_access.ClientDAO;
import model.Client;

@WebServlet("/addClient")

public class ClientAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1. Get a PrintWriter object for writing the text to be sent to the browser
		PrintWriter out = response.getWriter();
		response.setContentType("\"application/x-www-form-urlencoded");
		response.setCharacterEncoding("UTF-8");

		// 2. Retrieve the values of the request parameters
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
		String firstname = request.getParameter("firstname");
		System.out.println(firstname);
		String lastname = request.getParameter("lastname");
		System.out.println(lastname);
		String phone = request.getParameter("phone");
		System.out.println(phone);
		String email = request.getParameter("email");
		System.out.println(email);
		String taxId = request.getParameter("taxId");
		System.out.println(taxId);
		String streetaddress = request.getParameter("streetaddress");
		System.out.println(streetaddress);
		String postcode = request.getParameter("postcode");
		System.out.println(postcode);
		String city = request.getParameter("city");
		System.out.println(city);

		Client client = new Client(id, firstname, lastname, phone, email, taxId, streetaddress, postcode, city);

		ClientDAO clientDao = new ClientDAO();
		int errorCode = clientDao.insertClient(client);
		out.print(errorCode);

	}

}
