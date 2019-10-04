/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sareecenter.dao.custom.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import lk.ijse.sareecenter.dao.custom.OrderDetailsDAO;
import lk.ijse.sareecenter.db.DBConnection;
import lk.ijse.sareecenter.dto.OrderDetailsDTO;

/**
 *
 * @author User
 */
public class OrderDetailsDAOImpl implements OrderDetailsDAO {

    public boolean add(OrderDetailsDTO orderDetails) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO OrderDetails VALUES (?,?,?,?);";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, orderDetails.getOID());
        pstm.setObject(2, orderDetails.getI_code());
        pstm.setObject(3, orderDetails.getQty());
        pstm.setObject(4, orderDetails.getPrice());
        int affectedRows = pstm.executeUpdate();
        return (affectedRows > 0);
    }

     @Override
    public boolean update(OrderDetailsDTO orderDetails) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "UPDATE OrderDetails SET i_code=?, qty=?, price=? WHERE oid=?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, orderDetails.getI_code());
        pstm.setObject(2, orderDetails.getQty());
        pstm.setObject(3, orderDetails.getPrice());
        pstm.setObject(4, orderDetails.getOID());
        int affectedRows = pstm.executeUpdate();
        return (affectedRows > 0);
    }

     @Override
    public boolean delete(OrderDetailsDTO orderDetails) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "DELETE FROM OrderDetails WHERE oid = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, orderDetails.getOID());
        int affectedRows = pstm.executeUpdate();
        return (affectedRows > 0);
    }

     @Override
    public OrderDetailsDTO search(OrderDetailsDTO orderDetails) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM OrderDetails WHERE oid='" + orderDetails.getOID() + "'";
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);

        if (rst.next()) {
            return new OrderDetailsDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getInt(3),
                    rst.getBigDecimal(4));
        }

        return null;
    }

     @Override
    public ArrayList<OrderDetailsDTO> getAll() throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM OrderDetails";
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);

        ArrayList<OrderDetailsDTO> alOrderDetailss = null;

        while (rst.next()) {
            if (alOrderDetailss == null) {
                alOrderDetailss = new ArrayList<>();
            }

            alOrderDetailss.add(new OrderDetailsDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getInt(3),
                    rst.getBigDecimal(4)
            ));

        }

        return alOrderDetailss;
    }

    @Override
    public ArrayList<OrderDetailsDTO> getAllByODID(String id) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM OrderDetails where oid='"+id+"'";
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);

        ArrayList<OrderDetailsDTO> alOrderDetailss = null;

        while (rst.next()) {
            if (alOrderDetailss == null) {
                alOrderDetailss = new ArrayList<>();
            }

            alOrderDetailss.add(new OrderDetailsDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getInt(3),
                    rst.getBigDecimal(4)
            ));

        }

        return alOrderDetailss;
    }

  

}
