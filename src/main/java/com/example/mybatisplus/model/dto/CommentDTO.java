package com.example.mybatisplus.model.dto;

import lombok.Data;

@Data
public class CommentDTO {
    private Long goodsId;
    private Integer commentClass;
    private Integer pageNo = 1;
    private Integer pageSize = 10;
    private boolean timeDesc = false;
}
