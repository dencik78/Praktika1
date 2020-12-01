package Controller;

import Backend.dalykai;
import Backend.user;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import Date.userRepository;

public class dalSarasasController {

    @FXML
    private Button DeleteDalykas;

    @FXML
    private Label TitleDalykasField;

    @FXML
    private Label aprasymasField;

    @FXML
    private Label destytName;


    dalykai dalSave;
    adminWindController cgw;
    userRepository rp =new userRepository();

    @FXML
    void clickDeleteDal(ActionEvent event)throws Exception {
        rp.delete_dalykas(dalSave);
        cgw.updateDal();
    }

    public void display(dalykai dal,adminWindController cgw) throws Exception {

        this.dalSave = dal;
        this.cgw = cgw;
        TitleDalykasField.setText(dal.getTitle());
        aprasymasField.setText(dal.getAprasymas());
        user user = rp.userNameT(dal.getId());
        if (user != null) {
            destytName.setText(user.getName() + " " + user.getSurname());
        } else {
            destytName.setText("Nepriskirtas");
        }
    }
}
