package ru.test.market.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ru.test.market.bl.Manager;

public class MarketServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        if (request.getParameter("submit") != null) {

            int cashboxes = Integer.parseInt(request.getParameter("cashboxes"));
            int steps = Integer.parseInt(request.getParameter("steps"));

            Manager manager = new Manager(cashboxes);

            try (PrintWriter out = response.getWriter()) {
                out.write("<html>");
                out.write("<head>");
                out.write("<title>Servlet HelloWorld</title>");
                out.write("</head>");
                out.write("<body>");
                out.write("<h1>Servlet HelloWorld for Java course</h1>");

                for (int i = 0; i < steps; i++) {
                    manager.doStep();

                    out.write("<div>");
                    out.write("</div>");

                }

                out.write("</body>");
                out.write("</html>");
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
