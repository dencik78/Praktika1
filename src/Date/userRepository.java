package Date;

import Backend.cons;
import Backend.group;
import Backend.user;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Backend.dataBaseHendler;
import com.mysql.cj.jdbc.ha.NdbLoadBalanceExceptionChecker;

import javax.swing.*;

public class userRepository {
    private static user LogInUser;
    dataBaseHendler db = new dataBaseHendler();
    List<user> userList;
    List<group> groupList;

    public void registr(user user) throws Exception {
        String sqlT = "SELECT * FROM " + cons.DB_TITLE + "." + cons.USER_TABLE + " WHERE " + cons.USER_USERNAME + " =?";
        PreparedStatement prSt = db.getDbConnection().prepareStatement(sqlT);
        prSt.setString(1, user.getUsername());
        ResultSet resSet = prSt.executeQuery();

        int num = 0;
        while (resSet.next()) {
            num++;
        }

        if (num > 0) {
            throw new Exception("user is system");
        }

        String sqlS = "INSER INTO " + cons.DB_TITLE + "." + cons.USER_TABLE + " (" +
                cons.USER_NAME + ", " + cons.USER_SURNAME + ", " +
                cons.USER_GENDER + ", " + cons.USER_DALYKOID + ", " + cons.USER_GRUPESID +
                ", " + cons.USER_USERNAME + ", " + cons.USER_PASSWORD + ") VALUES " +
                "(?,?,?,?,?,?,?,?)";

        PreparedStatement prST = db.getDbConnection().prepareStatement(sqlS);
        prST.setString(1,user.getName());
        prST.setString(2, user.getSurname());
        prST.setString(3,user.getGender());
        prST.setInt(4,user.getIdLesson());
        prST.setInt(5,user.getIdGroups());
        prST.setString(6,user.getUsername());
        prST.setString(7,user.getPassword());

        prST.executeUpdate();
        prST.close();
    }

    public user LOgOn(String username,String password) throws Exception{
        user user1 = null;
        String sql = "SELECT * FROM " + cons.USER_TABLE + " WHERE " + cons.USER_USERNAME + "=? AND " + cons.USER_PASSWORD + "=?";

        PreparedStatement prSt = db.getDbConnection().prepareStatement(sql);
        prSt.setString(1,username);
        prSt.setString(2,password);

        ResultSet resSet = prSt.executeQuery();
        int num = 0;

        while(resSet.next()){
            num++;
            int id = resSet.getInt(cons.USER_ID);
            String name = resSet.getString(cons.USER_NAME);
            String surname = resSet.getString(cons.USER_SURNAME);
            String gender = resSet.getString(cons.USER_GENDER);
            int dalykoId = resSet.getInt(cons.USER_DALYKOID);
            int grupesId = resSet.getInt(cons.USER_GRUPESID);
            String username1 = resSet.getString(cons.USER_USERNAME);
            String password1 = null;
            int type = resSet.getInt(cons.USER_TYPE);
            user1 = new user(name,surname,gender,username,password,id,type,grupesId,dalykoId);
        }
        resSet.close();
        if(num <=0){
            throw new Exception("Not Wrong Username");
        }
        LogInUser = user1;
    return user1;
    }

    public void add_new_user_Student(user user) throws Exception{
        String sqlT = "SELECT * FROM " + cons.DB_TITLE + "." + cons.USER_TABLE + " WHERE " + cons.USER_USERNAME + " =?";
        PreparedStatement prSt = db.getDbConnection().prepareStatement(sqlT);
        prSt.setString(1, user.getUsername());
        ResultSet resSet = prSt.executeQuery();

        int num = 0;
        while (resSet.next()) {
            num++;
        }

        if (num > 0) {
            throw new Exception("user is system");
        }

        String sql = "INSERT INTO " + cons.DB_TITLE + "." +
                cons.USER_TABLE + " (" + cons.USER_NAME + ", " + cons.USER_SURNAME + ", " +
                cons.USER_GENDER + ", " + cons.USER_DALYKOID + ", " + cons.USER_GRUPESID +
                ", " + cons.USER_USERNAME + ", " + cons.USER_PASSWORD + " , " + cons.USER_TYPE + ") VALUES " +
                "(?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement prST = db.getDbConnection().prepareStatement(sql);
            prST.setString(1, user.getName());
            prST.setString(2, user.getSurname());
            prST.setString(3, user.getGender());
            prST.setString(4, null);
            prST.setInt(5, user.getIdGroups());
            prST.setString(6, user.getName());
            prST.setString(7, user.getSurname());
            prST.setString(8, String.valueOf(user.getType()));

            prST.executeUpdate();
            prST.close();
        }catch (Exception exc){
            JOptionPane.showMessageDialog(null, exc);
        }

    }

    public void add_new_user_Teacher(user user) throws Exception {
        String sqlT = "SELECT * FROM " + cons.DB_TITLE + "." + cons.USER_TABLE + " WHERE " + cons.USER_USERNAME + " =?";
        PreparedStatement prSt = db.getDbConnection().prepareStatement(sqlT);
        prSt.setString(1, user.getUsername());
        ResultSet resSet = prSt.executeQuery();

        int num = 0;
        while (resSet.next()) {
            num++;
        }

        if (num > 0) {
            throw new Exception("user is system");
        }

        String sql = "INSERT INTO " + cons.DB_TITLE + "." +
                cons.USER_TABLE + " (" + cons.USER_NAME + ", " + cons.USER_SURNAME + ", " +
                cons.USER_GENDER + ", " + cons.USER_DALYKOID + ", " + cons.USER_GRUPESID +
                ", " + cons.USER_USERNAME + ", " + cons.USER_PASSWORD + "," + cons.USER_TYPE + ") VALUES " +
                "(?,?,?,?,?,?,?,?,?)";
        try {

            PreparedStatement prST = db.getDbConnection().prepareStatement(sql);
            prST.setString(1, user.getName());
            prST.setString(2, user.getSurname());
            prST.setString(3, user.getGender());
            prST.setInt(4, user.getIdLesson());
            prST.setString(5, null);
            prST.setString(6, user.getName());
            prST.setString(7, user.getSurname());
            prST.setString(8, String.valueOf(user.getType()));

            prST.executeUpdate();
            prST.close();
        }catch (Exception exc){
            JOptionPane.showMessageDialog(null, exc);
        }
    }

    public void delete_user(user user) throws Exception{

        String sql ="DELETE FROM " + cons.DB_TITLE + "." + cons.USER_TABLE +
                " WHERE (" + cons.USER_ID + " =?";
        PreparedStatement prSt = db.getDbConnection().prepareStatement(sql);

        prSt.setString(1,String.valueOf(user.getId()));
        prSt.executeUpdate();
    }

    public void change_password(String newPassword,String oldPassword,String confPassword) throws Exception{
        String sqlPassword = "SELECT " + cons.USER_PASSWORD + " FROM " + cons.DB_TITLE + "." + cons.USER_TABLE + " WHERE " +
                cons.USER_ID + " =?";
        PreparedStatement prST1 = db.getDbConnection().prepareStatement(sqlPassword);
        prST1.setString(1,String.valueOf(LogInUser.getId()));
        ResultSet resSet = prST1.executeQuery();

        String password = null;
        while(resSet.next()){
            password = resSet.getString("password");
        }

        prST1.close();

        if(oldPassword.equals(password)) {
            if (newPassword.equals(confPassword)) {
                String sql = "UPDATE " + cons.DB_TITLE + "." + cons.USER_TABLE + " SET " +
                        cons.USER_PASSWORD + " =? WHERE (" + cons.USER_ID + " =?)";
                PreparedStatement prST = db.getDbConnection().prepareStatement(sql);
                prST.setString(1, newPassword);
                prST.setString(2, String.valueOf(LogInUser.getId()));

                prST.executeUpdate();
                prST.close();
            } else
                throw new Exception("Neteisingas pakartotinis slaptazodis");
        }else
            throw new Exception("neteisingas senas slaptazodis");
    }

    public void setLogInUser(user logInUser) {
        this.LogInUser = logInUser;
    }

    public List<group> getGroupList() throws Exception{
        groupList = new ArrayList<>();

        String sql = "SELECT * FROM grupe";
        PreparedStatement prST = db.getDbConnection().prepareStatement(sql);
        ResultSet resSet = prST.executeQuery();
        while(resSet.next()){
            int id = resSet.getInt("id");
        String pavadinimas = resSet.getString("pavadinimas");
        groupList.add(new group(id,pavadinimas));
        }
        return groupList;

    }

    public List<user> userList(int id) throws Exception {
        userList = new ArrayList<user>();

        String sql = "SELECT * FROM " + cons.DB_TITLE + "." + cons.USER_TABLE + " WHERE (" +
                cons.USER_GRUPESID + " =?)";

        PreparedStatement prST = db.getDbConnection().prepareStatement(sql);
        prST.setString(1, String.valueOf(id));

        ResultSet resSet = prST.executeQuery();

        while (resSet.next()) {
            String name = resSet.getString("name");
            String surname = resSet.getString("surname");
            String gender = resSet.getString("gender");
            int id1 = resSet.getInt("grupesId");
            userList.add(new user(name, surname, gender,id1));
        }
        return userList;
    }

    public List<user> userListStud() throws Exception {
        userList = new ArrayList<user>();

        String sql = "SELECT * FROM " + cons.DB_TITLE + "." + cons.USER_TABLE + " WHERE (" + cons.USER_GRUPESID + " > 0)";

        PreparedStatement prST = db.getDbConnection().prepareStatement(sql);

        ResultSet resSet = prST.executeQuery();

        while (resSet.next()) {
            String name = resSet.getString("name");
            String surname = resSet.getString("surname");
            String gender = resSet.getString("gender");
            int id = resSet.getInt("grupesId");
            userList.add(new user(name, surname, gender, id));
        }
        return userList;
    }

    public String GetuserGroupTitle(int id) throws Exception{
        List<group> g;
        g= getGroupList();
        String title = null;
        for(group group : g){
            if(group.getId() == id){
                title = group.getTitle();
            }
        }
        return title;
    }
}