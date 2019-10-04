/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sareecenter.dao.custom;

import java.util.ArrayList;
import lk.ijse.sareecenter.dao.SuperDAO;
import lk.ijse.sareecenter.dto.GRNDetailsDTO;

/**
 *
 * @author User
 */
public interface GRNDetailsDAO extends SuperDAO<GRNDetailsDTO> {

    public ArrayList<GRNDetailsDTO> getAllByGRNID(String grnid)throws Exception;
    
}
