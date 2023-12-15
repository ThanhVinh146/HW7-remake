package demo.sql;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class CourseService1 {
    public List<Course> getAllCourse() throws SQLException {
        Connection connection=Dbconnection.makeConnection();
        String SQL="SELECT * FROM course";

        Statement stmt= connection.createStatement();

        ResultSet resultSet=stmt.executeQuery(SQL);

        List<Course> list=new ArrayList<Course>();

        while (resultSet.next()){
        int id=resultSet.getInt("id");
        String name=resultSet.getString("name");
        int teacherId=resultSet.getInt("teacher_id");
        Course course=new Course(id,name,teacherId);
        list.add(course);}




    return list;
    }


}
