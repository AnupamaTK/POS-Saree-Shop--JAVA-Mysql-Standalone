/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sareecenter.controller;

import java.util.ArrayList;
import lk.ijse.sareecenter.dao.DAOFactory;
import lk.ijse.sareecenter.dao.custom.GRNDetailsDAO;
import lk.ijse.sareecenter.dto.GRNDetailsDTO;

/**
 *
 * @author User
 */
public class GRNDetailsController {
     public static GRNDetailsDAO grnDetailsDAO = (GRNDetailsDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.GRN_DETAILS);
    
    public static boolean addGRNDetails(GRNDetailsDTO grnDetails) throws  Exception  {
        boolean result = grnDetailsDAO.add(grnDetails);
        return result;
    }
    
    public static boolean deleteGRNDetails(GRNDetailsDTO grnDetails)throws Exception{
        boolean result = grnDetailsDAO.delete(grnDetails);
        return result;
    }
    
    public static boolean updateGRNDetails(GRNDetailsDTO grnDetails)throws Exception{
        boolean result = grnDetailsDAO.update(grnDetails);
        return result;
    }
    
    public static GRNDetailsDTO searchGRNDetails(GRNDetailsDTO grnDetails) throws Exception{
        GRNDetailsDTO searchedGRNDetails = grnDetailsDAO.search(grnDetails);
        return searchedGRNDetails;
    }
    
    public static ArrayList<GRNDetailsDTO> getAllGRNDetailss()throws Exception{
        return grnDetailsDAO.getAll();
    }
    public static ArrayList<GRNDetailsDTO> getAllByGRNID(String grnid)throws Exception{
        return grnDetailsDAO.getAllByGRNID(grnid);
    }
}
