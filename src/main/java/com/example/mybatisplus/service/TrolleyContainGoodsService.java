package com.example.mybatisplus.service;

import com.example.mybatisplus.model.domain.TrolleyContainGoods;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lxp
 * @since 2021-06-22
 */
public interface TrolleyContainGoodsService extends IService<TrolleyContainGoods> {

    TrolleyContainGoods getByFKs(Long id, Long goodsId);
}
