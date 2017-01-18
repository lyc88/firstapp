package com.lyc88.beans;

import org.hibernate.annotations.Cache;

import javax.persistence.*;

/**
 * Created by Administrator on 2017/1/15.
 */
@Entity
@Table(name="ztree")
public class Subject {
    @GeneratedValue
    @Id
    @Column(name="tree_id")
    private Integer treeId;
    @Column(name="parent_id")
    private Integer patentId;
    @Column(name="tree_code")
    private String treeCode;
    @Column(name="tree_desc")
    private String treeDesc;

    public Integer getTreeId() {
        return treeId;
    }

    public void setTreeId(Integer treeId) {
        this.treeId = treeId;
    }

    public Integer getPatentId() {
        return patentId;
    }

    public void setPatentId(Integer patentId) {
        this.patentId = patentId;
    }

    public String getTreeCode() {
        return treeCode;
    }

    public void setTreeCode(String treeCode) {
        this.treeCode = treeCode;
    }

    public String getTreeDesc() {
        return treeDesc;
    }

    public void setTreeDesc(String treeDesc) {
        this.treeDesc = treeDesc;
    }
}
