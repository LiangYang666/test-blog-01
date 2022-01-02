package com.liang.modules.sys.service.impl;

import com.liang.modules.sys.dao.UserLoginDao;
import com.liang.modules.sys.entity.VO.UserVOEntity;
import com.liang.modules.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserLoginDao userLoginDao;

    @Override
    public UserVOEntity findByPhone(String phone) {
        return userLoginDao.findByPhone(phone);
    }
}
