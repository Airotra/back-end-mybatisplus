package com.example.mybatisplus.web.controller;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplus.mapper.GoodsMapper;
import com.example.mybatisplus.model.domain.Admin;
import com.example.mybatisplus.model.domain.TrolleyContainGoods;
import com.example.mybatisplus.model.dto.GoodsDTO;
import com.example.mybatisplus.model.dto.GoodsDeleteDTO;
import freemarker.ext.beans.TemplateAccessible;
import com.example.mybatisplus.model.dto.GoodsDeleteDTO;
import freemarker.ext.beans.TemplateAccessible;
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
import java.sql.Array;
import java.sql.Wrapper;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.apache.logging.log4j.message.MapMessage.MapFormat.JSON;


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
/******************************************  自己写的查询  **********************************************************/

    /**
     * 描述:根据条件查询商品列表，实现了分页器和价格、人气顺序排序
     * 接受GET请求
     */
    @GetMapping("/listByPage")
    @ResponseBody
    public JsonResponse listByTypeOrderByPrice(GoodsDTO goodsDTO,HttpServletResponse httpServletResponse){
        httpServletResponse.setHeader("Access-Control-Allow-Origin","*");
        QueryWrapper<Goods> wrapper = new QueryWrapper<>();
        //name为null表示未按名字搜索
        if(!goodsDTO.getName().equals("null"))
            wrapper.lambda().like(Goods::getName,goodsDTO.getName());
        //种类为0时表示没有种类
        if(goodsDTO.getCategory()!=0)
            wrapper.lambda().eq(Goods::getCategory,goodsDTO.getCategory());
        //设置排序条件
        setGoodsWrapper(wrapper,goodsDTO.isOrderByPrice(),goodsDTO.isOrderByPurchase(),
                                        goodsDTO.isPriceDesc(),goodsDTO.isPurchaseDesc());
        //查询
        Page<Goods> page = goodsService.page(new Page<>(goodsDTO.getPageNo(),goodsDTO.getPageSize()),wrapper);
        return JsonResponse.success(page);
    }
    /**
     * 描述:按id批量删除
     * delete请求是真的垃圾，Get也是
     */

    //通过id获取商品信息
    @GetMapping("/getGoods")
    @ResponseBody
    public JsonResponse getGoods(Long id, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        Goods good = goodsService.getById(id);
        return JsonResponse.success(good);
    }
    /**
     * 描述:按id批量删除
     * delete请求是真的垃圾，Get也是
     */
    @PostMapping("/deleteGoodsByList")
    @ResponseBody
    public JsonResponse deleteGoodsByList(@RequestBody GoodsDeleteDTO goodsDeleteDTO, HttpServletResponse httpServletResponse){
        httpServletResponse.setHeader("Access-Control-Allow-Origin","*");
        List<Long> ids = goodsDeleteDTO.getIds();
        goodsService.deleteGoodsByIds(ids);
        return JsonResponse.success(null);
    }
    /****************************** 私有函数 **********************************/
    //设置goods的Wrapper的逻辑
    private void setGoodsWrapper(QueryWrapper<Goods> wrapper,boolean orderByPrice,boolean orderByPurchase,
                                 boolean PriceDesc,boolean PurchaseDesc){
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

