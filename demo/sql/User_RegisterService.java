package demo.sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class User_RegisterService {
    static List<User_Register> list=new ArrayList<User_Register>();

    public void registerNewCourse(int number,int id) throws SQLException {

        String SQL="insert into user_register(id,user_id,course_id)" +"values(5,5,6)";
        Connection connection=Dbconnection.makeConnection();
        Statement stmt= connection.createStatement();

        stmt.executeUpdate(SQL);



}
    public List<User_Register> getAllRegistedCourse() throws SQLException {
        Connection connection=Dbconnection.makeConnection();
        String SQL="SELECT * FROM user_register";

        Statement stmt= connection.createStatement();

        ResultSet resultSet=stmt.executeQuery(SQL);

        while (resultSet.next()){
            int id=resultSet.getInt("id");
            int userId=resultSet.getInt("user_id");
            int courseId=resultSet.getInt("course_id");
            User_Register courseRegisted=new User_Register(userId,courseId);
            list.add(courseRegisted);}

        return list;
    }}
