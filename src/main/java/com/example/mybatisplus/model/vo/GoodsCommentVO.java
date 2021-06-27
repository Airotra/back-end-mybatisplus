package com.example.mybatisplus.model.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.example.mybatisplus.model.domain.GoodsComment;
import com.example.mybatisplus.model.domain.User;
import lombok.Data;

@Data
public class GoodsCommentVO {
    private Long commentId;

    private Long goodsId;

    private Long userId;

    private String comment;

    @TableField("class")
    private Integer commentClass;

    private User user;
}
