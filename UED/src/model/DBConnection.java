package model;

import java.sql.*;

/**
 * Created by kalipts on 03/12/2017.
 */
public class DBConnection {
    private Connection connection;
    private PreparedStatement statement;
    private ResultSet result;
    public Connection DatabaseConnection() {
        String user = "root";
        String password = "learn4car1$";
        String url = "jdbc:mysql://localhost:3306/ued";
        try {
            connection = DriverManager.getConnection(url,user,password);
            System.out.println("Connection access");
        } catch (SQLException e) {
            System.out.println("Loi " + e.getMessage());
        }
        return connection;
    }

    public PreparedStatement getStatement() {
        return statement;
    }

    public void setStatement(PreparedStatement statement) {
        this.statement = statement;
    }

    public ResultSet getResult() {
        return result;
    }

    public void setResult(ResultSet result) {
        this.result = result;
    }
}
