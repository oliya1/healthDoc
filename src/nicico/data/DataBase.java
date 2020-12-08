package nicico.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {
    private static DataBase singleton;
    static {
        try {
            singleton = new DataBase( );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Connection connection;
    private Statement statement;

    public static DataBase getInstance( ) {
        return singleton;
    }
    public Connection getConnection() {
        return connection;
    }
    public Statement getStatement() {
        return statement;
    }

    private DataBase() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","hami1234");
        statement = connection.createStatement();
    }
    public void closeConnection() throws SQLException{
        if(connection!=null)
            connection.close();
    }
}
