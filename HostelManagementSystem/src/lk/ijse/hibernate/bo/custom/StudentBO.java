package lk.ijse.hibernate.bo.custom;

import lk.ijse.hibernate.bo.SuperBO;
import lk.ijse.hibernate.dto.StudentDTO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface StudentBO extends SuperBO{
    boolean save(StudentDTO studentDTO) throws SQLException, IOException, ClassNotFoundException;
    boolean update(StudentDTO studentDTO) throws SQLException, ClassNotFoundException, IOException;
    boolean delete(String s) throws SQLException, IOException, ClassNotFoundException;
    ArrayList<StudentDTO> getAllStudent() throws SQLException, ClassNotFoundException, IOException;
}
