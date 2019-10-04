/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sareecenter.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author User
 */
public class OrdersDTO extends SuperDTO{
    private String oid;
    private String o_date;
    private String cid;
    private BigDecimal total_price;;
    private int total_qty;

    public OrdersDTO() {
    }

    public OrdersDTO(String oid, String o_date, String cid, BigDecimal total_price, int total_qty) {
        this.oid = oid;
        this.o_date = o_date;
        this.cid = cid;
        this.total_price = total_price;
        this.total_qty = total_qty;
    }

    /**
     * @return the oid
     */
    public String getOID() {
        return oid;
    }

    /**
     * @param oid the oid to set
     */
    public void setOID(String oid) {
        this.oid = oid;
    }

    /**
     * @return the o_date
     */
    public String getO_date() {
        return o_date;
    }

    /**
     * @param o_date the o_date to set
     */
    public void setO_date(String o_date) {
        this.o_date = o_date;
    }

    /**
     * @return the cid
     */
    public String getCid() {
        return cid;
    }

    /**
     * @param cid the cid to set
     */
    public void setCid(String cid) {
        this.cid = cid;
    }

    /**
     * @return the total_price
     */
    public BigDecimal getTotal_price() {
        return total_price;
    }

    /**
     * @param total_price the total_price to set
     */
    public void setTotal_price(BigDecimal total_price) {
        this.total_price = total_price;
    }

    /**
     * @return the total_qty
     */
    public int getTotal_qty() {
        return total_qty;
    }

    /**
     * @param total_qty the total_qty to set
     */
    public void setTotal_qty(int total_qty) {
        this.total_qty = total_qty;
    }
    
    
    
}
