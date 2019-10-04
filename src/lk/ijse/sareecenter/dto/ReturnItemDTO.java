/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sareecenter.dto;

/**
 *
 * @author User
 */
public class ReturnItemDTO extends SuperDTO {

    private String RID;

    private String OID;
    private String r_item_code;
    private String new_OID;
    private String n_item_code;

    public ReturnItemDTO() {
    }

    public ReturnItemDTO(String RID, String OID, String r_item_code, String new_OID, String n_item_code) {
        this.RID = RID;
        this.OID = OID;
        this.r_item_code = r_item_code;
        this.new_OID = new_OID;
        this.n_item_code = n_item_code;
    }

    /**
     * @return the RID
     */
    public String getRID() {
        return RID;
    }

    /**
     * @param RID the RID to set
     */
    public void setRID(String RID) {
        this.RID = RID;
    }

    /**
     * @return the OID
     */
    public String getOID() {
        return OID;
    }

    /**
     * @param OID the OID to set
     */
    public void setOID(String OID) {
        this.OID = OID;
    }

    /**
     * @return the r_item_code
     */
    public String getR_item_code() {
        return r_item_code;
    }

    /**
     * @param r_item_code the r_item_code to set
     */
    public void setR_item_code(String r_item_code) {
        this.r_item_code = r_item_code;
    }

    /**
     * @return the new_OID
     */
    public String getNew_OID() {
        return new_OID;
    }

    /**
     * @param new_OID the new_OID to set
     */
    public void setNew_OID(String new_OID) {
        this.new_OID = new_OID;
    }

    /**
     * @return the n_item_code
     */
    public String getN_item_code() {
        return n_item_code;
    }

    /**
     * @param n_item_code the n_item_code to set
     */
    public void setN_item_code(String n_item_code) {
        this.n_item_code = n_item_code;
    }

   

}
