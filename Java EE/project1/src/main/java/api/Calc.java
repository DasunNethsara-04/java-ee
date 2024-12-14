package api;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = "/calc", initParams = {
        @WebInitParam(name="name", value = "John"),
        @WebInitParam(name="age", value = "25"),
})
public class Calc extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // get two numbers with operation
        String n1 = req.getParameter("n1");
        String n2 = req.getParameter("n2");
        String op = req.getParameter("op");

        double result = 0;
        double num1 = Double.parseDouble(n1);
        double num2 = Double.parseDouble(n2);

        switch (op) {
            case "add":
                result = num1 + num2;
                break;
            case "sub":
                result = num1 - num2;
                break;
            case "mul":
                result = num1 * num2;
                break;
            case "div":
                result = num1 / num2;
                break;
        }

        resp.getWriter().println("Result: " + result);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("POST method");
    }
}
