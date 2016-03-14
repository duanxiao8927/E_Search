package com.edison.model;

import java.io.Serializable;

/**
 * Created by xiaotufei on 16/3/6.
 */
public class PhoneInfo implements Serializable {


//            "phone": "15210011578",
//            "prefix": "1521001",
//            "supplier": "移动 ",
//            "province": "北京 ",
//            "city": "北京 ",
//            "suit": "152卡"

    private String phone;
    private String prefix;
    private String supplier;
    private String province;
    private String city;
    private String suit;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }
}
