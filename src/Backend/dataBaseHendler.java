package Backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dataBaseHendler extends config {
    Connection dbConnect;

    public Connection getDbConnection() throws SQLException, ClassNotFoundException {

        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;

        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnect = DriverManager.getConnection(connectionString, dbUser, dbPassword);
        return dbConnect;
    }
}
