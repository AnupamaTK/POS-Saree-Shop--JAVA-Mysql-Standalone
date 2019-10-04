/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sareecenter.dto;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class OrderDetailsDTO extends SuperDTO {

    private String oid;
    private String i_code;
    private int qty;
    private BigDecimal price;
    private ArrayList<ItemDTO> arrayList;

    public OrderDetailsDTO() {
    }

    public OrderDetailsDTO(String oid, String i_code, int qty, BigDecimal price, ArrayList<ItemDTO> arrayList) {
        this.oid = oid;
        this.i_code = i_code;
        this.qty = qty;
        this.price = price;
        this.arrayList = arrayList;
    }

    public OrderDetailsDTO(String oid, String i_code, int qty, BigDecimal price) {
        this.oid = oid;
        this.i_code = i_code;
        this.qty = qty;
        this.price = price;
    }

    /**
     * @return the oid
     */
    public String getOID() {
        return getOid();
    }

    /**
     * @param oid the oid to set
     */
    public void setOID(String oid) {
        this.setOid(oid);
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

    /**
     * @return the price
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * @return the oid
     */
    public String getOid() {
        return oid;
    }

    /**
     * @param oid the oid to set
     */
    public void setOid(String oid) {
        this.oid = oid;
    }

    /**
     * @return the arrayList
     */
    public ArrayList<ItemDTO> getArrayList() {
        return arrayList;
    }

    /**
     * @param arrayList the arrayList to set
     */
    public void setArrayList(ArrayList<ItemDTO> arrayList) {
        this.arrayList = arrayList;
    }

}
