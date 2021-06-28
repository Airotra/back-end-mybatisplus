package com.example.mybatisplus.service;

import com.example.mybatisplus.model.domain.OrderList;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mybatisplus.model.vo.OrderContainGoodsVO;

import java.util.List;

/**
 * <p>
 * ������ 服务类
 * </p>
 *
 * @author lxp
 * @since 2021-06-25
 */
public interface OrderListService extends IService<OrderList> {

    List<OrderList> getOrderByUserId(Long id);

    OrderContainGoodsVO getGoods(Long id);

    List getAllOrderList();
}
