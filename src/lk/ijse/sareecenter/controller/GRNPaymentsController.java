/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sareecenter.controller;

import java.util.ArrayList;
import lk.ijse.sareecenter.dao.DAOFactory;
import lk.ijse.sareecenter.dao.custom.GRNPaymentsDAO;
import lk.ijse.sareecenter.dto.GRNPaymentsDTO;

/**
 *
 * @author User
 */
public class GRNPaymentsController {
      public static GRNPaymentsDAO grnDetailsDAO = (GRNPaymentsDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.GRN_DETAILS);
    
    public static boolean addGRNPayments(GRNPaymentsDTO grnDetails) throws  Exception  {
        boolean result = grnDetailsDAO.add(grnDetails);
        return result;
    }
    
    public static boolean deleteGRNPayments(GRNPaymentsDTO grnDetails)throws Exception{
        boolean result = grnDetailsDAO.delete(grnDetails);
        return result;
    }
    
    public static boolean updateGRNPayments(GRNPaymentsDTO grnDetails)throws Exception{
        boolean result = grnDetailsDAO.update(grnDetails);
        return result;
    }
    
    public static GRNPaymentsDTO searchGRNPayments(GRNPaymentsDTO grnDetails) throws Exception{
        GRNPaymentsDTO searchedGRNPayments = grnDetailsDAO.search(grnDetails);
        return searchedGRNPayments;
    }
    
    public static ArrayList<GRNPaymentsDTO> getAllGRNPayments()throws Exception{
        return grnDetailsDAO.getAll();
    }
}
