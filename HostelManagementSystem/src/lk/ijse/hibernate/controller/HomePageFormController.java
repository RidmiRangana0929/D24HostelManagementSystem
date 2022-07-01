package lk.ijse.hibernate.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.ijse.hibernate.bo.BOFactory;
import lk.ijse.hibernate.bo.custom.ReservationBO;
import lk.ijse.hibernate.bo.custom.RoomBO;
import lk.ijse.hibernate.bo.custom.StudentBO;
import lk.ijse.hibernate.bo.custom.impl.StudentBOImpl;
import lk.ijse.hibernate.dao.DAOFactory;
import lk.ijse.hibernate.dao.custom.ReservationDAO;
import lk.ijse.hibernate.dao.custom.StudentDAO;
import lk.ijse.hibernate.dto.ReservationDTO;
import lk.ijse.hibernate.dto.RoomDTO;
import lk.ijse.hibernate.dto.StudentDTO;
import lk.ijse.hibernate.entity.Reservation;
import lk.ijse.hibernate.entity.Student;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class HomePageFormController {
    public AnchorPane homePageContext;
    public TextField txtStudentId;
    public TextField txtStudentName;
    public TextField txtAddress;
    public TextField txtContactNumber;
    public DatePicker dpDateOfBirth;
    public ComboBox<String> cmbGender;
    public TextField txtReservationId;
    public TextField txtDate;
    public TextField txtReservationStatus;
    public ComboBox<String> cmbStudentId;
    public ComboBox<String> cmbRoomTypeId;
    public ComboBox<String> cmbType;
    public TextField txtQty;
    public TableView<String> tblRoomTypes;
    public TableColumn colType;
    public TableColumn colKeyMoney;
    public TextField txtStatus;
    public TextField txtStdId;
    public Label lblTime;
    public Label lblDate;
    public Label lblGender;
    public Label lblDob;
    public JFXTextField txtDob;
    public JFXTextField txtGender;

    StudentBOImpl studentBOImpl = (StudentBOImpl) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.STUDENT);
    private final ReservationBO reservationBO = (ReservationBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.RESERVATION);

    private final StudentBO studentBO = (StudentBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.STUDENT);
    private final RoomBO roomBO = (RoomBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.ROOM);

    private final StudentDAO studentDAO = (StudentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.STUDENT);
    private final ReservationDAO reservationDAO = (ReservationDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.RESERVATION);

    //private final StudentBO=BOFactory.getBoFactory.getBO(BOFactory.BOTypes.STUDENT)

    public void initialize(){

        try {
            txtReservationId.setText(reservationBO.generateReservationId());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        cmbGender.getItems().add("Male");
        cmbGender.getItems().add("Female");
        cmbGender.getItems().add("Other");

        try {
            loadDataToComboBox();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        setDateTime();

    }

    private void setDateTime() {

        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
            lblTime.setText(LocalDateTime.now().format(formatter));

            SimpleDateFormat formatter2 = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date date = new java.util.Date();
            lblDate.setText(formatter2.format(date));
        }), new KeyFrame(Duration.seconds(1)));
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }

    private void loadDataToComboBox() throws SQLException, IOException, ClassNotFoundException {

        ArrayList<RoomDTO> allRoom = roomBO.getAllRoom();
        ArrayList<StudentDTO> allStudent = studentBO.getAllStudent();

        for (RoomDTO roomDTO:allRoom
        ) {
            cmbRoomTypeId.getItems().add(roomDTO.getRoom_type_id());
        }

        for (StudentDTO studentDTO:allStudent
        ) {
            cmbStudentId.getItems().add(studentDTO.getStudent_id());
        }

    }

    public void allReservationsOnAction(ActionEvent actionEvent) {
    }

    public void stIdSearchOnAction(ActionEvent actionEvent) throws SQLException, IOException, ClassNotFoundException {

        /*txtGender.clear();
        txtDob.clear();*/

        Student search = studentDAO.search(txtStudentId.getText());

        txtStudentId.setText(search.getStudent_id());
        txtStudentName.setText(search.getName());
        txtAddress.setText(search.getAddress());
        txtContactNumber.setText(search.getContact_no());
        txtGender.setText(search.getGender());
        txtDob.setText(String.valueOf(search.getDob()));


    }

    public void deleteOnAction(ActionEvent actionEvent) throws IOException {

        String id = txtStudentId.getText();
        try {
            if (studentBOImpl.delete(id)) {
                new Alert(Alert.AlertType.CONFIRMATION, "Deleted!").show();
            }
        } catch (Exception e) {
            System.out.println(e);
            new Alert(Alert.AlertType.ERROR, "Something Happened. try again carefully!").showAndWait();
        }

        Stage window = (Stage) homePageContext.getScene().getWindow();
        window.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/homePageForm.fxml"))));

    }

    public void saveOnAction(ActionEvent actionEvent) throws IOException {
        String id = txtStudentId.getText();
        String name = txtStudentName.getText();
        String address = txtAddress.getText();
        String contact_no = txtContactNumber.getText();
        Date date = Date.valueOf(dpDateOfBirth.getValue());
        String gender = cmbGender.getValue();

        try {
            if (studentBOImpl.save(new StudentDTO(id, name, address, contact_no, date, gender))) {
                new Alert(Alert.AlertType.CONFIRMATION, "Saved.!").show();
            }
        } catch (Exception e) {
            System.out.println(e);
            new Alert(Alert.AlertType.ERROR, "Something Happened. try again carefully!").showAndWait();
        }

        Stage window = (Stage) homePageContext.getScene().getWindow();
        window.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/homePageForm.fxml"))));

    }

    public void updateOnAction(ActionEvent actionEvent) throws IOException {



        String id = txtStudentId.getText();
        String name = txtStudentName.getText();
        String address = txtAddress.getText();
        String contact_no = txtContactNumber.getText();
        Date date = Date.valueOf(dpDateOfBirth.getValue());
        String gender = cmbGender.getValue();
        try {
            if(studentBOImpl.update(new StudentDTO(id, name, address, contact_no, date, gender))) {
                new Alert(Alert.AlertType.CONFIRMATION, "Updated.!").show();
            } else {
                new Alert(Alert.AlertType.ERROR, "Something Happened").show();
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Something Happened").show();
        }

        Stage window = (Stage) homePageContext.getScene().getWindow();
        window.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/homePageForm.fxml"))));

    }

    public void bookOnAction(ActionEvent actionEvent) {

        try {
            if(reservationBO.save(new ReservationDTO(txtReservationId.getText(), LocalDate.now(), cmbStudentId.getValue(), cmbRoomTypeId.getValue(),txtReservationStatus.getText()))) {
                new Alert(Alert.AlertType.CONFIRMATION, "Reserved!").show();
            } else {
                new Alert(Alert.AlertType.ERROR, "Something Happened").show();
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Something Happened").show();
        }

    }

    public void cmbTypeOnAction(ActionEvent actionEvent) {
    }

    public void manageRoomsOnAction(ActionEvent actionEvent) throws IOException {

        Stage window = (Stage) homePageContext.getScene().getWindow();
        window.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/roomForm.fxml"))));

    }


    public void labelClearGenderOnAction(ActionEvent actionEvent) {
        txtGender.clear();
    }

    public void labelClearDobOnAction(ActionEvent actionEvent) {
        txtDob.clear();
    }

    public void checkKeyMoneyStatus(ActionEvent actionEvent) throws SQLException, IOException, ClassNotFoundException {

        Reservation search = reservationDAO.search(txtStudentId.getText());
        //txtStatus.setText(search.getStatus());

    }
}
