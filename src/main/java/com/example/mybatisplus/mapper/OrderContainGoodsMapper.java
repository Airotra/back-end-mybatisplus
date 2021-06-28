package com.example.mybatisplus.mapper;

import com.example.mybatisplus.model.domain.OrderContainGoods;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mybatisplus.model.dto.OrderGoodsDTO;

import java.util.List;
import com.example.mybatisplus.model.vo.OrderContainGoodsVO;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lxp
 * @since 2021-06-26
 */
public interface OrderContainGoodsMapper extends BaseMapper<OrderContainGoods> {

    void InsertGoods(List<OrderGoodsDTO> goodsDetails);
}
