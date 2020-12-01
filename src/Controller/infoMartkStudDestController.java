package Controller;

import Backend.user;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class infoMartkStudDestController {

    @FXML
    private Label nameSurnamelabel;

    @FXML
    private Label markLabel;

    @FXML
    private Label dalykoTitle;

    public void dispaly(user user,String dalTitle,int mark) {
        nameSurnamelabel.setText(user.getName() + " " + user.getSurname());
        dalykoTitle.setVisible(true);
        dalykoTitle.setText(dalTitle);
        if (mark == 0) {
            markLabel.setText("Nera pazymio");
        } else {
            markLabel.setText(String.valueOf(mark));
        }
    }
}
