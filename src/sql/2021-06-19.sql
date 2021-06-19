-- 向goods表中增加名字字段
ALTER TABLE goods ADD COLUMN name VARCHAR(20) NOT NULL default '商品名';
