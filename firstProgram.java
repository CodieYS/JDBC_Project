package JDBC_Program;
import java.sql.*;


public class firstProgram {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root", "yash022" );
            Statement statement = conn.createStatement();

//            boolean rs = statement.execute("create table  demo(col1 int primary key, col2 varchar(20))");
//            System.out.println(rs);

            int executeupdate = statement.executeUpdate("insert into demo values(2, 'sukhija');");

            ResultSet rss = statement.executeQuery("select * from demo");

            while(rss.next()) {
                System.out.println(rss.getInt(1) + "\t" + rss.getString(2));
            }

            statement.close();
            conn.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
