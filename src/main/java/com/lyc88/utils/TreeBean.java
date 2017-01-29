package com.lyc88.utils;

import com.lyc88.beans.Subject;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/1/25.
 */
public class TreeBean implements Serializable{

    private Integer id;
    private Integer pId;
    private String name;

    private Boolean isParent;

    public Boolean getIsParent() {
        return isParent;
    }

    public void setIsParent(Boolean parent) {
        this.isParent = parent;
    }

    public Integer getId() {
        return id;
    }

    public Integer getpId() {
        return pId;
    }

    public String getName() {
        return name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public void setName(String name) {
        this.name = name;
    }


}
