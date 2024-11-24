package api;

import com.google.gson.Gson;
import dto.StudentDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/student")
public class StudentAPI extends HttpServlet {

    List<StudentDTO> students = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // get handler
        // get all students and send the response
        resp.getWriter().println(new Gson().toJson(students));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();

        // read the request body and set the values to studentDTO object
        StudentDTO studentDTO = new Gson().fromJson(reader, StudentDTO.class);

        // add the studentDTO object to the students list
        students.add(studentDTO);

        // send the response
        resp.getWriter().println("Student added successfully");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // put handler
        // get the id from the query parameter
        int id = Integer.parseInt(req.getParameter("id"));
        // get the request body
        BufferedReader reader = req.getReader();
        StudentDTO studentDTO = new Gson().fromJson(reader, StudentDTO.class);
        for (StudentDTO std : students) {
            if (std.getId() == id) {
                std.setName(studentDTO.getName());
                std.setCity(studentDTO.getCity());

                // send the response
                resp.getWriter().println("Student Updated Successfully " + std.toString());
                break;
            }
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // delete handler
        // catch the id from the query parameter
        int id = Integer.parseInt(req.getParameter("id"));
        // search through the students list and remove the student with the given id
        for (StudentDTO std : students) {
            if (std.getId() == id) {
                students.remove(std);
                // send the response
                resp.getWriter().println("Student Deleted Successfully");
                break;
            }
        }
    }
}
