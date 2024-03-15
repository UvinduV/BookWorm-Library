package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.bo.BoFactory;
import lk.ijse.bo.custom.BookBo;
import lk.ijse.bo.custom.BranchBo;
import lk.ijse.bo.custom.UserBo;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AdminDashboardController implements Initializable {
    @FXML
    private AnchorPane root;

    @FXML
    private AnchorPane rootNode;

    @FXML
    private Label txtBookCount;

    @FXML
    private Label txtBranchCount;

    @FXML
    private Label txtName;

    @FXML
    private Label txtUserCount;
    BranchBo branchBo = (BranchBo) BoFactory.getBOFactory().getBo(BoFactory.BoTypes.BRANCH);
    BookBo bookBo = (BookBo) BoFactory.getBOFactory().getBo(BoFactory.BoTypes.BOOK);
    UserBo userBo = (UserBo) BoFactory.getBOFactory().getBo(BoFactory.BoTypes.USER);

    public void setAction(String path) throws IOException {
        Parent root = FXMLLoader.load(this.getClass().getResource("/view/books_form.fxml"));
        Scene scene = new Scene(root);
        Stage primaryStage =(Stage) this.rootNode.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Book Worm");
    }
    @FXML
    void btnBooksOnAction(ActionEvent event) throws IOException {
        setAction("/view/books_form.fxml");

    }

    @FXML
    void btnBranchesOnAction(ActionEvent event) throws IOException {
        setAction("/view/branch_form.fxml");
    }

    @FXML
    void btnSignOutOnAction(ActionEvent event) throws IOException {

    }

    @FXML
    void btnUsersOnAction(ActionEvent event) throws IOException {

    }

    @FXML
    void btnDashboardOnAction(ActionEvent event) throws IOException {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


}
