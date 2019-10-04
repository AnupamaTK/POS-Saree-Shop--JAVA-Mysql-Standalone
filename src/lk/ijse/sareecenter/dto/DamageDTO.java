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
public class DamageDTO extends SuperDTO{
    private String did;
    private String description;
    private String grn_id;
    private String i_code;

    public DamageDTO() {
    }

    public DamageDTO(String did, String description, String grn_id, String i_code) {
        this.did = did;
        this.description = description;
        this.grn_id = grn_id;
        this.i_code = i_code;
    }

    /**
     * @return the did
     */
    public String getDID() {
        return did;
    }

    /**
     * @param did the did to set
     */
    public void setDID(String did) {
        this.did = did;
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
     * @return the grn_id
     */
    public String getGrn_id() {
        return grn_id;
    }

    /**
     * @param grn_id the grn_id to set
     */
    public void setGrn_id(String grn_id) {
        this.grn_id = grn_id;
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
    
}
