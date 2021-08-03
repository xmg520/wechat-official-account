package com.mzx.wechat321.pojo;

import com.github.pagehelper.IPage;

public class PageParam<T> implements IPage {
    //  description = "页码", defaultValue =  1
    private Integer pageNum = 1;

    //	description = "页数", defaultValue = 20
    private Integer pageSize = 20;

    //	description = "排序", example = "id desc"
    private String orderBy;

    //  description = "参数"
    private T param;


    @Override
    public Integer getPageNum() {
        return pageNum;
    }

    @Override
    public Integer getPageSize() {
        return pageSize;
    }

    @Override
    public String getOrderBy() {
        return orderBy;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public T getParam() {
        return param;
    }

    public void setParam(T param) {
        this.param = param;
    }

    public PageParam(Integer pageNum, Integer pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "PageParam{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", orderBy='" + orderBy + '\'' +
                ", param=" + param +
                '}';
    }
}
