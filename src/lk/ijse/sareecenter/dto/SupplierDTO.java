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
public class SupplierDTO extends SuperDTO{
    private String sup_id;
    private String sup_name;
    private String company_name;
    private String nic_no;
    private int tel_no;

    public SupplierDTO() {
    }

    public SupplierDTO(String sup_id, String sup_name, String company_name, String nic_no, int tel_no) {
        this.sup_id = sup_id;
        this.sup_name = sup_name;
        this.company_name = company_name;
        this.nic_no = nic_no;
        this.tel_no = tel_no;
    }

    /**
     * @return the sup_id
     */
    public String getSup_id() {
        return sup_id;
    }

    /**
     * @param sup_id the sup_id to set
     */
    public void setSup_id(String sup_id) {
        this.sup_id = sup_id;
    }

    /**
     * @return the sup_name
     */
    public String getSup_name() {
        return sup_name;
    }

    /**
     * @param sup_name the sup_name to set
     */
    public void setSup_name(String sup_name) {
        this.sup_name = sup_name;
    }

    /**
     * @return the company_name
     */
    public String getCompany_name() {
        return company_name;
    }

    /**
     * @param company_name the company_name to set
     */
    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    /**
     * @return the nic_no
     */
    public String getNic_no() {
        return nic_no;
    }

    /**
     * @param nic_no the nic_no to set
     */
    public void setNic_no(String nic_no) {
        this.nic_no = nic_no;
    }

    /**
     * @return the tel_no
     */
    public int getTel_no() {
        return tel_no;
    }

    /**
     * @param tel_no the tel_no to set
     */
    public void setTel_no(int tel_no) {
        this.tel_no = tel_no;
    }
    

    
}
