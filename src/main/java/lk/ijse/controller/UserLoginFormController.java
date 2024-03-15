package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.bo.BoFactory;
import lk.ijse.bo.custom.UserBo;

import java.io.IOException;

public class UserLoginFormController {
    @FXML
    private AnchorPane root;

    @FXML
    private AnchorPane rootNode;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUsername;
    MainUserController mainUserController = new MainUserController();
    UserBo userBo = (UserBo) BoFactory.getBOFactory().getBo(BoFactory.BoTypes.USER);

    @FXML
    void btnSignInOnAction(ActionEvent event) {

        clearFields();
        try {
            openWindow();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void signUpChangeOnAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(this.getClass().getResource("/view/user_register.fxml"));

        Scene scene = new Scene(root);

        Stage primaryStage =(Stage) this.rootNode.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Book Worm");
    }

    @FXML
    void btnHomeOnAction(ActionEvent event) throws IOException {
        Parent rootNode = FXMLLoader.load(this.getClass().getResource("/view/MainForm.fxml"));

        Scene scene = new Scene(rootNode);

        Stage primaryStage =(Stage) this.rootNode.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Book Worm");
    }

    /*public boolean validateUser(){
        String userName = txtUsername.getText();

        boolean isUserNameValidated = Pattern.matches("[A-Z][a-zA-Z\\s]+", userName);
        if (!isUserNameValidated) {
            new Alert(Alert.AlertType.ERROR, "Invalid UserName or Password!").show();
            return false;
        }

        String password = txtPassword.getText();

        boolean isPasswordValidated = Pattern.matches("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}", password);
        if (!isPasswordValidated) {
            new Alert(Alert.AlertType.ERROR, "Invalid Username or Password").show();
            return false;
        }

        return true;
    }*/

    private void clearFields() {
        txtUsername.setText("");
        txtPassword.setText("");
    }

    public void openWindow() throws IOException {
        Parent rootNode = FXMLLoader.load(this.getClass().getResource("/view/user_dashboard.fxml"));

        Scene scene = new Scene(rootNode);
        Stage primaryStage =(Stage) this.rootNode.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Book Worm");
    }
}
