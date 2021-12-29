package com.liang.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName(value = "roles")
public class RoleEntity implements Serializable {
    private static final long serialVersionUID = 7840592564845432616L;

    private int id;
    private String roleName;
}
