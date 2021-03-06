package com.example.mybatisplus.service.impl;

import com.example.mybatisplus.model.domain.Goods;
import com.example.mybatisplus.mapper.GoodsMapper;
import com.example.mybatisplus.service.GoodsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lxp
 * @since 2021-06-17
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {

    @Override
    public void deleteGoodsByIds(List<Long> ids) {
        baseMapper.deleteGoodsByIds(ids);
    }
}
