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
import lk.ijse.bo.custom.AdminBo;

import java.io.IOException;

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
        String userName = txtUsername.getText();
        String password = txtPassword.getText();

        try {
            openWindow();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        mainAdminController.setUserName(userName);


    }

    @FXML
    void signUpChangeOnAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(this.getClass().getResource("/view/admin_register.fxml"));

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
