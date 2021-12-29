package com.liang.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName(value = "permission")
public class PermissionEntity implements Serializable {
    private static final long serialVersionUID = 7501360721677209850L;

    private int id;
    private String permissionName;
}
