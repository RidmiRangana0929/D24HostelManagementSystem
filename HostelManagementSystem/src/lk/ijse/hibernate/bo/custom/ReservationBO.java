package lk.ijse.hibernate.bo.custom;

import lk.ijse.hibernate.bo.SuperBO;
import lk.ijse.hibernate.dto.ReservationDTO;
import lk.ijse.hibernate.dto.StudentDTO;

import java.io.IOException;
import java.sql.SQLException;

public interface ReservationBO extends SuperBO {
    boolean save(ReservationDTO reservationDTO) throws SQLException, IOException, ClassNotFoundException;
    boolean update(ReservationDTO reservationDTO) throws SQLException, ClassNotFoundException, IOException;
    boolean delete(String s) throws SQLException, IOException, ClassNotFoundException;
    String generateReservationId() throws SQLException, IOException, ClassNotFoundException;
}
