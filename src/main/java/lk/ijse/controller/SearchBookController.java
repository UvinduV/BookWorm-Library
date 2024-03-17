package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.bo.BoFactory;
import lk.ijse.bo.custom.BookBo;
import lk.ijse.dto.BookDto;

import java.io.IOException;

public class SearchBookController {
    @FXML
    private AnchorPane root;

    @FXML
    private AnchorPane rootNode;

    @FXML
    private Label txtName;

    @FXML
    private TextField txtSearchBook;

    BookBo bookBo = (BookBo) BoFactory.getBOFactory().getBo(BoFactory.BoTypes.BOOK);




    @FXML
    void btnSearchOnAction(ActionEvent event) {
        String title = txtSearchBook.getText();

        try{
            BookDto bookDto = bookBo.searchBook(title);

            if(bookDto != null){
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/BorrowNewBookForm.fxml"));
                Parent rootNode = loader.load();

                BorrowNewBookFormController detailsController = loader.getController();

                detailsController.searchBookDetails(bookDto);

                Scene scene = new Scene(rootNode);

                Stage stage = new Stage();
                stage.setTitle("Book Worm");
                stage.setScene(scene);
                stage.show();

                clearFields();
            }else {
                new Alert(Alert.AlertType.ERROR,"Book Not Found").show();
            }
        }catch(IOException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }



    }


    private void clearFields() {
        txtSearchBook.setText("");
    }
}
