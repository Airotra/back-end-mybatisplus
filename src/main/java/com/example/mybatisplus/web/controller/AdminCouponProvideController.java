package com.example.mybatisplus.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.mybatisplus.common.JsonResponse;
import com.example.mybatisplus.service.AdminCouponProvideService;
import com.example.mybatisplus.model.domain.AdminCouponProvide;


/**
 *
 *  前端控制器
 *
 *
 * @author lxp
 * @since 2021-06-25
 * @version v1.0
 */
@Controller
@RequestMapping("/api/adminCouponProvide")
public class AdminCouponProvideController {

    private final Logger logger = LoggerFactory.getLogger( AdminCouponProvideController.class );

    @Autowired
    private AdminCouponProvideService adminCouponProvideService;

    /**
    * 描述：根据Id 查询
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getById(@PathVariable("id") Long id)throws Exception {
        AdminCouponProvide  adminCouponProvide =  adminCouponProvideService.getById(id);
        return JsonResponse.success(adminCouponProvide);
    }

    /**
    * 描述：根据Id删除
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public JsonResponse deleteById(@PathVariable("id") Long id) throws Exception {
        adminCouponProvideService.removeById(id);
        return JsonResponse.success(null);
    }


    /**
    * 描述：根据Id 更新
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public JsonResponse updateAdminCouponProvide(@PathVariable("id") Long  id,AdminCouponProvide  adminCouponProvide) throws Exception {
        adminCouponProvide.setCouponId(id);
        adminCouponProvideService.updateById(adminCouponProvide);
        return JsonResponse.success(null);
    }


    /**
    * 描述:创建AdminCouponProvide
    *
    */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse create(@RequestBody AdminCouponProvide  adminCouponProvide) throws Exception {
        adminCouponProvideService.save(adminCouponProvide);
        return JsonResponse.success(null);
    }
}

