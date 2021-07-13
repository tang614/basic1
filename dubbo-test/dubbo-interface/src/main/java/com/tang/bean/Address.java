package com.tang.bean;

import java.io.Serializable;

public class Address implements Serializable {
    private String area;
    private Integer areaId;

    public Address(String area, Integer areaId) {
        this.area = area;
        this.areaId = areaId;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    @Override
    public String toString() {
        return "Address{" +
                "area='" + area + '\'' +
                ", areaId=" + areaId +
                '}';
    }
}
