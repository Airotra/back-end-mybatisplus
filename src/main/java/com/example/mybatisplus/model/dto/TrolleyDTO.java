package com.example.mybatisplus.model.dto;

import lombok.Data;

@Data
public class TrolleyDTO {
    private Integer pageNo = 1;
    private Integer pageSize = 10;
    public Long id = 0l;
    public Long goodsid = 0l;
    public Integer goodsnumber = 0;
}
