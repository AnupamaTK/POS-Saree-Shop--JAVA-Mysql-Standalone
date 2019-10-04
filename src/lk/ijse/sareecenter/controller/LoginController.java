/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sareecenter.controller;

import lk.ijse.sareecenter.dao.DAOFactory;
import lk.ijse.sareecenter.dao.custom.UserDAO;

/**
 *
 * @author User
 */
public class LoginController {
    public static UserDAO  userDAO = (UserDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.USER);
    public static boolean checkPassword(String userName , String password) throws Exception{
        return userDAO.CheckPassword(userName, password);
   }
    

    
    
}
