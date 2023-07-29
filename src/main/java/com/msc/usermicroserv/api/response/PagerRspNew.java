package com.msc.usermicroserv.api.response;




import java.util.ArrayList;
import java.util.List;

public class PagerRspNew {
    /**
     * 每页最大记录数限制
     */
    public static final Integer MAX_PAGE_SIZE = Integer.MAX_VALUE;
    /**
     * 当前页码
     */
    private Integer pageNumber = 1;
    /**
     * 每页记录数
     */
    private Integer pageSize = 10;
    /**
     * 总记录数
     */
    private Integer totalCount = 0;
    /**
     * 总页数
     */
    private Integer pageCount = 0;

    private List<?> result = new ArrayList<>();


    public Integer getPageNumber() {
        return pageNumber;
    }

    public PagerRspNew() {

    }

    public PagerRspNew(Integer nowPage, Integer pageSize) {
        this.pageNumber = nowPage;
        this.pageSize = pageSize;
    }

    public void setPageNumber(Integer pageNumber) {
        if (pageNumber < 1) {
            pageNumber = 1;
        }

        this.pageNumber = pageNumber;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        if (pageSize < 1) {
            pageSize = 1;
        } else if (pageSize > MAX_PAGE_SIZE) {
            pageSize = MAX_PAGE_SIZE;
        }
        this.pageSize = pageSize;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getPageCount() {
        pageCount = totalCount / pageSize;
        if (totalCount % pageSize > 0) {
            pageCount++;
        }
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public List<?> getResult() {
        return result;
    }

    public void setResult(List<?> result) {
        this.result = result;
    }


}
