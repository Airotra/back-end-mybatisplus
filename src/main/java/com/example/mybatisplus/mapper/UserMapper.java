package com.example.mybatisplus.mapper;

import com.example.mybatisplus.model.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mybatisplus.model.vo.UserVo;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lxp
 * @since 2021-06-19
 */
public interface UserMapper extends BaseMapper<User> {

    UserVo getAddr(Long id);

    UserVo getUserCoupon(Long id);

    List getCoupon(Long id);
}
