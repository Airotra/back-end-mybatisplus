package com.example.mybatisplus.web.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplus.model.dto.GoodsDTO;
import com.example.mybatisplus.model.dto.TrolleyContainsGoodsDTO;
import com.example.mybatisplus.model.dto.TrolleyDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.mybatisplus.common.JsonResponse;
import com.example.mybatisplus.service.TrolleyContainGoodsService;
import com.example.mybatisplus.model.domain.TrolleyContainGoods;

import javax.servlet.http.HttpServletResponse;


/**
 *
 *  前端控制器
 *
 *
 * @author lxp
 * @since 2021-06-22
 * @version v1.0
 */
@Controller
@RequestMapping("/api/trolleyContainGoods")
public class TrolleyContainGoodsController {

    private final Logger logger = LoggerFactory.getLogger( TrolleyContainGoodsController.class );

    @Autowired
    private TrolleyContainGoodsService trolleyContainGoodsService;

    /**
    * 描述：根据Id 查询
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getById(@PathVariable("id") Long id)throws Exception {
        TrolleyContainGoods  trolleyContainGoods =  trolleyContainGoodsService.getById(id);
        return JsonResponse.success(trolleyContainGoods);
    }

    /**
    * 描述：根据Id删除
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public JsonResponse deleteById(@PathVariable("id") Long id) throws Exception {
        trolleyContainGoodsService.removeById(id);
        return JsonResponse.success(null);
    }


    /**
    * 描述：根据Id 更新
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public JsonResponse updateTrolleyContainGoods(@PathVariable("id") Long  id,TrolleyContainGoods  trolleyContainGoods) throws Exception {
        trolleyContainGoods.setId(id);
        trolleyContainGoodsService.updateById(trolleyContainGoods);
        return JsonResponse.success(null);
    }


    /**
    * 描述:创建TrolleyContainGoods
    *
    */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse create(@RequestBody TrolleyContainGoods  trolleyContainGoods) throws Exception {
        trolleyContainGoodsService.save(trolleyContainGoods);
        return JsonResponse.success(null);
    }

    // 获取购物车内商品信息
    @GetMapping("/getTrolleyGoods")
    @ResponseBody
    public JsonResponse getTrolleyGoods(TrolleyDTO trolleyDTO,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        QueryWrapper<TrolleyContainGoods> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(TrolleyContainGoods::getId,trolleyDTO.id);
        Page<TrolleyContainGoods> page = trolleyContainGoodsService.page(new Page<>(trolleyDTO.getPageNo(),trolleyDTO.getPageSize()),wrapper);
        return JsonResponse.success(page);
    }


    // 删除购物车中商品
    @GetMapping("/removeGoods")
    @ResponseBody
    public JsonResponse removeGoods(TrolleyDTO trolleyDTO,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        QueryWrapper<TrolleyContainGoods> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(TrolleyContainGoods::getId,trolleyDTO.id).eq(TrolleyContainGoods::getGoodsId, trolleyDTO.goodsid);
        boolean remove = trolleyContainGoodsService.remove(wrapper);
        return JsonResponse.success(remove);
    }

    // 更新购物车中商品信息
    @GetMapping("/updateGoods")
    @ResponseBody
    public JsonResponse updateGoods(TrolleyDTO trolleyDTO,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        QueryWrapper<TrolleyContainGoods> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(TrolleyContainGoods::getGoodsId, trolleyDTO.goodsid).eq(TrolleyContainGoods::getId,trolleyDTO.id);

        TrolleyContainGoods trolleyContainGoods = new TrolleyContainGoods();
        trolleyContainGoods.setGoodsNumber(trolleyDTO.goodsnumber);
        boolean update = trolleyContainGoodsService.update(trolleyContainGoods, wrapper);

        return JsonResponse.success(update);
    }

    /*
    * syan
    * 根据trolleyId和goodsId查询单条记录
    */
    @PostMapping("/getByFKs")
    @ResponseBody
    public JsonResponse getByFKs(@RequestBody TrolleyContainsGoodsDTO trolleyContainsGoodsDTO,HttpServletResponse httpServletResponse){
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
        TrolleyContainGoods trolleyContainGoods = trolleyContainGoodsService.getByFKs(trolleyContainsGoodsDTO.getId(),
                trolleyContainsGoodsDTO.getGoodsId());
        return JsonResponse.success(trolleyContainGoods);
    }
    /*
    * syan
    * 更新购物车中商品的数量
    */
    @PostMapping("/updateTrolleyContainGoodsNumber")
    @ResponseBody
    public JsonResponse updateTrolleyContainGoods(@RequestBody TrolleyContainGoods trolleyContainGoods,
                                                  HttpServletResponse httpServletResponse){
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
        trolleyContainGoodsService.updateTrolleyContainGoodsNumber(trolleyContainGoods);
        return JsonResponse.success(null);
    }
}

