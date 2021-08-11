package com.mzx.wechat321.common;

public class ResponseCommon {
    private Integer pageNo;//每页显示条数

    private Integer pageSize;//当前页数

    private int code;

    private String msg;

    private int totalPage;//返回数据总页数

    private int totalCount;//返回数据总条数

    private Object data;

    public ResponseCommon() {
    }

    public ResponseCommon(Integer pageNo, Integer pageSize, int code, String msg, int totalPage, int totalCount, Object data) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.code = code;
        this.msg = msg;
        this.totalPage = totalPage;
        this.totalCount = totalCount;
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseCommon{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                ", pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                ", totalPage=" + totalPage +
                ", totalCount=" + totalCount +
                '}';
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
