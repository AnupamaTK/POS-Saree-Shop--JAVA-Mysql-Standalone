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
public class GRNDTO extends SuperDTO {

    private String GRN_id;
    private String sid;
    private String date;
    private int total_qty;
    private BigDecimal total_price;
    

    public GRNDTO() {
    }

    public GRNDTO(String GRN_id, String sid, String date, int total_qty, BigDecimal total_price) {
        this.GRN_id = GRN_id;
        this.sid = sid;
        this.date = date;
        this.total_qty = total_qty;
        this.total_price = total_price;
    }

    /**
     * @return the GRN_id
     */
    public String getGRN_id() {
        return GRN_id;
    }

    /**
     * @param GRN_id the GRN_id to set
     */
    public void setGRN_id(String GRN_id) {
        this.GRN_id = GRN_id;
    }

    /**
     * @return the sid
     */
    public String getSid() {
        return sid;
    }

    /**
     * @param sid the sid to set
     */
    public void setSid(String sid) {
        this.sid = sid;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
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


   
}
