package com.hzy.springboot.model.mgt;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class TUser implements Serializable {
    private Integer id;
    private String username;
    private String password;
}