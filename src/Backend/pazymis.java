package Backend;

public class pazymis {
    protected int id;
    protected int idDalykas;
    protected int idStudent;
    protected int pazymis1;

    public pazymis(int id,int idDalykas,int idStudent,int pazymis1){
        this.id = id;
        this.idDalykas = idDalykas;
        this.idStudent = idStudent;
        this.pazymis1 = pazymis1;
    }

    public int getId() {
        return id;
    }

    public int getIdDalykas() {
        return idDalykas;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public int getPazymis1() {
        return pazymis1;
    }
}
