package com.example.mybatisplus.model.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.util.List;


@Data
public class OrderGoodsDTO {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long goodsId;
    private int goodsNumber;
    private String goodsName;
    private double goodsPrice;
    private String goodsPicture;
    @JsonSerialize(using = ToStringSerializer.class)
    private  Long orderId;
}
