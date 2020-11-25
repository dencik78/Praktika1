package Controller;

import Backend.group;
import Backend.user;
import Date.userRepository;
import javafx.beans.property.adapter.JavaBeanObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.util.List;

public class adminWindController {

    @FXML
    private Button singOutbutton;

    @FXML
    private Pane newPane;

    @FXML
    private FlowPane contentCategoryGroupPane;

    @FXML
    private Button newButton;

    @FXML
    private Button grupesButton;


    @FXML
    private Button buttonAllList;

    @FXML
    private Button dalykaiButton;

    @FXML
    private Button propertiesButton;

    @FXML
    private Pane dalListPane;

    @FXML
    private FlowPane contentDalykuList;

    @FXML
    private Pane studentuListPane;

    @FXML
    private FlowPane contentStudentuList;

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

    userRepository userRep = new userRepository();
    private List<group> groupList;
    private List<user> listUser;

    @FXML
    void clickDalykaiButton(ActionEvent event) {
        propertiesPane.setVisible(false);
        studentuListPane.setVisible(false);
        newPane.setVisible(false);
        dalListPane.setVisible(true);

     //   FXMLLoader loader = new FXMLLoader(getClass().getResource("../Frontend"))

    }

    @FXML
    void clickGrupesButoon(ActionEvent event) throws Exception {
        propertiesPane.setVisible(false);
        dalListPane.setVisible(false);
        newPane.setVisible(false);
        studentuListPane.setVisible(true);


//        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Frontend/studentwind.fxml"));
//        Parent root = loader.load();
//        studWindController controller = loader.getController();
        showCategory();
        displayUser();
    }

    @FXML
    void clickPropertiesButton(ActionEvent event) {
        studentuListPane.setVisible(false);
        dalListPane.setVisible(false);
        newPane.setVisible(false);
        propertiesPane.setVisible(true);

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

    @FXML
    void clieckSavePasswordButton(ActionEvent event) throws Exception {
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
    void newButtonClick(ActionEvent event) {
        propertiesPane.setVisible(false);
        studentuListPane.setVisible(false);
        dalListPane.setVisible(false);
       newPane.setVisible(true);
    }

    public void showCategory() throws Exception{
        groupList = userRep.getGroupList();
        contentCategoryGroupPane.getChildren().clear();
        for(group g:groupList){
            Button btn = new Button(g.getTitle());
            btn.setPrefWidth(110);
            buttonCategoryHendler hendler = new buttonCategoryHendler(g,this);
            btn.setOnAction(hendler);
            contentCategoryGroupPane.getChildren().add(btn);
        }
    }
    public void displayUser() throws Exception{
        contentStudentuList.getChildren().clear();

            listUser = userRep.userListStud();
        for (user i : listUser) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../Frontend/studentwind.fxml"));
            Parent root = loader.load();
            studWindController controller = loader.getController();
            controller.displayStud(i);
            contentStudentuList.getChildren().add(root);

        }
    }

    @FXML
    void clickButtonAllList(ActionEvent event)throws Exception{
        displayUser();
    }

    public void displayUserGroup(int groupId) throws Exception{
        contentStudentuList.getChildren().clear();

        listUser = userRep.userList(groupId);
        for (user i : listUser) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../Frontend/studentwind.fxml"));
            Parent root = loader.load();
            studWindController controller = loader.getController();
            controller.displayStud(i);
            contentStudentuList.getChildren().add(root);

        }
    }

    public void displayUser(List<user> userList) throws Exception{
            contentStudentuList.getChildren().clear();
            for (user i : userList) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../Frontend/studentwind.fxml"));
                Parent root = loader.load();
                studWindController controller = loader.getController();
                controller.displayStud(i);
                contentStudentuList.getChildren().add(root);

            }
        }

}
