package lk.ijse.sareecenter.dto;


import java.util.Date;
import lk.ijse.sareecenter.dto.SuperDTO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author User
 */
public class ReplacementDTO extends SuperDTO {

    private String rep_id;
     private String rep_date;
    private String did;

    public ReplacementDTO() {
    }

    public ReplacementDTO(String rep_id, String rep_date, String did) {
        this.rep_id = rep_id;
        this.rep_date = rep_date;
        this.did = did;
    }

    /**
     * @return the rep_id
     */
    public String getRep_id() {
        return rep_id;
    }

    /**
     * @param rep_id the rep_id to set
     */
    public void setRep_id(String rep_id) {
        this.rep_id = rep_id;
    }

    /**
     * @return the rep_date
     */
    public String getRep_date() {
        return rep_date;
    }

    /**
     * @param rep_date the rep_date to set
     */
    public void setRep_date(String rep_date) {
        this.rep_date = rep_date;
    }

    /**
     * @return the did
     */
    public String getDid() {
        return did;
    }

    /**
     * @param did the did to set
     */
    public void setDid(String did) {
        this.did = did;
    }
   

   
}
