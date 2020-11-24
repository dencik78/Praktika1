package Backend;

public class dalykai {
    protected int id;
    protected String title;
    protected String aprasymas;

    public dalykai(int id,String title,String aprasymas){
        this.aprasymas = aprasymas;
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAprasymas() {
        return aprasymas;
    }
}
