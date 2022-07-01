package lk.ijse.hibernate.dao.custom.impl;

import lk.ijse.hibernate.dao.custom.StudentDAO;
import lk.ijse.hibernate.entity.Student;
import lk.ijse.hibernate.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO{


    @Override
    public ArrayList<Student> getAll() throws SQLException, ClassNotFoundException, IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        List<Student> student = session.createQuery("FROM Student ").list();
        transaction.commit();
        session.close();
        return (ArrayList<Student>) student;
    }

    @Override
    public boolean save(Student dto) throws SQLException, ClassNotFoundException, IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(dto);
        transaction.commit();
        session.close();


        return true;
    }

    @Override
    public boolean update(Student dto) throws SQLException, ClassNotFoundException, IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.update(dto);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public Student search(String s) throws SQLException, ClassNotFoundException, IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Student load = session.get(Student.class, s);
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
        session.delete(session.load(Student.class,s));
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public int generateNewID() throws SQLException, ClassNotFoundException, IOException {
        return 0;
    }
}
