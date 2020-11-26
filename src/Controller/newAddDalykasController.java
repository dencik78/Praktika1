package Controller;

import Backend.dalykai;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import Date.userRepository;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class newAddDalykasController {

    @FXML
    private TextField titleAddDalykas;

    @FXML
    private TextArea aprasymasField;

    @FXML
    private Button savebutton;


    public void clickSaveButton(ActionEvent actionEvent) throws Exception {
        userRepository rp =new userRepository();
        rp.add_new_dal(new dalykai(titleAddDalykas.getText().trim(),aprasymasField.getText().trim()));
        savebutton.getScene().getWindow().hide();

    }
}
