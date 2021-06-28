package com.example.mybatisplus.service.impl;

import com.example.mybatisplus.model.domain.OrderContainGoods;
import com.example.mybatisplus.mapper.OrderContainGoodsMapper;
import com.example.mybatisplus.model.dto.OrderGoodsDTO;
import com.example.mybatisplus.model.vo.OrderContainGoodsVO;
import com.example.mybatisplus.service.OrderContainGoodsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lxp
 * @since 2021-06-26
 */
@Service
public class OrderContainGoodsServiceImpl extends ServiceImpl<OrderContainGoodsMapper, OrderContainGoods> implements OrderContainGoodsService {
    @Override
    public void InsertGoods(List<OrderGoodsDTO> goodsDetails) {
        baseMapper.InsertGoods(goodsDetails);
    }
}
