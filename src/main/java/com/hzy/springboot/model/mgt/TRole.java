package com.hzy.springboot.model.mgt;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class TRole implements Serializable {
    private Integer id;

    private String name;

    private String description;
}