/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Nhatthang
 * @param <T>
 */
public interface CommonDao<T> extends Serializable {
    int insert(T Obj) throws ClassNotFoundException, SQLException;;
    int update(String oldObjID, T newOj) throws ClassNotFoundException, SQLException;;
    int delete(String objID) throws ClassNotFoundException, SQLException;;
    T getObjectByID(String id) throws ClassNotFoundException, SQLException;
}
