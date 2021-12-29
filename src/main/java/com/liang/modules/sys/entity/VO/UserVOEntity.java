package com.liang.modules.sys.entity.VO;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.liang.modules.sys.entity.UserEntity;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Set;

@Data
@TableName(value = "users")
public class UserVOEntity extends UserEntity implements Serializable {
    private static final long serialVersionUID = -8860349534536707832L;

    @TableField(exist = false)
    private Set<RoleVOEntity> roles;
}
