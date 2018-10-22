package com.yanyan.card.util;

import java.util.List;

/**
 * Created by sam on 2018/2/9.
 */
public class Page<T> {
    /**
     * 当前页数
     */
    private Integer curPage;
    //总记录数
    private Integer total;
    //每页条数
    private Integer pageSize;
    //共多少页
    private Integer pageCount;
    //起始数据
    private Integer beginPos;
    //   数据
    private List<T> rows;

    public Page() {

    }

    public Page(Integer curPage, Integer pageSize) {
        this.curPage = curPage;
        this.pageSize = pageSize;
    }

    public Page(Integer curPage, Integer pageSize, Integer total) {
        this.curPage = curPage;//当前页面
        this.pageSize = pageSize;//每页多少条
        this.beginPos = (curPage - 1) * pageSize;
        //总页数=总记录数total/pageSize（+1）
        this.pageCount = (total + pageSize - 1) / pageSize;
        this.total = total;
    }

    public Integer getCurPage() {
        return curPage;
    }

    public void setCurPage(Integer curPage) {
        this.curPage = curPage;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getBeginPos() {
        return beginPos;
    }

    public void setBeginPos(Integer beginPos) {
        this.beginPos = beginPos;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
