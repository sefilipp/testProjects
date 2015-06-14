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
                out.write("<title>Результат</title>");
                out.write("</head>");
                out.write("<body>");                

                for (int i = 0; i < steps; i++) {
                    manager.doStep();

                    out.write("<p>");
                    out.write("<h3>");
                    out.write("Шаг №");
                    out.write(Integer.toString(i+1));
                    out.write("</h3>");
                    out.write("</p>");
                    out.write(manager.getHtmlStepRepresentation());
                    
                    
                    //

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
