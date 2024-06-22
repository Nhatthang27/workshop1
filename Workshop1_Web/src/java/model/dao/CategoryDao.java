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
    public int insert(Category Obj) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(String oldObjID, Category newOj) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(String objID) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Category getObjectByID(String id) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
                    String categoryName = rs.getString("categoryName");
                    String note = rs.getString("note");
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
