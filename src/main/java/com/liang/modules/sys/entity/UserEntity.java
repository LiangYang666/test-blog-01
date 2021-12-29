package com.liang.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
@TableName(value = "users")
public class UserEntity implements Serializable {
    private static final long serialVersionUID = 4183054704913917874L;

    @TableId("id")
    private long id;
    private String username;
    private String password;
    private String phone;
    private String lastTime;
    private Integer roleId;
}
