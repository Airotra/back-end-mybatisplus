package com.example.mybatisplus.mapper;

import com.example.mybatisplus.model.domain.Goods;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lxp
 * @since 2021-06-17
 */
public interface GoodsMapper extends BaseMapper<Goods> {

    void deleteGoodsByIds(@Param("ids") List<Long> ids);
}
