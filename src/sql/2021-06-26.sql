-- 修改trolleyContainGoods表的字符集为utf-8 以支持中文
alter table trolley_contain_goods convert to character set utf8;
-- 修改trolleyContainGoods表中的图片字段 长度到1024
ALTER TABLE trolley_contain_goods MODIFY Column goods_picture varchar(1024) not null;
