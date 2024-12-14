package repo;

import entity.StudentEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class StudentRepo {
    public StudentEntity saveStudent(Session session, StudentEntity student) {
        try {
            session.save(student);
            return student;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
