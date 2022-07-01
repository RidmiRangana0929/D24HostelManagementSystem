package lk.ijse.hibernate.bo.custom.impl;

import lk.ijse.hibernate.bo.custom.StudentBO;
import lk.ijse.hibernate.dao.DAOFactory;
import lk.ijse.hibernate.dao.DAOType;
import lk.ijse.hibernate.dao.custom.StudentDAO;
import lk.ijse.hibernate.dao.custom.impl.StudentDAOImpl;
import lk.ijse.hibernate.dto.StudentDTO;
import lk.ijse.hibernate.entity.Student;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;


public class StudentBOImpl implements StudentBO{

    private final StudentDAO studentDAO = (StudentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.STUDENT);

    @Override
    public boolean save(StudentDTO studentDTO) throws SQLException, IOException, ClassNotFoundException {
        return studentDAO.save(new Student(
                studentDTO.getStudent_id(),studentDTO.getName(),studentDTO.getAddress(),studentDTO.getContact_no(),studentDTO.getDob(),studentDTO.getGender()
        ));
    }

    @Override
    public boolean update(StudentDTO studentDTO) throws SQLException, ClassNotFoundException, IOException {
        return studentDAO.update(new Student(studentDTO.getStudent_id(),studentDTO.getName(),studentDTO.getAddress(),studentDTO.getContact_no(),studentDTO.getDob(),studentDTO.getGender()
        ));
    }

    @Override
    public boolean delete(String s) throws SQLException, IOException, ClassNotFoundException {
        return studentDAO.delete(s);
    }

    @Override
    public ArrayList<StudentDTO> getAllStudent() throws SQLException, ClassNotFoundException, IOException {
        ArrayList<Student> all = studentDAO.getAll();
        ArrayList<StudentDTO> allStudent = new ArrayList<>();

        for (Student s:all
        ) {
            allStudent.add(new StudentDTO(s.getStudent_id(),s.getName(),s.getAddress(),s.getContact_no(),s.getDob(),s.getGender()));
        }
        return allStudent;
    }
}
