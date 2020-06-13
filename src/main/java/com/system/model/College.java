package com.system.model;


import lombok.Data;

import java.io.Serializable;
@Data
public class College implements Serializable {
    private Integer collegeId;
    private String cname;

    public Integer getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(Integer collegeId) {
        this.collegeId = collegeId;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }
}
