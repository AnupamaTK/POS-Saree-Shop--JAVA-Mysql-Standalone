/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sareecenter.controller;

import java.util.ArrayList;
import lk.ijse.sareecenter.dao.DAOFactory;
import lk.ijse.sareecenter.dao.custom.OrderDetailsDAO;
import lk.ijse.sareecenter.dto.OrderDetailsDTO;

/**
 *
 * @author User
 */
public class OrderDetailsController {
     public static OrderDetailsDAO ordersDetailsDAO = (OrderDetailsDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ORDER_DETAILS);
    
    public static boolean addOrderDetails(OrderDetailsDTO ordersDetails) throws  Exception  {
        boolean result = ordersDetailsDAO.add(ordersDetails);
        return result;
    }
    
    public static boolean deleteOrderDetails(OrderDetailsDTO ordersDetails)throws Exception{
        boolean result = ordersDetailsDAO.delete(ordersDetails);
        return result;
    }
    
    public static boolean updateOrderDetails(OrderDetailsDTO ordersDetails)throws Exception{
        boolean result = ordersDetailsDAO.update(ordersDetails);
        return result;
    }
    
    public static OrderDetailsDTO searchOrderDetails(OrderDetailsDTO ordersDetails) throws Exception{
        OrderDetailsDTO searchedOrderDetails = ordersDetailsDAO.search(ordersDetails);
        return searchedOrderDetails;
    }
    
    public static ArrayList<OrderDetailsDTO> getAllOrderDetailss()throws Exception{
        return ordersDetailsDAO.getAll();
    }
    public static ArrayList<OrderDetailsDTO> getAllByODID(String id)throws Exception{
        return ordersDetailsDAO.getAllByODID(id);
    }
   
}
