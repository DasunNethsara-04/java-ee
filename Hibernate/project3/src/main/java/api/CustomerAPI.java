package api;

import com.google.gson.Gson;
import dto.CustomerDTO;
import service.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet(urlPatterns = "/customers")
public class CustomerAPI extends HttpServlet {
    private final CustomerService customerService;

    public CustomerAPI() {
        this.customerService = new CustomerService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getHeader("Content-Type").equals("application/json")) {
            BufferedReader reader = req.getReader();
            CustomerDTO customerDTO = new Gson().fromJson(reader, CustomerDTO.class);
            CustomerDTO customerDTO1 = customerService.saveCustomer(customerDTO);
            if (customerDTO1 != null) {
                resp.getWriter().println(new Gson().toJson(customerDTO1));
            } else {
                resp.getWriter().println("Error");
            }
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }
}
