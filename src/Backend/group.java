package Backend;

import java.util.ArrayList;
import java.util.List;

public class group {

    protected int id;
    protected String title;
    private List<user> userList;

    public group(int id,String title){
        this.id = id;
        this.title = title;
        userList = new ArrayList<user>();

    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public List<user> getListUser(){
        return userList;
    }
}
