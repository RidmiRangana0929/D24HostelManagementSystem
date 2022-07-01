package lk.ijse.hibernate.bo.custom.impl;


import lk.ijse.hibernate.bo.custom.ReservationBO;
import lk.ijse.hibernate.dao.DAOFactory;
import lk.ijse.hibernate.dao.custom.ReservationDAO;
import lk.ijse.hibernate.dao.custom.RoomDAO;
import lk.ijse.hibernate.dao.custom.StudentDAO;
import lk.ijse.hibernate.dto.ReservationDTO;
import lk.ijse.hibernate.dto.StudentDTO;
import lk.ijse.hibernate.entity.Reservation;
import lk.ijse.hibernate.entity.Room;
import lk.ijse.hibernate.entity.Student;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

public class ReservationBOImpl implements ReservationBO {

    private final StudentDAO studentDAO = (StudentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.STUDENT);
    private final RoomDAO roomDAO = (RoomDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ROOM);
    private final ReservationDAO reservationDAO = (ReservationDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.RESERVATION);

    @Override
    public boolean save(ReservationDTO reservationDTO) throws SQLException, IOException, ClassNotFoundException {
        Room room = roomDAO.search(reservationDTO.getRoom_type_id());
        Student student = studentDAO.search(reservationDTO.getStudent_id());

        return   reservationDAO.save(new Reservation(reservationDTO.getRes_id(),LocalDate.now(),student,room,reservationDTO.getStatus()));

    }

    @Override
    public boolean update(ReservationDTO reservationDTO) throws SQLException, ClassNotFoundException, IOException {
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException, IOException, ClassNotFoundException {
        return false;
    }

    @Override
    public String generateReservationId() throws SQLException, IOException, ClassNotFoundException {
        int id = reservationDAO.generateNewID();

        if (id==0){
            return "R00-001";
        }else {
            return  "R00-00"+id;

        }
    }
}
