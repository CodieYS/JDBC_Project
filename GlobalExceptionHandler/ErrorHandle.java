package JDBC_Program.GlobalExceptionHandler;
import JDBC_Program.Dao.StudentUtil;
import JDBC_Program.Model.Student;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ErrorHandle {

    public static void handleSQLException(SQLException e) {
        System.err.println("Database connection error: " + e.getMessage());

    }

//    public static void handleSQLException(SQLException e) {
//    }

    public static void handleCreateStudentTable() {
        try {
            if (StudentUtil.createStudenttable()){
                System.out.println("table created successfully");
            }
        } catch (SQLException e) {
            System.err.println("Error while creating student table: " + e.getMessage());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void handleSaveRecord(Student student) {
        try {
            System.out.println(StudentUtil.saveRecord(student));
        } catch (SQLException e) {
            System.out.println("Error while saving record: " + e.getMessage());
        }
    }

    public static void handleDeleteById(int id) {
        try {
            System.out.println(StudentUtil.deleteById(id));;
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    public static void handleSaveMultipleRecords(List<Student> students) {
        try {
            System.out.println(StudentUtil.saveMUlRec(students));
        } catch (SQLException e) {
            System.err.println("Error while saving multiple records: " + e.getMessage());
        }
    }

    public static void handleUploadPicture(File file, int id) {
        try {
            System.out.println(StudentUtil.uplodPic(file, id));
        } catch (SQLException | IOException e) {
            System.out.println("Error while uploading picture: " + e.getMessage());
        }
    }

    public static void handleUpdateRecord() {
        try {
            System.out.println(StudentUtil.updaterecord());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("Record not Updated " + e.getMessage());
        }
    }

    public static void showAllrec(Student st) {
        try {
           StudentUtil.showAllrec(st);
        } catch (SQLException e) {
            ErrorHandle.handleSQLException(e);
        }
    }
    public static void handleShowAllRecById(int selectID) {
        try {
            // Call the showAllRecById method directly
            StudentUtil.showAllRecById(selectID);
        } catch (SQLException e) {
            // Handle SQL exception using the existing method
            handleSQLException(e);
        }
    }

    public static void handleInsertUsingStoredProc(Student st){
        try{
            System.out.println(StudentUtil.insertUsingStoredProc(st));
        }catch(SQLException e){
            System.out.println("Insertion Failed: " + e.getMessage());
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
