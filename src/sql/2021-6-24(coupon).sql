/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2021/6/24 12:24:33                           */
/*==============================================================*/

drop table if exists admin_coupon_provide;

drop table if exists coupon;

drop table if exists user_coupon_has;


/*==============================================================*/
/* Table: admin_coupon_provide                                  */
/*==============================================================*/
create table admin_coupon_provide
(
   admin_id             bigint not null,
   coupon_id            bigint not null,
   primary key (admin_id, coupon_id)
);

/*==============================================================*/
/* Table: coupon                                                */
/*==============================================================*/
create table coupon
(
   coupon_id            bigint not null,
   amount               int not null,
   quantity             int,
   primary key (coupon_id)
);


/*==============================================================*/
/* Table: user_coupon_has                                       */
/*==============================================================*/
create table user_coupon_has
(
   user_id              bigint not null,
   coupon_id            bigint not null,
   primary key (user_id, coupon_id)
);

alter table admin_coupon_provide add constraint FK_admin_coupon_provide foreign key (admin_id)
      references admin (admin_id) on delete restrict on update restrict;

alter table admin_coupon_provide add constraint FK_admin_coupon_provide2 foreign key (coupon_id)
      references coupon (coupon_id) on delete restrict on update restrict;

alter table user_coupon_has add constraint FK_user_coupon_has foreign key (user_id)
      references user (user_id) on delete restrict on update restrict;

alter table user_coupon_has add constraint FK_user_coupon_has2 foreign key (coupon_id)
      references coupon (coupon_id) on delete restrict on update restrict;


-- 给用户拥有优惠券表添加优惠券数量、金额信息
ALTER TABLE user_coupon_has ADD quantity INT;
ALTER TABLE user_coupon_has ADD amount INT;

-- 给用户拥有优惠券表和优惠券表添加到期时间
ALTER TABLE coupon ADD time datetime;
ALTER TABLE user_coupon_has ADD time datetime;

