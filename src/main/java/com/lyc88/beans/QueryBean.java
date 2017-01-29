package com.lyc88.beans;

import com.lyc88.utils.Page;

/**
 * Created by Administrator on 2017/1/27.
 */
public class QueryBean {
    private String q;
    /** 多个过滤字段, 分开**/
    private String fq;
    private Page page;
    /** 多个排序字段, 分开**/
    private String sort;
    /** 多个分面字段, 分开**/
    private String fact;

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public String getFq() {
        return fq;
    }

    public void setFq(String fq) {
        this.fq = fq;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getFact() {
        return fact;
    }

    public void setFact(String fact) {
        this.fact = fact;
    }
}
