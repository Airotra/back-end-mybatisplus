-- 修改goods表的字符集为utf-8 以支持中文 
alter table goods convert to character set utf8;

-- 修改goods的time字段为datetime
alter table goods modify column time datetime;