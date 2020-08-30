--用于测试mybatis的mysql数据库
show databases;
use qilvbin;
create table user (
    id int(11) not null auto_increment,
    username varchar(32) not null comment '用户名称',
    birthday datetime default null comment '生日',
    sex char(1) default null comment '性别',
    address varchar(256) default null comment '地址',
    primary key(id)
) ENGINE = InnoDB default charset = utf8;

insert into user(id,username,birthday,sex,address) values(41,'老王','2020-08-20 20:48:50','男','云南');
insert into user(id,username,birthday,sex,address) values(26,'老祁','2020-08-28 22:25:13','男','四川');
select * from user;
select  * from user where id = 26;

rollback ;