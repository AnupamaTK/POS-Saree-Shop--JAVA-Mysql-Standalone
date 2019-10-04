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
import lk.ijse.sareecenter.dao.custom.GRNDetailsDAO;
import lk.ijse.sareecenter.db.DBConnection;
import lk.ijse.sareecenter.dto.GRNDetailsDTO;

/**
 *
 * @author User
 */
public class GRNDetailsDAOImpl implements GRNDetailsDAO {

    public boolean add(GRNDetailsDTO grnDetails) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO GRNDetails VALUES (?,?,?,?);";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, grnDetails.getGRN_id());
        pstm.setObject(2, grnDetails.getI_code());
        pstm.setObject(3, grnDetails.getUnit_price());
        pstm.setObject(4, grnDetails.getQty());
        int affectedRows = pstm.executeUpdate();
        return (affectedRows > 0);
    }

     @Override
    public boolean update(GRNDetailsDTO grnDetails) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "UPDATE GRNDetails SET i_code=?, unit_price=?, qty=? WHERE grn_id=?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, grnDetails.getI_code());
        pstm.setObject(2, grnDetails.getUnit_price());
        pstm.setObject(3, grnDetails.getQty());
        pstm.setObject(4, grnDetails.getGRN_id());
        int affectedRows = pstm.executeUpdate();
        return (affectedRows > 0);
    }

     @Override
    public boolean delete(GRNDetailsDTO grnDetails) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "DELETE FROM GRNDetails WHERE grn_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, grnDetails.getGRN_id());
        int affectedRows = pstm.executeUpdate();
        return (affectedRows > 0);
    }

     @Override
    public GRNDetailsDTO search(GRNDetailsDTO grnDetails) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM GRNDetails WHERE grn_id='" + grnDetails.getGRN_id()+ "'";
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);

        if (rst.next()) {
            return new GRNDetailsDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getBigDecimal(3),
                    rst.getInt(4));

        }

        return null;
    }

     @Override
    public ArrayList<GRNDetailsDTO> getAll() throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM GRNDetails";
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);

        ArrayList<GRNDetailsDTO> alGRNDetailss = null;

        while (rst.next()) {
            if (alGRNDetailss == null) {
                alGRNDetailss = new ArrayList<>();
            }

            alGRNDetailss.add(new GRNDetailsDTO(
                     rst.getString(1),
                    rst.getString(2),
                    rst.getBigDecimal(3),
                    rst.getInt(4)
            ));

        }

        return alGRNDetailss;
    }
     
   

    @Override
    public ArrayList<GRNDetailsDTO> getAllByGRNID(String grn_id)throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM GRNDetails where grn_id='"+grn_id+"'";
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);

        ArrayList<GRNDetailsDTO> alOrderDetailss = null;

        while (rst.next()) {
            if (alOrderDetailss == null) {
                alOrderDetailss = new ArrayList<>();
            }

            alOrderDetailss.add(new GRNDetailsDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getBigDecimal(3),
                    rst.getInt(4)
                    
            ));

        }

        return alOrderDetailss;
    }

}
