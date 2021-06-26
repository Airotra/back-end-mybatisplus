package com.example.mybatisplus.web.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mybatisplus.model.domain.TrolleyContainGoods;
import com.example.mybatisplus.model.dto.TrolleyDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.mybatisplus.common.JsonResponse;
import com.example.mybatisplus.service.OrderListService;
import com.example.mybatisplus.model.domain.OrderList;

import javax.servlet.http.HttpServletResponse;


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
@RequestMapping("/api/orderList")
public class OrderListController {

    private final Logger logger = LoggerFactory.getLogger( OrderListController.class );

    @Autowired
    private OrderListService orderListService;

    /**
    * 描述：根据Id 查询
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getById(@PathVariable("id") Long id)throws Exception {
        OrderList  orderList =  orderListService.getById(id);
        return JsonResponse.success(orderList);
    }

    /**
    * 描述：根据Id删除
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public JsonResponse deleteById(@PathVariable("id") Long id) throws Exception {
        orderListService.removeById(id);
        return JsonResponse.success(null);
    }


    /**
    * 描述：根据Id 更新
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public JsonResponse updateOrderList(@PathVariable("id") Long  id,OrderList  orderList) throws Exception {
        orderList.setId(id);
        orderListService.updateById(orderList);
        return JsonResponse.success(null);
    }


    /**
    * 描述:创建OrderList
    *
    */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse create(@RequestBody OrderList  orderList) throws Exception {
        orderListService.save(orderList);
        return JsonResponse.success(null);
    }

    @GetMapping("/getOrder")
    @ResponseBody
    public JsonResponse removeGoods(Long id,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        OrderList order = orderListService.getById(id);
        return JsonResponse.success(order);
    }

}

