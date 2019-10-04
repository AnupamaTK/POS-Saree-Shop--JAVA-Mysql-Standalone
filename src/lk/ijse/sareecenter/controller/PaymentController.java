/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sareecenter.controller;

import java.util.ArrayList;
import lk.ijse.sareecenter.dao.DAOFactory;
import lk.ijse.sareecenter.dao.custom.PaymentDAO;
import lk.ijse.sareecenter.dto.PaymentDTO;

/**
 *
 * @author User
 */
public class PaymentController {
     public static PaymentDAO paymentDAO = (PaymentDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.PAYMENT);
    
    public static boolean addPayment(PaymentDTO payment) throws  Exception  {
        boolean result = paymentDAO.add(payment);
        return result;
    }
    
    public static boolean deletePayment(PaymentDTO payment)throws Exception{
        boolean result = paymentDAO.delete(payment);
        return result;
    }
    
    public static boolean updatePayment(PaymentDTO payment)throws Exception{
        boolean result = paymentDAO.update(payment);
        return result;
    }
    
    public static PaymentDTO searchPayment(PaymentDTO payment) throws Exception{
        PaymentDTO searchedPayment = paymentDAO.search(payment);
        return searchedPayment;
    }
    
    public static ArrayList<PaymentDTO> getAllPayments()throws Exception{
        return paymentDAO.getAll();
    }
}
