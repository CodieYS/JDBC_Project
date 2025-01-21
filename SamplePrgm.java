package JDBC_Program;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

import static java.lang.Class.forName;

public class SamplePrgm {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
        //1st Step---Load the Driver
//        Class.forName("com.mysql.jdbc.Driver");   //This is for load the Driver, which is Optional---

        //2nd Step---Create the Connection
        String url = "jdbc:mysql://localhost:3306/sample";
        String user = "root";
        String password = "yash022";
        Connection conn = DriverManager.getConnection(url, user, password);

        if (conn.isClosed()) {
            System.out.println("Connection is CLosed");
        } else {
            System.out.println("Connection is Established....");
        }

        //Create a Query

//        String q = "create table test(tId int(20) primary key auto_increment, tName varchar(50) not Null, tCity varchar(50))";

        //Create a Statement

//        Statement stmt = conn.createStatement();
//        stmt.executeUpdate(q);
//        System.out.println("Table Created in Your Database.");

//         Insert data into table
//        String q1 = "insert into test(tName,tCity) values (?,?)";
//
////        Get the Prepared Statement Object
//        PreparedStatement prstm =  conn.prepareStatement(q1);
//
////        Read Values from the User--
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//
//        String choice = null;
//
//        do {
//
//
//            System.out.println("Enter the Value that you want to Insert in the table Test....");
//            System.out.println("Enter Name: ");
//            String name = br.readLine();
//
//            System.out.println("Enter City: ");
//            String city = br.readLine();
//
////            Set the values
//
//            prstm.setString(1, name);
//            prstm.setString(2, city);
//            prstm.addBatch();
//
//            System.out.print("Do you want to add another record? (yes/no): ");
//            choice = br.readLine();
//
//        } while (choice.equalsIgnoreCase("yes"));
//
//        int[] results = prstm.executeBatch();
//        System.out.println(results.length + " records inserted successfully!");




//       System.out.println("Enter the Value that you want to Insert in the table Test....");
//
//        System.out.println("Enter Name: ");
//        String name = br.readLine();

//        System.out.println("Enter City: ");
//        String city = br.readLine();

        //Set the values
//        prstm.setString(1,name);
//        prstm.setString(2,city);
//          prstm.addBatch();
//        prstm.executeUpdate();


        //Insert Image into table(images)--------
        String q2 = "insert into images(pic) values(?)";

        PreparedStatement prstmt = conn.prepareStatement(q2);

        FileInputStream fs = new FileInputStream("imagesample2.jpg");
        prstmt.setBinaryStream(1,fs,fs.available());

        prstmt.executeUpdate();


        System.out.println("Inserted Data");

//        String q3 = "update test set tName=? , tCity=? where tId=?";
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        System.out.println("Enter the New Value for Name, City through ID....");
//
//        System.out.println("Enter New Name: ");
//        String newName = br.readLine();
//
//        System.out.println("Enter New City: ");
//        String newCity = br.readLine();
//
//        System.out.println("Enter the id: ");
//        int id = Integer.parseInt(br.readLine());
//
//        PreparedStatement prstmt = conn.prepareStatement(q3);
//        prstmt.setString(1,newName);
//        prstmt.setString(2,newCity);
//
//        prstmt.setInt(3,id);
//
//        prstmt.executeUpdate();
//        System.out.println("Records are Updated....");

//        System.out.println("Which data you want to read, for that mention ID below....");
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println("Enter the ID: ");
//        int selectID = Integer.parseInt(br.readLine());
//        String qID = "select * from test where tId = " + selectID;
////        String q4 = "select * from test";
//        Statement stmt = conn.createStatement();
//        ResultSet resultS = stmt.executeQuery(qID);
//
//        while (resultS.next()) {
//            int id = resultS.getInt(1);
//            String name = resultS.getString(2);
//            String city = resultS.getString(3);
//
//            System.out.println(id + ": " + name + " live in " + city);
//        }

        conn.close();

    }

}
