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
import model.dto.Account;
import model.dto.Category;
import model.dto.Product;
import util.DBContext;

/**
 *
 * @author Nhatthang
 */
public class ProductDao implements CommonDao<Product> {

    private ServletContext sc = null;

    public ProductDao(ServletContext sc) {
        this.sc = sc;
    }

    @Override
    public int insert(Product newPrd) throws ClassNotFoundException, SQLException {
        int res = 0;

        Connection con = null;
        PreparedStatement stm = null;

        try {
            //1. CONNECT DB
            con = DBContext.getConnection(sc);
            if (con != null) {
                //2. SQL 
                String sql = "INSERT INTO [dbo].[Product]\n"
                        + "           ([productId]\n"
                        + "           ,[productName]\n"
                        + "           ,[productImage]\n"
                        + "           ,[brief]\n"
                        + "           ,[postedDate]\n"
                        + "           ,[categoryId]\n"
                        + "           ,[username]\n"
                        + "           ,[price]\n"
                        + "           ,[discount]\n"
                        + "           ,[quantity])\n"
                        + "     VALUES\n"
                        + "           (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                //3. Statement 
                stm = con.prepareStatement(sql);
                stm.setString(1, newPrd.getProductId());
                stm.setString(2, newPrd.getProductName());
                stm.setString(3, newPrd.getProductImage());
                stm.setString(4, newPrd.getBrief());
                stm.setDate(5, newPrd.getPostedDate());
                stm.setInt(6, newPrd.getCategory().getCategoryId());
                stm.setString(7, newPrd.getAccount().getUsername());
                stm.setInt(8, newPrd.getPrice());
                stm.setInt(9, newPrd.getDiscount());
                stm.setInt(10, newPrd.getQuantity());
                //4. Excute
                res = stm.executeUpdate();
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
        return res;
    }

    @Override
    public int update(String oldPrdId, Product newPrd) throws ClassNotFoundException, SQLException {
        int res = 0;

        Connection con = null;
        PreparedStatement stm = null;

        try {
            //1. CONNECT DB
            con = DBContext.getConnection(sc);
            if (con != null) {
                //2. SQL 
                String sql = "UPDATE [dbo].[Product]\n"
                        + "   SET [productName] = ?\n"
                        + "      ,[productImage] = ?\n"
                        + "      ,[brief] = ?\n"
                        + "      ,[postedDate] = ?\n"
                        + "      ,[categoryId] = ?\n"
                        + "      ,[username] = ?\n"
                        + "      ,[price] = ?\n"
                        + "      ,[discount] = ?\n"
                        + "      ,[quantity] = ?\n"
                        + " WHERE [productId] = ?";
                //3. Statement 
                stm = con.prepareStatement(sql);
                stm.setString(1, newPrd.getProductName());
                stm.setString(2, newPrd.getProductImage());
                stm.setString(3, newPrd.getBrief());
                stm.setDate(4, newPrd.getPostedDate());
                stm.setInt(5, newPrd.getCategory().getCategoryId());
                stm.setString(6, newPrd.getAccount().getUsername());
                stm.setInt(7, newPrd.getPrice());
                stm.setInt(8, newPrd.getDiscount());
                stm.setInt(9, newPrd.getQuantity());
                stm.setString(10, oldPrdId);
                //4. Excute
                res = stm.executeUpdate();
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
        return res;
    }

    @Override
    public int delete(String productId) throws ClassNotFoundException, SQLException {
        int res = 0;

        Connection con = null;
        PreparedStatement stm = null;

        try {
            //1. CONNECT DB
            con = DBContext.getConnection(sc);
            if (con != null) {
                //2. SQL 
                String sql = "DELETE FROM [dbo].[Product]\n"
                        + "      WHERE productId = ?";
                //3. Statement 
                stm = con.prepareStatement(sql);
                stm.setString(1, productId);

                //4. Excute
                res = stm.executeUpdate();
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
        return res;
    }

    @Override
    public Product getObjectByID(String id) throws ClassNotFoundException, SQLException {
        Product prd = null;

        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            //1. CONNECT DB
            con = DBContext.getConnection(sc);
            if (con != null) {
                //2. SQL 
                String sql = "SELECT [productId]\n"
                        + "      ,[productName]\n"
                        + "      ,[productImage]\n"
                        + "      ,[brief]\n"
                        + "      ,[postedDate]\n"
                        + "      ,[categoryId]\n"
                        + "      ,[username]\n"
                        + "      ,[price]\n"
                        + "      ,[discount]\n"
                        + "      ,[quantity]\n"
                        + "  FROM [dbo].[Product]"
                        + "  WHERE [productId] = ?";
                //3. Statement 
                stm = con.prepareStatement(sql);
                stm.setString(1, id);
                //4. Excute
                rs = stm.executeQuery();

                //5. Process Result
                if (rs.next()) {
                    String productId = rs.getString("productId");
                    String productName = rs.getString("productName");
                    String productImage = rs.getString("productImage");
                    String brief = rs.getString("brief");
                    Date postedDate = rs.getDate("postedDate");
                    int categoryId = rs.getInt("categoryId");
                    String username = rs.getString("username");
                    int price = rs.getInt("price");
                    int discount = rs.getInt("discount");
                    int quantity = rs.getInt("quantity");

                    Account poster = new AccountDao(sc).getObjectByID(username);
                    Category cate = new CategoryDao(sc).getObjectByID(String.valueOf(categoryId));

                    prd = new Product(productId, productName, productImage, brief, postedDate, cate, poster, price, discount, quantity);

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
        return prd;
    }

    public List<Product> getAddProducts() throws ClassNotFoundException, SQLException {
        List<Product> products = null;

        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            //1. CONNECT DB
            con = DBContext.getConnection(sc);
            if (con != null) {
                //2. SQL 
                String sql = "SELECT [productId]\n"
                        + "      ,[productName]\n"
                        + "      ,[productImage]\n"
                        + "      ,[brief]\n"
                        + "      ,[postedDate]\n"
                        + "      ,[categoryId]\n"
                        + "      ,[username]\n"
                        + "      ,[price]\n"
                        + "      ,[discount]\n"
                        + "      ,[quantity]\n"
                        + "  FROM [dbo].[Product]";
                //3. Statement 
                stm = con.prepareStatement(sql);

                //4. Excute
                rs = stm.executeQuery();

                //5. Process Result
                while (rs.next()) {
                    if (products == null) {
                        products = new ArrayList<>();
                    }
                    String productId = rs.getString("productId");
                    String productName = rs.getString("productName");
                    String productImage = rs.getString("productImage");
                    String brief = rs.getString("brief");
                    Date postedDate = rs.getDate("postedDate");
                    int categoryId = rs.getInt("categoryId");
                    String username = rs.getString("username");
                    int price = rs.getInt("price");
                    int discount = rs.getInt("discount");
                    int quantity = rs.getInt("quantity");

                    Product product = new Product(productId, productName, productImage, brief, postedDate, null, new AccountDao(sc).getObjectByID(username), price, discount, quantity);

                    products.add(product);
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
        return products;
    }

}
