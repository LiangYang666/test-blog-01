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











