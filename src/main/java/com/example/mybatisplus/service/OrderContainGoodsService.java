package com.example.mybatisplus.service;

import com.example.mybatisplus.model.domain.OrderContainGoods;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mybatisplus.model.dto.OrderGoodsDTO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lxp
 * @since 2021-06-26
 */
public interface OrderContainGoodsService extends IService<OrderContainGoods> {
    void InsertGoods(List<OrderGoodsDTO> goodsDetails);
}
