package ru.test.market.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import ru.test.market.bl.Manager;

public class MarketServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        if (request.getParameter("submit") != null) {
            
            int cashboxes = 0;
            int steps = 0;

            try {
            cashboxes = Integer.parseInt(request.getParameter("cashboxes"));
            steps = Integer.parseInt(request.getParameter("steps"));
            } catch (NumberFormatException ex){
                response.getWriter().append("Неверно введены значения <br>");
                response.getWriter().append("<a href=\"../Market\">Назад</a>");
            }  

            Manager manager = new Manager(cashboxes);
            
            String sMan = request.getParameter("man");
            String sWoman = request.getParameter("woman");
            String sChild = request.getParameter("child");
            
            if (StringUtils.isNumeric(sMan) &&
                StringUtils.isNumeric(sWoman) &&
                StringUtils.isNumeric(sChild)   )
            {
                int man = Integer.parseInt(sMan);
                int woman = Integer.parseInt(sWoman);
                int child = Integer.parseInt(sChild);
                
                if (man + woman + child != 100){
                    response.getWriter().append("Неверно введены процентные соотношения <br>");
                    response.getWriter().append("<a href=\"../Market\">Назад</a>");
                    return;
                }
                
                manager.addPercentBalance(man, woman, child);
            }

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
