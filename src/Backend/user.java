package Backend;

public class user extends person {
    protected String username;
    protected String password;
    protected int id;
    protected String type;
    protected String idGroups;
    protected String idLesson;

    public user(String name,String surname,String gender,String username,String password,int id,String type,String idGroups,String idLesson){
        super(name,surname,gender);

        this.id = id;
        this.username = username;
        this.password = password;
        this.type = type;
        this.idGroups = idGroups;
        this.idLesson = idLesson;

    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getIdGroups() {
        return idGroups;
    }

    public String getIdLesson() {
        return idLesson;
    }
}
