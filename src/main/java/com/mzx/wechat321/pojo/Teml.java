package com.mzx.wechat321.pojo;

import java.io.Serializable;

/**
 * @author Mzx
 * "returncode": "100",
 * "returnmsg": "SUCCESS",
 * "quantity": "427.10",
 * "quantityunit": "度",
 * "canbuy": "true",
 * "description": "321房间",
 * "custparams": null
 */
public class Teml implements Serializable {
    private Integer returncode;
    private String returnmsg;
    private String quantity;
    private String quantityunit;
    private Boolean canbuy;
    private String description;
    private String custparams;

    public Teml() {
    }

    public Teml(Integer returncode, String returnmsg, String quantity, String quantityunit, Boolean canbuy, String description, String custparams) {
        this.returncode = returncode;
        this.returnmsg = returnmsg;
        this.quantity = quantity;
        this.quantityunit = quantityunit;
        this.canbuy = canbuy;
        this.description = description;
        this.custparams = custparams;
    }

    @Override
    public String toString() {
        return "Teml{" +
                "returncode=" + returncode +
                ", returnmsg='" + returnmsg + '\'' +
                ", quantity='" + quantity + '\'' +
                ", quantityunit='" + quantityunit + '\'' +
                ", canbuy=" + canbuy +
                ", description='" + description + '\'' +
                ", custparams='" + custparams + '\'' +
                '}';
    }

    public Integer getReturncode() {
        return returncode;
    }

    public void setReturncode(Integer returncode) {
        this.returncode = returncode;
    }

    public String getReturnmsg() {
        return returnmsg;
    }

    public void setReturnmsg(String returnmsg) {
        this.returnmsg = returnmsg;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getQuantityunit() {
        return quantityunit;
    }

    public void setQuantityunit(String quantityunit) {
        this.quantityunit = quantityunit;
    }

    public Boolean getCanbuy() {
        return canbuy;
    }

    public void setCanbuy(Boolean canbuy) {
        this.canbuy = canbuy;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCustparams() {
        return custparams;
    }

    public void setCustparams(String custparams) {
        this.custparams = custparams;
    }
}
