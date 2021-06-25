package com.example.mybatisplus.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.mybatisplus.common.JsonResponse;
import com.example.mybatisplus.service.TrolleyService;
import com.example.mybatisplus.model.domain.Trolley;


/**
 *
 *  前端控制器
 *
 *
 * @author lxp
 * @since 2021-06-21
 * @version v1.0
 */
@Controller
@RequestMapping("/api/trolley")
public class TrolleyController {

    private final Logger logger = LoggerFactory.getLogger( TrolleyController.class );

    @Autowired
    private TrolleyService trolleyService;

    /**
    * 描述：根据Id 查询
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getById(@PathVariable("id") Long id)throws Exception {
        Trolley  trolley =  trolleyService.getById(id);
        return JsonResponse.success(trolley);
    }

    /**
    * 描述：根据Id删除
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public JsonResponse deleteById(@PathVariable("id") Long id) throws Exception {
        trolleyService.removeById(id);
        return JsonResponse.success(null);
    }


    /**
    * 描述：根据Id 更新
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public JsonResponse updateTrolley(@PathVariable("id") Long  id,Trolley  trolley) throws Exception {
        trolley.setId(id);
        trolleyService.updateById(trolley);
        return JsonResponse.success(null);
    }


    /**
    * 描述:创建Trolley
    *
    */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse create(Trolley  trolley) throws Exception {
        trolleyService.save(trolley);
        return JsonResponse.success(null);
    }

}

