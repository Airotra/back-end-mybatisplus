-- 给购物车表中添加购物车中的商品数量信息
ALTER TABLE trolley_contain_goods ADD goods_number INT

-- 给购物车表中添加商品名称信息
ALTER TABLE trolley_contain_goods ADD goods_name VARCHAR(20) NOT NULL DEFAULT '商品名'

-- 给购物车表中添加商品价格的信息
ALTER TABLE trolley_contain_goods ADD goods_price DOUBLE

-- 给购物车添加商品图片的信息
ALTER TABLE trolley_contain_goods ADD goods_picture varchar(50)
