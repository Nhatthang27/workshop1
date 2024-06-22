/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import model.dto.Category;
import model.dto.Product;
import util.DBContext;

/**
 *
 * @author Nhatthang
 */
public class CategoryDao implements CommonDao<Category> {

    private ServletContext sc = null;

    public CategoryDao(ServletContext sc) {
        this.sc = sc;
    }

    @Override
    public int insert(Category cate) throws ClassNotFoundException, SQLException {
        int result = 0;

        Connection con = null;
        PreparedStatement stm = null;

        try {
            //1. CONNECT DB
            con = DBContext.getConnection(sc);
            if (con != null) {
                //2. SQL 
                String sql = "INSERT INTO [dbo].[Category]\n"
                        + "           ([categoryName]\n"
                        + "           ,[note])\n"
                        + "     VALUES\n"
                        + "           (?, ?)";
                //3. Statement 
                stm = con.prepareStatement(sql);
                stm.setString(1, cate.getCategoryName().trim());
                if (cate.getNote() != null) {
                    stm.setString(2, cate.getNote().trim());
                }

                //4. Excute
                result = stm.executeUpdate();

                //5. Process Result
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
    public int update(String oldCategoryId, Category newCate) throws ClassNotFoundException, SQLException {
        int result = 0;

        Connection con = null;
        PreparedStatement stm = null;

        try {
            //1. CONNECT DB
            con = DBContext.getConnection(sc);
            if (con != null) {
                //2. SQL 
                String sql = "UPDATE [dbo].[Category]\n"
                        + "   SET [categoryName] = ?\n"
                        + "      ,[note] = ?\n"
                        + " WHERE categoryId = ?";
                //3. Statement 
                System.err.println("id in DAO: " + oldCategoryId);
                stm = con.prepareStatement(sql);
                stm.setString(1, newCate.getCategoryName().trim());
                stm.setString(2, newCate.getNote().trim());
                stm.setInt(3, Integer.parseInt(oldCategoryId));

                //4. Excute
                result = stm.executeUpdate();

                //5. Process Result
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
    public int delete(String categoryId) throws ClassNotFoundException, SQLException {
        int result = 0;

        Connection con = null;
        PreparedStatement stm = null;

        try {
            //1. CONNECT DB
            con = DBContext.getConnection(sc);
            if (con != null) {
                //2. SQL 
                String sql = "DELETE FROM [dbo].[Category]\n"
                        + "      WHERE categoryId = ?";
                //3. Statement 
                stm = con.prepareStatement(sql);
                stm.setInt(1, Integer.parseInt(categoryId));

                //4. Excute
                result = stm.executeUpdate();

                //5. Process Result
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
    public Category getObjectByID(String id) throws ClassNotFoundException, SQLException {
        Category cate = null;

        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            //1. CONNECT DB
            con = DBContext.getConnection(sc);
            if (con != null) {
                //2. SQL 
                String sql = "SELECT [categoryId]\n"
                        + "      ,[categoryName]\n"
                        + "      ,[note]\n"
                        + "  FROM [dbo].[Category]"
                        + "  WHERE [categoryId] = ?";
                //3. Statement 
                stm = con.prepareStatement(sql);
                stm.setString(1, id);
                //4. Excute
                rs = stm.executeQuery();

                //5. Process Result
                if (rs.next()) {
                    int categoryId = rs.getInt("categoryId");
                    String categoryName = rs.getString("categoryName").trim();
                    String note = rs.getString("note").trim();
                    cate = new Category(categoryId, categoryName, note);
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
        return cate;
    }

    public List<Category> getAllCategories() throws ClassNotFoundException, SQLException {
        List<Category> categories = null;

        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            //1. CONNECT DB
            con = DBContext.getConnection(sc);
            if (con != null) {
                //2. SQL 
                String sql = "SELECT [categoryId]\n"
                        + "      ,[categoryName]\n"
                        + "      ,[note]\n"
                        + "  FROM [dbo].[Category]";
                //3. Statement 
                stm = con.prepareStatement(sql);

                //4. Excute
                rs = stm.executeQuery();

                //5. Process Result
                while (rs.next()) {
                    if (categories == null) {
                        categories = new ArrayList<>();
                    }
                    int categoryId = rs.getInt("categoryId");
                    String categoryName = rs.getString("categoryName").trim();
                    String note = rs.getString("note").trim();
                    Category cate = new Category(categoryId, categoryName, note);
                    categories.add(cate);
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
        return categories;
    }

}
