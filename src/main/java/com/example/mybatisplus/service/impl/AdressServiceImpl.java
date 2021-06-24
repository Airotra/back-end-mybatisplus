package com.example.mybatisplus.service.impl;

import com.example.mybatisplus.model.domain.Adress;
import com.example.mybatisplus.mapper.AdressMapper;
import com.example.mybatisplus.service.AdressService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lxp
 * @since 2021-06-23
 */
@Service
public class AdressServiceImpl extends ServiceImpl<AdressMapper, Adress> implements AdressService {

}
