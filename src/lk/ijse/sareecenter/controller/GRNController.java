/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sareecenter.controller;

import java.sql.Connection;
import java.util.ArrayList;
import lk.ijse.sareecenter.dao.DAOFactory;
import lk.ijse.sareecenter.dao.custom.GRNDAO;
import lk.ijse.sareecenter.dao.custom.GRNDetailsDAO;
import lk.ijse.sareecenter.dao.custom.GRNPaymentsDAO;
import lk.ijse.sareecenter.dao.custom.ItemDAO;
import lk.ijse.sareecenter.db.DBConnection;
import lk.ijse.sareecenter.dto.GRNDTO;
import lk.ijse.sareecenter.dto.GRNDetailsDTO;
import lk.ijse.sareecenter.dto.GRNPaymentsDTO;
import lk.ijse.sareecenter.dto.ItemDTO;

/**
 *
 * @author User
 */
public class GRNController {

    public static GRNDAO grnDAO = (GRNDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.GRN);
    private static GRNDetailsDAO grnDetailsDAO = (GRNDetailsDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.GRN_DETAILS);
    private static ItemDAO itemDAO = (ItemDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ITEM);
    private static Connection connection = DBConnection.getInstance().getConnection();
    private static GRNPaymentsDAO grnPaymentsDAO = (GRNPaymentsDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.GRN_PAYMENTS);

    public static boolean addGRN(GRNDTO grn, ArrayList<GRNDetailsDTO> al, GRNPaymentsDTO grnp) throws Exception {
        boolean flag = false;
        try {
            connection.setAutoCommit(false);
            flag = grnDAO.add(grn);

            if (flag) {
                for (GRNDetailsDTO grnDetailsDTO : al) {

                    boolean add;
                    add = grnDetailsDAO.add(grnDetailsDTO);

                    String i_code = grnDetailsDTO.getI_code();
                    ItemDTO dTO = new ItemDTO();
                    dTO.setItem_code(i_code);
                    ItemDTO searchI = itemDAO.search(dTO);
                    int qty = searchI.getQty_on_hand();
                    int w = grnDetailsDTO.getQty();
                    int cQty = qty + w;
                    searchI.setQty_on_hand(cQty);

                    if (add) {
                        boolean update = itemDAO.update(searchI);

                        if (update) {
                            boolean addp = grnPaymentsDAO.add(grnp);
                            if (addp) {

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

                }finally {
            connection.setAutoCommit(true);
        }
                return false;
            }

    

    

    public static boolean deleteGRN(GRNDTO grn) throws Exception {
        boolean result = grnDAO.delete(grn);
        return result;
    }

    public static boolean updateGRN(GRNDTO grn) throws Exception {
        boolean result = grnDAO.update(grn);
        return result;
    }

    public static GRNDTO searchGRN(GRNDTO grn) throws Exception {
        GRNDTO searchedGRN = grnDAO.search(grn);
        return searchedGRN;
    }

    public static ArrayList<GRNDTO> getAllGRNs() throws Exception {
        return grnDAO.getAll();
    }
}
