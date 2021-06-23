package com.example.mybatisplus.model.dto;

import lombok.Data;

@Data
public class TrolleyDTO {
    private Integer pageNo = 1;
    private Integer pageSize = 10;
    public Integer id = 0;
    public Integer goodsid = 0;
    public Integer goodsnumber = 0;
}
