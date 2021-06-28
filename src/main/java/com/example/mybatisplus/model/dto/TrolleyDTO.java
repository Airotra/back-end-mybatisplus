package com.example.mybatisplus.model.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

@Data
public class TrolleyDTO {
    private Integer pageNo = 1;
    private Integer pageSize = 10;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id = 0l;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long goodsid = 0l;
    private Integer goodsnumber = 0;
}
