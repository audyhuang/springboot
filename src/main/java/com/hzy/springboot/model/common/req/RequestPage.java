package com.hzy.springboot.model.common.req;

import lombok.Data;

@Data
public class RequestPage<T> {
    private Integer pageIndex = 1;
    private Integer pageSize = 10;
    private T data;
}
