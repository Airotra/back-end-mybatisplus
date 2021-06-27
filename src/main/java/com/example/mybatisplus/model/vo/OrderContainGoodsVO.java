package com.example.mybatisplus.model.vo;

import com.example.mybatisplus.model.domain.OrderContainGoods;
import com.example.mybatisplus.model.domain.OrderList;
import lombok.Data;
import java.util.List;

@Data
public class OrderContainGoodsVO extends OrderList {
    private List<OrderContainGoods> list;
}
