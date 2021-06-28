package com.example.mybatisplus.model.dto;

import lombok.Data;

@Data
public class TrolleyDTO {
    private Integer pageNo = 1;
    private Integer pageSize = 10;
    private Long id = 0l;
    private Long goodsid = 0l;
    private Integer goodsnumber = 0;
}
