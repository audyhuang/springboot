package com.hzy.springboot.model.common.resp;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResponsePage<T> implements Serializable {
    private Integer pageIndex = 1;
    private Integer pageSize = 10;
    private boolean hasNext = false;
    private boolean haxPre = false;
    private Long totalSize;
    private Long totalPage;
    private T data;

    public void setTotalSize(Long totalSize) {
        this.totalSize = totalSize;
        this.totalPage = totalSize ==0?1:(totalSize%this.pageSize==0?totalSize/this.pageSize: totalSize/this.pageSize +1);
        this.haxPre = totalSize <= this.pageSize || totalPage == 1 ? false : true;
        this.hasNext = totalSize <= pageSize || totalPage == Long.valueOf(this.pageIndex) ? false:true;
    }
}
