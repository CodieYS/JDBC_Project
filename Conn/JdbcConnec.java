package JDBC_Program.Conn;
import JDBC_Program.GlobalExceptionHandler.ErrorHandle;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnec {

    private  static JdbcConnec jdconnec;

    private Connection connection;

    private final String url = "jdbc:mysql://localhost:3306/db";
    private final String user = "root";
    private final String password = "yash022";

    private  JdbcConnec() {
        try {
            connection = DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            ErrorHandle.handleSQLException(e);
        }
    }

    public static JdbcConnec getInstance() {
        if (jdconnec == null) {
            synchronized (JdbcConnec.class) {   //For Type Cast i.e. Deserialization process perform in this step.
                if (jdconnec == null) {
                    jdconnec= new JdbcConnec();
                }
            }
        }
        return jdconnec;
    }

    public Connection getConnec() {
        return connection;
    }


}
