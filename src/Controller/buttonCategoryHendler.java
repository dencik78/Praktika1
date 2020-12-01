package Controller;

import Backend.group;
import javafx.event.Event;
import javafx.event.EventHandler;

import java.security.spec.ECField;

public class buttonCategoryHendler<ActionEvent extends Event> implements EventHandler<ActionEvent> {

    private group g;
    private adminWindController cgw;
    private destWindController cgw1;


    public buttonCategoryHendler(group g,adminWindController cgw){
        this.g = g;
        this.cgw = cgw;
    }

    public buttonCategoryHendler(group g,destWindController cgw){
        this.g = g;
        this.cgw1 = cgw;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        try {
            if(cgw !=null) {
                cgw.displayUserGroup(g.getId());
            }else if(cgw1 != null){
                cgw1.displayUserGroup(g.getId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
