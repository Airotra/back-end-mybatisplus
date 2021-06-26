package com.example.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import com.example.mybatisplus.model.domain.Trolley;
import com.example.mybatisplus.model.domain.User;
import com.example.mybatisplus.mapper.UserMapper;
import com.example.mybatisplus.model.vo.UserVo;
import com.example.mybatisplus.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lxp
 * @since 2021-06-19
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public UserVo getAddr(Long id) {
        return baseMapper.getAddr(id);
    }

    @Override
    public UserVo getUserCoupon(Long id) {
        return baseMapper.getUserCoupon(id);
    }

    @Override
    public List getCoupon(Long id) {
        return baseMapper.getCoupon(id);
    }

    @Override
    public User myGetById(long parseLong) {
        return baseMapper.myGetById(parseLong);
    }
}
