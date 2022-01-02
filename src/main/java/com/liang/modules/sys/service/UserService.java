package com.liang.modules.sys.service;

import com.liang.modules.sys.entity.VO.UserVOEntity;

public interface UserService {
    UserVOEntity findByPhone(String phone);
}
