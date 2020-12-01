package Backend;

public class cons {

    public static final String DB_TITLE = "akademine_sistema";

    //USER TABLE
    public static final String USER_TABLE = "usertable";
    public static final String USER_ID = "id";
    public static final String USER_NAME = "name";
    public static final String USER_SURNAME = "surname";
    public static final String USER_GENDER = "gender";
    public static final String USER_DALYKOID = "dalykoId";
    public static final String USER_GRUPESID = "grupesId";
    public static final String USER_USERNAME = "username";
    public static final String USER_PASSWORD = "password";
    public static final String USER_TYPE = "type";
    public static final String USER_LAIPSNIS = "laipsnis";

    //group TABLE
    public static final String GROUP_TABLE = "grupe";
    public static final String GROUP_ID = "id";
    public static final String GROUP_PAVADINIMAS = "pavadinimas";

    //groupDal TABLE
    public static final String GROUPDAL_TABLE = "groupdal";
    public static final String GROUPDAL_ID = "id";
    public static final String GROUPDAL_GROUPID = "idGroup";
    public static final String GROUPDAL_DALID = "idDal";


    //Dalykai TABLE
    public static final String DALYKAI_TABLE = "dalykas";
    public static final String DALYKAI_ID = "id";
    public static final String DALYKAI_PAVADINIMAS = "pavadinimas";
    public static final String DALYKAI_APRASYMAS = "aprasymas";

    //MARK TABLE
    public static final String MARK_TABLE = "pazymis";
    public static final String MARK_ID = "id";
    public static final String MARK_IDDAL = "idDalyko";
    public static final String MARK_IDSTUD = "idStudentas";
    public static final String MARK_MARK = "pazymis";

}
