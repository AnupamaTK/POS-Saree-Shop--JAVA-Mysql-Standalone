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
import lk.ijse.sareecenter.dao.custom.PaymentDAO;
import lk.ijse.sareecenter.db.DBConnection;
import lk.ijse.sareecenter.dto.PaymentDTO;

/**
 *
 * @author User
 */
public class PaymentDAOImpl implements PaymentDAO {

    public boolean add(PaymentDTO payment) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO Payment VALUES (?,?,?,?,?,?,?,?);";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, payment.getPID());
        pstm.setObject(2, payment.getP_date());
        pstm.setObject(3, payment.getOID());
        pstm.setObject(4, payment.getAmount());
        pstm.setObject(5, payment.getDisount());
        pstm.setObject(6, payment.getNet_amount());
        pstm.setObject(7, payment.getCash());
        pstm.setObject(8, payment.getBalance());
        int affectedRows = pstm.executeUpdate();
        return (affectedRows > 0);
    }

     @Override
    public boolean update(PaymentDTO payment) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "UPDATE Payment SET p_date=?, oid=?,amount=?,discount=?,net_amount=?,cash=?,balance=? WHERE pid=?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, payment.getP_date());
        pstm.setObject(2, payment.getOID());
        pstm.setObject(3, payment.getAmount());
        pstm.setObject(4, payment.getDisount());
        pstm.setObject(5, payment.getNet_amount());
        pstm.setObject(6, payment.getCash());
        pstm.setObject(7, payment.getBalance());
        pstm.setObject(8, payment.getPID());
        int affectedRows = pstm.executeUpdate();
        return (affectedRows > 0);
    }

     @Override
    public boolean delete(PaymentDTO payment) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "DELETE FROM Payment WHERE pid = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, payment.getPID());
        int affectedRows = pstm.executeUpdate();
        return (affectedRows > 0);
    }

     @Override
    public PaymentDTO search(PaymentDTO payment) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM Payment WHERE pid='" + payment.getPID() + "'||p_date='"+payment.getP_date()+"'||oid='"+payment.getOID()+"'";
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);

        if (rst.next()) {
            return new PaymentDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getBigDecimal(4),
                    rst.getBigDecimal(5),
                    rst.getBigDecimal(6),
                    rst.getBigDecimal(7),
                    rst.getBigDecimal(8));

        }

        return null;
    }

     @Override
    public ArrayList<PaymentDTO> getAll() throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM Payment";
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);

        ArrayList<PaymentDTO> alPayments = null;

        while (rst.next()) {
            if (alPayments == null) {
                alPayments = new ArrayList<>();
            }

            alPayments.add(new PaymentDTO(
                   rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getBigDecimal(4),
                    rst.getBigDecimal(5),
                    rst.getBigDecimal(6),
                    rst.getBigDecimal(7),
                    rst.getBigDecimal(8)
            ));

        }

        return alPayments;
    }

}
