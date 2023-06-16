package servlet;

import DAO.TeaDAO;
import model.Tea;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/tea")
public class TeaServlet extends HttpServlet {
    private TeaDAO teaDAO;

    @Override
    public void init() throws ServletException {
        teaDAO = new TeaDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        String teaIdString = requestURI.substring(requestURI.lastIndexOf('/') + 1);

        if (teaIdString.isEmpty()) {
            // Get all teas
            List<Tea> teas = teaDAO.getAllTeas();
            request.setAttribute("teas", teas);
            request.getRequestDispatcher("/WEB-INF/views/teas.html").forward(request, response);
        } else {
            // Get a specific tea
            Long teaId = Long.parseLong(teaIdString);
            Tea tea = teaDAO.getTeaById(teaId);
            request.setAttribute("tea", tea);
            request.getRequestDispatcher("/WEB-INF/views/tea.html").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        double price = Double.parseDouble(request.getParameter("price"));

        Tea tea = new Tea();
        tea.setName(name);
        tea.setDescription(description);
        tea.setPrice(price);

        teaDAO.addTea(tea);

        response.sendRedirect(request.getContextPath() + "/");
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String teaIdString = request.getParameter("id");
        Long teaId = Long.parseLong(teaIdString);

        Tea tea = teaDAO.getTeaById(teaId);
        if (tea != null) {
            String name = request.getParameter("name");
            String description = request.getParameter("description");
            double price = Double.parseDouble(request.getParameter("price"));

            tea.setName(name);
            tea.setDescription(description);
            tea.setPrice(price);

            teaDAO.updateTea(tea);
        }

        response.sendRedirect(request.getContextPath() + "/");
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String teaIdString = request.getParameter("id");
        Long teaId = Long.parseLong(teaIdString);

        teaDAO.deleteTea(teaId);

        response.sendRedirect(request.getContextPath() + "/");
    }

    @Override
    public void destroy() {
        teaDAO = null;
    }
}
