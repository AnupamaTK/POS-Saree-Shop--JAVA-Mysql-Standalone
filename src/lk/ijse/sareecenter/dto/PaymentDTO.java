/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sareecenter.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author User
 */
public class PaymentDTO extends SuperDTO{
    private String pid;
    private String p_date;
    private String oid;
    private BigDecimal amount;
    private BigDecimal disount;
    private BigDecimal net_amount;
    private BigDecimal cash;
    private BigDecimal balance;

    public PaymentDTO() {
    }

    public PaymentDTO(String pid, String p_date, String oid, BigDecimal amount, BigDecimal disount, BigDecimal net_amount, BigDecimal cash, BigDecimal balance) {
        this.pid = pid;
        this.p_date = p_date;
        this.oid = oid;
        this.amount = amount;
        this.disount = disount;
        this.net_amount = net_amount;
        this.cash = cash;
        this.balance = balance;
    }

    /**
     * @return the pid
     */
    public String getPID() {
        return pid;
    }

    /**
     * @param pid the pid to set
     */
    public void setPID(String pid) {
        this.pid = pid;
    }

    /**
     * @return the p_date
     */
    public String getP_date() {
        return p_date;
    }

    /**
     * @param p_date the p_date to set
     */
    public void setP_date(String p_date) {
        this.p_date = p_date;
    }

    /**
     * @return the oid
     */
    public String getOID() {
        return oid;
    }

    /**
     * @param oid the oid to set
     */
    public void setOID(String oid) {
        this.oid = oid;
    }

    /**
     * @return the amount
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * @return the disount
     */
    public BigDecimal getDisount() {
        return disount;
    }

    /**
     * @param disount the disount to set
     */
    public void setDisount(BigDecimal disount) {
        this.disount = disount;
    }

    /**
     * @return the net_amount
     */
    public BigDecimal getNet_amount() {
        return net_amount;
    }

    /**
     * @param net_amount the net_amount to set
     */
    public void setNet_amount(BigDecimal net_amount) {
        this.net_amount = net_amount;
    }

    /**
     * @return the cash
     */
    public BigDecimal getCash() {
        return cash;
    }

    /**
     * @param cash the cash to set
     */
    public void setCash(BigDecimal cash) {
        this.cash = cash;
    }

    /**
     * @return the balance
     */
    public BigDecimal getBalance() {
        return balance;
    }

    /**
     * @param balance the balance to set
     */
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

   
    
    
}
