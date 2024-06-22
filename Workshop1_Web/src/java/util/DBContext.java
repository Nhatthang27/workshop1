/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.ServletContext;

/**
 *
 * @author Nhatthang
 */
public class DBContext {
    
    public static Connection getConnection(ServletContext sc) throws ClassNotFoundException, SQLException{
        String hostname = sc.getInitParameter("hostname");
        String port = sc.getInitParameter("port");
        String databaseName = sc.getInitParameter("databaseName");
        String instanceName = sc.getInitParameter("instanceName");
        String username = sc.getInitParameter("username");
        String password = sc.getInitParameter("password");
        
        //1. Load Driver
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        //2. Create Connection String
        String url = "jdbc:sqlserver:" + String.format("//%s:%s", hostname, port)
                    + ";databaseName=" + databaseName
                    + ";instanceName=" + instanceName;
        //3. Open Connection
        Connection con = DriverManager.getConnection(url, username, password);
        return con;
    }
}
