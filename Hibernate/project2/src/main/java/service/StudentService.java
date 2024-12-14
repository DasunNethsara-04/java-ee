package service;

import dto.StudentDTO;
import entity.StudentEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import repo.StudentRepo;
import util.FactoryConfiguration;

public class StudentService {
    private final StudentRepo studentRepo;

    public StudentService() {
        studentRepo = new StudentRepo();
    }

    public StudentDTO saveStudent(StudentDTO student) {
        StudentEntity studentEntity = new StudentEntity();

        studentEntity.setId(student.getId());
        studentEntity.setName(student.getName());
        studentEntity.setCity(student.getCity());
        Session session = null;
        Transaction transaction = null;
        try {
            session = FactoryConfiguration.getInstance().getSession();
            transaction = session.beginTransaction();
            studentRepo.saveStudent(session, studentEntity);
            transaction.commit();
            return student;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
        return null;
    }
}
