/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sareecenter.dao.custom;

import lk.ijse.sareecenter.dao.SuperDAO;
import lk.ijse.sareecenter.dto.UserDTO;

/**
 *
 * @author User
 */
public interface UserDAO extends SuperDAO<UserDTO>{
    public boolean CheckPassword(String name, String password) throws Exception;
}
