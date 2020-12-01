package Controller;

import Date.userRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import javax.swing.*;
import java.sql.SQLException;

public class NewMarkWindowscontroller {

    @FXML
    private Label titleWindow;

    @FXML
    private Pane updatePane;

    @FXML
    private TextField markField;

    @FXML
    private Button saveButton;

    @FXML
    private Label marklabel;

    @FXML
    private Pane updatePane1;//new mark

    @FXML
    private TextField newmarkField;

    @FXML
    private Button newsaveButton1;

    userRepository rp = new userRepository();

    int dal;int stud;infoDestmarkController cgw;

    @FXML
    void clickNewSaveButton(ActionEvent event) throws SQLException, ClassNotFoundException {
        try {
            rp.newMark(newmarkField.getText().trim(), dal, stud);
            JOptionPane.showMessageDialog(null, "Pažymis įterptas");
            cgw.displayUser();
            newsaveButton1.getScene().getWindow().hide();
        } catch (Exception exc) {
            JOptionPane.showMessageDialog(null, "Neteisingai ivesti duomenis");
        }
    }

    @FXML
    void clickSaveButton(ActionEvent event) throws Exception {
        try {
            rp.updateMark(markField.getText(), dal, stud);
            JOptionPane.showMessageDialog(null, "Pažymis pakeistas");
            cgw.displayUser();
            saveButton.getScene().getWindow().hide();
        } catch (Exception exc) {
            JOptionPane.showMessageDialog(null,"Neteisingai ivesti duomenis");
        }
    }

    public void newDisplay(int dal,int stud,infoDestmarkController cgw){
        titleWindow.setText("Naujo pažymio įterpimas");
        updatePane1.setVisible(true);
        updatePane.setVisible(false);
        this.dal =  dal;
        this.stud = stud;
        this.cgw = cgw;
    }

    public void updateDisplay(int mark,int dal,int stud,infoDestmarkController cgw){
        titleWindow.setText("Pažymio atnaujinimas");
        marklabel.setText(String.valueOf(mark));
        updatePane1.setVisible(false);
        updatePane.setVisible(true);
        this.dal =  dal;
        this.stud = stud;
        this.cgw = cgw;
    }
}
