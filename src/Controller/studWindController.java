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

    private user userSave;
    adminWindController cgw;

    @FXML
    void clickDelteUser(ActionEvent event) throws Exception {
        userRepository rp = new userRepository();
        rp.delete_user(userSave);
        cgw.updateGroup();
    }

    public void displayStud(user i,adminWindController cgw) throws Exception{
        userRepository rp = new userRepository();
        nameField.setText(i.getName());
        surnameField.setText(i.getSurname());
        String title = rp.GetuserGroupTitle(i.getIdGroups());
        int id = i.getIdGroups();
        userSave = i;
        this.cgw = cgw;
        groupTitleLabel.setText(rp.GetuserGroupTitle(i.getIdGroups()));
    }
}
