package controller;

import dto.StudentDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet(urlPatterns = "/student")
public class StudentController extends HttpServlet {

    List<StudentDTO> list = new ArrayList<StudentDTO>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // get handler
        int id = Integer.parseInt(req.getParameter("id"));
        for(StudentDTO std: list) {
            if(std.getId() == id) {
                resp.getWriter().println(std.toString());
                break;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // post handler
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String city = req.getParameter("city");

        StudentDTO studentDTO = new StudentDTO();

        studentDTO.setId(id);
        studentDTO.setName(name);
        studentDTO.setCity(city);

        boolean isAdded = list.add(studentDTO);
        resp.getWriter().println("Student added: " + isAdded);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // update handler
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String city = req.getParameter("city");

        for(StudentDTO std: list) {
            if(std.getId() == id) {
                std.setId(id);
                std.setName(name);
                std.setCity(city);
                resp.getWriter().println(std.toString());
                break;
            }
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // delete handler
        int id = Integer.parseInt(req.getParameter("id"));

        for(StudentDTO std: list) {
            if(std.getId() == id) {
                list.remove(std);
                resp.getWriter().println("Student deleted: " + id);
                break;
            }
        }
    }
}
