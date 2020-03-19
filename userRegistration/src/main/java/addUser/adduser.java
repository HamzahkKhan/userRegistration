package addUser;

import Connection.UserDbConn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;

public class adduser {

    public static int addUser(String username, String useremail, String userpassword) throws SQLException, ClassNotFoundException, NamingException {

        Connection con = UserDbConn.getConn();
        PreparedStatement ps = con.prepareStatement("insert into user_info (user_Name, user_Email, user_Password) values (?,?,?)");
        ps.setString(1, username);
        ps.setString(2, useremail);
        ps.setString(3, userpassword);
        int result = 0;

        try {
            result = ps.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
            con.close();
            return result;

        }

        return result;

    }

    public static int checkEmail(String email) throws ClassNotFoundException, SQLException, NamingException {
        Connection con = UserDbConn.getConn();
        PreparedStatement ps = con.prepareStatement("Select * from user_info where user_Email = (?)");
        ps.setString(1, email);

        int s = 0;
        ResultSet rs = ps.executeQuery();
        List<User> lst = new ArrayList<>();

        if (rs != null) {

            while (rs.next()) {

                User user = new User(rs.getString("user_Name"), rs.getString("user_Email"));
                lst.add(user);

            }

        }

        if (lst.isEmpty()) {
            s = 1;
            return s;
        }
        return s;
    }
    
    
    public static int checkName(String Name) throws ClassNotFoundException, SQLException, NamingException {
        Connection con = UserDbConn.getConn();
        PreparedStatement ps = con.prepareStatement("Select * from user_info where user_Name = (?)");
        ps.setString(1, Name);

        int s = 0;
        ResultSet rs = ps.executeQuery();
        List<User> lst = new ArrayList<>();

        if (rs != null) {

            while (rs.next()) {

                User user = new User(rs.getString("user_Name"), rs.getString("user_Email"));
                lst.add(user);

            }

        }

        if (lst.isEmpty()) {
            s = 1;
            return s;
        }
        return s;
    }

}
