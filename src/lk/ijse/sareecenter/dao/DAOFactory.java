/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sareecenter.dao;

import lk.ijse.sareecenter.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.sareecenter.dao.custom.impl.GRNDAOImpl;
import lk.ijse.sareecenter.dao.custom.impl.GRNDetailsDAOImpl;
import lk.ijse.sareecenter.dao.custom.impl.GRNPaymentsDAOImpl;
import lk.ijse.sareecenter.dao.custom.impl.ItemDAOImpl;
import lk.ijse.sareecenter.dao.custom.impl.OrderDetailsDAOImpl;
import lk.ijse.sareecenter.dao.custom.impl.OrdersDAOImpl;
import lk.ijse.sareecenter.dao.custom.impl.PaymentDAOImpl;
import lk.ijse.sareecenter.dao.custom.impl.QueryDAOImpl;
import lk.ijse.sareecenter.dao.custom.impl.SupplierDAOImpl;
import lk.ijse.sareecenter.dao.custom.impl.UserDAOImpl;

/**
 *
 * @author User
 */
public class DAOFactory {

    public enum DAOTypes {

        CUSTOMER, GRN, GRN_DETAILS, ITEM, ORDERS, ORDER_DETAILS, PAYMENT, SUPPLIER, QUERY, GRN_PAYMENTS, USER
    }

    private static DAOFactory daoFactory;

    private DAOFactory() {

    }

    public static DAOFactory getInstance() {
        if (daoFactory == null) {
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }

    public SuperDAO getDAO(DAOTypes daoType) {
        switch (daoType) {
            case CUSTOMER:
                return new CustomerDAOImpl();

            case GRN:
                return new GRNDAOImpl();
            case GRN_DETAILS:
                return new GRNDetailsDAOImpl();
            case ITEM:
                return new ItemDAOImpl();
            case ORDERS:
                return new OrdersDAOImpl();
            case ORDER_DETAILS:
                return new OrderDetailsDAOImpl();
            case PAYMENT:
                return new PaymentDAOImpl();

            case SUPPLIER:
                return new SupplierDAOImpl();

            case USER:
                return new UserDAOImpl();
            case QUERY:
                return new QueryDAOImpl();
            case GRN_PAYMENTS:
                return new GRNPaymentsDAOImpl();
            default:
                return null;
        }
    }
}
