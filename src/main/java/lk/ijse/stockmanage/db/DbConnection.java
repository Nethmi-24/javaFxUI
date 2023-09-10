package lk.ijse.stockmanage.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static DbConnection dbConnection;
    private static Connection con;


    private DbConnection() throws SQLException {
        con= DriverManager.getConnection("jdbc:mysql://localhost:3306/kade","root","Navodya24!#");
    }
    public static DbConnection getInstance() throws SQLException {
        return (dbConnection==null)?dbConnection=new DbConnection():dbConnection;
    }

    public Connection getConnection() {
        return con;
    }
}
