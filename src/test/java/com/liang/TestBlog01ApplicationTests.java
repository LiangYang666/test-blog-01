package com.liang;

import com.liang.modules.sys.dao.UserDao;
import com.liang.modules.sys.entity.UserEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class TestBlog01ApplicationTests {

    @Autowired
    private UserDao userDao;

    @Test
    void contextLoads() {
        List<UserEntity> usersEntities = userDao.selectList(null);
        System.out.println(usersEntities);
    }


}
