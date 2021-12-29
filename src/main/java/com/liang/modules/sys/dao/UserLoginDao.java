package com.liang.modules.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liang.modules.sys.entity.UserEntity;
import com.liang.modules.sys.entity.VO.UserVOEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLoginDao extends BaseMapper<UserVOEntity> {
    UserVOEntity findByPhone(String phone);
}
