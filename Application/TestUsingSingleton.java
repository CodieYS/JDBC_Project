package JDBC_Program.Application;
import JDBC_Program.Model.Student;
import java.io.File;
import JDBC_Program.GlobalExceptionHandler.ErrorHandle;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestUsingSingleton {
    public static void main(String[] args) throws SQLException, IOException {
        Student student = new Student();

        List<Student> listOfStudent = new ArrayList<>();
        Collections.addAll(listOfStudent, new Student("abc", (byte)20, "java"), new Student("xyz", (byte)30, "python"));


        student.setCourse("Rust");
        student.setAge(24);
        student.setName("Chutkuu");

        ErrorHandle.handleCreateStudentTable();
        ErrorHandle.handleSaveRecord(student);
        ErrorHandle.handleDeleteById(19);
        ErrorHandle.handleUpdateRecord();
        ErrorHandle.handleSaveMultipleRecords(listOfStudent);
        ErrorHandle.handleUploadPicture(new File("E:\\\\java project\\\\IdeaProjects\\\\DSwithJava\\\\src\\\\JDBC_Program\\\\imagesample2.jpg"),12);
        ErrorHandle.showAllrec(student);
        ErrorHandle.handleShowAllRecById(13);
        ErrorHandle.handleInsertUsingStoredProc(student);
//

//
//

    }
}
