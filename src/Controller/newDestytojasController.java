package Controller;

import Backend.dalykai;
import Backend.group;
import Backend.user;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;
import Date.userRepository;

public class newDestytojasController {

    @FXML
    private CheckBox menChekBox;

    @FXML
    private CheckBox womenCheckBox;

    @FXML
    private ListView<String> ListDal;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField surnameTextField;

    @FXML
    private Button saveButton;

    @FXML
    private TextField laipsnisTextField;

    private String gender;
    userRepository rp = new userRepository();

    public void initialize() throws Exception {
        List<dalykai> listD = rp.getDalykuList();
        List<String> listTitle = new ArrayList<>();
        for(dalykai d:listD){
            listTitle.add(d.getTitle());
        }
        ObservableList<String> listGroup = FXCollections.observableList(listTitle);
        ListDal.setItems(listGroup);

    }

    @FXML
    void ChekBoxMen(ActionEvent event) {
        if(menChekBox.isSelected()){
            womenCheckBox.setSelected(false);
        }

    }

    @FXML
    void chekBoxWomen(ActionEvent event) {
        if(womenCheckBox.isSelected()){
            menChekBox.setSelected(false);
        }
    }

    @FXML
    void clickSaveButton(ActionEvent event) throws Exception {
        if(menChekBox.isSelected()){
            gender = "Men";
        }else if(womenCheckBox.isSelected()){
            gender = "Women";
        }

        ObservableList<Integer> SelIndexList = ListDal.getSelectionModel().getSelectedIndices();
        List<dalykai> listG = rp.getDalykuList();
        int curId = listG.get(SelIndexList.get(0)).getId();


        user user = new user(nameTextField.getText().trim(),surnameTextField.getText().trim(),laipsnisTextField.getText().trim(),gender,curId);
        rp.add_new_user_Teacher(user);

        saveButton.getScene().getWindow().hide();
    }

}
