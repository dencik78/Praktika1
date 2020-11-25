package Controller;

import Backend.user;
import Date.userRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;

public class logInWindowController {
    @FXML
    private TextField LoginFieldText;

    @FXML
    private TextField passwordTextField;

    @FXML
    private Button logInButton;

    @FXML
    void clickLogInButton(ActionEvent event) throws Exception {
        userRepository uRP = new userRepository();

        user user;
        try {
            if (LoginFieldText.getText().isEmpty() || passwordTextField.getText().isEmpty()) {
                throw new Exception("you dont write login or password");
            } else {
                user = uRP.LOgOn(LoginFieldText.getText().trim(), passwordTextField.getText().trim());
                logInButton.getScene().getWindow().hide();
                uRP.setLogInUser(user);
                if(user.getType() == 9){
                    FXMLLoader root = new FXMLLoader(getClass().getResource("../Frontend/adminWindow.fxml"));
                    Parent loader =root.load();
                    Stage stage = new Stage();
                    stage.setScene((new Scene(loader, 811, 575)));
                    stage.show();
                }else if (user.getType() == 0) {
                    FXMLLoader root = new FXMLLoader(getClass().getResource("../Frontend/studentWindow.fxml"));
                    Parent loader = root.load();
                    Stage stage = new Stage();
                    stage.setScene((new Scene(loader, 811, 575)));
                    stage.show();
                }else if(user.getType() == 1){
                    FXMLLoader root = new FXMLLoader(getClass().getResource("../Frontend/destitojoWindow.fxml"));
                    Parent loader = root.load();
                    Stage stage = new Stage();
                    stage.setScene((new Scene(loader, 811, 575)));
                    stage.show();
                }
            }
        }catch (Exception exc){
            JOptionPane.showMessageDialog(null,exc);
        }
    }

}
