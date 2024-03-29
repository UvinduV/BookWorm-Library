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

        AnchorPane load = FXMLLoader.load(getClass().getResource(path));
        root.getChildren().clear();
        root.getChildren().add(load);
    }
    @FXML
    void btnBooksOnAction(ActionEvent event) throws IOException {
        setAction("/view/BookForm.fxml");

    }

    @FXML
    void btnBranchesOnAction(ActionEvent event) throws IOException {
        setAction("/view/BranchForm.fxml");
    }

    @FXML
    void btnSignOutOnAction(ActionEvent event) throws IOException {
       /* setAction("/view/AdminLoginForm.fxml");*/
        Parent root = FXMLLoader.load(this.getClass().getResource("/view/AdminLoginForm.fxml"));
        Scene scene = new Scene(root);
        Stage primaryStage =(Stage) this.rootNode.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Book Worm");

    }

    @FXML
    void btnUsersOnAction(ActionEvent event) throws IOException {
        setAction("/view/UsersForm.fxml");
    }

    @FXML
    void btnDashboardOnAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(this.getClass().getResource("/view/Admindashboard.fxml"));
        Scene scene = new Scene(root);
        Stage primaryStage =(Stage) this.rootNode.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Book Worm");

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setTxtBranchCount(txtBranchCount);
        setTxtBookCount(txtBookCount);
        setUserCount(txtUserCount);
    }

    private void setUserCount(Label txtUserCount) {
        String userCount = String.valueOf(0);

        try {
            userCount = userBo.getUserCount();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        txtUserCount.setText(userCount);
    }

    public void setTxtBranchCount(Label txtBranchCount) {
        String branchCount = String.valueOf(0);
        try {
            branchCount = branchBo.getBranchCount();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        txtBranchCount.setText(branchCount);
    }

    public void setTxtBookCount(Label txtBookCount){
        String bookCount = String.valueOf(0);

        try {
            bookCount = bookBo.getBookCount();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        txtBookCount.setText(bookCount);
    }

    public void setUserName(String userName) {
       /* this.txtName.setText(userName);*/
        if(txtName != null){
            txtName.setText(userName);
        }else {
            System.out.println("txtName is null");
        }
    }
}
