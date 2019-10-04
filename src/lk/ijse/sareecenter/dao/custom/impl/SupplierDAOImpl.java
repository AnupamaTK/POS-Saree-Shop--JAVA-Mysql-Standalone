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
import lk.ijse.sareecenter.dao.custom.SupplierDAO;
import lk.ijse.sareecenter.db.DBConnection;
import lk.ijse.sareecenter.dto.SupplierDTO;

/**
 *
 * @author User
 */
public class SupplierDAOImpl implements SupplierDAO {

    public boolean add(SupplierDTO supplier) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO Supplier VALUES (?,?,?,?,?);";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, supplier.getSup_id());
        pstm.setObject(2, supplier.getSup_name());
        pstm.setObject(3, supplier.getCompany_name());
        pstm.setObject(4, supplier.getNic_no());
        pstm.setObject(5, supplier.getTel_no());

        int affectedRows = pstm.executeUpdate();
        return (affectedRows > 0);
    }

     @Override
    public boolean update(SupplierDTO supplier) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "UPDATE Supplier SET sup_name=?,company_name=?, nic_no=?, tel_no=? WHERE sup_id=?";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(1, supplier.getSup_name());
        pstm.setObject(2, supplier.getCompany_name());
        pstm.setObject(3, supplier.getNic_no());
        pstm.setObject(4, supplier.getTel_no());
        pstm.setObject(5, supplier.getSup_id());
        int affectedRows = pstm.executeUpdate();
        return (affectedRows > 0);
    }

     @Override
    public boolean delete(SupplierDTO supplier) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "DELETE FROM Supplier WHERE sup_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, supplier.getSup_id());
        int affectedRows = pstm.executeUpdate();
        return (affectedRows > 0);
    }

     @Override
    public SupplierDTO search(SupplierDTO supplier) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM Supplier WHERE sup_id='" + supplier.getSup_id()+ "'";
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);

        if (rst.next()) {
            return new SupplierDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getInt(5));

        }

        return null;
    }

     @Override
    public ArrayList<SupplierDTO> getAll() throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM Supplier";
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);

        ArrayList<SupplierDTO> alSuppliers = null;

        while (rst.next()) {
            if (alSuppliers == null) {
                alSuppliers = new ArrayList<>();
            }

            alSuppliers.add(new SupplierDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getInt(5)
            ));

        }

        return alSuppliers;
    }
}
