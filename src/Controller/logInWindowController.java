package Controller;

import Backend.user;
import Date.userRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

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
                System.out.println("Seccsesful");
            }
        }catch (Exception exc){
            JOptionPane.showMessageDialog(null,exc);
        }
    }

}
