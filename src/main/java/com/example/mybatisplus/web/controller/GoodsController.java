package com.example.mybatisplus.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.mybatisplus.common.JsonResponse;
import com.example.mybatisplus.service.GoodsService;
import com.example.mybatisplus.model.domain.Goods;


/**
 *
 *  前端控制器
 *
 *
 * @author lxp
 * @since 2021-06-17
 * @version v1.0
 */
@Controller
@RequestMapping("/api/goods")
public class GoodsController {

    private final Logger logger = LoggerFactory.getLogger( GoodsController.class );

    @Autowired
    private GoodsService goodsService;

    /**
    * 描述：根据Id 查询
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getById(@PathVariable("id") Long id)throws Exception {
        Goods  goods =  goodsService.getById(id);
        return JsonResponse.success(goods);
    }

    /**
    * 描述：根据Id删除
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public JsonResponse deleteById(@PathVariable("id") Long id) throws Exception {
        goodsService.removeById(id);
        return JsonResponse.success(null);
    }


    /**
    * 描述：根据Id 更新
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public JsonResponse updateGoods(@PathVariable("id") Long  id,Goods  goods) throws Exception {
        goods.setGoodsId(id);
        goodsService.updateById(goods);
        return JsonResponse.success(null);
    }


    /**
     * 描述:创建Goods
     * 只接受json格式的数据
     * 必要的字段不能少
     * 时间类型为localDate 字符串格式为 "2014-01-01 00:00:00"
    */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse create(@RequestBody Goods  goods) throws Exception {
        System.out.println(goods.getTime());
        goodsService.save(goods);
        return JsonResponse.success(null);
    }
}

