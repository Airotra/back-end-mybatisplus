-- 修改图片字段长度到1024
ALTER TABLE goods MODIFY Column picture varchar(1024) not null;

-- 修改头像字段长度到1024
ALTER TABLE user MODIFY Column avatar varchar(1024);
