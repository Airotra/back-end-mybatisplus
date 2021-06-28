package com.example.mybatisplus.model.dto;

import lombok.Data;

import java.util.List;


@Data
public class OrderGoodsDTO {
    private Long goodsId;
    private int goodsNumber;
    private String goodsName;
    private double goodsPrice;
    private String goodsPicture;
    private  Long orderId;
}
