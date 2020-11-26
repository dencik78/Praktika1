package Controller;

import Backend.dalykai;
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

    dalykai dalSave;
    adminWindController cgw;

    @FXML
    void clickDeleteDal(ActionEvent event)throws Exception {
        userRepository rp =new userRepository();
        rp.delete_dalykas(dalSave);
        cgw.updateDal();
    }

    public void display(dalykai dal,adminWindController cgw){
        this.dalSave = dal;
        this.cgw = cgw;
        TitleDalykasField.setText(dal.getTitle());
        aprasymasField.setText(dal.getAprasymas());

    }
}
