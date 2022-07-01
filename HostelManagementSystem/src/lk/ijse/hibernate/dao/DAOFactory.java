package lk.ijse.hibernate.dao;

import lk.ijse.hibernate.dao.custom.impl.ReservationDAOImpl;
import lk.ijse.hibernate.dao.custom.impl.RoomDAOImpl;
import lk.ijse.hibernate.dao.custom.impl.StudentDAOImpl;

public class DAOFactory {

    private static DAOFactory daoFactory;

    private DAOFactory() {
    }

    public static DAOFactory getDaoFactory() {
        return (daoFactory == null) ? daoFactory=new DAOFactory() : daoFactory;
    }

    public enum DAOTypes{
        RESERVATION,ROOM,STUDENT
    }

    public SuperDAO getDAO(DAOTypes daoTypes) {
        switch (daoTypes) {
            case RESERVATION:
                return new ReservationDAOImpl();
            case ROOM:
                return new RoomDAOImpl();
            case STUDENT:
                return new StudentDAOImpl();
            default:
                return null;
        }
    }

}
