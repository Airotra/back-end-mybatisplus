package com.example.mybatisplus.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class GoodsDeleteDTO {
    private Long id;
    private List<Long> ids;
}
