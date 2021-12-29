package com.liang.modules.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liang.modules.sys.entity.UserEntity;
import org.springframework.stereotype.Repository;

/**
 *
 * @ProjectName:
 * @Package:        com.liang.modules.sys.dao
 * @ClassName:      UserDao.java
 * @Description:    查询User表数据的dao
 * @Author:         Yang Liang
 * @CreateDate:     2021/12/28 20:24
 * @Version:        1.0
 */
@Repository
public interface UserDao extends BaseMapper<UserEntity> {
}
