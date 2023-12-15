
import demo.sql.*;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import static demo.sql.UserService.number;


public class main {

    static String id;
    static String passWord;
    static String name;
    static int choice;
    static Scanner input = new Scanner(System.in);

    UserService userService=new UserService();
    List<User> list1=UserService.getAllUser();
    static User_RegisterService userRegisterService=new User_RegisterService();

    public main() throws SQLException {
    }


    public static void main(String[] args) throws SQLException {
        boolean run = true;
        String again = null;

        showMenu();
        choice = input.nextInt();
        do {
            switch (choice) {
                case 1:
                    try {
                        List<User> list1=UserService.getAllUser();
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    loginStep();
                    showCourse();
                    System.out.println("Choose Your course Id: ");
                    int idCourse=input.nextInt();
                    userRegisterService.registerNewCourse(number,idCourse);
                    showRegistedCourse();
                    System.exit(0);
                    break;
                case 2:
                    regStep();
                    System.out.println("come back to main menu(yes/no)");
                    again = input.next();
                    showMenu();
                    choice = input.nextInt();
            }
            if ("yes".equals(again)) {
                continue;
            } else {
                run = false;
                break;
            }

        } while (run);
        System.exit(0);
    }
    public static void loginStep() {
        do {
            System.out.println("Enter Your name:");
            id = input.next();
            System.out.println("Enter your password:");
            passWord = input.next();
        } while (UserService.checkAccount(id, passWord) == false);
    }
    public static void regStep() {
        do {
            System.out.println("Enter Your Register name:");
            id = input.next();
            System.out.println("Enter your password:");
            passWord = input.next();
        } while (UserService.checkAccount(id, passWord) == false);
        if (UserService.checkAccount(id, passWord) == true) {
            //registerAccount.RegAccount(id, passWord, name);
        }
    }
    public static void showMenu() {
        System.out.println("Main Menu");
        System.out.println("1.Login");
        System.out.println("2.Register");
        System.out.println("--------------------------");
    }
    public static void showCourse() throws SQLException {
        CourseService1 courseService1=new CourseService1();
        List<Course> list=courseService1.getAllCourse();

        for(Course course :list){
            System.out.println("Course : "+ course.getName()+ "  | ID : "+ course.getId()+"  | teacher_id: "+course.getTeacherId());
        }
    }
    public static void showRegistedCourse() throws SQLException {
        User_RegisterService userRegisterService1=new User_RegisterService();
        List<User_Register> list=userRegisterService1.getAllRegistedCourse();

        for(User_Register registeredCourse :list){
            System.out.println("Id : "+ registeredCourse.getId()+ "  | UserId : "+ registeredCourse.getId()+"  | Course_id: "+registeredCourse.getCourseId());
        }
    }
}




