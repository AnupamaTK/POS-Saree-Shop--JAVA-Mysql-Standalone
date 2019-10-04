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
public class UserDTO extends SuperDTO{
    private String userID;
    private String name;
    private String prefferedName;
    private String password;
    private String telNo;
    private String nic_no;

    public UserDTO() {
    }

    public UserDTO(String userID, String name, String prefferedName, String password, String telNo, String nic_no) {
        this.userID = userID;
        this.name = name;
        this.prefferedName = prefferedName;
        this.password = password;
        this.telNo = telNo;
        this.nic_no = nic_no;
    }
    
    

    /**
     * @return the userID
     */
    public String getUserID() {
        return userID;
    }

    /**
     * @param userID the userID to set
     */
    public void setUserID(String userID) {
        this.userID = userID;
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
     * @return the prefferedName
     */
    public String getPrefferedName() {
        return prefferedName;
    }

    /**
     * @param prefferedName the prefferedName to set
     */
    public void setPrefferedName(String prefferedName) {
        this.prefferedName = prefferedName;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the telNo
     */
    public String getTelNo() {
        return telNo;
    }

    /**
     * @param telNo the telNo to set
     */
    public void setTelNo(String telNo) {
        this.telNo = telNo;
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

    
}
