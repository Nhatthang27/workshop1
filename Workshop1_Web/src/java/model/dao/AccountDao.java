/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import model.dto.Account;
import util.DBContext;

/**
 *
 * @author Nhatthang
 */
public class AccountDao implements CommonDao<Account> {

    private ServletContext sc = null;

    public AccountDao(ServletContext sc) {
        this.sc = sc;
    }

    @Override
    public int insert(Account acc) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        int result = 0;

        try {
            //1. CONNECT DB
            con = DBContext.getConnection(sc);
            if (con != null) {
                //2. SQL String
                String sql = "INSERT INTO [dbo].[Account]\n"
                        + "           ([username]\n"
                        + "           ,[password]\n"
                        + "           ,[lastName]\n"
                        + "           ,[firstName]\n"
                        + "           ,[dob]\n"
                        + "           ,[gender]\n"
                        + "           ,[phone]\n"
                        + "           ,[isActive]\n"
                        + "           ,[role])\n"
                        + "     VALUES\n"
                        + "           (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                //3. Create SQL Statement
                stm = con.prepareStatement(sql);
                stm.setString(1, acc.getUsername());
                stm.setString(2, acc.getPassword());
                stm.setString(3, acc.getLastName());
                stm.setString(4, acc.getFirstName());
                stm.setDate(5, acc.getDob());
                stm.setBoolean(6, acc.isGender());
                stm.setString(7, acc.getPhone());
                stm.setBoolean(8, acc.isIsActive());
                stm.setInt(9, acc.getRole());
                //4. Execute Query
                result = stm.executeUpdate();
                //5. Process Result
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;
    }

    @Override
    public int update(String oldAccID, Account newAcc) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        int result = 0;

        try {
            con = DBContext.getConnection(sc);
            if (con != null) {
                String sql = "UPDATE [dbo].[Account]\n"
                        + "   SET [password] = ?\n"
                        + "      ,[lastName] = ?\n"
                        + "      ,[firstName] = ?\n"
                        + "      ,[dob] = ?\n"
                        + "      ,[gender] = ?\n"
                        + "      ,[phone] = ?\n"
                        + "      ,[isActive] = ?\n"
                        + "      ,[role] = ?\n"
                        + " WHERE [username] = ?";
                System.out.println("Old ID: " + oldAccID);
                stm = con.prepareStatement(sql);
                stm.setString(1, newAcc.getPassword());
                stm.setString(2, newAcc.getLastName());
                stm.setString(3, newAcc.getFirstName());
                stm.setDate(4, newAcc.getDob());
                stm.setBoolean(5, newAcc.isGender());
                stm.setString(6, newAcc.getPhone());
                stm.setBoolean(7, newAcc.isIsActive());
                stm.setInt(8, newAcc.getRole());
                stm.setString(9, oldAccID);
                result = stm.executeUpdate();
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;
    }

    @Override
    public int delete(String username) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        int result = 0;

        try {
            con = DBContext.getConnection(sc);
            if (con != null) {
                String sql = "UPDATE [dbo].[Account]\n"
                        + "   SET [isDeleted] = 1\n"
                        + " WHERE [username] = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                result = stm.executeUpdate();
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;
    }
    
    public int active(String username, String isActive) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        int result = 0;

        try {
            con = DBContext.getConnection(sc);
            if (con != null) {
                String sql = "UPDATE [dbo].[Account]\n"
                        + "   SET [isActive] = ?\n"
                        + " WHERE [username] = ?";
                stm = con.prepareStatement(sql);
                stm.setBoolean(1, isActive.equals("0"));
                stm.setString(2, username);
                result = stm.executeUpdate();
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;
    }

    public int isExistAccount(String username, String password) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        int result = 0; //-1: not active, 0: wrong username, password, 1: success
        try {
            //1. CONNECT DB
            con = DBContext.getConnection(sc);
            if (con != null) {
                //2. SQL String
                String sql = "SELECT username, isActive "
                        + "FROM Account "
                        + "WHERE username = ? "
                        + "AND password = ? ";
                //3. Create SQL Statement
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                stm.setString(2, password);
                //4. Execute Query
                rs = stm.executeQuery();
                //5. Process Result
                if (rs.next()) {
                    if (rs.getBoolean("isActive") == false) {
                        result = -1;
                    } else {
                        result = 1;
                    }
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;
    }

    public List<Account> getAllAccount() throws ClassNotFoundException, SQLException {
        List<Account> accounts = null;

        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            //1. CONNECT DB
            con = DBContext.getConnection(sc);
            if (con != null) {
                //2. SQL 
                String sql = "SELECT [username]\n"
                        + "      ,[password]\n"
                        + "      ,[lastName]\n"
                        + "      ,[firstName]\n"
                        + "      ,[dob]\n"
                        + "      ,[gender]\n"
                        + "      ,[phone]\n"
                        + "      ,[isActive]\n"
                        + "      ,[role]\n"
                        + "      ,[isDeleted]\n"
                        + "  FROM [ProductIntro].[dbo].[Account]\n"
                        + "  WHERE [isDeleted] = 0";
                //3. Statement 
                stm = con.prepareStatement(sql);

                //4. Excute
                rs = stm.executeQuery();

                //5. Process Result
                while (rs.next()) {
                    if (accounts == null) {
                        accounts = new ArrayList<>();
                    }
                    String username = rs.getString("username");
                    String password = rs.getString("password");
                    String lastName = rs.getString("lastName");
                    String firstName = rs.getString("firstName");
                    Date dob = rs.getDate("dob");
                    boolean gender = rs.getBoolean("gender");
                    String phone = rs.getString("phone");
                    boolean isActive = rs.getBoolean("isActive");
                    int role = rs.getInt("role");
                    boolean isDeleted = rs.getBoolean("isDeleted");
                    accounts.add(new Account(username, password, lastName, firstName, dob, gender, phone, isActive, role, isDeleted));
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return accounts;
    }

    @Override
    public Account getObjectByID(String id) throws ClassNotFoundException, SQLException {
        Account acc = null;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            //1. CONNECT DB
            con = DBContext.getConnection(sc);
            if (con != null) {
                //2. SQL String
                String sql = "SELECT [username]\n"
                        + "      ,[password]\n"
                        + "      ,[lastName]\n"
                        + "      ,[firstName]\n"
                        + "      ,[dob]\n"
                        + "      ,[gender]\n"
                        + "      ,[phone]\n"
                        + "      ,[isActive]\n"
                        + "      ,[role]\n"
                        + "      ,[isDeleted]\n"
                        + "  FROM [ProductIntro].[dbo].[Account]\n"
                        + "  WHERE [username] = ?";
                //3. Create SQL Statement
                stm = con.prepareStatement(sql);
                stm.setString(1, id);
                //4. Execute Query
                rs = stm.executeQuery();
                //5. Process Result
                if (rs.next()) {
                    String username = rs.getString("username");
                    String password = rs.getString("password");
                    String lastName = rs.getString("lastName");
                    String firstName = rs.getString("firstName");
                    Date dob = rs.getDate("dob");
                    boolean gender = rs.getBoolean("gender");
                    String phone = rs.getString("phone");
                    boolean isActive = rs.getBoolean("isActive");
                    int role = rs.getInt("role");
                    boolean isDeleted = rs.getBoolean("isDeleted");
                    acc = new Account(username, password, lastName, firstName, dob, gender, phone, isActive, role, isDeleted);
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return acc;
    }
}
