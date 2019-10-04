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
import lk.ijse.sareecenter.dao.custom.GRNDAO;
import lk.ijse.sareecenter.db.DBConnection;
import lk.ijse.sareecenter.dto.GRNDTO;

/**
 *
 * @author User
 */
public class GRNDAOImpl implements GRNDAO {

    public boolean add(GRNDTO grn) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO GRN VALUES (?,?,?,?,?);";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, grn.getGRN_id());
        pstm.setObject(2, grn.getSid());
        pstm.setObject(3, grn.getDate());
        pstm.setObject(4, grn.getTotal_qty());
        pstm.setObject(5, grn.getTotal_price());
        int affectedRows = pstm.executeUpdate();
        return (affectedRows > 0);
    }

    // @Override
    public boolean update(GRNDTO grn) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "UPDATE GRN SET sid=?, date=?, total_qty=?,total_price=? WHERE grn_id=?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, grn.getSid());
        pstm.setObject(2, grn.getDate());
        pstm.setObject(3, grn.getTotal_qty());
        pstm.setObject(4, grn.getTotal_price());
        pstm.setObject(5, grn.getGRN_id());
        int affectedRows = pstm.executeUpdate();
        return (affectedRows > 0);
    }

    // @Override
    public boolean delete(GRNDTO grn) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "DELETE FROM GRN WHERE grn_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, grn.getGRN_id());
        int affectedRows = pstm.executeUpdate();
        return (affectedRows > 0);
    }

    // @Override
    public GRNDTO search(GRNDTO grn) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM GRN WHERE grn_id='" + grn.getGRN_id() + "'||date='" + grn.getDate() + "'||sup_id='" + grn.getSid() + "'";
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);

        if (rst.next()) {
            return new GRNDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getInt(4),
                    rst.getBigDecimal(5));

        }

        return null;
    }

    // @Override
    public ArrayList<GRNDTO> getAll() throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM GRN";
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);

        ArrayList<GRNDTO> alGRNs = null;

        while (rst.next()) {
            if (alGRNs == null) {
                alGRNs = new ArrayList<>();
            }

            alGRNs.add(new GRNDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getInt(4),
                    rst.getBigDecimal(5)
            ));

        }

        return alGRNs;
    }

}
