package JDBC_Program.Dao;
import JDBC_Program.Conn.JdbcConnec;
import JDBC_Program.Model.Student;

import java.io.*;
import java.sql.*;
import java.util.List;

public class StudentUtil {
    //Connection Established---------
    public static Connection connectToDB() {
        return JdbcConnec.getInstance().getConnec();
    }
    //Create Table-------
    public static boolean createStudenttable() throws SQLException {
        Statement stmt = connectToDB().createStatement();
        return !stmt.execute("CREATE TABLE if not exists Student(stu_id int primary key auto_increment, Stu_Name varchar(20) not null, Stu_Course varchar(15), Stu_Age tinyint);");
    }
    //Insert Data in Table---------
    public static String saveRecord(Student st) throws SQLException {
        PreparedStatement preparedStatement = connectToDB().prepareStatement("insert into student (Stu_Name, Stu_Course, Stu_Age) VALUES (?, ?, ?)");
        preparedStatement.setString(1, st.getName());
        preparedStatement.setString(2, st.getCourse());
        preparedStatement.setInt(3, st.getAge());

        int re = preparedStatement.executeUpdate();
        return "Record added" + re;
    }
    //    Inserted multiple values------------
    public static  int saveMUlRec(List<Student> ls) throws SQLException {
        Connection conn = connectToDB();
        conn.setAutoCommit(false);

        PreparedStatement p = conn.prepareStatement("insert into student (Stu_Name, Stu_course, Stu_age) Values(?,?,?)");
        int[ ] recs;
        for(Student stu : ls){
            p.setString(1,stu.getName());
            p.setString(2,stu.getCourse());
            p.setInt(3,stu.getAge());
            p.addBatch();
        }
        recs = p.executeBatch();
        conn.commit();
        return recs.length;
    }
    //Delete Data from Table through ID---------
    public static String deleteById(int id) throws SQLException {
        PreparedStatement psmt = connectToDB().prepareStatement("delete from student where Stu_id=?");
        psmt.setInt(1,id);

        int result = psmt.executeUpdate();

        if(result>=1){
            String q5 = "ALTER TABLE student AUTO_INCREMENT = 1;";
            connectToDB().prepareStatement(q5).executeUpdate();
            return "Record Delete with id:" + id;

        }else {
            return  "Record not Found";
        }

    }
    //Update Data in Table--------
    public static String updaterecord() throws IOException, SQLException {
        String q3 = "update student set stu_Name=? , stu_Course=?, Stu_Age=? where stu_Id=?";

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter the New Value for Name, City and Age through ID....");

        System.out.println("Enter New Name: ");
        String newName = br.readLine();

        System.out.println("Enter New Course: ");
        String newCourse = br.readLine();

        System.out.println("Enter the Age: ");
        int newAge = Integer.parseInt(br.readLine());

        System.out.println("Enter the id: ");
        int id = Integer.parseInt(br.readLine());

        PreparedStatement prstmt = connectToDB().prepareStatement(q3);
        prstmt.setString(1,newName);
        prstmt.setString(2,newCourse);
        prstmt.setInt(3,newAge);

        prstmt.setInt(4,id);

        prstmt.executeUpdate();

        return "Record Updated...";
    }
    //View ALl Data from Table--------
    public static ResultSet showAllrec(Student st) throws SQLException {
        CallableStatement call = connectToDB().prepareCall("select * from student;");
        ResultSet rs1 = call.executeQuery();
        while(rs1.next()){
            System.out.println(
                    "Student ID: " + rs1.getInt("stu_id") + ", " +
                            "Student Name: " + rs1.getString("Stu_Name") + ", " +
                            "Student Course: " + rs1.getString("Stu_Course") + ", " +
                            "Student Age: " + rs1.getInt("Stu_Age")
            );
        }
        return rs1;
    }
    //View Specific Data from Table Through ID----------
    public static ResultSet showAllRecById(int selectID) throws SQLException {
        String qID = "select * from student where Stu_id = ?";
        PreparedStatement prtmt = connectToDB().prepareStatement(qID);
        prtmt.setInt(1,selectID);
        ResultSet resultS = prtmt.executeQuery();
        while(resultS.next()){
            System.out.println(
                    "Student ID: " + resultS.getInt("stu_id") + ", " +
                            "Student Name: " + resultS.getString("Stu_Name") + ", " +
                            "Student Course: " + resultS.getString("Stu_Course") + ", " +
                            "Student Age: " + resultS.getInt("Stu_Age")
            );
        }
        return resultS;
    }
    //Insert Image in Table----------
    public static String uplodPic(File file, int id) throws SQLException, IOException {
        PreparedStatement pt = connectToDB().prepareStatement("update student Set image = ? where stu_id = ?;");
        FileInputStream fis = new FileInputStream(file);
        pt.setBinaryStream(1,fis,fis.available());
        pt.setInt(2,id);

       return pt.executeUpdate() >= 1 ? "record updated" :"not uploaded";

    }
    //Insert Data by Using the Stored Procedure--------
    public static String insertUsingStoredProc(Student stu) throws SQLException {

        CallableStatement call = connectToDB().prepareCall("Call newRec(?,?,?,?);");
        call.setInt(1, stu.getId());
        call.setString(2,stu.getName());
        call.setString(3,stu.getCourse());
        call.setInt(4,stu.getAge());

        return call.executeUpdate()>0?"Insertion Successfully":"Insertion Failed";
    }

}