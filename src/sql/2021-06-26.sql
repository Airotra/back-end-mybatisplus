-- 修改trolleyContainGoods表的字符集为utf-8 以支持中文
alter table trolley_contain_goods convert to character set utf8;
-- 修改trolleyContainGoods表中的图片字段 长度到1024
ALTER TABLE trolley_contain_goods MODIFY Column goods_picture varchar(1024) not null;

-- 修改goods_comment表的字符集为utf-8 以支持中文
alter table goods_comment convert to character set utf8;

-- 给购物车表中添加购物车中的商品数量信息
ALTER TABLE goods_comment ADD comment_time datetime;
