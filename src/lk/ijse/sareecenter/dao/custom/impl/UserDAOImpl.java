/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sareecenter.dao.custom.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import lk.ijse.sareecenter.dao.custom.UserDAO;
//import lk.ijse.sareecenter.dao.custom.UserDAO;
//import lk.ijse.sareecenter.dao.custom.UserDAO;
import lk.ijse.sareecenter.db.DBConnection;
import lk.ijse.sareecenter.dto.UserDTO;

//*
// *
// * @author User
// 
public class UserDAOImpl implements UserDAO {

    @Override
    public boolean add(UserDTO user) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO User VALUES (?,?,?,?,?,?);";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, user.getUserID());
        pstm.setObject(2, user.getName());
        pstm.setObject(3, user.getPrefferedName());
        pstm.setObject(4, user.getPassword());
        pstm.setObject(5, user.getTelNo());
        pstm.setObject(6, user.getNic_no());

        int affectedRows = pstm.executeUpdate();
        return (affectedRows > 0);
    }

    @Override
    public boolean update(UserDTO user) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "UPDATE User SET user_name=?,prefferd_name=?,password=?,tel_no=?,nic_no=? where uid=?";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(1, user.getName());
        pstm.setObject(2, user.getPrefferedName());
        pstm.setObject(3, user.getPassword());
        pstm.setObject(4, user.getTelNo());
        pstm.setObject(5, user.getNic_no());
        pstm.setObject(6, user.getUserID());
        int affectedRows = pstm.executeUpdate();
        return (affectedRows > 0);
    }

    @Override
    public boolean delete(UserDTO user) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "DELETE FROM User WHERE i_code = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, user.getUserID());
        int affectedRows = pstm.executeUpdate();
        return (affectedRows > 0);
    }

    @Override
    public UserDTO search(UserDTO user) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM User WHERE i_code='" + user.getUserID() + "'";
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);

        if (rst.next()) {
            return new UserDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6)
            );
        }

        return null;
    }

    @Override

//     *
//     * @return
//     * @throws Exception
    public ArrayList<UserDTO> getAll() throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM User";
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);

        ArrayList<UserDTO> alUsers = null;

        while (rst.next()) {
            if (alUsers == null) {
                alUsers = new ArrayList<>();
            }

            alUsers.add(new UserDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6)
            ));

        }

        return alUsers;
    }

    @Override
    public boolean CheckPassword(String name, String password) throws Exception {
        String sql = "Select * from user where prefferd_name='" + name + "' && password='" + password + "'";
        Connection conn = DBConnection.getInstance().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        if (rst.next()) {
            return true;
        } else {
            return false;
        }
    }
}
