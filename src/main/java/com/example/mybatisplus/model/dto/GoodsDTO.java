package com.example.mybatisplus.model.dto;

import lombok.Data;

@Data
public class GoodsDTO {
    private String name = "null";
    private Integer pageNo = 1;
    private Integer pageSize = 10;
    private Integer category = 0;
    //默认为价格升序，购买次数降序
    private boolean orderByPrice = true;
    private boolean orderByPurchase = true;
    private boolean PriceDesc = false;
    private boolean PurchaseDesc = true;
}
