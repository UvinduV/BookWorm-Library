package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.bo.BoFactory;
import lk.ijse.bo.custom.AdminBo;
import lk.ijse.dto.AdminDto;

import java.io.IOException;
import java.sql.SQLException;
import java.util.regex.Pattern;

public class AdminLoginFormController {

    @FXML
    private AnchorPane root;

    @FXML
    private AnchorPane rootNode;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUsername;
    AdminBo adminBo = (AdminBo) BoFactory.getBOFactory().getBo(BoFactory.BoTypes.ADMIN);
    AdminDashboardController mainAdminController = new AdminDashboardController();
    @FXML
    void btnSignInOnAction(ActionEvent event) {
        /*String userName = txtUsername.getText();
        String password = txtPassword.getText();

        if (userName.isEmpty() || password.isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Please enter all fields").show();
            return;
        }

        if(validateAdmin()){
            AdminDto adminDto = adminBo.adminSignIn(userName,password);
            if(adminDto != null){
                try {
                    clearFields();
                    new Alert(Alert.AlertType.CONFIRMATION,"Welcome Admin").show();
                    openWindow();
                    mainAdminController.setUserName(userName);
                } catch (IOException e) {
                    clearFields();
                    new Alert(Alert.AlertType.ERROR,"Username or Password Incorrect").show();
                }
            }
        }*/
        String userName = txtUsername.getText();
        String password = txtPassword.getText();

        if (userName.isEmpty() || password.isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Please enter all fields").show();
            return;
        }

        if(validateAdmin()){
            try {
                AdminDto adminDto = adminBo.adminSignIn(userName,password);
                if (adminDto != null) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Login Successful").show();
                    System.out.println("Login Successful");
                    clearFields();
                    openWindow();
                }else {
                    new Alert(Alert.AlertType.ERROR, "incorrect username or password").show();
                    System.out.println("Login Failed ,incorrect username or password");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }



    }

    private boolean validateAdmin() {
        String userName = txtUsername.getText();

        boolean isUserNameValidated = Pattern.matches("[a-z]{3,}[\\d]{2,}+", userName);
        if (!isUserNameValidated) {
            new Alert(Alert.AlertType.ERROR, "Invalid UserName").show();
            return false;
        }

        String password = txtPassword.getText();

        boolean isPasswordValidated = Pattern.matches("(\\d){4,}(?=[a-z])(?=.*[A-Z]).{4,}", password);
        if (!isPasswordValidated) {
            new Alert(Alert.AlertType.ERROR, "Invalid Password").show();
            return false;
        }

        return true;
    }

    @FXML
    void signUpChangeOnAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(this.getClass().getResource("/view/AdminSignUpForm.fxml"));

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

    private void clearFields() {
        txtUsername.setText("");
        txtPassword.setText("");
    }

    public void openWindow() throws IOException {
        Parent rootNode = FXMLLoader.load(this.getClass().getResource("/view/Admindashboard.fxml"));

        Scene scene = new Scene(rootNode);
        Stage primaryStage =(Stage) this.rootNode.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Book Worm");
    }


}
