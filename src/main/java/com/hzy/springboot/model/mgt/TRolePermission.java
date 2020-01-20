package com.hzy.springboot.model.mgt;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class TRolePermission implements Serializable {
    private Integer id;

    private Integer roleId;

    private Integer permissionId;
}