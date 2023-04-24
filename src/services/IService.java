/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Dell 6540
 */
public interface IService<T> {
     void createOne(T t) throws SQLException;
    void updateOne(T t) throws SQLException;
    void deletOne(T t) throws SQLException;
    List<T> selectAll() throws SQLException;
   
}
