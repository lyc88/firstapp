package com.lyc88.utils;

/**
 * Created by Administrator on 2017/1/27.
 */
public class Page {
    private int pageSize = 10;
    private int currentPage = 1;
    private int nextPage;
    private int prePage;
    private int totalPage;
    /** 一共多少条 **/
    private long total;

    public Page(){};
    public Page(long total,int pageSize) {
        this.total = total;
        this.pageSize = pageSize;
        this.totalPage = (int) (total%pageSize==0?total/pageSize:total/pageSize+1);
    }

    public void setTotal(long total) {
        this.total = total;
        this.totalPage = (int) (total%pageSize==0?total/pageSize:total/pageSize+1);
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public int getNextPage() {
        if((currentPage+1)<totalPage)
        return currentPage+1;
        else{
            return currentPage;
        }
    }

    public int getPrePage() {
        if ((currentPage-1)<0)
        return currentPage-1;
        else return currentPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public long getTotal() {
        return total;
    }

    public static void main(String[] args) {
        System.out.println(new Page().currentPage);
    }
}
