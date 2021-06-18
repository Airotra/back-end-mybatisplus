/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2021/6/17 18:26:52                           */
/*==============================================================*/


drop table if exists admin;

drop table if exists admin_comment_delete;

drop table if exists admin_goods_manage;

drop table if exists admin_order_manage;

drop table if exists adress;

drop table if exists goods;

drop table if exists goods_comment;

drop table if exists order_contain_goods;

drop table if exists order_list;

drop table if exists trolley;

drop table if exists trolley_contain_goods;

drop table if exists user;

/*==============================================================*/
/* Table: admin                                                 */
/*==============================================================*/
create table admin
(
   admin_id             bigint not null,
   admin_account        varchar(11) not null,
   admin_password       varchar(15) not null,
   primary key (admin_id)
);

alter table admin comment '管理员表';

/*==============================================================*/
/* Table: admin_comment_delete                                  */
/*==============================================================*/
create table admin_comment_delete
(
   admin_id             bigint not null,
   comment_id           bigint not null,
   primary key (admin_id, comment_id)
);

/*==============================================================*/
/* Table: admin_goods_manage                                    */
/*==============================================================*/
create table admin_goods_manage
(
   goods_id             bigint not null,
   admin_id             bigint not null,
   primary key (goods_id, admin_id)
);

/*==============================================================*/
/* Table: admin_order_manage                                    */
/*==============================================================*/
create table admin_order_manage
(
   order_id             bigint not null,
   admin_id             bigint not null,
   primary key (order_id, admin_id)
);

/*==============================================================*/
/* Table: adress                                                */
/*==============================================================*/
create table adress
(
   adress_id            bigint not null,
   user_id              bigint,
   nation               varchar(1024) not null,
   provice              varchar(1024) not null,
   city                 varchar(1024) not null,
   district             varchar(1024) not null,
   addr                 varchar(1024) not null,
   primary key (adress_id)
);

alter table adress comment '地址表';

/*==============================================================*/
/* Table: goods                                                 */
/*==============================================================*/
create table goods
(
   goods_id             bigint not null,
   category             int not null,
   price                double not null,
   store                int not null,
   time                 date not null,
   description          varchar(1024) not null,
   picture              varchar(50) not null,
   purchase_times       int not null,
   side_dec_1           varchar(1024),
   side_dec_2           varchar(1024),
   side_dec_3           varchar(1024),
   primary key (goods_id)
);

/*==============================================================*/
/* Table: goods_comment                                         */
/*==============================================================*/
create table goods_comment
(
   comment_id           bigint not null,
   goods_id             bigint,
   user_id              bigint,
   comment              varchar(1024),
   class                int not null,
   primary key (comment_id)
);

alter table goods_comment comment '商品评价表';

/*==============================================================*/
/* Table: order_contain_goods                                   */
/*==============================================================*/
create table order_contain_goods
(
   order_id             bigint not null,
   goods_id             bigint not null,
   primary key (order_id, goods_id)
);

/*==============================================================*/
/* Table: order_list                                            */
/*==============================================================*/
create table order_list
(
   order_id             bigint not null,
   adress_id            bigint,
   user_id              bigint,
   transport_number     varchar(50),
   get_by_self          bool not null,
   paid                 bool not null,
   order_status         int not null,
   primary key (order_id)
);

alter table order_list comment '订单表';

/*==============================================================*/
/* Table: trolley                                               */
/*==============================================================*/
create table trolley
(
   trolley_id           bigint not null,
   primary key (trolley_id)
);

/*==============================================================*/
/* Table: trolley_contain_goods                                 */
/*==============================================================*/
create table trolley_contain_goods
(
   trolley_id           bigint not null,
   goods_id             bigint not null,
   primary key (trolley_id, goods_id)
);

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   user_id              bigint not null,
   trolley_id           bigint,
   nick_ame             varchar(20) not null,
   phone_number         varchar(11) not null,
   password             varchar(15) not null,
   point                int not null,
   avatar               varchar(50),
   primary key (user_id)
);

alter table user comment '用户表';

alter table admin_comment_delete add constraint FK_admin_comment_delete foreign key (admin_id)
      references admin (admin_id) on delete restrict on update restrict;

alter table admin_comment_delete add constraint FK_admin_comment_delete2 foreign key (comment_id)
      references goods_comment (comment_id) on delete restrict on update restrict;

alter table admin_goods_manage add constraint FK_admin_goods_manage foreign key (goods_id)
      references goods (goods_id) on delete restrict on update restrict;

alter table admin_goods_manage add constraint FK_admin_goods_manage2 foreign key (admin_id)
      references admin (admin_id) on delete restrict on update restrict;

alter table admin_order_manage add constraint FK_admin_order_manage foreign key (order_id)
      references order_list (order_id) on delete restrict on update restrict;

alter table admin_order_manage add constraint FK_admin_order_manage2 foreign key (admin_id)
      references admin (admin_id) on delete restrict on update restrict;

alter table adress add constraint FK_user_adress_has foreign key (user_id)
      references user (user_id) on delete restrict on update restrict;

alter table goods_comment add constraint FK_comment foreign key (user_id)
      references user (user_id) on delete restrict on update restrict;

alter table goods_comment add constraint FK_goods_comment_has foreign key (goods_id)
      references goods (goods_id) on delete restrict on update restrict;

alter table order_contain_goods add constraint FK_order_contain_goods foreign key (order_id)
      references order_list (order_id) on delete restrict on update restrict;

alter table order_contain_goods add constraint FK_order_contain_goods2 foreign key (goods_id)
      references goods (goods_id) on delete restrict on update restrict;

alter table order_list add constraint FK_order_adress_has foreign key (adress_id)
      references adress (adress_id) on delete restrict on update restrict;

alter table order_list add constraint FK_user_order_manage foreign key (user_id)
      references user (user_id) on delete restrict on update restrict;

alter table trolley_contain_goods add constraint FK_trolley_contain_goods foreign key (trolley_id)
      references trolley (trolley_id) on delete restrict on update restrict;

alter table trolley_contain_goods add constraint FK_trolley_contain_goods2 foreign key (goods_id)
      references goods (goods_id) on delete restrict on update restrict;

alter table user add constraint FK_add foreign key (trolley_id)
      references trolley (trolley_id) on delete restrict on update restrict;

