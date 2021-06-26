package com.example.mybatisplus.service.impl;

import com.example.mybatisplus.model.domain.OrderList;
import com.example.mybatisplus.mapper.OrderListMapper;
import com.example.mybatisplus.service.OrderListService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * ������ 服务实现类
 * </p>
 *
 * @author lxp
 * @since 2021-06-25
 */
@Service
public class OrderListServiceImpl extends ServiceImpl<OrderListMapper, OrderList> implements OrderListService {

}
