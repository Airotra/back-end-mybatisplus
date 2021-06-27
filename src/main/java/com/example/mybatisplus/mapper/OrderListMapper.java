package com.example.mybatisplus.mapper;

import com.example.mybatisplus.model.domain.OrderList;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mybatisplus.model.vo.OrderContainGoodsVO;

import java.util.List;

/**
 * <p>
 * ������ Mapper 接口
 * </p>
 *
 * @author lxp
 * @since 2021-06-25
 */
public interface OrderListMapper extends BaseMapper<OrderList> {

    List<OrderList> getOrderByUserId(Long id);

    OrderContainGoodsVO getGoods(Long id);
}
