/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sareecenter.controller;

import java.util.ArrayList;
import lk.ijse.sareecenter.dao.DAOFactory;
import lk.ijse.sareecenter.dao.custom.CustomerDAO;
import lk.ijse.sareecenter.dto.CustomerDTO;

/**
 *
 * @author User
 */
public class CustomerController {
     public static CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    
    public static boolean addCustomer(CustomerDTO customer) throws  Exception  {
        boolean result = customerDAO.add(customer);
        return result;
    }
    
    public static boolean deleteCustomer(CustomerDTO customer)throws Exception{
        boolean result = customerDAO.delete(customer);
        return result;
    }
    
    public static boolean updateCustomer(CustomerDTO customer)throws Exception{
        boolean result = customerDAO.update(customer);
        return result;
    }
    
    public static CustomerDTO searchCustomer(CustomerDTO customer) throws Exception{
        CustomerDTO searchedCustomer = customerDAO.search(customer);
        return searchedCustomer;
    }
    
    public static ArrayList<CustomerDTO> getAllCustomers()throws Exception{
        return customerDAO.getAll();
    }
}
