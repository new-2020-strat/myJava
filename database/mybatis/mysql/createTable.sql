#用于测试mybatis的mysql数据库
show databases;
use qilvbin;
#创建用户表
drop table if exists user;
create table user (
    id int(11) not null auto_increment,
    username varchar(32) not null comment '用户名称',
    birthday datetime default null comment '生日',
    sex char(1) default null comment '性别',
    address varchar(256) default null comment '地址',
    primary key(id)
) ENGINE = InnoDB default charset = utf8;
insert into user(id,username,birthday,sex,address) values(41,'老王','2020-08-20 20:48:50','男','云南');
insert into user(id,username,birthday,sex,address) values(28,'小李','2020-08-28 22:25:13','女','大理');
commit;
select * from user;
select * from user where username like '%祁%';
commit ;
#创建账户表
drop table if exists account;
create table account(
    id int(11) not null comment '编号',
    uid int(11) default null comment '用户编号',
    money double default null comment '金额',
    primary key (id),
    key FK_Reference_8 (uid),
    constraint FK_Reference_8 foreign key (uid) references user (id)
) ENGINE = InnoDB default charset = utf8;
insert into account(id, uid, money) VALUES (5,27,4500),(6,27,6500);
commit;
select * from account;
#一对多和一对一查询语句
select a.*,u.username,u.address from account a,user u where a.uid = u.id;
select a.*,u.* from account a,user u where a.uid = u.id;
select u.*,a.id aid,a.uid,a.money from user u left outer join account a on u.id=a.uid;
#创建测试多对多的角色表role
drop table if exists role;
create table role(
    id int(11) not null comment '编号',
    role_name varchar(30) default null comment '角色名称',
    role_desc varchar(60) default null comment '角色描述',
    primary key (id)
)ENGINE = InnoDB default charset = utf8;
insert into role(id, role_name, role_desc) VALUES (1,'院长','管理整个学院'),(2,'总裁','管理整个公司'),(3,'校长','管理整个学校');
commit;
select * from role;
#创建用户和角色的中间表customer_role
drop table if exists customer_role;
create table customer_role(
    cid int(11) not null comment '用户编号',
    rid int(11) not null comment '角色编号',
    primary key(cid,rid),
    key FK_Reference_10 (cid),
    key FK_Reference_9 (rid),
    constraint FK_Reference_10 foreign key(cid) references user(id),
    constraint FK_Reference_9 foreign key(rid) references role(id)
)ENGINE = InnoDB default charset = utf8;
insert into customer_role(cid, rid) VALUES (27,1),(28,2),(43,3);
insert into customer_role(cid, rid) VALUES (28,1),(43,1);
select * from customer_role;
#创建测试多对多的用户表
drop table  if exists customer;
create table customer (
    id int(11) not null auto_increment,
    username varchar(32) not null comment '用户名称',
    birthday datetime default null comment '生日',
    sex char(1) default null comment '性别',
    address varchar(256) default null comment '地址',
    primary key(id)
) ENGINE = InnoDB default charset = utf8;
insert into customer(id,username,birthday,sex,address) values(27,'老王','2020-08-20 20:48:50','男','云南');
insert into customer(id,username,birthday,sex,address) values(28,'小李','2020-08-28 22:25:13','女','大理');
insert into customer(id,username,birthday,sex,address) values(43,'老祁','2020-08-28 22:25:13','男','四川');

select * from customer;


select r.id rid,r.role_name,r.role_desc,c.* from role r
left outer join customer_role cr on r.id=cr.rid
left outer join customer c on cr.cid=c.id;

select c.*, r.id rid,r.role_name,r.role_desc from customer c
left outer join customer_role cr on c.id=cr.cid
left outer join role r on cr.rid = r.id;

#创建测试jndi的student表
drop table if exists student;
create table student(
    id int(11) not null comment '学号',
    name varchar(30) default null comment '姓名',
    sex char default null comment '性别',
    primary key (id)
)ENGINE = InnoDB default charset = utf8;
insert into student(id, name, sex) VALUES (1,'小祁','男'),(2,'小李','女');
select * from student;

drop table if exists account_spring;
create table account_spring(
    id int(11) primary key auto_increment comment '编号',
    uname varchar(40) default null comment '用户名',
    money float default null comment '金额'
) ENGINE = InnoDB default charset = utf8;

insert into account_spring(uname, money) VALUES ('老祁',1000),('老吕',500);
select * from account_spring;

use qilvbin;


#创建账户表(用于ssm整合测试)
drop table if exists account_ssm;
create table account_ssm(
    id int(11) not null comment '编号',
    name varchar(20) default null comment '用户名',
    money double default null comment '金额',
    primary key (id)
) ENGINE = InnoDB default charset = utf8;
select * from account_ssm;

insert into account_ssm(id, name, money) VALUES (1,'老祁',100),(2,'老吕',50);
select * from account_ssm;

select * from news;
drop table news;











