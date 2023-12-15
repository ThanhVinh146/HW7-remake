package demo.sql;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class demo {
    public static void main(String[] args) throws SQLException {
        CourseService1 courseService1=new CourseService1();
        List<Course> list=courseService1.getAllCourse();

        for(Course course :list){
            System.out.println("Course : "+ course.getName()+ "  | ID : "+ course.getId()+"  | teacher_id: "+course.getTeacherId());
        }
        UserService userService=new UserService();
        List<User> list1=UserService.getAllUser();

        for(User user :list1){
            System.out.println("name : "+ user.getName()+ "  | pass : "+ user.getPassword());

    }
}}
