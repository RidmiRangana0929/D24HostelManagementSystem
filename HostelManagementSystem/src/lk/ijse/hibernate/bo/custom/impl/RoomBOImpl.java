package lk.ijse.hibernate.bo.custom.impl;

import lk.ijse.hibernate.bo.custom.RoomBO;
import lk.ijse.hibernate.dao.DAOFactory;
import lk.ijse.hibernate.dao.custom.RoomDAO;
import lk.ijse.hibernate.dto.RoomDTO;
import lk.ijse.hibernate.dto.StudentDTO;
import lk.ijse.hibernate.entity.Room;
import lk.ijse.hibernate.entity.Student;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;


public class RoomBOImpl implements RoomBO {

    private final RoomDAO roomDAO = (RoomDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ROOM);

    @Override
    public boolean save(RoomDTO roomDTO) throws SQLException, IOException, ClassNotFoundException {
        return roomDAO.save(new Room(
                roomDTO.getRoom_type_id(),roomDTO.getType(),roomDTO.getKey_money(),roomDTO.getQty()
        ));
    }

    @Override
    public boolean update(RoomDTO roomDTO) throws SQLException, ClassNotFoundException, IOException {
        return roomDAO.save(new Room(roomDTO.getRoom_type_id(),roomDTO.getType(),roomDTO.getKey_money(),roomDTO.getQty()
        ));
    }

    @Override
    public boolean delete(String s) throws SQLException, IOException, ClassNotFoundException {
        return roomDAO.delete(s);
    }

    @Override
    public ArrayList<RoomDTO> getAllRoom() throws SQLException, ClassNotFoundException, IOException {
        ArrayList<Room> all = roomDAO.getAll();
        ArrayList<RoomDTO> allRoom = new ArrayList<>();

        for (Room s:all
        ) {
            allRoom.add(new RoomDTO(s.getRoom_type_id(),s.getType(),s.getKey_money(),s.getQty()));
        }
        return allRoom;
    }

    /*@Override
    public ArrayList<RoomDTO> getAllRoom() throws SQLException, ClassNotFoundException, IOException {
        ArrayList<Room> all = roomDAO.getAll();
        ArrayList<RoomDTO> allRoom = new ArrayList<>();

        for (Room room:all
        ) {
            allRoom.add(new RoomDTO(room.getRoom_type_id(),room.getType(),room.getKey_money(),room.getQty()));
        }
        return allRoom;
    }*/
}
