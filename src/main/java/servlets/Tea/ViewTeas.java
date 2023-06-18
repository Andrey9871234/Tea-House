package servlets.Tea;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
//
//import org.thymeleaf.TemplateEngine;
//import org.thymeleaf.context.Context;
//import org.thymeleaf.context.WebContext;
//import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import models.Tea;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;

import com.google.gson.Gson;

import DAO.TeaDAO;

/**
 * Servlet implementation class viewTeas
 */
@WebServlet(name = "viewTea", value = "/viewTea")
public class ViewTeas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private TeaDAO teaDAO;
    private Gson gson;

	@Override
    public void init() throws ServletException {
        super.init();
        teaDAO = new TeaDAO(); // Instantiate the TeaDAO
        gson = new Gson();
    }
    public ViewTeas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Tea> teas = teaDAO.getAllTeas();
//		ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver((ServletContext) getServletContext());
//		templateResolver.setPrefix("/"); // Set the directory where your Thymeleaf templates are located
//		templateResolver.setSuffix(".html");
//		templateResolver.setTemplateMode("HTML");
//
//		TemplateEngine templateEngine = new TemplateEngine();
//		templateEngine.setTemplateResolver(templateResolver);
//
//		WebContext webContext = new WebContext(getServletContext(), request, response);
//		webContext.setVariable("teas", teas); // Pass your model object to the template
//
//		String view = "viewTeas"; // Specify the name of your Thymeleaf template
//		String html = templateEngine.process(view, webContext);
//
//		response.setContentType("text/html");
//		response.setCharacterEncoding("UTF-8");
//		response.getWriter().write(html);
//
		String json = gson.toJson(teas);
		response.setContentType("application/json");
//        request.setAttribute("teas", teas);
//        request.getRequestDispatcher("viewTeas.html").forward(request, response);
        response.getWriter().write(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
