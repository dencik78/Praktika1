package Controller;

import Backend.dalykai;
import Backend.user;
import Date.userRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class infoDestmarkController {

    @FXML
    private Label nameSurnameLabel;

    @FXML
    private Label markLabel;

    @FXML
    private Button updateMark;

    @FXML
    private Button newmark;

    userRepository userRp = new userRepository();
    user user;
    int dal;

    public void displayUser() throws Exception{
        nameSurnameLabel.setText(user.getName() + " " + user.getSurname());
        markLabel.setText(String.valueOf(userRp.getMark(dal,user.getId())));
        if(userRp.getMark(dal,user.getId()) > 0){
            updateMark.setVisible(true);
            newmark.setVisible(false);
        }else {
            markLabel.setText("Nera pažymio");
            updateMark.setVisible(false);
            newmark.setVisible(true);
        }
    }

    @FXML
    void newmarkClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Frontend/newMarkWindows.fxml"));
        Parent root = loader.load();
        NewMarkWindowscontroller controller = loader.getController();
        controller.newDisplay(dal,user.getId(),this);
        Stage stage = new Stage();
        stage.setScene(new Scene(root,231,200));
        stage.show();
    }

    @FXML
    void updateClixkMark(ActionEvent event) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Frontend/newMarkWindows.fxml"));
        Parent root = loader.load();
        NewMarkWindowscontroller controller = loader.getController();
        controller.updateDisplay(userRp.getMark(dal,user.getId()),dal,user.getId(),this);
        Stage stage = new Stage();
        stage.setScene(new Scene(root,231,200));
        stage.show();
    }

    public void dateUp(user user,int dal){
        this.user = user;
        this.dal = dal;
    }

}
