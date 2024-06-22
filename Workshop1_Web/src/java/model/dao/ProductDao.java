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
    public int insert(Product Obj) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(String oldObjID, Product newOj) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(String objID) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Product getObjectByID(String id) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
