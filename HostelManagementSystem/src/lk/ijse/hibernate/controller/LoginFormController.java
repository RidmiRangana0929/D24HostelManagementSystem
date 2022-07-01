package lk.ijse.hibernate.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginFormController {
    public AnchorPane loginContext;
    public TextField txtUsername;
    public PasswordField pwdPassword;

    public void loginOnAction(ActionEvent actionEvent) throws IOException {

        if(txtUsername.getText().equals("a") && pwdPassword.getText().equals("1")){
            Stage window = (Stage) loginContext.getScene().getWindow();
            window.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/homePageForm.fxml"))));
        }else {
            new Alert(Alert.AlertType.ERROR, "Login Fail!").showAndWait();
        }
    }
}
