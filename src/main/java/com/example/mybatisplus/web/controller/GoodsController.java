package com.example.mybatisplus.web.controller;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplus.model.domain.Admin;
import com.example.mybatisplus.model.domain.TrolleyContainGoods;
import com.example.mybatisplus.model.dto.GoodsDTO;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.mybatisplus.common.JsonResponse;
import com.example.mybatisplus.service.GoodsService;
import com.example.mybatisplus.model.domain.Goods;

import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;


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
        System.out.println(LocalDateTime.now());
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
     * 接受put请求
     * 输入非法值似乎不能进行更新 （描述可以更改为空）
     * 注意前端加限制
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public JsonResponse updateGoods(@PathVariable("id") Long  id,@RequestBody Goods  goods) throws Exception {
        goods.setGoodsId(id);
        goodsService.updateById(goods);
        return JsonResponse.success(null);
    }


    /**
     * 描述:创建Goods
     * 接受post请求
     * 只接受json格式的数据
     * 必要的字段不能少 id自动生成 类型为IdType.ASSIGN_ID
     * 时间类型为localDate 字符串格式为 "2014-01-01 00:00:00"
    */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse create(@RequestBody Goods  goods) throws Exception {
        System.out.println(goods.getTime());
        goodsService.save(goods);
        return JsonResponse.success(null);
    }

    @RequestMapping("/list")
    @ResponseBody
    public JsonResponse list(Model model,
                             @RequestParam(required = false,defaultValue = "1") Integer pageNo,
                             @RequestParam(required = false,defaultValue = "10")Integer pageSize){
        Page<Goods> page = goodsService.page(new Page<>(pageNo, pageSize));
        return JsonResponse.success(page);
    }

    @GetMapping("/listByPage")
    @ResponseBody
    public  JsonResponse list2(GoodsDTO goodsDTO, HttpServletResponse httpServletResponse){
        System.out.println(goodsDTO.getPageSize());
        httpServletResponse.setHeader("Access-Control-Allow-Origin","*");
        Page<Goods> page = goodsService.page(new Page<>(goodsDTO.getPageNo(),goodsDTO.getPageSize()));
        return  JsonResponse.success(page);
    }

    //通过id获取商品信息
    @GetMapping("/getGoods")
    @ResponseBody
    public JsonResponse getGoods(Long id, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        Goods good = goodsService.getById(id);
        return JsonResponse.success(good);
    }
    /****************************************************************/
    //设置goods的Wrapper的逻辑
    private void setGoodsWrapper(QueryWrapper<Goods> wrapper, boolean orderByPrice, boolean orderByPurchase,
                                 boolean PriceDesc, boolean PurchaseDesc){
        //按价格排序
        if(orderByPrice){
            if(PriceDesc)wrapper.lambda().select().orderByDesc(Goods::getPrice);
            else wrapper.lambda().select().orderByAsc(Goods::getPrice);
        }
        //按购买次数排序
        if(orderByPurchase){
            if(PurchaseDesc)wrapper.lambda().select().orderByDesc(Goods::getPurchaseTimes);
            else wrapper.lambda().select().orderByAsc(Goods::getPurchaseTimes);
        }

    }

}

