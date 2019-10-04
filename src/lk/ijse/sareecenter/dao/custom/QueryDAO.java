/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sareecenter.dao.custom;

import java.util.ArrayList;
import lk.ijse.sareecenter.dao.SuperDAO;
import lk.ijse.sareecenter.dto.SuperDTO;

/**
 *
 * @author User
 */
public interface QueryDAO extends SuperDAO<SuperDTO>{
    @Override
    public default boolean add(SuperDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public default boolean delete(SuperDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public default ArrayList<SuperDTO> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public default SuperDTO search(SuperDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public default boolean update(SuperDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
}
