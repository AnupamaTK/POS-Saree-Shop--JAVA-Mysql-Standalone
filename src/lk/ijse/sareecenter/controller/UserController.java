/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sareecenter.controller;

import java.util.ArrayList;
import lk.ijse.sareecenter.dao.DAOFactory;
import lk.ijse.sareecenter.dao.custom.UserDAO;
import lk.ijse.sareecenter.dto.UserDTO;

/**
 *
 * @author User
 */
public class UserController {
     public static UserDAO supplierDAO = (UserDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.SUPPLIER);
    
    public static boolean addUser(UserDTO supplier) throws  Exception  {
        boolean result = supplierDAO.add(supplier);
        return result;
    }
    
    public static boolean deleteUser(UserDTO supplier)throws Exception{
        boolean result = supplierDAO.delete(supplier);
        return result;
    }
    
    public static boolean updateUser(UserDTO supplier)throws Exception{
        boolean result = supplierDAO.update(supplier);
        return result;
    }
    
    public static UserDTO searchUser(UserDTO supplier) throws Exception{
        UserDTO searchedUser = supplierDAO.search(supplier);
        return searchedUser;
    }
    
    public static ArrayList<UserDTO> getAllUsers()throws Exception{
        return supplierDAO.getAll();
    }
 
}
