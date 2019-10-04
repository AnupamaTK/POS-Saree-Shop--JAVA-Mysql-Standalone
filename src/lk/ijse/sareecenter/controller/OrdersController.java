/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sareecenter.controller;

import java.sql.Connection;
import java.util.ArrayList;
import lk.ijse.sareecenter.dao.DAOFactory;
import lk.ijse.sareecenter.dao.custom.ItemDAO;
import lk.ijse.sareecenter.dao.custom.OrderDetailsDAO;
import lk.ijse.sareecenter.dao.custom.OrdersDAO;
import lk.ijse.sareecenter.dao.custom.PaymentDAO;
import lk.ijse.sareecenter.db.DBConnection;
import lk.ijse.sareecenter.dto.ItemDTO;
import lk.ijse.sareecenter.dto.OrderDetailsDTO;
import lk.ijse.sareecenter.dto.OrdersDTO;
import lk.ijse.sareecenter.dto.PaymentDTO;

/**
 *
 * @author User
 */
public class OrdersController {

    public static OrdersDAO ordersDAO = (OrdersDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ORDERS);
    private static OrderDetailsDAO orderDetailsDAO = (OrderDetailsDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ORDER_DETAILS);
    private static ItemDAO itemDAO = (ItemDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ITEM);
    private static Connection connection = DBConnection.getInstance().getConnection();
    private static PaymentDAO paymentDAO = (PaymentDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.PAYMENT);//

    public static boolean addOrders(OrdersDTO orders, ArrayList<OrderDetailsDTO> al, PaymentDTO pDTO) throws Exception {
        boolean flag = false;
        try {
            connection.setAutoCommit(false);
            flag = ordersDAO.add(orders);
            if (flag) {
                for (OrderDetailsDTO orderDetailsDTO : al) {

                    boolean add = orderDetailsDAO.add(orderDetailsDTO);

                    String i_code = orderDetailsDTO.getI_code();
                    ItemDTO dTO = new ItemDTO();
                    dTO.setItem_code(i_code);
                    ItemDTO searchI = itemDAO.search(dTO);
                    int qty = searchI.getQty_on_hand();
                    int w = orderDetailsDTO.getQty();
                    int cQty = qty - w;
                    searchI.setQty_on_hand(cQty);

                    if (add) {
                        boolean update = itemDAO.update(searchI);

                        if (update) {
                            boolean updateP;
                            updateP = paymentDAO.add(pDTO);
                            if (updateP) {
                                connection.commit();
                                return true;
                            } else {
                                connection.rollback();
                                return false;
                            }
                        } else {
                            connection.rollback();
                            return false;
                        }
                    } else {
                        connection.rollback();
                        return false;
                    }
                }
            } else {
                connection.rollback();
                return false;
            }

        } finally {
            connection.setAutoCommit(true);
        }
        return false;
    }

    public static boolean deleteOrders(OrdersDTO orders) throws Exception {
        boolean result = ordersDAO.delete(orders);
        return result;
    }

    public static boolean updateOrders(OrdersDTO orders) throws Exception {
        boolean result = ordersDAO.update(orders);
        return result;
    }

    public static OrdersDTO searchOrders(OrdersDTO orders) throws Exception {
        OrdersDTO searchedOrders = ordersDAO.search(orders);
        return searchedOrders;
    }

    public static ArrayList<OrdersDTO> getAllOrderss() throws Exception {
        return ordersDAO.getAll();
    }
}
