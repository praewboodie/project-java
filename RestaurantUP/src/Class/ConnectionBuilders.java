package Class;

import java.sql.*;
import javax.naming.NamingException;

public class ConnectionBuilders {
    private static final String url = "jdbc:mysql://my57db-pj.sit.kmutt.ac.th:3306/i105g2db?zeroDateTimeBehavior=convertToNull";
    private static final String user = "i105g2u02";
    private static final String pwd = "be=u8aGu6uza";
    private static final String driver = "com.mysql.jdbc.Driver";
    
 
        public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        Connection con = null;
        con = DriverManager.getConnection(url, user, pwd);
        return con;
    }

    public static Connection getConnect() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

