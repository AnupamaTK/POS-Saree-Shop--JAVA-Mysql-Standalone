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
public class CustomerDTO extends SuperDTO {

    private String cid;
    private String name;
    private String nic_no;
    private int tel_no;
    private String address;

    public CustomerDTO() {
    }

    public CustomerDTO(String cid, String name, String nic_no, int tel_no, String address) {
        this.cid = cid;
        this.name = name;
        this.nic_no = nic_no;
        this.tel_no = tel_no;
        this.address = address;
    }

    /**
     * @return the cid
     */
    public String getCID() {
        return cid;
    }

    /**
     * @param cid the cid to set
     */
    public void setCID(String cid) {
        this.cid = cid;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the nic_no
     */
    public String getNIC_no() {
        return nic_no;
    }

    /**
     * @param nic_no the nic_no to set
     */
    public void setNIC_no(String nic_no) {
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

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

   
    

    
}
