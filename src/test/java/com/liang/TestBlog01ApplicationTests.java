package com.liang;

import com.alibaba.druid.pool.DruidDataSource;
import com.liang.modules.sys.dao.UserDao;
import com.liang.modules.sys.dao.UserLoginDao;
import com.liang.modules.sys.entity.UserEntity;
import com.liang.modules.sys.entity.VO.UserVOEntity;
import com.liang.modules.sys.service.UserService;
import com.liang.modules.sys.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
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

    @Autowired
    private UserLoginDao userLoginDao;
    @Test
    void test2(){
        UserVOEntity byPhone = userLoginDao.findByPhone("12345678910");
        System.out.println(byPhone.getUsername());
        System.out.println(byPhone.getPassword());
        System.out.println("====>Roles");
        byPhone.getRoles().forEach(x-> System.out.println(x.getId()+" "+x.getRoleName()+ x.getPermissionSet()));
    }

    @Autowired
    private UserServiceImpl userServiceImpl;
    @Test
    void test3(){
        UserVOEntity byPhone = userServiceImpl.findByPhone("12345678910");
        System.out.println(byPhone.getUsername());
        System.out.println(byPhone.getPassword());
        System.out.println("====>Roles");
        byPhone.getRoles().forEach(x-> System.out.println(x.getId()+" "+x.getRoleName()+ x.getPermissionSet()));
    }

}
