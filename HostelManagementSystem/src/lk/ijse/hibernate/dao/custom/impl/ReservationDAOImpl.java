package lk.ijse.hibernate.dao.custom.impl;

import lk.ijse.hibernate.dao.custom.ReservationDAO;
import lk.ijse.hibernate.entity.Reservation;
import lk.ijse.hibernate.entity.Student;
import lk.ijse.hibernate.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReservationDAOImpl implements ReservationDAO{
    @Override
    public ArrayList<Reservation> getAll() throws SQLException, ClassNotFoundException, IOException {
        return null;
    }

    @Override
    public boolean save(Reservation dto) throws SQLException, ClassNotFoundException, IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(dto);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Reservation dto) throws SQLException, ClassNotFoundException, IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(dto);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public Reservation search(String s) throws SQLException, ClassNotFoundException, IOException {
        return null;
    }

    @Override
    public boolean exist(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException, IOException {
        return false;
    }

    @Override
    public int generateNewID() throws SQLException, ClassNotFoundException, IOException {
        return 0;
    }
}
