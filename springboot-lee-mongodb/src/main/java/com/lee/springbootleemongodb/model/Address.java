package com.lee.springbootleemongodb.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author WangLe
 * @date 2018/12/20 10:04
 * @description
 */
public class Address implements Serializable {
    // 位置
    private String loction;

    // 居住的开始时间
    private Date startDate;

    // 居住的结束时间
    private Date endDate;

    public Address() {
    }

    public Address(String loction, Date startDate, Date endDate) {
        this.loction = loction;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getLoction() {
        return loction;
    }

    public void setLoction(String loction) {
        this.loction = loction;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Address{" +
                "loction='" + loction + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
