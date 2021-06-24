package com.example.mybatisplus.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.mybatisplus.common.JsonResponse;
import com.example.mybatisplus.service.CouponService;
import com.example.mybatisplus.model.domain.Coupon;

import javax.servlet.http.HttpServletResponse;
import java.util.List;


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
@RequestMapping("/api/coupon")
public class CouponController {

    private final Logger logger = LoggerFactory.getLogger( CouponController.class );

    @Autowired
    private CouponService couponService;

    /**
    * 描述：根据Id 查询
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getById(@PathVariable("id") Long id)throws Exception {
        Coupon  coupon =  couponService.getById(id);
        return JsonResponse.success(coupon);
    }

    /**
    * 描述：根据Id删除
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public JsonResponse deleteById(@PathVariable("id") Long id) throws Exception {
        couponService.removeById(id);
        return JsonResponse.success(null);
    }


    /**
    * 描述：根据Id 更新
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public JsonResponse updateCoupon(@PathVariable("id") Long  id,@RequestBody Coupon  coupon) throws Exception {
        coupon.setCouponId(id);
        couponService.updateById(coupon);
        return JsonResponse.success(null);
    }


    /**
    * 描述:创建Coupon
    *
    */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse create(@RequestBody Coupon  coupon) throws Exception {
        couponService.save(coupon);
        return JsonResponse.success(null);
    }

    @RequestMapping("/getAllCoupon")
    @ResponseBody
    public JsonResponse getAllCoupon(Long id, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");

        List<Coupon> list = couponService.getAllCoupon();

        return JsonResponse.success(list);
    }
}

