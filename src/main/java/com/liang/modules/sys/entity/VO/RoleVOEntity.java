package com.liang.modules.sys.entity.VO;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.liang.modules.sys.entity.PermissionEntity;
import com.liang.modules.sys.entity.RoleEntity;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Set;

@Data
@TableName(value = "roles")
public class RoleVOEntity extends RoleEntity implements Serializable {
    private static final long serialVersionUID = 3137462801862176163L;

    @TableField(exist = false)
    private Set<PermissionEntity> permissionSet;
}
