package lk.ijse.hibernate.bo;

import lk.ijse.hibernate.bo.custom.impl.ReservationBOImpl;
import lk.ijse.hibernate.bo.custom.impl.RoomBOImpl;
import lk.ijse.hibernate.bo.custom.impl.StudentBOImpl;
import lk.ijse.hibernate.dao.custom.impl.RoomDAOImpl;

public class BOFactory {

    private static BOFactory boFactory;

    private BOFactory(){}

    public static BOFactory getBoFactory(){
        return (boFactory == null) ? boFactory=new BOFactory() : boFactory;
    }

    public enum BOTypes{
        STUDENT,ROOM,RESERVATION
    }

    public SuperBO getBO(BOTypes boTypes){
        switch (boTypes){
            case STUDENT:
                return new StudentBOImpl();

            case ROOM:
                return new RoomBOImpl();

            case RESERVATION:
                return new ReservationBOImpl();

            default:
                return null;
        }
    }

}
