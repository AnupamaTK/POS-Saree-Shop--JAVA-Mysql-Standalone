/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sareecenter.dto;

import java.math.BigDecimal;

/**
 *
 * @author User
 */
public class GRNPaymentsDTO extends SuperDTO{
    private String grnPID;
    private String pDate;
    private String grnID;
    private BigDecimal total_price;
    private int total_qty;

    public GRNPaymentsDTO() {
    }

    public GRNPaymentsDTO(String grnPID, String pDate, String grnID, BigDecimal total_price, int total_qty) {
        this.grnPID = grnPID;
        this.pDate = pDate;
        this.grnID = grnID;
        this.total_price = total_price;
        this.total_qty = total_qty;
    }

    /**
     * @return the grnPID
     */
    public String getGrnPID() {
        return grnPID;
    }

    /**
     * @param grnPID the grnPID to set
     */
    public void setGrnPID(String grnPID) {
        this.grnPID = grnPID;
    }

    /**
     * @return the pDate
     */
    public String getpDate() {
        return pDate;
    }

    /**
     * @param pDate the pDate to set
     */
    public void setpDate(String pDate) {
        this.pDate = pDate;
    }

    /**
     * @return the grnID
     */
    public String getGrnID() {
        return grnID;
    }

    /**
     * @param grnID the grnID to set
     */
    public void setGrnID(String grnID) {
        this.grnID = grnID;
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
