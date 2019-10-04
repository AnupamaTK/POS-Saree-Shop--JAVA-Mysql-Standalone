  
package lk.ijse.sareecenter.dao.custom.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import lk.ijse.sareecenter.dao.custom.ItemDAO;
import lk.ijse.sareecenter.db.DBConnection;
import lk.ijse.sareecenter.dto.ItemDTO;

/**
 *
 * @author User
 */
public class ItemDAOImpl implements ItemDAO {
   

    public boolean add(ItemDTO item) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO Item VALUES (?,?,?,?,?,?,?,?);";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, item.getItem_code());
        pstm.setObject(2, item.getType());
        pstm.setObject(3, item.getBrand());
        pstm.setObject(4, item.getColour());
        pstm.setObject(5, item.getDescription());
        pstm.setObject(6, item.getBuying_price());
        pstm.setObject(7, item.getSelling_price());
        pstm.setObject(8, item.getQty_on_hand());
        int affectedRows = pstm.executeUpdate();
        return (affectedRows > 0);
    }

     @Override
    public boolean update(ItemDTO item) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "UPDATE Item SET type=?, brand=?, colour=?,description=?,buying_price=?,selling_price=?,qty_on_hand=? WHERE i_code=?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, item.getType());
        pstm.setObject(2, item.getBrand());
        pstm.setObject(3, item.getColour());
        pstm.setObject(4, item.getDescription());
        pstm.setObject(5, item.getBuying_price());
        pstm.setObject(6, item.getSelling_price());
        pstm.setObject(7, item.getQty_on_hand());
        pstm.setObject(8, item.getItem_code());
        int affectedRows = pstm.executeUpdate();
        return (affectedRows > 0);
    }

     @Override
    public boolean delete(ItemDTO item) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "DELETE FROM Item WHERE i_code = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, item.getItem_code());
        int affectedRows = pstm.executeUpdate();
        return (affectedRows > 0);
    }

     @Override
    public ItemDTO search(ItemDTO item) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM Item WHERE i_code='" + item.getItem_code()+ "'";
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);

        if (rst.next()) {
            return new ItemDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getBigDecimal(6),
                    rst.getBigDecimal(7),
                    rst.getInt(8));                 
        }

        return null;
    }

     @Override
    public ArrayList<ItemDTO> getAll() throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM Item";
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);

        ArrayList<ItemDTO> alItems = null;

        while (rst.next()) {
            if (alItems == null) {
                alItems = new ArrayList<>();
            }

            alItems.add(new ItemDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getBigDecimal(6),
                    rst.getBigDecimal(7),
                    rst.getInt(8)
            ));

        }

        return alItems;
    }

    @Override
    public boolean qtySubUpdate(ItemDTO item) throws Exception {
      Connection connection = DBConnection.getInstance().getConnection();
        String sql = "UPDATE Item SET qty_on_hand=qty_on_hand-? WHERE i_code=?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, item.getQty_on_hand());
        pstm.setObject(2, item.getItem_code());

        int affectedRows = pstm.executeUpdate();
        return (affectedRows > 0);
    }

    @Override
    public boolean qtyAddUpdate(ItemDTO item) throws Exception {
      Connection connection = DBConnection.getInstance().getConnection();
        String sql = "UPDATE Item SET qty_on_hand=qty_on_hand+? WHERE i_code=?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, item.getQty_on_hand());
        pstm.setObject(2, item.getItem_code());

        int affectedRows = pstm.executeUpdate();
        return (affectedRows > 0);
    }
}
