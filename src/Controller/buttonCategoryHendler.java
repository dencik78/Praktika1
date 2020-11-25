package Controller;

import Backend.group;
import javafx.event.Event;
import javafx.event.EventHandler;

import java.security.spec.ECField;

public class buttonCategoryHendler<ActionEvent extends Event> implements EventHandler<ActionEvent> {

    private group g;
    private adminWindController cgw;


    public buttonCategoryHendler(group g,adminWindController cgw){
        this.g = g;
        this.cgw = cgw;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        try {
            cgw.displayUserGroup(g.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
