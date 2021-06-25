package com.example.mybatisplus.service;

import com.example.mybatisplus.model.domain.Goods;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lxp
 * @since 2021-06-17
 */
@Repository
public interface GoodsService extends IService<Goods> {

    void deleteGoodsByIds(List<Long> ids);
}
