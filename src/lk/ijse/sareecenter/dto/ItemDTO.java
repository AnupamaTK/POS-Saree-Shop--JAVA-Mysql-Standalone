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
public class ItemDTO extends SuperDTO{
    private String item_code;
    private String type;
    private String brand;
    private String colour;
    private String description;
    private BigDecimal buying_price;
    private BigDecimal selling_price;
    private int qty_on_hand;

    public ItemDTO() {
    }

    public ItemDTO(String item_code, String type, String brand, String colour, String description, BigDecimal buying_price, BigDecimal selling_price, int qty_on_hand) {
        this.item_code = item_code;
        this.type = type;
        this.brand = brand;
        this.colour = colour;
        this.description = description;
        this.buying_price = buying_price;
        this.selling_price = selling_price;
        this.qty_on_hand = qty_on_hand;
    }

    /**
     * @return the item_code
     */
    public String getItem_code() {
        return item_code;
    }

    /**
     * @param item_code the item_code to set
     */
    public void setItem_code(String item_code) {
        this.item_code = item_code;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * @param brand the brand to set
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * @return the colour
     */
    public String getColour() {
        return colour;
    }

    /**
     * @param colour the colour to set
     */
    public void setColour(String colour) {
        this.colour = colour;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the buying_price
     */
    public BigDecimal getBuying_price() {
        return buying_price;
    }

    /**
     * @param buying_price the buying_price to set
     */
    public void setBuying_price(BigDecimal buying_price) {
        this.buying_price = buying_price;
    }

    /**
     * @return the selling_price
     */
    public BigDecimal getSelling_price() {
        return selling_price;
    }

    /**
     * @param selling_price the selling_price to set
     */
    public void setSelling_price(BigDecimal selling_price) {
        this.selling_price = selling_price;
    }

    /**
     * @return the qty_on_hand
     */
    public int getQty_on_hand() {
        return qty_on_hand;
    }

    /**
     * @param qty_on_hand the qty_on_hand to set
     */
    public void setQty_on_hand(int qty_on_hand) {
        this.qty_on_hand = qty_on_hand;
    }
    

}
