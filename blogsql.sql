show databases ;
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


# 联表查看信息
select u.*, r.role_name, rpn.permission_id, p.permission_name
from users u
join roles r on u.role_id = r.id
join role_permission rpn on r.id = rpn.role_id
join permission p on rpn.permission_id = p.id;









