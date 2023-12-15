package demo.sql;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class UserService {
    public static int number;
    static List<User> list=new ArrayList<User>();

    public static List<User> getAllUser() throws SQLException {
        Connection connection=Dbconnection.makeConnection();
        String SQL="SELECT name,password FROM user";

        Statement stmt= connection.createStatement();

        ResultSet resultSet=stmt.executeQuery(SQL);


        while (resultSet.next()){
            String name=resultSet.getString("name");
            String password=resultSet.getString("password");
            User user=new User(name,password);
            list.add(user);}




        return list;
}
    public static boolean checkAccount(String no, String pass) {

        for (int i = 0; i < list.size(); i++) {
            if (no.equals(list.get(i).getName()) && pass.equals(list.get(i).getPassword())) {
                System.out.println("You are login");
                System.out.println("hello " + list.get(i).getName());
                number=list.get(i).getId();
                return true;
            }
        }
        System.out.println("Your number card or your pin are not correct , please try again!");
        return false;
    }

}
