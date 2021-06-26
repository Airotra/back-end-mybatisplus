package com.example.mybatisplus.mapper;

import com.example.mybatisplus.model.domain.TrolleyContainGoods;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lxp
 * @since 2021-06-22
 */
public interface TrolleyContainGoodsMapper extends BaseMapper<TrolleyContainGoods> {

    TrolleyContainGoods getByFKs(@Param("id") Long id,@Param("goodsId") Long goodsId);

    void updateTrolleyContainGoodsNumber(@Param("trolleyContainGoods") TrolleyContainGoods trolleyContainGoods);
}
