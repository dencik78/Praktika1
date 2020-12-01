package Controller;

import Backend.dalykai;
import Backend.group;
import Backend.user;
import Date.userRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javax.swing.*;
import java.util.List;

public class destWindController {

    @FXML
    private Button singOutbutton;

    @FXML
    private Pane mainPain;

    @FXML
    private Button propertiesButton;

    @FXML
    private Label vardasPavardeLabel;

    @FXML
    private Label dalykoPav;

    @FXML
    private Button group;


    @FXML
    private Pane propertiesPane;

    @FXML
    private TextField oldPasswordField;

    @FXML
    private TextField newPasswordField;

    @FXML
    private TextField confPasswordField;

    @FXML
    private Button savePasswordButton;

    @FXML
    private FlowPane contentGroupFlow;

    @FXML
    private FlowPane contentStudFlow;

    @FXML
    private Pane grupesPazymPane;

    @FXML
    private FlowPane grupesPazFlow;
    userRepository userRep = new userRepository();

    List<group> groupList;
    List<user> userList;

    private int dal;

    @FXML
    void clickPropertiesButton(ActionEvent event) {
        mainPain.setVisible(false);
        propertiesPane.setVisible(true);

    }

    @FXML
    void groupClick(ActionEvent event) {
        propertiesPane.setVisible(false);
       mainPain.setVisible(true);
    }

    @FXML
    void clieckSavePasswordButton(ActionEvent event) {
        try {
            if(!newPasswordField.getText().isEmpty() && !oldPasswordField.getText().isEmpty() && !confPasswordField.getText().isEmpty()) {
                userRep.change_password(newPasswordField.getText().trim(), oldPasswordField.getText().trim(), confPasswordField.getText().trim());
                newPasswordField.clear();
                oldPasswordField.clear();
                confPasswordField.clear();
                JOptionPane.showMessageDialog(null,"Slaptazodis pasikeite!");
            }else
                throw new Exception("Truksta irasu");
        }catch (Exception exc){
            JOptionPane.showMessageDialog(null, exc);
        }
    }


    @FXML
    void clickSingOut(ActionEvent event) throws Exception {
            userRep.setLogInUser(null);
            singOutbutton.getScene().getWindow().hide();
            FXMLLoader root = new FXMLLoader(getClass().getResource("../Frontend/logInWindow.fxml"));
            Parent loader =root.load();
            Stage stage = new Stage();
            stage.setScene((new Scene(loader, 811, 575)));
            stage.show();
        }


    public void infoMain(user user){
        vardasPavardeLabel.setText(user.getName() + " " + user.getSurname());
    }

    public void showCategory() throws Exception {

        groupList = userRep.getGroupIDLesson(dal);
        contentGroupFlow.getChildren().clear();
        for (group g : groupList) {
            Button btn = new Button(g.getTitle());
            btn.setPrefWidth(110);
            buttonCategoryHendler hendler = new buttonCategoryHendler(g, this);
            btn.setOnAction(hendler);
            contentGroupFlow.getChildren().add(btn);
        }
    }

    public void displayUserGroup(int groupId) throws Exception {
        contentStudFlow.getChildren().clear();

        userList = userRep.userList(groupId);
        for (user i : userList) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../Frontend/infoDestMark.fxml"));
            Parent root = loader.load();
            infoDestmarkController controller = loader.getController();
            controller.dateUp(i,dal);
            controller.displayUser();
            contentStudFlow.getChildren().add(root);

        }

    }

    public void setDal(int dalId){
        this.dal = dalId;
    }
}

