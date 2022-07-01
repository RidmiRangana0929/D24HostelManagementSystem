package lk.ijse.hibernate.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudDAO<T,ID> extends SuperDAO{
    ArrayList<T> getAll() throws SQLException, ClassNotFoundException, IOException;

    boolean save(T dto) throws SQLException, ClassNotFoundException, IOException;

    boolean update(T dto) throws SQLException, ClassNotFoundException, IOException;

    T search(ID id) throws SQLException, ClassNotFoundException, IOException;

    boolean exist(ID id) throws SQLException, ClassNotFoundException;

    boolean delete(ID id) throws SQLException, ClassNotFoundException, IOException;

    int generateNewID() throws SQLException, ClassNotFoundException, IOException;
}
