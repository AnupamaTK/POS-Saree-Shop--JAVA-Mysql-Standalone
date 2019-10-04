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
import lk.ijse.sareecenter.dao.custom.GRNPaymentsDAO;
import lk.ijse.sareecenter.db.DBConnection;
import lk.ijse.sareecenter.dto.GRNPaymentsDTO;

/**
 *
 * @author User
 */
public class GRNPaymentsDAOImpl implements GRNPaymentsDAO {

    @Override
    public boolean add(GRNPaymentsDTO grnPayments) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO GRNPayments VALUES (?,?,?,?,?);";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, grnPayments.getGrnPID());
         pstm.setObject(2, grnPayments.getpDate());
        pstm.setObject(3, grnPayments.getGrnID());
        pstm.setObject(4, grnPayments.getTotal_price());
        pstm.setObject(5, grnPayments.getTotal_qty());
        
        int affectedRows = pstm.executeUpdate();
        return (affectedRows > 0);
    }

     @Override
    public boolean update(GRNPaymentsDTO grnPayments) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "UPDATE GRNPayments SET date?,grn_id=?, total_price=?, total_qty=? WHERE grnp_id=?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, grnPayments.getpDate());
        pstm.setObject(2, grnPayments.getGrnID());
        pstm.setObject(3, grnPayments.getTotal_price());
        pstm.setObject(4, grnPayments.getTotal_qty());
        int affectedRows = pstm.executeUpdate();
        pstm.setObject(5, grnPayments.getGrnPID());
        return (affectedRows > 0);
    }

     @Override
    public boolean delete(GRNPaymentsDTO grnPayments) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "DELETE FROM GRNPayments WHERE grnp_id=?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, grnPayments.getGrnPID());
        int affectedRows = pstm.executeUpdate();
        return (affectedRows > 0);
    }

     @Override
    public GRNPaymentsDTO search(GRNPaymentsDTO grnPayments) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM GRNPayments WHERE grnp_id='" + grnPayments.getGrnPID()+ "'||date='"+grnPayments.getpDate()+"'||grn_id='"+grnPayments.getGrnID()+"'";
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);

        if (rst.next()) {
            return new GRNPaymentsDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getBigDecimal(4),
                    rst.getInt(5));

        }

        return null;
    }

     @Override
    /**
     *
     * @return @throws Exception
     */
    public ArrayList<GRNPaymentsDTO> getAll() throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM GRNPayments";
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);

        ArrayList<GRNPaymentsDTO> alGRNPaymentss = null;

        while (rst.next()) {
            if (alGRNPaymentss == null) {
                alGRNPaymentss = new ArrayList<>();
            }

            alGRNPaymentss.add(new GRNPaymentsDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getBigDecimal(4),
                    rst.getInt(5)
            ));

        }

        return alGRNPaymentss;
    }
}
