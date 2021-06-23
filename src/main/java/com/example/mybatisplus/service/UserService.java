package com.example.mybatisplus.service;

import com.example.mybatisplus.model.domain.Trolley;
import com.example.mybatisplus.model.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mybatisplus.model.vo.UserVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lxp
 * @since 2021-06-19
 */
public interface UserService extends IService<User> {

    UserVo getAddr(Long id);
}
