package jp.co.siam.restapi.common.mybatis;

import java.io.Serializable;


public class PagingParameter implements Serializable {

    public static final int DEFAULT_PAGE_SIZE = 50;

    public static final int MAX_PAGE_SIZE = 1000;

    public static final int FIRST_PAGE = 1;

    public PagingParameter() {
        setPageNum(FIRST_PAGE);
        setPageSize(DEFAULT_PAGE_SIZE);
    }


    private Integer pageNum;

    private Integer pageSize;

    private long total;

    public static void setDefault(PagingParameter parameter) {
        if (parameter.getPageNum() == null) {
            parameter.setPageNum(FIRST_PAGE);
        }
        if (parameter.getPageSize() == null) {
            parameter.setPageSize(DEFAULT_PAGE_SIZE);
        }
        if (parameter.getPageSize() > PagingParameter.MAX_PAGE_SIZE) {
            parameter.setPageSize(PagingParameter.MAX_PAGE_SIZE);
        }
    }

    public void init() {
        setDefault(this);
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
