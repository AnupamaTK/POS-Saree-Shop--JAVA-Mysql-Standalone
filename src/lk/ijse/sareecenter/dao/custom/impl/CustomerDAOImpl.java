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
import lk.ijse.sareecenter.dao.custom.CustomerDAO;
import lk.ijse.sareecenter.db.DBConnection;
import lk.ijse.sareecenter.dto.CustomerDTO;

public class CustomerDAOImpl implements CustomerDAO {

     @Override

    public boolean add(CustomerDTO customer) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO Customer VALUES (?,?,?,?,?);";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, customer.getCID());
        pstm.setObject(2, customer.getName());

        pstm.setObject(3, customer.getNIC_no());
        pstm.setObject(4, customer.getTel_no());
        pstm.setObject(5, customer.getAddress());
        int affectedRows = pstm.executeUpdate();
        return (affectedRows > 0);
    }

     @Override
    public boolean update(CustomerDTO customer) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "UPDATE Customer SET name=?, nic_no=?, tel_no=?,address=? WHERE cid=?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, customer.getName());
        pstm.setObject(2, customer.getNIC_no());
        pstm.setObject(3, customer.getTel_no());
        pstm.setObject(4, customer.getAddress());
        pstm.setObject(5, customer.getCID());
        int affectedRows = pstm.executeUpdate();
        return (affectedRows > 0);
    }

     @Override
    public boolean delete(CustomerDTO customer) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "DELETE FROM Customer WHERE cid = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, customer.getCID());
        int affectedRows = pstm.executeUpdate();
        return (affectedRows > 0);
    }

     @Override
    public CustomerDTO search(CustomerDTO customer) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM Customer WHERE name='" + customer.getName()+ "'";
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);

        if (rst.next()) {
            return new CustomerDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getInt(4),
                    rst.getString(5));

        }

        return null;
    }

     @Override
    public ArrayList<CustomerDTO> getAll() throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM Customer";
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);

        ArrayList<CustomerDTO> alCustomers = null;

        while (rst.next()) {
            if (alCustomers == null) {
                alCustomers = new ArrayList<>();
            }

            alCustomers.add(new CustomerDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getInt(4),
                    rst.getString(5)));

        }

        return alCustomers;
    }
 
     
}
