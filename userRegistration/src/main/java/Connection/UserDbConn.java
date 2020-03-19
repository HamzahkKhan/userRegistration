package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.naming.NamingException;


public class UserDbConn {

    public static Connection getConn() throws ClassNotFoundException, SQLException, NamingException {

        Connection conn = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3300/registration?useTimezone=true&serverTimezone=UTC", "root", "123456");

        return conn;
    }

}
