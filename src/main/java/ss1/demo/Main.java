package ss1.demo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/jdbc";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //tạo driver
        Class.forName(DRIVER);
        //mở kết nôi
        Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        System.out.println(conn);
        //tạo state
//        Statement statement = conn.createStatement();
//        //thực thi statement
//        ResultSet rs = statement.executeQuery("select * from student");
//        //biê đổi rs -> list
//        List<Student> students=  new ArrayList<>();
//        while (rs.next()){
//            Student student = new Student();
//            student.setId(rs.getInt("id"));
//            student.setName(rs.getString("name"));
//            student.setAge(rs.getInt("age"));
//            students.add(student);
//        }

        //prepare statement

//        PreparedStatement prepare = conn.prepareStatement("select * from student where name like ? ");
////        ktra tuong doi->truyen doi so
//        prepare.setString(1,"%a%");
//        // thuc thi cau lenh
//        ResultSet rs = prepare.executeQuery();

        // callable statment ->call procedure
        CallableStatement callSt= conn.prepareCall("{call insert_student(?,?)}");
        callSt.setString(1,"pham hung");
        callSt.setInt(2,20);
        int count = callSt.executeUpdate();
        System.out.println(count);

//        List<Student> students=  new ArrayList<>();
//        while (rs.next()){
//            Student student = new Student();
//            student.setId(rs.getInt("id"));
//            student.setName(rs.getString("name"));
//            student.setAge(rs.getInt("age"));
//            students.add(student);
//        }
//        System.out.println("list"+students);
//        conn.close();
    }
}