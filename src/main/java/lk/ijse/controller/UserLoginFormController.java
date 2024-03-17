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
import lk.ijse.bo.custom.UserBo;
import lk.ijse.dto.AdminDto;
import lk.ijse.dto.UserDto;

import java.io.IOException;
import java.util.regex.Pattern;

public class UserLoginFormController {
    @FXML
    private AnchorPane root;

    @FXML
    private AnchorPane rootNode;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUsername;
    UserDashboardController userDashboardController = new UserDashboardController();
    UserBo userBo = (UserBo) BoFactory.getBOFactory().getBo(BoFactory.BoTypes.USER);

    @FXML
    void btnSignInOnAction(ActionEvent event) {

        /*if(validateUser()){
            String userName = txtUsername.getText();
            String password = txtPassword.getText();

            UserDto userDto = userBo.userSignIn(userName,password);

            if(userDto != null){
                try{
                    clearFields();
                    openWindow();
                    new Alert(Alert.AlertType.CONFIRMATION,"Welcome User").show();
                    //userDashboardController.setUserName(userDto.getUserName());
                }catch (Exception e){
                    clearFields();
                    new Alert(Alert.AlertType.ERROR,"Login Failed").show();
                }
            }
        }*/
        String userName = txtUsername.getText();
        String password = txtPassword.getText();

        if (userName.isEmpty() || password.isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Please enter all fields").show();
            return;
        }

        if(validateUser()){
            try {
                UserDto userDto = userBo.userSignIn(userName,password);
                if (userDto!= null) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Login Successful").show();
                    System.out.println("Login Successful");
                    clearFields();
                    openWindow();
                    System.out.println("user login dashboard");
                }else {
                    new Alert(Alert.AlertType.ERROR, "incorrect username or password").show();
                    System.out.println("Login Failed ,incorrect username or password");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }

    @FXML
    void signUpChangeOnAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(this.getClass().getResource("/view/UserSignUpForm.fxml"));

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

    public boolean validateUser(){
        String userName = txtUsername.getText();

        boolean isUserNameValidated = Pattern.matches("([a-z]){4,}(\\d){2,}", userName);
        if (!isUserNameValidated) {
            new Alert(Alert.AlertType.ERROR, "Invalid UserName!").show();
            return false;
        }

        String password = txtPassword.getText();

        boolean isPasswordValidated = Pattern.matches("(\\d){4,}", password);
        if (!isPasswordValidated) {
            new Alert(Alert.AlertType.ERROR, "Invalid Password!").show();
            return false;
        }

        return true;
    }

    private void clearFields() {
        txtUsername.setText("");
        txtPassword.setText("");
    }

    public void openWindow() throws IOException {

        /*FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/UserDashboard.fxml"));
        Parent rootNode = loader.load();
        Scene scene = new Scene(rootNode);
        Stage stage = new Stage();
        stage.setTitle("Book Worm");
        stage.setScene(scene);
        stage.show();*/

        Parent rootNode = FXMLLoader.load(this.getClass().getResource("/view/UserDashboard.fxml"));

        Scene scene = new Scene(rootNode);
        Stage primaryStage =(Stage) this.rootNode.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Book Worm");
    }
}
