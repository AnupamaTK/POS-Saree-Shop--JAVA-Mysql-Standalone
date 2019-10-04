/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sareecenter.dao.custom;

import lk.ijse.sareecenter.dao.SuperDAO;
import lk.ijse.sareecenter.dto.ItemDTO;

/**
 *
 * @author User
 */
public interface ItemDAO extends SuperDAO<ItemDTO>{

    public boolean qtySubUpdate(ItemDTO oldItemDTO) throws Exception;

    public boolean qtyAddUpdate(ItemDTO newItemDTO) throws Exception;
    
}
