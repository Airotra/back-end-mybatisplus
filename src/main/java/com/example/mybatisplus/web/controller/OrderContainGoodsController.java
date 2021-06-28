package com.example.mybatisplus.web.controller;

import com.example.mybatisplus.model.dto.OrderGoodsDTO;
import com.example.mybatisplus.model.vo.OrderContainGoodsVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.mybatisplus.common.JsonResponse;
import com.example.mybatisplus.service.OrderContainGoodsService;
import com.example.mybatisplus.model.domain.OrderContainGoods;

import javax.servlet.http.HttpServletResponse;
import java.util.List;


/**
 *
 *  前端控制器
 *
 *
 * @author lxp
<<<<<<< Updated upstream
 * @since 2021-06-27
=======
 * @since 2021-06-26
>>>>>>> Stashed changes
 * @version v1.0
 */
@Controller
@RequestMapping("/api/orderContainGoods")
public class OrderContainGoodsController {

    private final Logger logger = LoggerFactory.getLogger( OrderContainGoodsController.class );

    @Autowired
    private OrderContainGoodsService orderContainGoodsService;

    /**
    * 描述：根据Id 查询
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getById(@PathVariable("id") Long id)throws Exception {
        OrderContainGoods  orderContainGoods =  orderContainGoodsService.getById(id);
        return JsonResponse.success(orderContainGoods);
    }

    /**
    * 描述：根据Id删除
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public JsonResponse deleteById(@PathVariable("id") Long id) throws Exception {
        orderContainGoodsService.removeById(id);
        return JsonResponse.success(null);
    }


    /**
    * 描述：根据Id 更新
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public JsonResponse updateOrderContainGoods(@PathVariable("id") Long  id,OrderContainGoods  orderContainGoods) throws Exception {
        orderContainGoods.setOrderId(id);
        orderContainGoodsService.updateById(orderContainGoods);
        return JsonResponse.success(null);
    }


    /**
    * 描述:创建OrderContainGoods
    *
    */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse create(@RequestBody OrderContainGoods  orderContainGoods) throws Exception {
        orderContainGoodsService.save(orderContainGoods);
        return JsonResponse.success(orderContainGoods);
    }

    @PostMapping("/insertGoodsByList")
    @ResponseBody
    public JsonResponse insertGoodsByList(@RequestBody List<OrderGoodsDTO> goodsDetails, HttpServletResponse httpServletResponse){
        httpServletResponse.setHeader("Access-Control-Allow-Origin","*");
        orderContainGoodsService.InsertGoods(goodsDetails);
        return JsonResponse.success(null);
    }
}

