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
public class GRNDetailsDTO extends SuperDTO{
    private String GRN_id;
    private String i_code;
    private BigDecimal unit_price;
    private int qty;

    public GRNDetailsDTO() {
    }

    public GRNDetailsDTO(String GRN_id, String i_code, BigDecimal unit_price, int qty) {
        this.GRN_id = GRN_id;
        this.i_code = i_code;
        this.unit_price = unit_price;
        this.qty = qty;
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
     * @return the i_code
     */
    public String getI_code() {
        return i_code;
    }

    /**
     * @param i_code the i_code to set
     */
    public void setI_code(String i_code) {
        this.i_code = i_code;
    }

    /**
     * @return the unit_price
     */
    public BigDecimal getUnit_price() {
        return unit_price;
    }

    /**
     * @param unit_price the unit_price to set
     */
    public void setUnit_price(BigDecimal unit_price) {
        this.unit_price = unit_price;
    }

    /**
     * @return the qty
     */
    public int getQty() {
        return qty;
    }

    /**
     * @param qty the qty to set
     */
    public void setQty(int qty) {
        this.qty = qty;
    }
    
    
    
}
