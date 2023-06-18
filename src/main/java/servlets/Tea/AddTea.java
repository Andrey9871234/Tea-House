package servlets.Tea;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Tea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import com.google.gson.Gson;

import DAO.TeaDAO;

@WebServlet(name = "addTea", value = "/addTea")
public class AddTea extends HttpServlet {
    protected void
    processRequest(HttpServletRequest request,
                   HttpServletResponse response)
        throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
    }
	private TeaDAO teaDAO;
    private Gson gson;
	private static final long serialVersionUID = 1L;

	@Override
    public void init() throws ServletException {
        super.init();
        teaDAO = new TeaDAO(); // Instantiate the TeaDAO
        gson = new Gson();
    }
	
	public AddTea() {
        super();
        // TODO Auto-generated constructor stub
    }
	
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
        throws ServletException, IOException
    {
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Read the JSON data from the request body
        BufferedReader reader = request.getReader();
        Gson gson = new Gson();
        Tea tea = gson.fromJson(reader, Tea.class);
        
        teaDAO.addTea(tea);
        
        // Prepare the response
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
        
        // Create a JSON object for the response
        String jsonResponse = gson.toJson(tea);
        
        // Send the JSON response back to the client
        writer.write(jsonResponse);
        writer.close();
    }
}
