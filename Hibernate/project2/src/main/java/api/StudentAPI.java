package api;

import com.google.gson.Gson;
import dto.StudentDTO;
import service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet(urlPatterns = "/students")
public class StudentAPI extends HttpServlet {
    private final StudentService studentService;

    public StudentAPI() {
        studentService = new StudentService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getHeader("Content-Type").equals("application/json")) {
            BufferedReader reader = req.getReader();
            StudentDTO studentDTO = new Gson().fromJson(reader, StudentDTO.class);
            StudentDTO studentDTO1 = studentService.saveStudent(studentDTO);

            if (studentDTO1 != null) {
                resp.getWriter().write(new Gson().toJson(studentDTO1));
            } else {
                resp.getWriter().write("Failed to save student");
            }
        }
    }
}
