package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class UserDashboardController {
    @FXML
    private AnchorPane root;

    @FXML
    private AnchorPane rootNode;

    @FXML
    private Label txtBorrowedBooks;

    @FXML
    private Label txtDueBooks;

    @FXML
    private Label txtName;

    public void setAction(String path) throws IOException {
        AnchorPane load = FXMLLoader.load(getClass().getResource(path));
        root.getChildren().clear();
        root.getChildren().add(load);
    }

    @FXML
    void btnBooksOnAction(ActionEvent event) throws IOException {
        setAction("/view/SearchBookForm.fxml");
    }

    @FXML
    void btnDashboardOnAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(this.getClass().getResource("/view/UserDashboard.fxml"));

        Scene scene = new Scene(root);

        Stage primaryStage =(Stage) this.rootNode.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Book Worm");
    }

    @FXML
    void btnPasswordOnAction(ActionEvent event) throws IOException {
        setAction("/view/ProfileForm.fxml");
    }

    @FXML
    void btnSignOutOnAction(ActionEvent event) throws IOException {
        /*Stage stage = (Stage) this.rootNode.getScene().getWindow();
        stage.close();
        System.out.println("logout to user");*/

        Parent root = FXMLLoader.load(this.getClass().getResource("/view/AdminLoginForm.fxml"));
        Scene scene = new Scene(root);
        Stage primaryStage =(Stage) this.rootNode.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Book Worm");
    }


    @FXML
    void btnBorrowedOnAction(ActionEvent event) throws IOException {
        setAction("/view/BorrowedBookForm.fxml");
    }

    public void setUserName(String userName) {
        this.txtName.setText(userName);
    }
}
