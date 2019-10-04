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
import lk.ijse.sareecenter.dao.custom.OrdersDAO;
import lk.ijse.sareecenter.db.DBConnection;
import lk.ijse.sareecenter.dto.OrdersDTO;

/**
 *
 * @author User
 */
public class OrdersDAOImpl implements OrdersDAO {

    public boolean add(OrdersDTO orders) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO Orders VALUES (?,?,?,?,?);";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, orders.getOID());
        pstm.setObject(2, orders.getO_date());
        pstm.setObject(3, orders.getCid());
        pstm.setObject(4, orders.getTotal_price());
        pstm.setObject(5, orders.getTotal_qty());
        int affectedRows = pstm.executeUpdate();
        return (affectedRows > 0);
    }

     @Override
    public boolean update(OrdersDTO orders) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "UPDATE Orders SET o_date=?, cid=?, total_price=?,total_qty=? WHERE oid=?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, orders.getO_date());
        pstm.setObject(2, orders.getCid());
        pstm.setObject(3, orders.getTotal_price());
        pstm.setObject(4, orders.getTotal_qty());
        pstm.setObject(5, orders.getOID());
        int affectedRows = pstm.executeUpdate();
        return (affectedRows > 0);
    }

     @Override
    public boolean delete(OrdersDTO orders) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "DELETE FROM Orders WHERE oid = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, orders.getOID());
        int affectedRows = pstm.executeUpdate();
        return (affectedRows > 0);
    }

    @Override
    public OrdersDTO search(OrdersDTO orders) throws Exception {
        { Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM Orders WHERE oid='" + orders.getOID() + "'||o_date='"+orders.getO_date()+"'||cid='"+orders.getCid()+"'";
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);

        if (rst.next()) {
            return new OrdersDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getBigDecimal(4),
                    rst.getInt(5));

        }
        return null;
        }

    }
    
@Override

    public ArrayList<OrdersDTO> getAll() throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM Orders";
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);

        ArrayList<OrdersDTO> alOrderss = null;

        while (rst.next()) {
            if (alOrderss == null) {
                alOrderss = new ArrayList<>();
            }

            alOrderss.add(new OrdersDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getBigDecimal(4),
                    rst.getInt(5)
            ));

        }

        return alOrderss;
    }
    
}
