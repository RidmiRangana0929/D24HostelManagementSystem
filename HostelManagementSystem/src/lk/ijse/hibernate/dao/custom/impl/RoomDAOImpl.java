package lk.ijse.hibernate.dao.custom.impl;

import lk.ijse.hibernate.bo.SuperBO;
import lk.ijse.hibernate.dao.custom.RoomDAO;
import lk.ijse.hibernate.entity.Room;
import lk.ijse.hibernate.entity.Student;
import lk.ijse.hibernate.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomDAOImpl implements RoomDAO {
    @Override
    public ArrayList<Room> getAll() throws SQLException, ClassNotFoundException, IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        List<Room> room = session.createQuery("FROM Room ").list();
        transaction.commit();
        session.close();
        return (ArrayList<Room>) room;
    }

    @Override
    public boolean save(Room dto) throws SQLException, ClassNotFoundException, IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(dto);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Room dto) throws SQLException, ClassNotFoundException, IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(dto);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public Room search(String s) throws SQLException, ClassNotFoundException, IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Room load = session.get(Room.class, s);
        transaction.commit();
        session.close();
        return load;
    }

    @Override
    public boolean exist(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException, IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(session.load(Room.class,s));
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public int generateNewID() throws SQLException, ClassNotFoundException, IOException {
        return 0;
    }
}
