package lk.ijse.hibernate.bo.custom;

import lk.ijse.hibernate.bo.SuperBO;
import lk.ijse.hibernate.dto.RoomDTO;
import lk.ijse.hibernate.dto.StudentDTO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface RoomBO extends SuperBO {
    boolean save(RoomDTO roomDTO) throws SQLException, IOException, ClassNotFoundException;
    boolean update(RoomDTO roomDTO) throws SQLException, ClassNotFoundException, IOException;
    boolean delete(String s) throws SQLException, IOException, ClassNotFoundException;
    ArrayList<RoomDTO> getAllRoom() throws SQLException, ClassNotFoundException, IOException;
}
