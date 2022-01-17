@[toc](个人网站建立)
**写在前面**
本项目为github网址为[链接](https://github.com/LiangYang666/test-blog-01)，项目所需前端文件(HTML和JS)可以从GitHub仓库中下载获取，另外本项目按照步骤依次进行了commit，因此如果使用git clone将项目下载下来，将会得到与博客教程几乎一致的历史线，如图用IDEA打开时，观察Git，将得到如下图，因此可根据博客内容，每个小节进行检查
# 一、登录界面实现
## 1.1 工程建立
1. 新建
   ![在这里插入图片描述](https://img-blog.csdnimg.cn/14a5491d3eae4d2ab0fea0a478a8ec4a.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA5rSq5Z-O5biD6KGj,size_20,color_FFFFFF,t_70,g_se,x_16)
2. 选择4个初始依赖，`Thymeleaf`在`Template Engines`中
   ![在这里插入图片描述](https://img-blog.csdnimg.cn/c9d4804c776640c79c473ff821702c92.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA5rSq5Z-O5biD6KGj,size_20,color_FFFFFF,t_70,g_se,x_16)
3. 等待依赖下载完成
   ![在这里插入图片描述](https://img-blog.csdnimg.cn/2d1a5c795fb14af2bba2c045d5e1e4cb.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA5rSq5Z-O5biD6KGj,size_20,color_FFFFFF,t_70,g_se,x_16)
4. 依赖下载完成后目录结构，文件标志将变化
   ![在这里插入图片描述](https://img-blog.csdnimg.cn/ade33031734c4164aa0c20e7ff7ee994.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA5rSq5Z-O5biD6KGj,size_20,color_FFFFFF,t_70,g_se,x_16)
## 1.2 前端
因为还要适配移动端的页面，因此选择[amazeui](http://amazeui.shopxo.net/)作为基本样式库
1.  安装amazui样式库
    点击[使用手册](http://amazeui.shopxo.net/getting-started/)页面，选择[版本](http://amazeui.shopxo.net/static/zip/AmazeUI-2.7.2.zip)进行下载
    ![在这里插入图片描述](https://img-blog.csdnimg.cn/d0ccd7ebebd8485a9e0c594fbd0aa28d.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA5rSq5Z-O5biD6KGj,size_20,color_FFFFFF,t_70,g_se,x_16)
    解压后将`assets`复制到`resources/static`目录下
    ![在这里插入图片描述](https://img-blog.csdnimg.cn/f3c60bb89d1b4825a2761b66da07908c.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA5rSq5Z-O5biD6KGj,size_20,color_FFFFFF,t_70,g_se,x_16)
2. 添加jQuery
   下载[jquery-1.12.4.min.js](https://blog.jquery.com/2016/05/20/jquery-1-12-4-and-2-2-4-released/)，添加至`resources/static/assets/js`下，也可在我的github工程中下载
   ![在这里插入图片描述](https://img-blog.csdnimg.cn/c9f962b71524490dad4c203ea8a2b8ee.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA5rSq5Z-O5biD6KGj,size_20,color_FFFFFF,t_70,g_se,x_16)
3. 添加login(登陆页面)，footer(网页底部)，和lheader(网页头部)三个页面到`resources/templates`下
   ![在这里插入图片描述](https://img-blog.csdnimg.cn/ce029c0f323e4890b95a073d42cc6874.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA5rSq5Z-O5biD6KGj,size_20,color_FFFFFF,t_70,g_se,x_16)
4. 添加页面相关的`index.css`和`tig.css`两个样式文件到`resources/static/style/js`下，其中tig.css设置初始时“用户名或密码错误”和“客官，密码格式6-18位”两个提示不显示
   ![在这里插入图片描述](https://img-blog.csdnimg.cn/b6a81e6eb4c44d4a91d81c779211c253.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA5rSq5Z-O5biD6KGj,size_20,color_FFFFFF,t_70,g_se,x_16)
5. 添加登陆有关的`login.js`和`background.js`到`resources/static/style/js`下，
   这两个是个java scrip
   `login.js`主要作用为判断账号和密码是否符合有关的判断，显示有关提示
   `background.js`是背景有关的，实现背景的线条吸附和点按出现小心心
   ![在这里插入图片描述](https://img-blog.csdnimg.cn/da0f8c144d8346a490038bf7a6b4ebd0.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA5rSq5Z-O5biD6KGj,size_20,color_FFFFFF,t_70,g_se,x_16)
6. 添加博客logo
   网页顶部显示的博客logo图片到`resources/style/images`下，命名为`myPicture.jpg`
   最终目前所有前端有关文件结构如下图所示
   ![在这里插入图片描述](https://img-blog.csdnimg.cn/65a5560a13c2433e8dc2c9ba3401250b.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA5rSq5Z-O5biD6KGj,size_20,color_FFFFFF,t_70,g_se,x_16)
## 1.3 页面显示测试
1. 新建controller包
   创建`com.liang.modules.sys.controller`包
   ![在这里插入图片描述](https://img-blog.csdnimg.cn/73c41c03608446ebaf7b3db4dd004a87.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA5rSq5Z-O5biD6KGj,size_20,color_FFFFFF,t_70,g_se,x_16)
   ![在这里插入图片描述](https://img-blog.csdnimg.cn/9326402ec1ef4aaaab803358e978c2c5.png)
3. 新建类
   ![在这里插入图片描述](https://img-blog.csdnimg.cn/50a5a3e9f9a744b2af541bfaf5087cdb.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA5rSq5Z-O5biD6KGj,size_20,color_FFFFFF,t_70,g_se,x_16)新建TestController类，并写入，启动
   ```java
   @Controller
   public class TestController {
       @RequestMapping("/")
       public String toLogin(){
           return "login";
       }
   }
   ```
   ![在这里插入图片描述](https://img-blog.csdnimg.cn/5934bd50948e482d9cec0abeda6688db.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA5rSq5Z-O5biD6KGj,size_20,color_FFFFFF,t_70,g_se,x_16)
4. 浏览器输入http://localhost:8080/，查看界面如下
   ![在这里插入图片描述](https://img-blog.csdnimg.cn/4f57a844a59d4c7bad2f50eaed434999.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBA5rSq5Z-O5biD6KGj,size_20,color_FFFFFF,t_70,g_se,x_16)
# 二、Shiro登录验证
## 2.1 数据库
### 2.1.1 数据表设计
创建数据库，并依次创建用户信息表、角色表、权限表、角色权限映射表
```sql
create database blog1;
use blog1;

# 创建用户信息表
create table users(
    `id` int(11) not null auto_increment comment 'id',
    `username` varchar(255) not null comment '用户名',
    `password` varchar(60) not null comment '密码',
    `phone` varchar(11) not null comment '手机',
    `last_time` date default null comment '最后登录时间',
    `role_id` int(1) not null comment '角色id',
    primary key (`id`)
)engine=InnoDB DEFAULT CHARSET=utf8mb4;

# 创建角色表
create table roles(
    `id` int(1) not null comment '角色id',
    `role_name` varchar(10) not null comment '角色名称',
    primary key (`id`)
)engine=InnoDB DEFAULT CHARSET=utf8mb4;

# 创建权限表
create table permission(
    `id` int(1) not null comment '权限id',
    `permission_name` varchar(10) not null comment '权限名称',
    primary key(`id`)
)engine=InnoDB DEFAULT CHARSET=utf8mb4;

# 创建角色和权限对应表
create table role_permission (
    `role_id` int(1) not null comment '角色id',
    `permission_id` int(1) not null comment '权限id',
    key `role_id` (`role_id`),
    key `permission_id` (`permission_id`)
)engine=InnoDB DEFAULT CHARSET=utf8mb4;
```
### 2.1.2 插入数据
```sql
# 插入角色表信息
insert into roles values (1, 'admin');
insert into roles values (2, 'user');
insert into roles values (3, 'partner');
# 插入权限表信息
insert into permission values (1, 'editor');
insert into permission values (2, 'manage');
insert into permission values (3, 'comment');
#插入角色和对应的权限对应关系
insert into role_permission values (1, 2);
insert into role_permission values (2, 3);
insert into role_permission values (3, 1);
# 插入用户信息
insert into users values(1, '洪城布衣','123456', '12345678910', '2021-12-22', 1);
```
### 2.1.3 联表查看信息
```sql

select u.*, r.role_name, rpn.permission_id, p.permission_name from users u
join roles r on u.role_id = r.id
join role_permission rpn on r.id = rpn.role_id
join permission p on rpn.permission_id = p.id;
```
如图为结果：
![在这里插入图片描述](https://img-blog.csdnimg.cn/cd88ee7ad49c40489970cb8cc19f5708.png)
## 2.2 工程项目继续开发
### 2.2.1 添加mybatis-plus和druid依赖
在pom.xml的<dependencies>标签中添加如下
```xml
        <!--mybatis-plus配置-->
        <dependency>
            <groupId>com.baomidou</groupId>
            <artifactId>mybatis-plus-boot-starter</artifactId>
            <version>3.1.0</version>
        </dependency>
        <!--引入druid数据源-->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid-spring-boot-starter</artifactId>
            <version>1.1.14</version>
        </dependency>
```
添加后，版本号或包会是红色，点Maven->再刷新，将会对相应的依赖进行下载和加载，加载完成后红色就消失，当添加其它依赖时也是这样操作，一直等待其红色消失
![在这里插入图片描述](https://img-blog.csdnimg.cn/f029f382e8cf4adba113de38f844009c.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBA5rSq5Z-O5biD6KGj,size_10,color_FFFFFF,t_70,g_se,x_16)
### 2.2.2 配置数据库连接
1. 在resources下创建application.yaml和application-dev.yaml，如下图所示
   ![在这里插入图片描述](https://img-blog.csdnimg.cn/4ad245ca8c6142228cc4ec26e7652f2e.png)
2. 在application.yaml中填写如下内容
   ```yaml
   # 使用application的配置文件
   spring:
     # 配置文件 dev|test|prod
     profiles:
       active: dev
   
   # mybatis-plus配置
   mybatis-plus:
     mapper-locations: classpath:mappering/*.xml
     #实体扫描，多个package用逗号或者分号分隔
     type-aliases-package: com.liang.modules.sys.entity
     global-config:
       db-config:
         table-underline: true
         db-type: mysql
   ```
3. 在application-dev.yaml中填写如下内容，
   ```yaml
   server:
     port: 8080
   spring:
     datasource:
       username: root
       password: 123456
       url: jdbc:mysql://localhost:3306/blog1?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8
       driver-class-name: com.mysql.cj.jdbc.Driver
       type: com.alibaba.druid.pool.DruidDataSource
       druid:
         initial-size: 5
         min-idle: 5
         max-active: 20
         max-wait: 60000
         time-between-eviction-runs-millis: 60000
         min-evictable-idle-time-millis: 300000
         validation-query: SELECT 1 FROM DUAL
         test-while-idle: true
         test-on-borrow: false
         test-on-return: false
         pool-prepared-statements: true
         filter:
           commons-log:
             connection-logger-name: stat,wall,log4j
         max-pool-prepared-statement-per-connection-size: 20
         use-global-data-source-stat: true
         connection-properties: druid.stat.mergeSql=true;druid.stat.slowSqlMillis=500
   ```
### 2.2.3 创建实体类
1. 首先创建com.liang.modules.sys.entity包，即在modules.sys下创建entity，entity下将会存放普通实体类，在entity下继续创建com.liang.modules.sys.entity.VO包（视图对象类）
2. 在entity下创建PermissionEntity、RoleEntity、UsersEntity三个类，VO下创建UsersVOEntity和RoleVOEntity两个类，如下图所示，图中文件名显示红色请忽略，是git有关的
   ![在这里插入图片描述](https://img-blog.csdnimg.cn/b16e1d424d3e48c48b5a49aa9ed2c588.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBA5rSq5Z-O5biD6KGj,size_15,color_FFFFFF,t_70,g_se,x_16)
3. 各个类的主体代码如下
   ```java
   @Data
   @TableName(value = "users")
   public class UsersEntity implements Serializable {
       private static final long serialVersionUID = 4183054704913917874L;
   
       @TableId("id")
       private long id;
       private String username;
       private String password;
       private String phone;
       private String lastTime;
       private Integer roleId;
   }
   
   
   @Data
   @TableName(value = "permission")
   public class PermissionEntity implements Serializable {
       private static final long serialVersionUID = 7501360721677209850L;
   
       private int id;
       private String permissionName;
   }
   @Data
   
   
   @TableName(value = "roles")
   public class RoleEntity implements Serializable {
       private static final long serialVersionUID = 7840592564845432616L;
   
       private int id;
       private String roleName;
   }
   
   
   @Data
   @TableName(value = "roles")
   public class RoleVOEntity extends RoleEntity implements Serializable {
       private static final long serialVersionUID = 3137462801862176163L;
   
       @TableField(exist = false)
       private Set<PermissionEntity> permissionSet;
   }
   
   
   @Data
   @TableName(value = "users")
   public class UsersVOEntity extends UsersEntity implements Serializable {
       private static final long serialVersionUID = -8860349534536707832L;
   
       @TableField(exist = false)
       private Set<RoleVOEntity> roles;
   }
   ```
5. 其中每个实体类的serialVersionUID是序列化有关的，可以删除我写的，然后自己生成，生成方式如下：Idea安装 GenerateSerialVersionUID 插件，重启Idea，在类中键盘按`alt+Insetrt`自动生成序列化uid
   ![在这里插入图片描述](https://img-blog.csdnimg.cn/5576a74948d94b05901b00760413b2f8.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBA5rSq5Z-O5biD6KGj,size_13,color_FFFFFF,t_70,g_se,x_16)
### 2.2.4 创建一个dao并测试
1. 创建com.liang.modules.sys.dao包
1. 创建com.liang.modules.sys.dao.UserDao.java接口，内容如下
   ```java
   @Repository
   public interface UserDao extends BaseMapper<UsersEntity> {
   }
   ```
2. 添加包扫描
   在com.liang.TestBlog01Application前面添加
   `@MapperScan("com.liang.modules.sys.dao")`
   如下图所示
   ![在这里插入图片描述](https://img-blog.csdnimg.cn/8c8a756cdf5e4b759818ab6bd0f3cc8c.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBA5rSq5Z-O5biD6KGj,size_20,color_FFFFFF,t_70,g_se,x_16)
4. 测试类编写
   在测试类`com.liang.TestBlog01ApplicationTests`中，填写测试内容，测试类所在位置可看下一步的测试
   填写内容如下，主要调用的是mybatis-plus生成的CRUD
   ```java
   @SpringBootTest
   class TestBlog01ApplicationTests {
   
       @Autowired
       private UserDao userDao;
   
       @Test
       void contextLoads() {
           List<UsersEntity> usersEntities = userDao.selectList(null);
           System.out.println(usersEntities);
       }
   }
   
   ```
    3. 测试
       按下图箭头2，运行contextLoads测试方法
       ![在这里插入图片描述](https://img-blog.csdnimg.cn/865acaac5d044e1baf8f4859c6ac8215.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBA5rSq5Z-O5biD6KGj,size_20,color_FFFFFF,t_70,g_se,x_16)
       测试完成后，正常的话不报红，打印如下，将会查询users表中所有数据
       ![在这里插入图片描述](https://img-blog.csdnimg.cn/8c84dd07b921400c80abc3228ea4a28b.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBA5rSq5Z-O5biD6KGj,size_20,color_FFFFFF,t_70,g_se,x_16)
### 2.2.5 创建UsersLogin有关的接口及类
UsersLoginDao接口、UsersLoginDao.xml、UserService接口以及UserServiceImpl实现类
1. com.liang.modules.sys.dao.UsersLoginDao接口
   ```java
   @Repository
   public interface UserLoginDao extends BaseMapper<UsersVOEntity> {
       UsersVOEntity findByPhone(String phone);
   }
   ```
2. 在resources下新建mappering目录，并在mappering目录下新建UsersLoginDao.xml文件，内容如下
   ```xml
   <?xml version="1.0" encoding="UTF-8" ?>
   <!DOCTYPE mapper
           PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
           "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
   <mapper namespace="com.liang.modules.sys.dao.UserLoginDao">
       <resultMap id="userMap" type="com.liang.modules.sys.entity.VO.UserVOEntity">
           <id property="id" column="id"/>
           <result property="username" column="username"/>
           <result property="password" column="password"/>
           <result property="phone" column="phone"/>
           <result property="lastTime" column="last_time"/>
           <collection property="roles" ofType="com.liang.modules.sys.entity.VO.RoleVOEntity">
               <id property="id" column="role_id"/>
               <result property="roleName" column="role_name"/>
               <collection property="permissionSet" ofType="com.liang.modules.sys.entity.PermissionEntity">
                   <id property="id" column="permission_id"/>
                   <result property="permissionName" column="permission_name"/>
               </collection>
           </collection>
       </resultMap>
       <select id="findByPhone" parameterType="String" resultMap="userMap">
           select u.*, r.role_name, p.id as permission_id, p.permission_name
           from users u
                    join roles r on u.role_id=r.id
                    join role_permission rp on r.id = rp.role_id
                    join permission p on p.id = rp.permission_id
           where phone=#{phone};
       </select>
   </mapper>
   ```
3. 在测试类中加一个测试函数，并将userLoginDao注入
   ```java
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
   ```
4. 运行这个测试方法
   输出如下
   ![在这里插入图片描述](https://img-blog.csdnimg.cn/406aa89f6be84179bc00227bf957f075.png)
### 2.2.6 创建UserService
1. 创建`com.liang.modules.sys.service`包
2. 创建`com.liang.modules.sys.service.UserService`接口和`com.liang.modules.sys.service.impl.UserServiceImpl`实现类
3. 内容分别如下
   ```java
   public interface UserService {
       UserVOEntity findByPhone(String phone);
   }
   ```
   ```java
   @Service
   public class UserServiceImpl implements UserService {
   
       @Autowired
       private UserLoginDao userLoginDao;
   
       @Override
       public UserVOEntity findByPhone(String phone) {
           return userLoginDao.findByPhone(phone);
       }
   }
   ```
4. 同理你也可以使用测试类对写的service层作一个测试
   ```java
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
   ```


## 2.3 Shiro验证
### 2.3.1 添加Shiro相关依赖
pom.xml中添加
```xml
        <!--shiro 配置-->
        <dependency>
            <groupId>org.apache.shiro</groupId>
            <artifactId>shiro-spring-boot-web-starter</artifactId>
            <version>1.7.1</version>
        </dependency>

        <!--模板引擎thymeleaf使用shiro权限对组件进行显示控制-->
        <dependency>
            <groupId>com.github.theborakompanioni</groupId>
            <artifactId>thymeleaf-extras-shiro</artifactId>
            <version>2.0.0</version>
        </dependency>
```
### 2.3.2 创建UserRealm
创建`com.liang.modules.sys.shiro.UserRealm`类
暂时重写认证方法，主要内容为通过token获取到网页传来的username（其实为手机号）与密码加盐后生成编码，即内容暂时为
```java
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken userToken = (UsernamePasswordToken) authenticationToken;
        UserVOEntity user = userService.findByPhone(userToken.getUsername());
        if (user==null){
            throw new UnknownAccountException("该手机号不存在!");
        } else {
            // 以手机号作为盐值进行MD5加盐
            ByteSource salt = ByteSource.Util.bytes(user.getPhone());
            return new SimpleAuthenticationInfo(user, user.getPassword(),  salt, this.getName());
        }
    }
}
```
### 2.3.3 创建ShiroConfig
创建`com.liang.modules.sys.shiro.ShiroConfig`
```java
@Configuration
public class ShiroConfig {

    /**
     * 密码校验规则 HashedCredentialsMatcher
     * 这个Bean自动装载到Spring中，当登录认证的时候自动使用这种方式对密码进行编码，因为首先密码不会在数据库中明文保存
     */
    @Bean("hashedCredentialsMatcher")
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        //指定加密方式为MD5
        credentialsMatcher.setHashAlgorithmName("MD5");
        //加密次数
        credentialsMatcher.setHashIterations(1024);
        credentialsMatcher.setStoredCredentialsHexEncoded(true);
        return credentialsMatcher;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(
            @Qualifier("defaultWebSecurityManager") WebSecurityManager securityManager
    ){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(securityManager);   // 设置安全管理器
        // 设置登录url映射
        bean.setLoginUrl("login");
        // 设置未授权时的跳转的请求
        bean.setUnauthorizedUrl("/");
        // 添加shiro的内置过滤器
        /*
            anon: 无需认证就可以登录
            authc:必须认证才能登录
            user: 必须拥有“记住我”这个功能
            perms:拥有对某个资源的权限才能访问
            role:拥有某个角色才能访问
         */
        LinkedHashMap<String, String> filterMap = new LinkedHashMap<>();    //使用LinkedHashMap可以保证顺序 以便 /** anon在最后过滤
        // 权限授权,访问url需要权限,支持通配符
        filterMap.put("/", "anon");
        filterMap.put("/user", "authc");    // authc --   认证(登录)才能使用
        filterMap.put("/editor", "roles[admin]");
        filterMap.put("/SuperAdmin", "roles[admin]");
        filterMap.put("/druid/**", "anon");
        filterMap.put("/**", "anon");
        bean.setFilterChainDefinitionMap(filterMap);
        return bean;
    }
    //2. 获取安全管理器
    @Bean(name = "defaultWebSecurityManager")
    public DefaultWebSecurityManager defaultWebSecurityManager(
            @Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);    //注入
        return securityManager;
    }
    //  1.定义userRealm进springboot组件 并配置认证加密方式
    @Bean(name="userRealm")
    public UserRealm userRealm(){
        UserRealm userRealm = new UserRealm();
        userRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return userRealm;
    }
}
```
### 2.3.4 创建Json返回类
创建`com.liang.common.utils.JsonResult`类
```java
@Data
@AllArgsConstructor
public class JsonResult {
    private Integer status; //业务相应状态
    private String msg;     //响应消息
    private Object data;    //响应数据
}
```
### 2.3.5 创建LoginController
创建com.liang.modules.sys.controller.LoginController
该部分代码主要完成登陆的验证跳转，具体流程可看后面的流程分析

```java
@RestController
public class LoginController {

    @GetMapping("loginUser")
    public JsonResult loginUser(@RequestParam("phone") String phone,
                                @RequestParam("password") String password,
                                HttpSession session){
        UsernamePasswordToken token = new UsernamePasswordToken(phone, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            UserVOEntity user = (UserVOEntity) subject.getPrincipal();
            user.setPassword("");
            session.setAttribute("user", user);
            return new JsonResult(200, "ok", null);
        } catch (AuthenticationException e){
            return new JsonResult(500, "用户名或密码错误", null);
        }
    }
}
```
### 2.3.6 MD5加盐生成密码并保存数据库
创建类
```java
public class ShiroMD5 {
    public static Object MD5(String phone, String password){
        // 与UserRealm中的认证方法一样，以手机号作为盐值进行MD5加盐
        ByteSource salt = ByteSource.Util.bytes(phone);

        // 参数分别是加密方式、待加密串(密码)、盐、加密次数
        // 这里的加密方式和次数要与ShiroConfig中我们写的hashedCredentialsMatcher一致
        return new SimpleHash("MD5", password, salt, 1024);
    }

    public static void main(String[] args) {
        // 保存密码到数据库的时候，可以将手机号、密码输入进来，这将生成一个加密后的字符串，
        // 将生成的加密字符串保存至数据库即可，下次登陆时将使用加密串进行核验
        System.out.println(MD5("12345678910", "123456"));
    }
}
```
运行main函数，我得到的是`f878b04f4dcf4610626327d0630fc81f`
在博客使用的数据库中执行如下指令更新数据库
```sql
update users
set password='f878b04f4dcf4610626327d0630fc81f'
where phone='12345678910';
```


### 2.3.7 更改login.js的验证
这里由于我们使用的手机号是12345678910，其实是没有这种12开头规范的手机号，我们将`resources/static/style/js/login.js`中的myreg正则表达式更改为可以匹配我们设定的手机号的
即将log函数中这个
`var myreg = /^(((13[0-9]{1})|(14[0-9]{1})|(17[0]{1})|(15[0-3]{1})|(15[5-9]{1})|(18[0-9]{1}))+\d{8})$/;`
改为
` var myreg = /^(((12[0-9]{1})|(13[0-9]{1})|(14[0-9]{1})|(17[0]{1})|(15[0-3]{1})|(15[5-9]{1})|(18[0-9]{1}))+\d{8})$/;`
### 2.3.8 运行测试
我在做到这里的时候出现了依赖错误，具体情况是程序报红但点进去后又不爆红了，不爆红后点运行，出现org.apache.shiro.spring.web不存在（如下图），但点进程序段又没爆红，最后是通过配置使用其他maven解决的，没出现问题可以继续往后进行
![在这里插入图片描述](https://img-blog.csdnimg.cn/70bc1efdff904e6b9d981cdbf7539667.png)
运行主启动类，即`com.liang.TestBlog01Application`
输入网址`http://localhost:8080/`

输入手机12345678910  
输入密码，先随机输入一个错误的密码，例如123123，登录  
提示密码错误  
![在这里插入图片描述](https://img-blog.csdnimg.cn/ddc60ed373a14f4baa946c7d81c52a26.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBA5rSq5Z-O5biD6KGj,size_20,color_FFFFFF,t_70,g_se,x_16)

再输入123456，跳转到另外一个界面，并且浏览器地址栏显示为`http://localhost:8080/lasturl`，证明代码到此就完成了登陆的认证操作
![在这里插入图片描述](https://img-blog.csdnimg.cn/294fcb3e8b304089b0cb80f82fb4eefa.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBA5rSq5Z-O5biD6KGj,size_20,color_FFFFFF,t_70,g_se,x_16)

## 2.3.5 分析
# 三、界面完善
## 3.1 静态文件
### 3.1.1 引入index页面
1. 从项目源码中的index.html导入至`src/main/resources/templates/index.html`
2. 注释掉以下三个位置的div

```html
# 注释掉这些
<div th:replace="lunbo :: lunbo"></div>	
<div th:replace="left :: left"></div>
<div th:replace="aside :: aside"></div>
```

### 3.1.2 引入lasturl.html页面
从项目源码中的lasturl.html导入至`src/main/resources/templates/lasturl.html`
### 3.1.3 导入lastUrl.js
导入`src/main/resources/static/style/js/lastUrl.js`

## 3.2 创建HomeController类
1. 将之前创建的TestController类删除
2. 创建com.liang.modules.sys.controller.HomeController
   内容如下
   ```java
     /**
     * @description 跳转至首页
     */
   @Controller
   public class HomeController {
       @RequestMapping({"/", "/index"})
       public String index(){
           return "index";
       }
   }
   
    /**
     * @description 跳转至登陆页面，并保存跳转前的页面位置lastUrl
     */
   @GetMapping("login")
   public String login(HttpServletRequest request){
       String lastUrl = request.getHeader("Referer");// 获取从哪里点进来的
       if (StringUtils.isEmpty(lastUrl)){
           return "login";
       }
       if (lastUrl.contains("findPwd") ||
           lastUrl.contains("register") ||
           lastUrl.contains("login")){
           //若为注册、找回密码等界面进的登陆连接则删除lastUrl属性，这样就可以在登陆完成时不会又重新跳转回注册、找回密码等链接
           request.getSession().removeAttribute("lastUrl");
       } else {
           //保存跳转页面之前的url
           request.getSession().setAttribute("lastUrl", lastUrl);
       }
       return "login";
   }

    /**
     * @description 跳转到index.html或lasturl.html，保存存储的链接到response头
     */
   @GetMapping("lasturl")
   public String lastUrl(HttpServletRequest request, HttpServletResponse response){
       System.out.println("进入了lastUrl");
       String lastUrl = (String) request.getSession().getAttribute("lastUrl");
       if (StringUtils.isEmpty(lastUrl)){
           System.out.println("index ==> 1");
           System.out.println(lastUrl);
           return "index";
       } else {
           response.setHeader("lastUrl", lastUrl);
           System.out.println("index ==> 2");
           System.out.println(lastUrl);
           return "lasturl";
       }
   }
   ```
## 3.3 测试与分析
### 3.3.1 测试
运行未正常的，可查看`target中`是否有新添加的静态文件，如没有可以先将`target`删除重新编译生成  
输入http://localhost:8080/显示如下，点击登陆，输入手机和密码，登陆成功后将正常返回至首页
![在这里插入图片描述](https://img-blog.csdnimg.cn/d33e216a7c4c46dd99d653e7266b5c70.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBA5rSq5Z-O5biD6KGj,size_20,color_FFFFFF,t_70,g_se,x_16)
### 3.3.2 分析
登录后未显示登录用户名，仍然显示登陆和注册两个按钮，这不是我们所需要的，这是由于我们还没做授权，下一步将做授权

# 四、授权
## 4.1 授权设置
### 4.1.1 重写授权方法
对`com.liang.modules.sys.shiro.UserRealm`类中的`doGetAuthorizationInfo`授权方法重写，之前我们重写的是认证方法

```java
     /**
      * @method  授权方法
      */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取用户(前期认证已经加入进去了)
        UserVOEntity user = (UserVOEntity) SecurityUtils.getSubject().getPrincipal();
        Set<RoleVOEntity> roles = user.getRoles();
        List<String> roleNameList = new ArrayList<>();
        List<String> permissionList = new ArrayList<>();
        for (RoleVOEntity role :
                roles) {
            roleNameList.add(role.getRoleName());   // 添加角色名称
            for (PermissionEntity permission:
                 role.getPermissionSet()) {
                permissionList.add(permission.getPermissionName()); // 添加权限名称
            }
        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();     // 授权
        info.addStringPermissions(permissionList);
        info.addRoles(roleNameList);
        return info;
    }
```
### 4.1.2 shiro授权按钮显示配置
在`com.liang.modules.sys.shiro.ShiroConfig`中添加一个方法

```java
    // Shiro控制ThymeLeaf界面按钮根据授权信息是否显示
    @Bean
    public ShiroDialect getShiroDialect(){
        return new ShiroDialect();
    }
```

## 4.2 测试及分析
### 4.2.1 测试
同理，运行，输入网址、登录，登录完成后上方的登录和注册按钮消失并显示为登录用户的名称，如图所示
![在这里插入图片描述](https://img-blog.csdnimg.cn/af593dd3a3a84880944c8002b6b14755.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBA5rSq5Z-O5biD6KGj,size_20,color_FFFFFF,t_70,g_se,x_16)
### 4.2.1 分析
这里能做到根据授权信息决定是否显示登录、注册按钮的原因是huml中shiro web的支持，shiro标签根据当前的授权信息，调整前端页面标签的显示  
例如可以查看header.html文件中，注册按钮的一段html程序，当未认证的时候即`shiro:notAuthenticated=""`，标签内的将会显示
```html
<div class="am-topbar-right" shiro:notAuthenticated="">
    <a href="/register" class="am-btn am-btn-primary am-topbar-btn am-btn-sm"
       style="color: white">注册</a>
</div>
```
