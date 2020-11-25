package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import Backend.user;
import Date.userRepository;

public class studWindController {


    @FXML
    private Label nameField;

    @FXML
    private Button DelteUserButton;

    @FXML
    private Button deleteuserInGroupButton;

    @FXML
    private Label surnameField;

    @FXML
    private Label groupTitleLabel;

    @FXML
    void clickDelteUser(ActionEvent event) {

    }

    @FXML
    void clickDelteUserInGroup(ActionEvent event) {

    }

    public void displayStud(user i) throws Exception{
        userRepository rp = new userRepository();
        nameField.setText(i.getName());
        surnameField.setText(i.getSurname());
        String title = rp.GetuserGroupTitle(i.getIdGroups());
        int id = i.getIdGroups();
        groupTitleLabel.setText(rp.GetuserGroupTitle(i.getIdGroups()));
    }
}
