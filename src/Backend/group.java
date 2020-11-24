package Backend;

public class group {

    protected int id;
    protected String title;

    public group(int id,String title){
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
