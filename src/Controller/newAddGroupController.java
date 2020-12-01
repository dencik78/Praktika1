package Controller;

import Backend.dalykai;
import Backend.group;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import java.util.ArrayList;
import java.util.List;
import Date.userRepository;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import javax.swing.*;

public class newAddGroupController {

    userRepository rp = new userRepository();
    @FXML
    private TextField titleGroupAddField;

    @FXML
    private ListView<String> listGroupReal;

    @FXML
    private ListView<String> listGorupChouse;

    @FXML
    private Button buttonNext;

    @FXML
    private Button saveButton;
    List<dalykai> listG = rp.getDalykuList();
    List<dalykai> Chouse = new ArrayList<>();
    int nums[];

    public newAddGroupController() throws Exception {
    }

    public void initialize() throws Exception {
        List<String> listTitle = new ArrayList<>();
        for(dalykai d :listG){
            listTitle.add(d.getTitle());
        }
        ObservableList<String> listGroup = FXCollections.observableList(listTitle);
        listGroupReal.setItems(listGroup);

    }

    public void clickButtonNext(ActionEvent actionEvent) throws Exception {
        List<String> listTitle = new ArrayList<>();
        ObservableList<Integer> SelIndexList = listGroupReal.getSelectionModel().getSelectedIndices();

        Chouse.add(listG.get(SelIndexList.get(0)));
        int id = SelIndexList.get(0);
        listG.remove(id);




        for(dalykai d :listG){
            listTitle.add(d.getTitle());
        }
        ObservableList<String> listGroup = FXCollections.observableList(listTitle);
        listGroupReal.setItems(listGroup);

        List<String> listTitle1 = new ArrayList<>();
        for(dalykai d :Chouse){
            listTitle1.add(d.getTitle());
        }

        ObservableList<String> listGroup1 = FXCollections.observableList(listTitle1);
        listGorupChouse.setItems(listGroup1);


    }

    public void clickSaveButton(ActionEvent actionEvent) throws Exception {
        nums = new int[Chouse.size()];
        int i = 0;
        for (dalykai d : Chouse) {
            nums[i] = d.getId();
            i++;
        }
        try {
            if (titleGroupAddField.getText().isEmpty()) {
                throw new Exception("Neivesti duomenis");
            } else {
                rp.add_new_group(nums, titleGroupAddField.getText().trim());


                saveButton.getScene().getWindow().hide();
            }
        } catch (Exception exc) {
            JOptionPane.showMessageDialog(null, exc.getMessage());
        }
    }
}
