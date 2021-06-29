package com.example.mybatisplus.model.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

@Data
public class CommentDTO {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long goodsId;
    private Integer commentClass;
    private Integer pageNo = 1;
    private Integer pageSize = 10;
    private boolean timeDesc = false;
}
