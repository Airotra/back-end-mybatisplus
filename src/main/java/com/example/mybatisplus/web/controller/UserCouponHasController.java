package com.example.mybatisplus.web.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mybatisplus.model.domain.User;
import com.example.mybatisplus.model.dto.UserCouponHasDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.mybatisplus.common.JsonResponse;
import com.example.mybatisplus.service.UserCouponHasService;
import com.example.mybatisplus.model.domain.UserCouponHas;


/**
 *
 *  前端控制器
 *
 *
 * @author lxp
 * @since 2021-06-24
 * @version v1.0
 */
@Controller
@RequestMapping("/api/userCouponHas")
public class UserCouponHasController {

    private final Logger logger = LoggerFactory.getLogger( UserCouponHasController.class );

    @Autowired
    private UserCouponHasService userCouponHasService;

    /**
    * 描述：根据Id 查询
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getById(@PathVariable("id") Long id)throws Exception {
        UserCouponHas  userCouponHas =  userCouponHasService.getById(id);
        return JsonResponse.success(userCouponHas);
    }

    /**
    * 描述：根据Id删除
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public JsonResponse deleteById(@PathVariable("id") Long id) throws Exception {
        userCouponHasService.removeById(id);
        return JsonResponse.success(null);
    }


    /**
    * 描述：根据Id 更新
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public JsonResponse updateUserCouponHas(@PathVariable("id") Long  id,UserCouponHas  userCouponHas) throws Exception {
        userCouponHas.setCouponId(id);
        userCouponHasService.updateById(userCouponHas);
        return JsonResponse.success(null);
    }


    /**
    * 描述:创建UserCouponHas
    *
    */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse create(@RequestBody UserCouponHas  userCouponHas) throws Exception {
        userCouponHasService.save(userCouponHas);
        return JsonResponse.success(null);
    }

    /**
     * 描述：根据Id 更新
     *
     */
    @RequestMapping(value = "/updateUserCoupon", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse updateUserCoupon(@RequestBody UserCouponHasDTO userCouponHasDTO) throws Exception {
        QueryWrapper<UserCouponHas> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(UserCouponHas::getCouponId, userCouponHasDTO.getCouponId());
        UserCouponHas userCoupon = new UserCouponHas();
        userCoupon.setAmount(userCouponHasDTO.getAmount());
        userCoupon.setTime(userCouponHasDTO.getTime());
        boolean update = userCouponHasService.update(userCoupon, wrapper);

        return JsonResponse.success(update);
    }
}

