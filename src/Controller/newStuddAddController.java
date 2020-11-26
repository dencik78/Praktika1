package Controller;

import Backend.group;
import Backend.user;
import Date.userRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.List;

public class newStuddAddController {
    @FXML
    private CheckBox menChekBox;

    @FXML
    private CheckBox womenCheckBox;

    @FXML
    private ListView<String> ListGruop;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField surnameTextField;

    @FXML
    private Button saveButton;
    String gender;
    userRepository rp = new userRepository();



    public void initialize() throws Exception {
        List<group> listG = rp.getGroupList();
        List<String> listTitle = new ArrayList<>();
        for(group g :listG){
            listTitle.add(g.getTitle());
        }
        ObservableList<String> listGroup = FXCollections.observableList(listTitle);
        ListGruop.setItems(listGroup);

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

        ObservableList<Integer> SelIndexList = ListGruop.getSelectionModel().getSelectedIndices();
        List<group> listG = rp.getGroupList();
        int curId = listG.get(SelIndexList.get(0)).getId();


        user user = new user(nameTextField.getText().trim(),surnameTextField.getText().trim(),gender,curId);

        rp.add_new_user_Student(user);

        saveButton.getScene().getWindow().hide();
    }
}
