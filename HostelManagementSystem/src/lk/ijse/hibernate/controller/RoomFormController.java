package lk.ijse.hibernate.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import lk.ijse.hibernate.bo.BOFactory;
import lk.ijse.hibernate.bo.custom.impl.RoomBOImpl;
import lk.ijse.hibernate.bo.custom.impl.StudentBOImpl;
import lk.ijse.hibernate.dao.DAOFactory;
import lk.ijse.hibernate.dao.custom.RoomDAO;
import lk.ijse.hibernate.dao.custom.StudentDAO;
import lk.ijse.hibernate.dto.RoomDTO;
import lk.ijse.hibernate.dto.StudentDTO;
import lk.ijse.hibernate.entity.Room;
import lk.ijse.hibernate.entity.Student;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

public class RoomFormController {
    public AnchorPane roomsContext;
    public TextField txtRoomTypeId;
    public ComboBox<String> cmbType;
    public TextField txtKeyMoney;
    public TextField txtQty;
    public TableView tblRooms;
    public TableColumn colRoomTypeId;
    public TableColumn colType;
    public TableColumn colKeyMoney;
    public TableColumn colQuantity;
    public JFXTextField txtType;

    RoomBOImpl roomBOImpl = (RoomBOImpl) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.ROOM);

    private final RoomDAO roomDAO = (RoomDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ROOM);

    public void initialize(){
        cmbType.getItems().add("Non-AC");
        cmbType.getItems().add("Non-AC / Food");
        cmbType.getItems().add("AC");
        cmbType.getItems().add("AC / Food");
    }

    public void deleteOnAction(ActionEvent actionEvent) {
    }

    public void addOnAction(ActionEvent actionEvent) {

        String id = txtRoomTypeId.getText();
        String type = cmbType.getValue();
        String key_money = txtKeyMoney.getText();
        int qty = Integer.parseInt(txtQty.getText());

        try {
            if (roomBOImpl.save(new RoomDTO(id, type, key_money, qty))) {
                new Alert(Alert.AlertType.CONFIRMATION, "Added!").show();
            }
        } catch (Exception e) {
            System.out.println(e);
            new Alert(Alert.AlertType.ERROR, "Something Happened. try again carefully!").showAndWait();
        }

    }

    public void updateOnAction(ActionEvent actionEvent) {

        String id = txtRoomTypeId.getText();
        String type = cmbType.getValue();
        String key_money = txtKeyMoney.getText();
        int qty = Integer.parseInt(txtQty.getText());

        try {
            if (roomBOImpl.update(new RoomDTO(id, type, key_money, qty))) {
                new Alert(Alert.AlertType.CONFIRMATION, "Updated!").show();
            }
        } catch (Exception e) {
            System.out.println(e);
            new Alert(Alert.AlertType.ERROR, "Something Happened. try again carefully!").showAndWait();
        }

    }

    public void backOnAction(ActionEvent actionEvent) {
    }

    public void searchRoomOnAction(ActionEvent actionEvent) throws SQLException, IOException, ClassNotFoundException {

        Room search = roomDAO.search(txtRoomTypeId.getText());

        txtRoomTypeId.setText(search.getRoom_type_id());
        txtType.setText(search.getType());
        txtKeyMoney.setText(search.getKey_money());
        txtQty.setText(String.valueOf(search.getQty()));

    }

    public void labelClearTypeOnAction(ActionEvent actionEvent) {
        txtType.clear();
    }
}
