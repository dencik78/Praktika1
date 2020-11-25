package Backend;

public class user extends person {
    protected String username;
    protected String password;
    protected int id;
    protected int type;
    protected int idGroups;
    protected int idLesson;

    public user(String name,String surname,String gender,String username,String password,int id,int type,int idGroups,int idLesson){
        super(name,surname,gender);

        this.id = id;
        this.username = username;
        this.password = password;
        this.type = type;
        this.idGroups = idGroups;
        this.idLesson = idLesson;

    }

    public user(String name,String surname,String gender,int idGroups){
        super(name,surname,gender);
    this.idGroups = idGroups;
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

    public int getType() {
        return type;
    }

    public int getIdGroups() {
        return idGroups;
    }

    public int getIdLesson() {
        return idLesson;
    }
}
